package com.asrtu.bean;

import java.util.Date;

public class CirtBillBean {
	
	private Integer transId;
	private String billNo;
	
	private Date billDate;
	private String billDateString;
	
	private Float billAmount;
	private String asrtRefNo;
	private String vendorId;
	private String vendorName;
	private String itemCode;
	private String itemName;
	private Integer stoNo;
	private Float testCharge;
	private String remarks;

	private String stoId;
	
	public String getStoId() {
		return stoId;
	}

	public void setStoId(String stoId) {
		this.stoId = stoId;
	}

	public String getBillDateString() {
		return billDateString;
	}

	public void setBillDateString(String billDateString) {
		this.billDateString = billDateString;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Integer getStoNo() {
		return stoNo;
	}
	public void setStoNo(Integer stoNo) {
		this.stoNo = stoNo;
	}
	private String pageAction;
	
	@Override
	public String toString() {
		return "CirtBillBean [transId=" + transId + ", billNo=" + billNo + ", billDate=" + billDate
				+ ", billDateString=" + billDateString + ", billAmount=" + billAmount + ", asrtRefNo=" + asrtRefNo
				+ ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", itemCode=" + itemCode + ", itemName="
				+ itemName + ", stoNo=" + stoNo + ", testCharge=" + testCharge + ", remarks=" + remarks + ", stoId="
				+ stoId + ", pageAction=" + pageAction + "]";
	}
	public String getPageAction() {
		return pageAction;
	}
	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}
	public Integer getTransId() {
		return transId;
	}
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Float billAmount) {
		this.billAmount = billAmount;
	}
	public String getAsrtRefNo() {
		return asrtRefNo;
	}
	public void setAsrtRefNo(String asrtRefNo) {
		this.asrtRefNo = asrtRefNo;
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
	
	

}
