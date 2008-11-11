/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */ 
package com.uvasoftware.core.zis;


import com.uvasoftware.core.SIFObjectName;

import java.util.ArrayList;


/**
 * Stores Agent information all in memory
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class AgentRecord {
	public String type = "Agent";
	public String name;
	public String sourceId;
	public int maxBufferSize;
	public String version;
	public String mode = "Pull";
	public ArrayList<SIFObjectName> provides = new ArrayList<SIFObjectName>();
	public ArrayList<SIFObjectName> subscribes = new ArrayList<SIFObjectName>();
	
	public boolean isSleep = false;
	
	public AgentRecord(String sourceId) {
		this.sourceId = sourceId;
	}

}
