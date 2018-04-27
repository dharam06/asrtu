package com.asrtu.bean;

import java.util.Date;

import javax.persistence.Column;

public class StoOrderFormBean {
	
	private Integer stoTransId;
	private Integer stoNo;
	private String vendorId;
	private String vendorName;
	private String producGroupCode;
	private String producGroupName;
	private String productSubGroupCode;
	private String productSubGroupName;
	private String itemCode;
	
	private String itemName;

	private Float testCharge;
	
	private Date testDate;
	private String testDateString;
	
	private String remarks;
	private String quantity;
	private Float netAmount;
	
	private String stoId;

	private String vendorAddress;

	private String testType;

	private String rctrc;
	
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getRctrc() {
		return rctrc;
	}
	public void setRctrc(String rctrc) {
		this.rctrc = rctrc;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getStoId() {
		return stoId;
	}
	public void setStoId(String stoId) {
		this.stoId = stoId;
	}
	public String getTestDateString() {
		return testDateString;
	}
	public void setTestDateString(String testDateString) {
		this.testDateString = testDateString;
	}
	public Integer getStoTransId() {
		return stoTransId;
	}
	public void setStoTransId(Integer stoTransId) {
		this.stoTransId = stoTransId;
	}
	public Integer getStoNo() {
		return stoNo;
	}
	public void setStoNo(Integer stoNo) {
		this.stoNo = stoNo;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProducGroupCode() {
		return producGroupCode;
	}
	public void setProducGroupCode(String producGroupCode) {
		this.producGroupCode = producGroupCode;
	}
	public String getProducGroupName() {
		return producGroupName;
	}
	public void setProducGroupName(String producGroupName) {
		this.producGroupName = producGroupName;
	}
	public String getProductSubGroupCode() {
		return productSubGroupCode;
	}
	public void setProductSubGroupCode(String productSubGroupCode) {
		this.productSubGroupCode = productSubGroupCode;
	}
	public String getProductSubGroupName() {
		return productSubGroupName;
	}
	public void setProductSubGroupName(String productSubGroupName) {
		this.productSubGroupName = productSubGroupName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Float getTestCharge() {
		return testCharge;
	}
	public void setTestCharge(Float testCharge) {
		this.testCharge = testCharge;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}
	@Override
	public String toString() {
		return "StoOrderFormBean [stoTransId=" + stoTransId + ", stoNo=" + stoNo + ", vendorId=" + vendorId
				+ ", vendorName=" + vendorName + ", producGroupCode=" + producGroupCode + ", producGroupName="
				+ producGroupName + ", productSubGroupCode=" + productSubGroupCode + ", productSubGroupName="
				+ productSubGroupName + ", itemCode=" + itemCode + ", itemName=" + itemName + ", testCharge="
				+ testCharge + ", testDate=" + testDate + ", testDateString=" + testDateString + ", remarks=" + remarks
				+ ", quantity=" + quantity + ", netAmount=" + netAmount + ", stoId=" + stoId + ", vendorAddress="
				+ vendorAddress + ", testType=" + testType + ", rctrc=" + rctrc + "]";
	}
	
	
	
}
