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
@Table(name="testing_charge")
public class TestingCharge implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECEIPT_NO")
	private Integer receiptNo;
	
	@Column(name="RECEIPT_DATE")
	private Date receiptDate;
	
	@Column(name="VENDOR_CODE")
	private String vendorId;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="ITEM_GROUP_CODE")
	private String itemCode;
	
	@Column(name="ITEM_GROUP_NAME")
	private String itemName;
	
	@Column(name="TESTING_CHARGE")
	private Float testCharge;
	
	@Column(name="DDNO")
	private String chqNo;
	
	@Column(name="DD_DATE")
	private Date chqDate;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Column(name="BANK_CODE")
	private String bankCode;
	
	@Column(name="REMARKS")
	private String remark;
	
	@Column(name="NET_TEST_CHARGE")
	private Float netTestCharge;
	
	@Column(name="SERVICE_TAX")
	private Float serviceTax;

	@Column(name="SERVICE_TAX_AMOUNT")
	private Float serviceTaxAmount;
	
	public Float getServiceTaxAmount() {
		return serviceTaxAmount;
	}

	public void setServiceTaxAmount(Float serviceTaxAmount) {
		this.serviceTaxAmount = serviceTaxAmount;
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
		return "TestingCharge [receiptNo=" + receiptNo + ", receiptDate=" + receiptDate + ", vendorId=" + vendorId
				+ ", vendorName=" + vendorName + ", itemCode=" + itemCode + ", itemName=" + itemName + ", testCharge="
				+ testCharge + ", chqNo=" + chqNo + ", chqDate=" + chqDate + ", bankName=" + bankName + ", bankCode="
				+ bankCode + ", remark=" + remark + ", netTestCharge=" + netTestCharge + ", serviceTax=" + serviceTax
				+ ", serviceTaxAmount=" + serviceTaxAmount + "]";
	}

	
	
}
