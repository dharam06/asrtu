package com.asrtu.bean;

import java.util.Date;

public class TestingSearch {
	
	private Date fromDate;
	private Date toDate;
	private String vendorCode;
	private String itemCode;
	private Integer volume;
	
	private Date transactionDateFrom;
	private Date transactionDateTo;
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Date getTransactionDateFrom() {
		return transactionDateFrom;
	}
	public void setTransactionDateFrom(Date transactionDateFrom) {
		this.transactionDateFrom = transactionDateFrom;
	}
	public Date getTransactionDateTo() {
		return transactionDateTo;
	}
	public void setTransactionDateTo(Date transactionDateTo) {
		this.transactionDateTo = transactionDateTo;
	}
	@Override
	public String toString() {
		return "TestingSearch [fromDate=" + fromDate + ", toDate=" + toDate + ", vendorCode=" + vendorCode
				+ ", itemCode=" + itemCode + ", volume=" + volume + ", transactionDateFrom=" + transactionDateFrom
				+ ", transactionDateTo=" + transactionDateTo + "]";
	}

}
