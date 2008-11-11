/**
 * 
 */
package com.uvasoftware.core;

import static org.junit.Assert.*;

import org.junit.Test;
import com.uvasoftware.core.util.*;

/**
 * @author Rafael Ferreira
 *
 */
public class SIFMessageTest {

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#SIFMessage()}.
	 */
	@Test
	public void testSIFMessage() {
		SIFMessage msg = new SIFMessage();
		assertNotNull(msg);
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#SIFMessage(java.lang.Object)}.
	 */
	@Test
	public void testSIFMessageObject() {
		SIFPing ping = new SIFPing();
		SIFMessage msg = new SIFMessage(ping.getPrimitive());
		assertEquals(ping.getPrimitive(),msg.getPrimitive());
	}



	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#setPrimitive(java.lang.Object)}.
	 */
	@Test
	public void testSetPrimitive() {
		SIFPing ping = new SIFPing();
		SIFMessage msg = new SIFMessage();
		msg.setPrimitive(ping.getPrimitive());
		assertEquals(ping.getPrimitive(),msg.getPrimitive());
		
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#toString()}.
	 */
	@Test
	public void testToString() {
		SIFPing ping = new SIFPing();

		assertTrue(ping.toString().contains("<SIF_SystemControlData><SIF_Ping/></SIF_SystemControlData></SIF_SystemControl></SIF_Message>"));
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getAck()}.
	 */
	@Test
	public void testGetAck() {
		SIFAck  ack = new SIFAck();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getAck().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getPing()}.
	 */
	@Test
	public void testGetPing() {
		SIFPing  ack = new SIFPing();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getPing().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getProvide()}.
	 */
	@Test
	public void testGetProvide() {
		SIFProvide  ack = new SIFProvide();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getProvide().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getRegister()}.
	 */
	@Test
	public void testGetRegister() {
		SIFRegister  ack = new SIFRegister();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getRegister().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getRequest()}.
	 */
	@Test
	public void testGetRequest() {
		SIFRequest  ack = new SIFRequest();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getRequest().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getSleep()}.
	 */
	@Test
	public void testGetSleep() {
		SIFSleep  ack = new SIFSleep();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getSleep().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getSubscribe()}.
	 */
	@Test
	public void testGetSubscribe() {
		SIFSubscribe  ack = new SIFSubscribe();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getSubscribe().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getUnprovide()}.
	 */
	@Test
	public void testGetUnprovide() {
		SIFUnProvide  ack = new SIFUnProvide();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getUnProvide().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getUnregister()}.
	 */
	@Test
	public void testGetUnregister() {
		SIFUnRegister  ack = new SIFUnRegister();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getUnRegister().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getUnSubscribe()}.
	 */
	@Test
	public void testGetUnsubscribe() {
		SIFUnSubscribe  ack = new SIFUnSubscribe();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getUnSubscribe().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getWakeup()}.
	 */
	@Test
	public void testGetWakeup() {
		SIFWakeup  ack = new SIFWakeup();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getWakeup().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getResponse()}.
	 */
	@Test
	public void testGetResponse() {
		SIFResponse  ack = new SIFResponse();
		SIFMessage msg = new SIFMessage(ack.getPrimitive());
		assertEquals(ack.getPrimitive(),msg.getResponse().getPrimitive());
	}

	/**
	 * Test method for {@link com.uvasoftware.core.SIFMessage#getHeader()}.
	 */
	@Test
	public void testGetHeader() {
		SIFHeader  header = new SIFHeader();
		SIFPing ping = new SIFPing();
		System.out.println(ping);
		//ping.getHeader().setPrimitive(header.getPrimitive());
		ping.setHeader(header);
		System.out.println(ping);
		assertEquals(header.getPrimitive(),ping.getHeader().getPrimitive());
	}
	
	@Test
	public void testGetType() {
		SIFPing ping = new SIFPing();
		assertEquals(SIFMessage.Type.PING,ping.getType());
	}
	
	@Test
	public void testGetVersion() {
		SIFMessage msg = new SIFMessage();
		msg.setProtocolVersion("A");
		assertEquals("A",msg.getProtocolVersion());
	}
	
	@Test
	public void testMakeSureThereIsAVersionString() throws Exception {
		SIFMessage b = new SIFMessage();
		assertEquals(Config.getInstance().getOrException(ConfigConstants.PROTOCOL_VERSION),b.getProtocolVersion());
	}
}
