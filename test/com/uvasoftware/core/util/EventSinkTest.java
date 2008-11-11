package com.uvasoftware.core.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uvasoftware.core.exception.StopDispatchException;

public class EventSinkTest {
	
	int counter = 0;
	
	public class AngryHandler implements IEventHandler {

		public void handle(Object eventSource, Object eventArgs)
				throws Exception {
			throw new StopDispatchException();
			
		}
	
	}
	
	public class CountHandler implements IEventHandler {

		public void handle(Object eventSource, Object eventArgs) {
			// TODO Auto-generated method stub
			counter++;
		}
	}
	
	@Test
	public void testAppendHandler() {
		EventSink es = new EventSink();
		int a = es.appendHandler(new CountHandler());
		assertEquals(0,a);
	}

	@Test
	public void testDispatch() throws Exception {
		EventSink es = new EventSink();
		int a = es.appendHandler(new CountHandler());
		es.dispatch(this,null);
		assertEquals(1,counter);
	}

	@Test
	public void testRemoverHandler() throws Exception {
		EventSink es = new EventSink();
		int a = es.appendHandler(new CountHandler());
		es.removerHandler(a);
		int old_counter = counter;
		es.dispatch(this,null);
		assertEquals(old_counter,counter);
		
		
	}
	
	@Test
	public void testDispatchAsync() throws Exception{
		counter = 0;
		EventSink es = new EventSink();
		es.appendHandler(new CountHandler());
		es.dispatchAsync(this,null,new CountHandler());
		Thread.sleep(2000);
		assertEquals(2,counter);
	}

	@Test
	public void testEarlyDispatchTerminaton() throws Exception {
		counter = 0;
		EventSink es = new EventSink();
		es.appendHandler(new AngryHandler());
		es.appendHandler(new CountHandler());
		Thread.sleep(2000);
		assertEquals(0,counter);	
	}
}
