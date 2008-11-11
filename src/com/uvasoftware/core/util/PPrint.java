package com.uvasoftware.core.util;


/** 
 * Helper class for human readable display of SIF objects.<br>
 * There's basically a single significant method in this class: print which is overloaded to handle<br>
 * all the different types. 
 * 
 * <p>
 * usage:
 * <code>
 * SIFZoneStatus s = new SIFZoneStatus();
 * PPrint.print(s);
 * </code>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 *
 */

import java.util.Iterator;

import com.uvasoftware.core.SIFAck;
import com.uvasoftware.core.SIFHeader;
import com.uvasoftware.core.data.infra.*;

public class PPrint {

		
		public static void print(SIFHeader header) {
			System.out.println("Header information:");
			System.out.println("Source Id:" + header.getSourceId());
			System.out.println("Destination Id:" + header.getDestinationId());
			System.out.println("Message Id:" + header.getId());
			System.out.println("SIF Time:" + header.getSIFTime());
		}
		
		/**
		 * Prints <code>SIF_ZoneStatus</code> messages
		 * @param stat
		 */
		public static void print(SIFZoneStatus stat) {

			
			System.out.println("ZoneStatus information for zone: " + stat.getName());
			
			
			System.out.println("");
			System.out.println("Vendor information:");
			System.out.println("");
			
			System.out.println("  Name: " + stat.getVendorName());
			if (stat.getProduct() != null && stat.getProductVersion() != null)
				System.out.println("  Product: " + stat.getProduct()+ "  Version: " + stat.getProductVersion());
			
			System.out.println("");
			
			System.out.println("Providers:");

			if (stat.getProviders().size() > 0) {
				for (Iterator <SIFZoneStatus.SIFProvier> it = stat.getProviders().iterator(); it.hasNext(); ) {
					SIFZoneStatus.SIFProvier p = it.next();
					System.out.println();
					System.out.println(String.format("  Provider [%s]:" , p.sourceId));
					
					
					StringBuffer buff = new StringBuffer();
					
					if (p.objects.size() > 0 ) {
						for (String i: p.objects) {
							buff.append(i);
							buff.append(",");
						}
					} else {
						buff.append("none");
					}
					
					System.out.println(String.format("  Provided objects: {%s}", buff));
				}
				
			}
			
			System.out.println();
			System.out.println("Subscribers:");
			
			if (stat.getSubscribers().size() > 0) {
				for (Iterator <SIFZoneStatus.SIFSubscriber> it = stat.getSubscribers().iterator(); it.hasNext(); ) {
					SIFZoneStatus.SIFSubscriber p = it.next();
					System.out.println();
					System.out.println(String.format("  Subscriber [%s]:" , p.sourceId));
					
					
					StringBuffer buff = new StringBuffer();
					
					if (p.objects.size() > 0 ) {
						for (String i: p.objects) {
							buff.append(i);
							buff.append(",");
						}
					} else {
						buff.append("none");
					}
					
					System.out.println(String.format("  Subscribed objects: {%s}", buff));

				}
				
			}

			System.out.println("");
			System.out.println("Registered agents/nodes:");
			System.out.println("");
			
			StringBuffer buff = new StringBuffer();
			for ( SIFZoneStatus.SIFNode p: stat.getNodes()) {
				buff.append(p.name != null ? p.name : "none" );
				buff.append(" {\n");
				buff.append("\n  ");
				
				buff.append("Source Id: ");
				buff.append(p.sourceId != null ? p.sourceId : "none" );
				buff.append("\n  ");
				
				buff.append("Mode: ");
				buff.append(p.mode != null ? p.mode : "none" );
				buff.append("\n  ");
				
				buff.append("Version: ");
				buff.append(p.version != null ? p.version : "none" );
				buff.append("\n  ");
				
				buff.append("Max buffer size: ");
				buff.append(p.maxBuffer != null ? p.maxBuffer : "none" );
				buff.append("\n  ");
				
				buff.append("Is agent sleeping? ");
				buff.append( p.isSleeping ? p.isSleeping : "no" );
				buff.append("\n}");
				

			}
			
			System.out.println(buff);
		
			
		}
		
		public static void print(SIFAck ack) {
			System.out.println("SIFAck information:");
        	if  (ack.getErrorCode() > 0) {
        		System.out.println("Error code:" + ack.getErrorCode());
        		System.out.println("Error description:" + ack.getErrorDesc());
       		}
        
       		 if (ack.getStatusCode() > 0) {
        		System.out.println("Status code:" + ack.getStatusCode());
        	}
		}
}
