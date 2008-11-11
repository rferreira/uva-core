/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */

package com.uvasoftware.core.util;

import java.util.ArrayList;
import java.util.concurrent.*;
import org.apache.log4j.Logger;
import com.uvasoftware.core.exception.StopDispatchException;

/**
 * EventSinks are an easy way to provide multicast delegates for event handling.
 * <p>
 * In a nutshell, EventSinks allow you to quickly create event notification
 * points to which end users can subscribe by implementing the IEventHandler
 * interface
 * <p>
 * Also, please note that most events are dispatch serially. The async dispatch
 * options is only provided for convenience. <br>
 * <p>
 * How to use the event sink: 
 * <p>
 * <code>
 *	public void testDispatch() throws Exception { <br>
 *		EventSink es = new EventSink(); <br>
 *		int a = es.appendHandler(new CountHandler()); <br>
 *		es.dispatch(this,null); <br>
 *	}<br>
 * </code>
 * 
 * @see com.uvasoftware.core.util.IEventHandler
 * @author Rafael Ferreira <raf@uvasoftware.com>
 * 
 */
public class EventSink {
	private ArrayList<IEventHandler> listeners = new ArrayList<IEventHandler>();
	private static Logger log = Logger.getLogger(EventSink.class);
	private static ExecutorService es = Executors.newCachedThreadPool();

	/**
	 * Returns the number of handlers currently registered with this event
	 * 
	 * @return
	 */
	public int size() {
		return (listeners.size());
	}

	/**
	 * Simple worker runnable to assist with dispatching events async
	 * 
	 * @author Rafael Ferreira <raf@uvasoftware.com>
	 * 
	 */
	private class EventSinkWorker implements Runnable {
		EventSink target = null;
		Object eventSource, eventArgs;
		IEventHandler callback = null;

		public EventSinkWorker(EventSink ev, Object eventSource,
				Object eventArgs, IEventHandler callback) {
			target = ev;
			this.eventArgs = eventArgs;
			this.eventSource = eventSource;
			this.callback = callback;
		}

		public void run() {
			try {
				target.dispatch(eventSource, eventArgs);

				log.debug("calling callback");

				if (callback != null)
					callback.handle(this, null);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}
		}
	}

	/**
	 * Subscribe to this event by passing a delegate that implements the
	 * IEventHandler interface
	 * 
	 * @param handler
	 *            the delegate
	 * @return the id of the delegate in the delegate queue (use this id to
	 *         remove the delegate later)
	 */
	public int appendHandler(IEventHandler handler) {
		listeners.add(handler);
		return listeners.indexOf(handler);
	}

	/**
	 * Dispatches the event queue by calling all the delegates serially
	 * 
	 * @param eventSource
	 *            the object that triggered the event
	 * @param eventArgs
	 *            the arguments needed to service the event (note that this is
	 *            in a per event basis)
	 * @throws Exception
	 *             the exception thrown by the event handler - note that if one
	 *             of the events throws an exception, the whole pipeline gets
	 *             killed
	 */
	public void dispatch(Object eventSource, Object eventArgs) throws Exception {
		for (IEventHandler i : listeners) {
			try {
				i.handle(eventSource, eventArgs);
			} catch (StopDispatchException e) {
				log.info("early chain termination caught", e);
				return;
			}
		}
	}

	/**
	 * Dispatches the event queue asynchronously and calls the callback when
	 * done
	 * 
	 * @param eventSource
	 *            the object that triggered the event
	 * @param eventArgs
	 *            the arguments needed to service the event (note that this is
	 *            in a per event basis)
	 * @param callback
	 *            the callback method to be called once the async dispatch is
	 *            done
	 * @throws Exception
	 *             the exception thrown by the event handler - note that if one
	 *             of the events throws an exception, the whole pipeline gets
	 *             killed
	 */
	public void dispatchAsync(Object eventSource, Object eventArgs,
			IEventHandler callback) throws Exception {
		es.execute(new EventSinkWorker(this, eventSource, eventArgs, callback));
	}

	/**
	 * Removes a handler/delegate identified by this id
	 * 
	 * @param id
	 *            the handler id
	 * @return true if successful
	 */
	public synchronized boolean removerHandler(int id) {
		if (listeners.remove(id) != null)
			return true;

		return false;

	}

}
