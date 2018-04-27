package com.asrtu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sto_issue")
public class StoOrderForm implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer stoTransId;
	
	@Column(name="STONO")
	private Integer stoNo;
	
	@Column(name="STO_ID")
	private String stoId;

	
	@Column(name="VENDOR_ID")
	private String vendorId;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	
	// PLEASE NOTE ITEM_CODE will have PRODUCT GROUP CODE
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	// PLEASE NOTE ITEM_CODE will have PRODUCT GROUP NAME
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="TESTING_CHARGE")
	private Float testCharge;
	
	@Column(name="TESTING_DATE")
	private Date testDate;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="QUANTITY")
	private String quantity;
	
	@Column(name="NETAMOUNT")
	private Float netAmount;

	@Column(name="PRODUCTSUBGROUPCODE")
	private String productSubGroupCode;
	
	@Column(name="IS_PAID")
	private String isPaid;

	@Column(name="TEST_TYPE")
	private String testType;

	@Column(name="RCTRC")
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

	public String getStoId() {
		return stoId;
	}

	public void setStoId(String stoId) {
		this.stoId = stoId;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
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

	public String getProductSubGroupCode() {
		return productSubGroupCode;
	}

	public void setProductSubGroupCode(String productSubGroupCode) {
		this.productSubGroupCode = productSubGroupCode;
	}

	@Override
	public String toString() {
		return "StoOrderForm [stoTransId=" + stoTransId + ", stoNo=" + stoNo + ", stoId=" + stoId + ", vendorId="
				+ vendorId + ", vendorName=" + vendorName + ", itemCode=" + itemCode + ", itemName=" + itemName
				+ ", testCharge=" + testCharge + ", testDate=" + testDate + ", remarks=" + remarks + ", quantity="
				+ quantity + ", netAmount=" + netAmount + ", productSubGroupCode=" + productSubGroupCode + ", isPaid="
				+ isPaid + ", testType=" + testType + ", rctrc=" + rctrc + "]";
	}


}
