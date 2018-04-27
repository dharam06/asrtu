package com.asrtu.bean;

import java.util.Date;

public class MisSearchResult {
	
	private String vendorCode;
	private String itemCode;
	private String stuCode;
	private String vendorName;
	private String itemName;
	private String stuName;

	private String rcCellCode;

	private Date rateContractFrom;
	private Date rateContractTo;
	private Date clearedUpTo;
	
	private float currentPeriodRebate;
	private float previousPeriodRebate;
	private float rebateDifference;
	
	private Date transactionDateFrom;
	private Date transactionDateTo;
	
	
	private RebateSearchCriteria rebateSearchCriteria;
	
	
	public RebateSearchCriteria getRebateSearchCriteria() {
		return rebateSearchCriteria;
	}
	public void setRebateSearchCriteria(RebateSearchCriteria rebateSearchCriteria) {
		this.rebateSearchCriteria = rebateSearchCriteria;
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
	public String getRcCellCode() {
		return rcCellCode;
	}
	public void setRcCellCode(String rcCellCode) {
		this.rcCellCode = rcCellCode;
	}
	public Date getRateContractFrom() {
		return rateContractFrom;
	}
	public void setRateContractFrom(Date rateContractFrom) {
		this.rateContractFrom = rateContractFrom;
	}
	public Date getRateContractTo() {
		return rateContractTo;
	}
	public void setRateContractTo(Date rateContractTo) {
		this.rateContractTo = rateContractTo;
	}
	public Date getClearedUpTo() {
		return clearedUpTo;
	}
	public void setClearedUpTo(Date clearedUpTo) {
		this.clearedUpTo = clearedUpTo;
	}
	public float getCurrentPeriodRebate() {
		return currentPeriodRebate;
	}
	public void setCurrentPeriodRebate(float currentPeriodRebate) {
		this.currentPeriodRebate = currentPeriodRebate;
	}
	public float getPreviousPeriodRebate() {
		return previousPeriodRebate;
	}
	public void setPreviousPeriodRebate(float previousPeriodRebate) {
		this.previousPeriodRebate = previousPeriodRebate;
	}
	public float getRebateDifference() {
		return rebateDifference;
	}
	public void setRebateDifference(float rebateDifference) {
		this.rebateDifference = rebateDifference;
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
	@Override
	public String toString() {
		return "MisSearchResult [vendorCode=" + vendorCode + ", itemCode=" + itemCode + ", stuCode=" + stuCode
				+ ", vendorName=" + vendorName + ", itemName=" + itemName + ", stuName=" + stuName + ", rcCellCode="
				+ rcCellCode + ", rateContractFrom=" + rateContractFrom + ", rateContractTo=" + rateContractTo
				+ ", clearedUpTo=" + clearedUpTo + ", currentPeriodRebate=" + currentPeriodRebate
				+ ", previousPeriodRebate=" + previousPeriodRebate + ", rebateDifference=" + rebateDifference
				+ ", transactionDateFrom=" + transactionDateFrom + ", transactionDateTo=" + transactionDateTo
				+ ", rebateSearchCriteria=" + rebateSearchCriteria + "]";
	}
	
	


}
