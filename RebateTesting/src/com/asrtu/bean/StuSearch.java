package com.asrtu.bean;

import java.util.Date;

import javax.persistence.Column;

public class StuSearch {
	
	private String vendorCode;
	private String itemCode;
	private Date transactionDateFrom;
	private Date transactionDateTo;
	private Date transactionDate;
	private String stuCode;
	private String nodalName;
	private String nodalCode;
	
	private String alternative;
	
	private String vendorName;
	private String itemName;
	private String stuName;
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getAlternative() {
		return alternative;
	}
	public void setAlternative(String alternative) {
		this.alternative = alternative;
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
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	
	public String getNodalName() {
		return nodalName;
	}
	public void setNodalName(String nodalName) {
		this.nodalName = nodalName;
	}
	public String getNodalCode() {
		return nodalCode;
	}
	public void setNodalCode(String nodalCode) {
		this.nodalCode = nodalCode;
	}
	
	@Override
	public String toString() {
		return "StuSearch [vendorCode=" + vendorCode + ", itemCode=" + itemCode + ", transactionDateFrom="
				+ transactionDateFrom + ", transactionDateTo=" + transactionDateTo + ", transactionDate="
				+ transactionDate + ", stuCode=" + stuCode + ", nodalName=" + nodalName + ", nodalCode=" + nodalCode
				+ ", alternative=" + alternative + ", vendorName=" + vendorName + ", itemName=" + itemName
				+ ", stuName=" + stuName + "]";
	}
	
	
}
