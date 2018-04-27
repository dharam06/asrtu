package com.asrtu.bean;

import java.util.Date;

public class MisSearchCriteria {
	
	private String vendorCode;
	private String itemCode;
	private String stuCode;

	private String rcCellCode;
	
	private String financeYear;
	private Integer financeYearId;

	private String transactionDateFromString;
	private Date transactionDateFrom;
	private String transactionDateToString;
	private Date transactionDateTo;
	
	private boolean isAlternative;
	
	
	public boolean isAlternative() {
		return isAlternative;
	}
	public void setAlternative(boolean isAlternative) {
		this.isAlternative = isAlternative;
	}
	public Integer getFinanceYearId() {
		return financeYearId;
	}
	public void setFinanceYearId(Integer financeYearId) {
		this.financeYearId = financeYearId;
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
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	public String getRcCellCode() {
		return rcCellCode;
	}
	public void setRcCellCode(String rcCellCode) {
		this.rcCellCode = rcCellCode;
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
	
	@Override
	public String toString() {
		return "MisSearchCriteria [vendorCode=" + vendorCode + ", itemCode=" + itemCode + ", stuCode=" + stuCode
				+ ", rcCellCode=" + rcCellCode + ", financeYear=" + financeYear + ", financeYearId=" + financeYearId
				+ ", transactionDateFromString=" + transactionDateFromString + ", transactionDateFrom="
				+ transactionDateFrom + ", transactionDateToString=" + transactionDateToString + ", transactionDateTo="
				+ transactionDateTo + ", isAlternative=" + isAlternative + "]";
	}


}
