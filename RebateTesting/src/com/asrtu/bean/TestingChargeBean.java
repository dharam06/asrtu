package com.asrtu.bean;

import java.util.Date;

public class TestingChargeBean {
	
	private Integer sno;
	private Integer receiptNo;
	private Date receiptDate;
	private String receiptDateString;
	private String vendorId;
	private String vendorName;
	private String itemCode;
	private String itemName;
	private Float testCharge;
	private String chqNo;
	private Date chqDate;
	private String chqDateString;
	private String bankName;
	private String bankCode;
	private String remark;
	private Float netTestCharge;
	private Float serviceTax;
	private Float serviceTaxAmount;
	
	
	public Float getServiceTaxAmount() {
		return serviceTaxAmount;
	}
	public void setServiceTaxAmount(Float serviceTaxAmount) {
		this.serviceTaxAmount = serviceTaxAmount;
	}
	public String getReceiptDateString() {
		return receiptDateString;
	}
	public void setReceiptDateString(String receiptDateString) {
		this.receiptDateString = receiptDateString;
	}
	public String getChqDateString() {
		return chqDateString;
	}
	public void setChqDateString(String chqDateString) {
		this.chqDateString = chqDateString;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Integer getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(Integer receiptNo) {
		this.receiptNo = receiptNo;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
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
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	public Date getChqDate() {
		return chqDate;
	}
	public void setChqDate(Date chqDate) {
		this.chqDate = chqDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Float getNetTestCharge() {
		return netTestCharge;
	}
	public void setNetTestCharge(Float netTestCharge) {
		this.netTestCharge = netTestCharge;
	}
	public Float getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(Float serviceTax) {
		this.serviceTax = serviceTax;
	}
	@Override
	public String toString() {
		return "TestingChargeBean [sno=" + sno + ", receiptNo=" + receiptNo + ", receiptDate=" + receiptDate
				+ ", receiptDateString=" + receiptDateString + ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", itemCode=" + itemCode + ", itemName=" + itemName + ", testCharge=" + testCharge + ", chqNo="
				+ chqNo + ", chqDate=" + chqDate + ", chqDateString=" + chqDateString + ", bankName=" + bankName
				+ ", bankCode=" + bankCode + ", remark=" + remark + ", netTestCharge=" + netTestCharge + ", serviceTax="
				+ serviceTax + ", serviceTaxAmount=" + serviceTaxAmount + "]";
	}
	
	}
