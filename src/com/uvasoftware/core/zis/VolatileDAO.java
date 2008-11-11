package com.uvasoftware.core.zis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.SIFZoneStatus;



/**
 * All in memory implementation of IZISDAO - backed by maps and sets primitives<p>
 * I shouldn't have to say this but this is only suitable for (unit)testing since it is carries a single mutex for all the read/write operations.
 * <p>
 * For information on these methods see @see IZISDAO
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class VolatileDAO implements IZISDAO {
	private static Logger log = Logger.getLogger(VolatileDAO.class);
	
	
	// Data Structures 
	Map<String,AgentRecord>  agents = new HashMap<String,AgentRecord>();
	Map<String, ArrayList<SIFMessage> > messages = new HashMap<String, ArrayList<SIFMessage> >();
	
	Object mutex = new Object();
	
	
	public VolatileDAO() {
		log.info("Volatile ZIS DAO starting up");
	}
	
	/**
	 * Gets the agent record for the specified name
	 */
	public AgentRecord getAgent(String sourceId) {
		
		log.debug("Returning agent record for:" + sourceId);
		
		AgentRecord rec = null;
		rec = agents.get(sourceId);

		
		return(rec);
	}
	
	/**
	 * Deletes the agent record for the specified name
	 */
	public void deleteAgent(String sourceId) {
		
		log.debug("deleting agent record for:" + sourceId);
		synchronized(mutex) {
			agents.remove(sourceId);
			messages.remove(sourceId);
		}
		return;
	}

	/**
	 * Gets all messages for a specific agent name (both events and queries). In this case this is an extremely expensive process O(n) 
	 */
	public List<SIFMessage> getMessagesForAgent(String sourceId) {
		log.debug("getting all messages for agent:" + sourceId);
		
		ArrayList<SIFMessage> resp = new ArrayList<SIFMessage>();
		
		AgentRecord agent = getAgent(sourceId);
		
		if (agent == null) {
			log.error("agent cannot be found in database");
			return(null);
		}
		
		synchronized(mutex) {
			log.debug("agent possesses " + messages.get(agent.sourceId).size() + " messages");
			resp.addAll(messages.get(agent.sourceId));
			//log.debug("clearing agent queue");
			//messages.get(agent.sourceId).clear();
		}
		return(resp);
			
	}

	/**
	 * Puts/Stores an specified agent record
	 */
	public void putAgent(AgentRecord rec) {
		log.debug("putting agent:" + rec.sourceId);
		agents.put(rec.sourceId,rec);
		
		synchronized(mutex) {
			if ( !messages.containsKey(rec.sourceId) ) {
				log.info("creating new message queu for agent:" + rec.sourceId);
				messages.put(rec.sourceId, new ArrayList<SIFMessage>());
			}
		}
	}
	/**
	 * Puts/Stores a message in the queue
	 */
	public void putMessage(SIFMessage msg) {
		log.debug("putting message with id:" + msg.getId());	
		
		AgentRecord ar = null;
		
		/*
		 * CASE 1 - contains a destination Id
		 */
		if (msg.getHeader().getDestinationId() != null ) {
			log.debug("matching destination id");
			
			ar = getAgent(msg.getHeader().getDestinationId());
			if ( ar == null ) {
				log.error(String.format("destination id referenced in messages %s could not be found", msg.getId()));
			} else {
				log.debug("message being added to " + ar.sourceId + " queue");
				synchronized(mutex) {
					messages.get(ar.sourceId).add(msg);
					//log.debug("new queue size for agent:" + ar.sourceId + " is " + messages.get(ar.sourceId).size());
				}
				
				return;
			}
		}
		
		/*
		 * Case 2: Looking for providers
		 */
		if (msg.getType() == SIFMessage.Type.REQUEST) {	
			
			// we can't find the destination id, so let's send it to the default provider
			
			ar = getProvider(msg.getRequest().getQuery().getSIFObjectName());
			
			if (ar != null ) {
				log.debug("message being added to " + ar.sourceId + " queue");
				synchronized(mutex) {
					messages.get(ar.sourceId).add(msg);
					//log.debug("new queue size for agent:" + ar.sourceId + " is " + messages.get(ar.sourceId).size());
				}
			}
			
		}else if (msg.getType() == SIFMessage.Type.EVENT ) {
			log.debug("looking for event handlers");
			for (AgentRecord i: getSubscribers(msg.getEvent().getEventObjectName()) ) {
				log.debug("message being added to " + i.sourceId + " queue");
				synchronized(mutex) {
					messages.get(i.sourceId).add(msg);
					//log.debug("new queue size for agent:" + ar.sourceId + " is " + messages.get(ar.sourceId).size());
				}
			}
			
		}
		 
	}

	private AgentRecord getProvider(SIFObjectName t) {
	
		synchronized(mutex) {
			for (Map.Entry<String, AgentRecord> entry: agents.entrySet()) {
				
				// This logic assumed that there can only be 1 provider
				for (SIFObjectName name: entry.getValue().provides) {
					if ( t == name ) {
						return(entry.getValue());
					}
				}
				
			}
		}
		return null;
	}
	
	private List<AgentRecord> getSubscribers(SIFObjectName t) {
		
		ArrayList<AgentRecord> resp = new ArrayList<AgentRecord>();

		synchronized(mutex) {
			for (Map.Entry<String, AgentRecord> entry: agents.entrySet()) {
			
				if (entry.getValue().subscribes.contains(t)) {
					resp.add(entry.getValue());
				}
			}
			
		}
		return(resp);
	}
	
	public void deleteMessage(String sourceId, String messageId) {
		AgentRecord agent = getAgent(sourceId);
	
		log.debug(String.format("trying to delete message [%s] from queue [%s]",messageId, sourceId));
		
		if (agent == null) {
			log.error("agent " + sourceId + " cannot be found in database");
			return;
		}
		
		log.debug("removing message with id:" + messageId + " for agent " + agent.sourceId);
		synchronized(mutex) {
			for (int i=0; i < messages.get(agent.sourceId).size(); i ++ ) {
				if (messageId == messages.get(agent.sourceId).get(i).getId() ) {
					messages.get(agent.sourceId).remove(i);
					continue;
				}
			}
	
		}
		
		
		
	}
	
	public SIFZoneStatus getZoneStatus() {
		SIFZoneStatus zt = new SIFZoneStatus();
		SIFZoneStatus.SIFNode n = null;
		SIFZoneStatus.SIFProvier p = null;
		SIFZoneStatus.SIFSubscriber s = null;
		ArrayList<SIFZoneStatus.SIFNode> nodes = new ArrayList<SIFZoneStatus.SIFNode>();
		ArrayList<SIFZoneStatus.SIFProvier> providers = new ArrayList<SIFZoneStatus.SIFProvier>();
		ArrayList<SIFZoneStatus.SIFSubscriber> subscribers = new ArrayList<SIFZoneStatus.SIFSubscriber>();
		
		synchronized(mutex) {	
			for  (AgentRecord r:  agents.values() ) {
				// populating nodes
				n = new SIFZoneStatus.SIFNode();
				n.name = r.name;
				n.sourceId = r.sourceId;
				n.mode = r.mode;
				n.version = r.version;
				n.type = r.type;
				
				if (r.isSleep) 
					n.isSleeping = true;
				else 
					n.isSleeping = false;
				
				n.maxBuffer = String.valueOf(r.maxBufferSize);
				
				nodes.add(n);
				
				// populating providers
				p = new SIFZoneStatus.SIFProvier();
				p.sourceId = n.sourceId;
				for (SIFObjectName oname: r.provides) {
					p.objects.add(oname.name());
				}
				
				// populating subscribers
				s = new SIFZoneStatus.SIFSubscriber();
				s.sourceId = n.sourceId;
				for (SIFObjectName oname: r.subscribes) {
					s.objects.add(oname.name());
				}
				
				providers.add(p);
				subscribers.add(s);
			
			}
			
			
		}
		
		zt.setNodes(nodes);
		zt.setProviders(providers);
		zt.setSubscribers(subscribers);
		
		return(zt);

	}
}
