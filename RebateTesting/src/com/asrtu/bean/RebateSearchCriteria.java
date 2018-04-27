package com.asrtu.bean;

import java.util.Date;

public class RebateSearchCriteria {

	
	
	private String vendorCode;
	private String itemCode;
	private String transactionDateFromString;
	private Date transactionDateFrom;
	private String transactionDateToString;
	private Date transactionDateTo;

	
	private Date transactionDate;
	private String chequeNo;
	private Date chequeDate;

	private String financeYear;
	private Integer financeYearId;

	private String vendorName;
	private String itemName;

	
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
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public Date getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
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
	public String getTransactionDateFromString() {
		return transactionDateFromString;
	}
	public void setTransactionDateFromString(String transactionDateFromString) {
		this.transactionDateFromString = transactionDateFromString;
	}
	public Date getTransactionDateFrom() {
		return transactionDateFrom;
	}
	public void setTransactionDateFrom(Date transactionDateFrom) {
		this.transactionDateFrom = transactionDateFrom;
	}
	public String getTransactionDateToString() {
		return transactionDateToString;
	}
	public void setTransactionDateToString(String transactionDateToString) {
		this.transactionDateToString = transactionDateToString;
	}
	public Date getTransactionDateTo() {
		return transactionDateTo;
	}
	public void setTransactionDateTo(Date transactionDateTo) {
		this.transactionDateTo = transactionDateTo;
	}
	
	
	public String getFinanceYear() {
		return financeYear;
	}
	public void setFinanceYear(String financeYear) {
		this.financeYear = financeYear;
	}
	public Integer getFinanceYearId() {
		return financeYearId;
	}
	public void setFinanceYearId(Integer financeYearId) {
		this.financeYearId = financeYearId;
	}
	@Override
	public String toString() {
		return "RebateSearchCriteria [vendorCode=" + vendorCode + ", itemCode=" + itemCode
				+ ", transactionDateFromString=" + transactionDateFromString + ", transactionDateFrom="
				+ transactionDateFrom + ", transactionDateToString=" + transactionDateToString + ", transactionDateTo="
				+ transactionDateTo + ", transactionDate=" + transactionDate + ", chequeNo=" + chequeNo
				+ ", chequeDate=" + chequeDate + ", financeYear=" + financeYear + ", financeYearId=" + financeYearId
				+ ", vendorName=" + vendorName + ", itemName=" + itemName + "]";
	}
	
}
