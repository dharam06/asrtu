package com.astru.util;

import java.util.Date;

public class InvoiceSearch {
	
	private Date quarterFromDate;
	public Date getQuarterFromDate() {
		return quarterFromDate;
	}
	public void setQuarterFromDate(Date quarterFromDate) {
		this.quarterFromDate = quarterFromDate;
	}
	public Date getQuarterToDate() {
		return quarterToDate;
	}
	public void setQuarterToDate(Date quarterToDate) {
		this.quarterToDate = quarterToDate;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	private Date quarterToDate;
	private String vendorCode;
	private String itemCode;
	private Integer volume;
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

}
