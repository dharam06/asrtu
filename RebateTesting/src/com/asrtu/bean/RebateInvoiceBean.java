package com.asrtu.bean;

import java.util.Date;

public class RebateInvoiceBean {
	

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
	
	private Float invoicePayment;
	
	private String rebateType;
	private Float totalTaxPercentage; 
	
	private String gstNumber;
	private Integer gstId;
	
	private Float rebatePrOutstanding;
	private Float rebatePrRemainingOutstanding;
	private Float rebateTaxOutstanding;
	private Float rebateTaxRemainingOutstanding;
	
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
	public Float getTotalTaxPercentage() {
		return totalTaxPercentage;
	}
	public void setTotalTaxPercentage(Float totalTaxPercentage) {
		this.totalTaxPercentage = totalTaxPercentage;
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
	public RebateInvoiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RebateInvoiceBean(Integer invoiceNumber,Integer asrtuInvoiceNumber, Float rebateOutstanding, Float rebateRemainingOutstanding) {
		super();
		this.asrtuInvoiceNumber = asrtuInvoiceNumber;
		this.invoiceNumber = invoiceNumber;
		this.rebateOutstanding = rebateOutstanding;
		this.rebateRemainingOutstanding = rebateRemainingOutstanding;
	}
	public Float getInvoicePayment() {
		return invoicePayment;
	}
	public void setInvoicePayment(Float invoicePayment) {
		this.invoicePayment = invoicePayment;
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
		return "RebateInvoiceBean [invoiceNumber=" + invoiceNumber + ", asrtuInvoiceNumber=" + asrtuInvoiceNumber
				+ ", invoiceDate=" + invoiceDate + ", quarter=" + quarter + ", quarterFromDate=" + quarterFromDate
				+ ", quarterToDate=" + quarterToDate + ", invoiceDateString=" + invoiceDateString
				+ ", quarterFromDateString=" + quarterFromDateString + ", quarterToDateString=" + quarterToDateString
				+ ", vendorCode=" + vendorCode + ", firmName=" + firmName + ", itemCode=" + itemCode + ", itemName="
				+ itemName + ", regularRebate=" + regularRebate + ", rebateOutstanding=" + rebateOutstanding
				+ ", rebateRemainingOutstanding=" + rebateRemainingOutstanding + ", invoicePayment=" + invoicePayment
				+ ", rebateType=" + rebateType + ", totalTaxPercentage=" + totalTaxPercentage + ", gstNumber="
				+ gstNumber + ", gstId=" + gstId + ", rebatePrOutstanding=" + rebatePrOutstanding
				+ ", rebatePrRemainingOutstanding=" + rebatePrRemainingOutstanding + ", rebateTaxOutstanding="
				+ rebateTaxOutstanding + ", rebateTaxRemainingOutstanding=" + rebateTaxRemainingOutstanding
				+ ", getAsrtuInvoiceNumber()=" + getAsrtuInvoiceNumber() + ", getGstNumber()=" + getGstNumber()
				+ ", getGstId()=" + getGstId() + ", getRebatePrOutstanding()=" + getRebatePrOutstanding()
				+ ", getRebatePrRemainingOutstanding()=" + getRebatePrRemainingOutstanding()
				+ ", getRebateTaxOutstanding()=" + getRebateTaxOutstanding() + ", getRebateTaxRemainingOutstanding()="
				+ getRebateTaxRemainingOutstanding() + ", getTotalTaxPercentage()=" + getTotalTaxPercentage()
				+ ", getRebateType()=" + getRebateType() + ", getRebateRemainingOutstanding()="
				+ getRebateRemainingOutstanding() + ", getInvoicePayment()=" + getInvoicePayment()
				+ ", getInvoiceNumber()=" + getInvoiceNumber() + ", getInvoiceDate()=" + getInvoiceDate()
				+ ", getVendorCode()=" + getVendorCode() + ", getFirmName()=" + getFirmName() + ", getQuarter()="
				+ getQuarter() + ", getItemCode()=" + getItemCode() + ", getItemName()=" + getItemName()
				+ ", getQuarterFromDate()=" + getQuarterFromDate() + ", getQuarterToDate()=" + getQuarterToDate()
				+ ", getRegularRebate()=" + getRegularRebate() + ", getRebateOutstanding()=" + getRebateOutstanding()
				+ ", getInvoiceDateString()=" + getInvoiceDateString() + ", getQuarterFromDateString()="
				+ getQuarterFromDateString() + ", getQuarterToDateString()=" + getQuarterToDateString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
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
