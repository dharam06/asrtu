package com.asrtu.bean;

import java.util.Date;

public class VendorGstSearch {
	
	private Date quarterFromDate;
	private Date quarterToDate;
	private String vendorCode;
	private String itemCode;
	private Integer volume;
	
	private Date transactionDateFrom;
	private Date transactionDateTo;
	private Date transactionDate;
	
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
	
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "InvoiceSearch [quarterFromDate=" + quarterFromDate + ", quarterToDate=" + quarterToDate
				+ ", vendorCode=" + vendorCode + ", itemCode=" + itemCode + ", volume=" + volume
				+ ", transactionDateFrom=" + transactionDateFrom + ", transactionDateTo=" + transactionDateTo
				+ ", transactionDate=" + transactionDate + "]";
	}
	

}
