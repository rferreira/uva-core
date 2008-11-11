package com.uvasoftware.core.zis;

import java.util.List;

import com.uvasoftware.core.*;
import com.uvasoftware.core.data.infra.SIFZoneStatus;

/**
 * Interface for persisting ZIS information
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public interface IZISDAO {
		
	/**
	 * Persists or updates and Agent record
	 * @param rec the Agent Record to be persisted
	 */
	public void putAgent(AgentRecord rec);
	/**
	 * Gets the AgentRecord that matches the name
	 * @param sourceId the agent name - should be unique
	 * @return
	 */
	public AgentRecord getAgent(String sourceId);
	
	/**
	 * Deletes the AgentRecord that matches the name
	 * @param sourceId the agent name - should be unique
	 * @return
	 */
	public void deleteAgent(String sourceId);
	
	
	/**
	 * Appends message to the bottom of the message queue
	 * @param msg the message to be appended
	 */
	public void putMessage(SIFMessage msg);
	
	/**
	 * Removes message from the agent message queue
	 * @sourceId the name of the agent
	 * @messageId the id of the message to be removed 
	 */
	public void deleteMessage(String sourceId, String messageId);
	
	/**
	 * Returns all the messages that are relevant to this user (both events and queries)
	 * @param sourceId
	 */
	public List<SIFMessage> getMessagesForAgent(String sourceId);

	/**
	 * Returns a <code>SIZoneStatus</code> object as per the sif spec
	 * @return
	 */
	public SIFZoneStatus getZoneStatus();
}

