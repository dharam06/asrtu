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
@Table(name="CIRT_BILL_TRANS")
public class CirtBill implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
		
	@Id
	@Column(name="TRANS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transId;
	
	@Column(name="BILL_NO")
	private String billNo;
	
	@Column(name="BILL_DATE")
	private Date billDate;
	
	@Column(name="BILL_AMT")
	private Float billAmount;
	
	@Column(name="ASRT_REF_NO")
	private String asrtRefNo;
	
	@Column(name="VENDOR_ID")
	private String vendorId;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="STO_NO")
	private Integer stONo;
	
	@Column(name="TEST_CHARGE")
	private Float testCharge;
	
	@Column(name="REMARKS")
	private String remarks;

	@Column(name="STO_ID")
	private String stoId;
	
	public String getStoId() {
		return stoId;
	}

	public void setStoId(String stoId) {
		this.stoId = stoId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Integer getStONo() {
		return stONo;
	}

	public void setStONo(Integer stONo) {
		this.stONo = stONo;
	}

	public Float getTestCharge() {
		return testCharge;
	}

	public void setTestCharge(Float testCharge) {
		this.testCharge = testCharge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CirtBill [transId=" + transId + ", billNo=" + billNo + ", billDate=" + billDate + ", billAmount="
				+ billAmount + ", asrtRefNo=" + asrtRefNo + ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", itemCode=" + itemCode + ", itemName=" + itemName + ", stONo=" + stONo + ", testCharge="
				+ testCharge + ", remarks=" + remarks + ", stoId=" + stoId + "]";
	}




}
