package com.asrtu.bean;

import java.util.Date;

import javax.persistence.Column;

public class InvoiceBean {
	

	private Integer invoiceNumber;
	private Integer asrtuInvoiceNumber;
	
	public Integer getAsrtuInvoiceNumber() {
		return asrtuInvoiceNumber;
	}
	public void setAsrtuInvoiceNumber(Integer asrtuInvoiceNumber) {
		this.asrtuInvoiceNumber = asrtuInvoiceNumber;
	}
	private Date invoiceDate;
	
	private String quarter;
	private Date quarterFromDate;
	private Date quarterToDate;
	
	private String invoiceDateString;
	private String quarterFromDateString;
	private String quarterToDateString;
	
	private String vendorCode;
	private String firmName; 
	private String itemCode;              
	private String itemName;    

	private Float regularRebate;                       
	private Float rebateOutstanding;
	
	private Float rebateRemainingOutstanding;
	
	private String rebateType;
	
	private Float totalTax;
	
	private Float tax1;
	
	private Float tax2;
	
	private Float tax3;
	
	private Float tax4;
	private Float amount;

	private Float totalTaxPercentage;
	private Float taxPercentage1;
	private Float taxPercentage2;
	private Float taxPercentage3;
	private Float taxPercentage4;
	
	private Float interestOnServiceTax;
	
	private String gstNumber;
	private Integer gstId;
	
	private Float rebatePrOutstanding;
	private Float rebatePrRemainingOutstanding;
	private Float rebateTaxOutstanding;
	private Float rebateTaxRemainingOutstanding;
	
	
	public Float getRebatePrOutstanding() {
		return rebatePrOutstanding;
	}
	public void setRebatePrOutstanding(Float rebatePrOutstanding) {
		this.rebatePrOutstanding = rebatePrOutstanding;
	}
	public Float getRebatePrRemainingOutstanding() {
		return rebatePrRemainingOutstanding;
	}
	public void setRebatePrRemainingOutstanding(Float rebatePrRemainingOutstanding) {
		this.rebatePrRemainingOutstanding = rebatePrRemainingOutstanding;
	}
	public Float getRebateTaxOutstanding() {
		return rebateTaxOutstanding;
	}
	public void setRebateTaxOutstanding(Float rebateTaxOutstanding) {
		this.rebateTaxOutstanding = rebateTaxOutstanding;
	}
	public Float getRebateTaxRemainingOutstanding() {
		return rebateTaxRemainingOutstanding;
	}
	public void setRebateTaxRemainingOutstanding(Float rebateTaxRemainingOutstanding) {
		this.rebateTaxRemainingOutstanding = rebateTaxRemainingOutstanding;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public Integer getGstId() {
		return gstId;
	}
	public void setGstId(Integer gstId) {
		this.gstId = gstId;
	}
	public Float getInterestOnServiceTax() {
		return interestOnServiceTax;
	}
	public void setInterestOnServiceTax(Float interestOnServiceTax) {
		this.interestOnServiceTax = interestOnServiceTax;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getTotalTaxPercentage() {
		return totalTaxPercentage;
	}
	public void setTotalTaxPercentage(Float totalTaxPercentage) {
		this.totalTaxPercentage = totalTaxPercentage;
	}
	public Float getTaxPercentage1() {
		return taxPercentage1;
	}
	public void setTaxPercentage1(Float taxPercentage1) {
		this.taxPercentage1 = taxPercentage1;
	}
	public Float getTaxPercentage2() {
		return taxPercentage2;
	}
	public void setTaxPercentage2(Float taxPercentage2) {
		this.taxPercentage2 = taxPercentage2;
	}
	public Float getTaxPercentage3() {
		return taxPercentage3;
	}
	public void setTaxPercentage3(Float taxPercentage3) {
		this.taxPercentage3 = taxPercentage3;
	}
	public Float getTaxPercentage4() {
		return taxPercentage4;
	}
	public void setTaxPercentage4(Float taxPercentage4) {
		this.taxPercentage4 = taxPercentage4;
	}
	public Float getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Float totalTax) {
		this.totalTax = totalTax;
	}
	public Float getTax1() {
		return tax1;
	}
	public void setTax1(Float tax1) {
		this.tax1 = tax1;
	}
	public Float getTax2() {
		return tax2;
	}
	public void setTax2(Float tax2) {
		this.tax2 = tax2;
	}
	public Float getTax3() {
		return tax3;
	}
	public void setTax3(Float tax3) {
		this.tax3 = tax3;
	}
	public Float getTax4() {
		return tax4;
	}
	public void setTax4(Float tax4) {
		this.tax4 = tax4;
	}
	public String getRebateType() {
		return rebateType;
	}
	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}
	public Float getRebateRemainingOutstanding() {
		return rebateRemainingOutstanding;
	}
	public void setRebateRemainingOutstanding(Float rebateRemainingOutstanding) {
		this.rebateRemainingOutstanding = rebateRemainingOutstanding;
	}
	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
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
	public Date getQuarterFromDate() {
		return quarterFromDate;
	}
	public void setQuarterFromDate(Date quarterFromDate) {
		this.quarterFromDate = quarterFromDate;
	}
	public Date getQuarterToDate() {
		return quarterToDate;
	}
	public void setQuarterToDate(Date quarterToDate) {
		this.quarterToDate = quarterToDate;
	}
	public Float getRegularRebate() {
		return regularRebate;
	}
	public void setRegularRebate(Float regularRebate) {
		this.regularRebate = regularRebate;
	}
	public Float getRebateOutstanding() {
		return rebateOutstanding;
	}
	public void setRebateOutstanding(Float rebateOutstanding) {
		this.rebateOutstanding = rebateOutstanding;
	}
	@Override
	public String toString() {
		return "InvoiceBean [invoiceNumber=" + invoiceNumber + ", asrtuInvoiceNumber=" + asrtuInvoiceNumber
				+ ", invoiceDate=" + invoiceDate + ", quarter=" + quarter + ", quarterFromDate=" + quarterFromDate
				+ ", quarterToDate=" + quarterToDate + ", invoiceDateString=" + invoiceDateString
				+ ", quarterFromDateString=" + quarterFromDateString + ", quarterToDateString=" + quarterToDateString
				+ ", vendorCode=" + vendorCode + ", firmName=" + firmName + ", itemCode=" + itemCode + ", itemName="
				+ itemName + ", regularRebate=" + regularRebate + ", rebateOutstanding=" + rebateOutstanding
				+ ", rebateRemainingOutstanding=" + rebateRemainingOutstanding + ", rebateType=" + rebateType
				+ ", totalTax=" + totalTax + ", tax1=" + tax1 + ", tax2=" + tax2 + ", tax3=" + tax3 + ", tax4=" + tax4
				+ ", amount=" + amount + ", totalTaxPercentage=" + totalTaxPercentage + ", taxPercentage1="
				+ taxPercentage1 + ", taxPercentage2=" + taxPercentage2 + ", taxPercentage3=" + taxPercentage3
				+ ", taxPercentage4=" + taxPercentage4 + ", interestOnServiceTax=" + interestOnServiceTax
				+ ", gstNumber=" + gstNumber + ", gstId=" + gstId + ", rebatePrOutstanding=" + rebatePrOutstanding
				+ ", rebatePrRemainingOutstanding=" + rebatePrRemainingOutstanding + ", rebateTaxOutstanding="
				+ rebateTaxOutstanding + ", rebateTaxRemainingOutstanding=" + rebateTaxRemainingOutstanding
				+ ", getAsrtuInvoiceNumber()=" + getAsrtuInvoiceNumber() + ", getRebatePrOutstanding()="
				+ getRebatePrOutstanding() + ", getRebatePrRemainingOutstanding()=" + getRebatePrRemainingOutstanding()
				+ ", getRebateTaxOutstanding()=" + getRebateTaxOutstanding() + ", getRebateTaxRemainingOutstanding()="
				+ getRebateTaxRemainingOutstanding() + ", getGstNumber()=" + getGstNumber() + ", getGstId()="
				+ getGstId() + ", getInterestOnServiceTax()=" + getInterestOnServiceTax() + ", getAmount()="
				+ getAmount() + ", getTotalTaxPercentage()=" + getTotalTaxPercentage() + ", getTaxPercentage1()="
				+ getTaxPercentage1() + ", getTaxPercentage2()=" + getTaxPercentage2() + ", getTaxPercentage3()="
				+ getTaxPercentage3() + ", getTaxPercentage4()=" + getTaxPercentage4() + ", getTotalTax()="
				+ getTotalTax() + ", getTax1()=" + getTax1() + ", getTax2()=" + getTax2() + ", getTax3()=" + getTax3()
				+ ", getTax4()=" + getTax4() + ", getRebateType()=" + getRebateType()
				+ ", getRebateRemainingOutstanding()=" + getRebateRemainingOutstanding() + ", getInvoiceNumber()="
				+ getInvoiceNumber() + ", getInvoiceDate()=" + getInvoiceDate() + ", getVendorCode()=" + getVendorCode()
				+ ", getFirmName()=" + getFirmName() + ", getQuarter()=" + getQuarter() + ", getItemCode()="
				+ getItemCode() + ", getItemName()=" + getItemName() + ", getQuarterFromDate()=" + getQuarterFromDate()
				+ ", getQuarterToDate()=" + getQuarterToDate() + ", getRegularRebate()=" + getRegularRebate()
				+ ", getRebateOutstanding()=" + getRebateOutstanding() + ", getInvoiceDateString()="
				+ getInvoiceDateString() + ", getQuarterFromDateString()=" + getQuarterFromDateString()
				+ ", getQuarterToDateString()=" + getQuarterToDateString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getInvoiceDateString() {
		return invoiceDateString;
	}
	public void setInvoiceDateString(String invoiceDateString) {
		this.invoiceDateString = invoiceDateString;
	}
	public String getQuarterFromDateString() {
		return quarterFromDateString;
	}
	public void setQuarterFromDateString(String quarterFromDateString) {
		this.quarterFromDateString = quarterFromDateString;
	}
	public String getQuarterToDateString() {
		return quarterToDateString;
	}
	public void setQuarterToDateString(String quarterToDateString) {
		this.quarterToDateString = quarterToDateString;
	}

}
