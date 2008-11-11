/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core.util;

/**
 * 
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public interface IEventHandler {
	public void handle(Object eventSource, Object eventArgs) throws Exception;
}
