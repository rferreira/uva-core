package com.uvasoftware.core.data.infra;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.uvasoftware.core.ISIFObject;
import com.uvasoftware.core.data.common.BaseSIFObject;

import com.uvasoftware.core.primitives.ProvideObjectNames;
import com.uvasoftware.core.primitives.SubscribeObjectNames;
import com.uvasoftware.core.primitives.YesOrNoType;


/**
 * Represents a <code>SIFZoneStatus</code> SIF object by the Infrastructure Work Group
 * <p>
 * From the spec:<br>
 * The SIF_ZoneStatus object is an object that is implicitly provided by all Zone Integration Servers to provide
information about the ZIS. This object is mandatory. SIF_Events are not reported.
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 *TODO: this needs to be better documented!
 *TODO: Add support for settings elements
 */
public class SIFZoneStatus extends BaseSIFObject implements ISIFObject {
	/* HELPER INNER CLASSES */
	
	public static class SIFProvier {
		public String sourceId;
		public ArrayList <String> objects = new ArrayList<String>(); 
	}
	
	public static class SIFSubscriber {
		public String sourceId;
		public ArrayList <String> objects = new ArrayList<String>();
	}
	
	public static class SIFNode {
		public String type;
		public String name;
		public String sourceId;
		public String mode;
		public String protocolType;
		public boolean isSecure = false;
		public String URL;
		public String version;
		public String maxBuffer;
		public boolean isSleeping = false;
		
	}
	
	/* MAIN CLASS STUFF */
	
	private static Logger log = Logger.getLogger(SIFZoneStatus.class);
	
	com.uvasoftware.core.primitives.SIFZoneStatus primitive = new com.uvasoftware.core.primitives.SIFZoneStatus();
	
	public SIFZoneStatus() {
		
	}
	@Deprecated
	public String getZoneID() { 
		return(primitive.getZoneId());
	}
	public String getZoneId() { 
		return(primitive.getZoneId());
	}
	
	public void setZoneId(String id) {
		primitive.setZoneId(id);
	}
	
	public SIFZoneStatus(com.uvasoftware.core.primitives.SIFZoneStatus primitive) {
		this.setPrimitive(primitive);
	}
	
	public String getName() {
		return(primitive.getSIFName());	
	}
	
	public void setName(String name) {
		primitive.setSIFName(name);
	}
	
	public String getVendorName() {

		return(primitive.getSIFVendor() == null? null : primitive.getSIFVendor().getSIFName());
	}
	
	public void setVendorName(String name) {
		if (primitive.getSIFVendor() == null) { primitive.setSIFVendor(new com.uvasoftware.core.primitives.SIFVendor() ); }
		primitive.getSIFVendor().setSIFName(name);
	}
	
	public String getProduct() {
		 
		return(primitive.getSIFVendor() == null? null : primitive.getSIFVendor().getSIFProduct());
		
	}
	public void setProduct(String name) {
		if (primitive.getSIFVendor() == null) { primitive.setSIFVendor(new com.uvasoftware.core.primitives.SIFVendor() ); }
		primitive.getSIFVendor().setSIFProduct(name);
	}
	
	public String getProductVersion() {
		return(primitive.getSIFVendor() == null? null : primitive.getSIFVendor().getSIFVersion());
	}
	
	public void setProductVersion(String version) {
		if (primitive.getSIFVendor() == null) { primitive.setSIFVendor(new com.uvasoftware.core.primitives.SIFVendor() ); }
		primitive.getSIFVendor().setSIFVersion(version);
	}
	public String getAdministratorUrl() { 
		return(primitive.getSIFAdministrationURL());
	}
	
	public void setAdministratorUrl(String name) {
		this.primitive.setSIFAdministrationURL(name);
	}
	/**
	 * Returns the a list of providers and the objects they provide
	 *<p>
	 * Note that this is actually an expensive operation (well, depending on the size of the zone)
	 * since its output is not cached. 
	 * @return an arraylist of type SIFZoneStatus.SIFProvider with all the data 
	 */
	public List <SIFZoneStatus.SIFProvier> getProviders() {
		ArrayList <SIFZoneStatus.SIFProvier> ar = new ArrayList<SIFZoneStatus.SIFProvier>();
		
		try {
			
			for (com.uvasoftware.core.primitives.SIFProvider provider: primitive.getSIFProviders().getSIFProvider()) {
				SIFZoneStatus.SIFProvier p = new SIFZoneStatus.SIFProvier();
				p.sourceId = provider.getSourceId();
				
				if (provider.getSIFObject().size() > 0 )
					for (com.uvasoftware.core.primitives.SIFProvider.SIFObject obj: provider.getSIFObject()) {
						if (obj != null )
							p.objects.add(obj.getObjectName().toString());
					}
			
				ar.add(p);
			}
		
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return(ar);
	}
	
	public void setProviders(List<SIFZoneStatus.SIFProvier> providers)  {
		com.uvasoftware.core.primitives.SIFProvider.SIFObject so = null;
		com.uvasoftware.core.primitives.SIFProvider p1 = null;
		com.uvasoftware.core.primitives.SIFProviders p2 = new com.uvasoftware.core.primitives.SIFProviders();

		for (SIFZoneStatus.SIFProvier p: providers) {
			p1 = new com.uvasoftware.core.primitives.SIFProvider();
			p1.setSourceId(p.sourceId);
			
			for (String s: p.objects) {
				so = new com.uvasoftware.core.primitives.SIFProvider.SIFObject();
				so.setObjectName(ProvideObjectNames.fromValue(s));
			}
			p1.getSIFObject().add(so);
			p2.getSIFProvider().add(p1);
		}
		primitive.setSIFProviders(p2);
	}
	
	/**
	 * Returns the a list of providers and the objects they provide
	 * <p>
	 * Note that this is actually an expensive operation (well, depending on the size of the zone)
	 * since its output is not cached. 
	 * 
	 * @return an arraylist of type SIFZoneStatus.SIFProvider with all the data 
	 */
	public List <SIFZoneStatus.SIFSubscriber> getSubscribers() {
		ArrayList <SIFZoneStatus.SIFSubscriber> ar = new ArrayList<SIFZoneStatus.SIFSubscriber>();
		try  {

			
			for (com.uvasoftware.core.primitives.SIFSubscriber provider: primitive.getSIFSubscribers().getSIFSubscriber()) {
				SIFZoneStatus.SIFSubscriber p = new SIFZoneStatus.SIFSubscriber();
				p.sourceId = provider.getSourceId();
				
				if (provider.getSIFObject().size() > 0 )
					for (com.uvasoftware.core.primitives.SIFSubscriber.SIFObject obj: provider.getSIFObject()) {
						if (obj != null )
							p.objects.add(obj.getObjectName().toString());
					}
				
				ar.add(p);
			
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return(ar);
	}
	
	public void setSubscribers(List<SIFZoneStatus.SIFSubscriber> subscribers)  {
		com.uvasoftware.core.primitives.SIFSubscriber.SIFObject so = null;
		com.uvasoftware.core.primitives.SIFSubscriber p1 = null;
		com.uvasoftware.core.primitives.SIFSubscribers p2 = new com.uvasoftware.core.primitives.SIFSubscribers();
		
		for (SIFZoneStatus.SIFSubscriber p: subscribers) {
			p1 = new com.uvasoftware.core.primitives.SIFSubscriber();
			p1.setSourceId(p.sourceId);
			
			for (String s: p.objects) {
				so = new com.uvasoftware.core.primitives.SIFSubscriber.SIFObject();
				so.setObjectName(SubscribeObjectNames.valueOf(s));
			}
			
			p1.getSIFObject().add(so);
			p2.getSIFSubscriber().add(p1);
		}
		
		primitive.setSIFSubscribers(p2);
	}
	
	/**
	 * Returns the a list of providers and the objects they provide
	 * <p>
	 * Note that this is actually an expensive operation (well, depending on the size of the zone)
	 * since its output is not cached. 
	 * @return an arraylist of type SIFZoneStatus.SIFProvider with all the data 
	 */
	public List <SIFZoneStatus.SIFNode> getNodes() {
		ArrayList <SIFZoneStatus.SIFNode> ar = new ArrayList<SIFZoneStatus.SIFNode>();
		
		try {
		
			SIFZoneStatus.SIFNode n = null;
			com.uvasoftware.core.primitives.SIFSIFNode n1 = null;
			
			for (Iterator it = primitive.getSIFSIFNodes().getSIFSIFNode().iterator(); it.hasNext(); ) {
				
				n = new SIFZoneStatus.SIFNode();
				n1 = (com.uvasoftware.core.primitives.SIFSIFNode)it.next();
				
				//n.isSecure = n1.getSIFProtocol().getSecure();
				//n.isSleeping = n1.getSIFSleeping().YES;
				n.maxBuffer = String.valueOf(n1.getSIFMaxBufferSize());
				n.mode = n1.getSIFMode();
				n.name = n1.getSIFName();
				n.protocolType = n1.getSIFProtocol() == null? "none" : n1.getSIFProtocol().getType();
				n.sourceId = n1.getSIFSourceId();
				n.type = n1.getType();
				n.URL = n1.getSIFProtocol() != null? n1.getSIFProtocol().getSIFURL() : "none";
				n.version = n1.getSIFVersion().size() > 1 ? n1.getSIFVersion().get(0).toString() : "none";
				
				log.debug("adding:" + n.sourceId);			
				ar.add(n);
			}
		} catch (Exception e) {
			log.warn(e);
			e.printStackTrace();
		}
		
		return(ar);
	}
	
	public void setNodes(List<SIFZoneStatus.SIFNode> nodes) {
		com.uvasoftware.core.primitives.SIFSIFNode n1 = null;
		com.uvasoftware.core.primitives.SIFSIFNodes n2 = new com.uvasoftware.core.primitives.SIFSIFNodes();

		for (SIFZoneStatus.SIFNode s: nodes) {
			n1 = new com.uvasoftware.core.primitives.SIFSIFNode();
			log.debug("adding entry for node:" + s.name);
			n1.setSIFName(s.name);
			
			n1.setSIFSourceId(s.sourceId);
			n1.getSIFVersion().add(s.version);
			n1.setSIFMaxBufferSize( new BigInteger(s.maxBuffer));
			n1.setSIFMode(s.mode);
			n1.setType(s.type);
			if (s.isSleeping) {
				n1.setSIFSleeping(YesOrNoType.YES);
			}else {
				n1.setSIFSleeping(YesOrNoType.NO);
			}
			

			n2.getSIFSIFNode().add(n1);

		}
		
		
		primitive.setSIFSIFNodes(n2);
	}


}
