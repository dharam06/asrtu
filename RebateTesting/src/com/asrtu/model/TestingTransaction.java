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
@Table(name="TESTING_TRANS")
public class TestingTransaction implements Serializable  {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANS_ID")
	private Integer transactionNumber;
	
	@Column(name="VENDOR_CODE")
	private String vendorId;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="ITEM_GROUP_CODE")
	private String itemCode;
	
	@Column(name="ITEM_GROUP_NAME")
	private String itemName;
	
	@Column(name="OPEN_BALANCE")
	private Float openingBalance;

	@Column(name="CLOSE_BALANCE")
	private Float closingBalance;

	@Column(name="CREDIT")
	private Float creditAmount;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="TRANS_DATE")
	private Date transactionDate;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
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

	public Float getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Float openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Float getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Float closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Float getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Float creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TestingTransaction [transactionNumber=" + transactionNumber + ", vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", itemCode=" + itemCode + ", itemName=" + itemName + ", openingBalance="
				+ openingBalance + ", closingBalance=" + closingBalance + ", creditAmount=" + creditAmount
				+ ", remarks=" + remarks + ", transactionDate=" + transactionDate + "]";
	}
	
	

}
