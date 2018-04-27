package com.asrtu.bean;

import java.util.Date;
import java.util.List;

public class VendorTransBean {
	
	private Integer sno;
	private Integer asrtuInvoiceNumber;
	private String quarter;
	private String itemName;
	private String itemCode;	
	private Float regularRebate;
	private Float rebateOutstanding;
	private String firmName;
	private String firmCode;
	private String stuName;
	private String stuCode;
	private Float vendorTotalAmount;
	private Float vendorRebateAmount;
	private Integer invoiceNumber;
	private String purchaseOrderNumber;
	private Date purchaseOrderDate;	
	private Date asrtuInvoiceDate;
	private Date quarterFromDate;
	private Date quarterToDate;
	private Date invoiceDate;

	private String purchaseOrderDateString;	
	private String asrtuInvoiceDateString;
	private String quarterFromDateString;
	private String quarterToDateString;
	private String invoiceDateString;

	private String pageAction;
	
	private List<VendorTransBeanDetail> vendorTransBeanDetail;

	public String getPurchaseOrderDateString() {
		return purchaseOrderDateString;
	}

	public void setPurchaseOrderDateString(String purchaseOrderDateString) {
		this.purchaseOrderDateString = purchaseOrderDateString;
	}

	public String getAsrtuInvoiceDateString() {
		return asrtuInvoiceDateString;
	}

	public void setAsrtuInvoiceDateString(String asrtuInvoiceDateString) {
		this.asrtuInvoiceDateString = asrtuInvoiceDateString;
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

	public String getInvoiceDateString() {
		return invoiceDateString;
	}

	public void setInvoiceDateString(String invoiceDateString) {
		this.invoiceDateString = invoiceDateString;
	}

	public VendorTransBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getAsrtuInvoiceNumber() {
		return asrtuInvoiceNumber;
	}

	public void setAsrtuInvoiceNumber(Integer asrtuInvoiceNumber) {
		this.asrtuInvoiceNumber = asrtuInvoiceNumber;
	}

	public Date getAsrtuInvoiceDate() {
		return asrtuInvoiceDate;
	}

	public void setAsrtuInvoiceDate(Date asrtuInvoiceDate) {
		this.asrtuInvoiceDate = asrtuInvoiceDate;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getFirmCode() {
		return firmCode;
	}

	public void setFirmCode(String firmCode) {
		this.firmCode = firmCode;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuCode() {
		return stuCode;
	}

	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}

	public Float getVendorTotalAmount() {
		return vendorTotalAmount;
	}

	public void setVendorTotalAmount(Float vendorTotalAmount) {
		this.vendorTotalAmount = vendorTotalAmount;
	}

	public Float getVendorRebateAmount() {
		return vendorRebateAmount;
	}

	public void setVendorRebateAmount(Float vendorRebateAmount) {
		this.vendorRebateAmount = vendorRebateAmount;
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

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Date getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(Date purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public List<VendorTransBeanDetail> getVendorTransBeanDetail() {
		return vendorTransBeanDetail;
	}

	public void setVendorTransBeanDetail(List<VendorTransBeanDetail> vendorTransBeanDetail) {
		this.vendorTransBeanDetail = vendorTransBeanDetail;
	}

	@Override
	public String toString() {
		return "VendorTransBean [sno=" + sno + ", asrtuInvoiceNumber=" + asrtuInvoiceNumber + ", quarter=" + quarter
				+ ", itemName=" + itemName + ", itemCode=" + itemCode + ", regularRebate=" + regularRebate
				+ ", rebateOutstanding=" + rebateOutstanding + ", firmName=" + firmName + ", firmCode=" + firmCode
				+ ", stuName=" + stuName + ", stuCode=" + stuCode + ", vendorTotalAmount=" + vendorTotalAmount
				+ ", vendorRebateAmount=" + vendorRebateAmount + ", invoiceNumber=" + invoiceNumber
				+ ", purchaseOrderNumber=" + purchaseOrderNumber + ", purchaseOrderDate=" + purchaseOrderDate
				+ ", asrtuInvoiceDate=" + asrtuInvoiceDate + ", quarterFromDate=" + quarterFromDate + ", quarterToDate="
				+ quarterToDate + ", invoiceDate=" + invoiceDate + ", purchaseOrderDateString="
				+ purchaseOrderDateString + ", asrtuInvoiceDateString=" + asrtuInvoiceDateString
				+ ", quarterFromDateString=" + quarterFromDateString + ", quarterToDateString=" + quarterToDateString
				+ ", invoiceDateString=" + invoiceDateString + ", pageAction=" + pageAction + ", vendorTransBeanDetail="
				+ vendorTransBeanDetail + "]";
	}

	
}
