package com.asrtu.bean;
/*******************************************************************************
 * Copyright (c) 2009 Apria Healthcare                                          *
 * As an unpublished work. All Rights Reserved.                                 *
 * This media contains an authorized copy or copies of material copyrighted by  *
 * Apria Healthcare and is the unpublished, confidential property of            *
 * Apria Healthcare. You may not disclose, copy or use any portion of           *
 * these materials for any purpose without the express written consent of Apria *
 * Healthcare.  You must reproduce this copyright notice and any other          *
 * copyright notices included in machine-readable copies on all authorized      *
 * copies.                                                                      *
 *******************************************************************************/


import java.io.Serializable;


public class DropDownBean implements Serializable {
	
	private long code;
	private String type;
	private String displayValue;	
	private int attribCriticalityValue;
	private String active;
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public int getAttribCriticalityValue() {
		return attribCriticalityValue;
	}
	public void setAttribCriticalityValue(int attribCriticalityValue) {
		this.attribCriticalityValue = attribCriticalityValue;
	}
	public String isActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		
		sb.append("[ code=").append( code );
		sb.append(", type=").append( type );
		sb.append(", displayValue=").append( displayValue );
		sb.append(", attribCriticalityValue=").append( attribCriticalityValue );
		sb.append(", isActive=").append( active ).append(" ]");			
		
		return sb.toString();
	}
}
