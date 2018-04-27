package com.asrtu.bean;

import java.util.Date;

public class QuarterBean {
	
	private Integer slNo;
	private String quarter;
	
	private Date qFrom;
	private Date qtDate;
	
	private String qFromString;
	private String qtDateString;
	
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public Date getqFrom() {
		return qFrom;
	}
	public void setqFrom(Date qFrom) {
		this.qFrom = qFrom;
	}
	public Date getQtDate() {
		return qtDate;
	}
	public void setQtDate(Date qtDate) {
		this.qtDate = qtDate;
	}
	public String getqFromString() {
		return qFromString;
	}
	public void setqFromString(String qFromString) {
		this.qFromString = qFromString;
	}
	public String getQtDateString() {
		return qtDateString;
	}
	public void setQtDateString(String qtDateString) {
		this.qtDateString = qtDateString;
	}
	@Override
	public String toString() {
		return "QuarterBean [slNo=" + slNo + ", quarter=" + quarter + ", qFrom=" + qFrom + ", qtDate=" + qtDate
				+ ", qFromString=" + qFromString + ", qtDateString=" + qtDateString + "]";
	}
		
	
}
