/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.data.student.*;

/**
 * @author Rafael Ferreira
 *
 */
public class SIFEVentTest  {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFEvent#SIFEvent()}.
	 */
	@Test
	public void testSIFEvent() throws Exception {
		RoomType rt = new RoomType("A","B");
		rt.setRefId("260A962CB9854215932B61A32D269992");
		
		SIFEvent ev = new SIFEvent();
		ev.setEventData(rt,SIFObjectName.RoomType.name(),SIFEvent.Action.Remove);
		
		System.out.println(ev);
		
		assertTrue(ev.toString().contains("<SIF_ObjectData><SIF_EventObject ObjectName=\"RoomType\" Action=\"Remove\"><RoomType SchoolInfoRefId=\"A\" RefId=\"260A962CB9854215932B61A32D269992\"><Description>B</Description></RoomType></SIF_EventObject></SIF_ObjectData></SIF_Event></SIF_Message>"));

	}
	
	



}
