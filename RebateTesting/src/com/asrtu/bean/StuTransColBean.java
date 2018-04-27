package com.asrtu.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class StuTransColBean {
	
	
	private Integer sno;
	
	private String vendorName;
	private String vendorCode;
	private String itemCode;
	private String itemName;
	private String invoiceNumber;  
	private Date invoiceDate; 
	private String invoiceDateString;  

	private Float stuTotalAmount;                       
	private Float stuTotalRebate;
	private String firmName;
	
	private String quarter;
	private String month;
	private String stuName;
	private Integer year;
	private String stuCode;
	private String nodalCode;
	private String nodalName;
	private Date transactionDate;
	private String transactionDateString;

	private Date infoReceiptDate;
	private String infoReceiptDateString;
	
	private Date purchaseOrderDate;
	private String purchaseOrderDateString;
	private String purchaseOrderNumber;
	
	
	
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
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Float getStuTotalAmount() {
		return stuTotalAmount;
	}
	public void setStuTotalAmount(Float stuTotalAmount) {
		this.stuTotalAmount = stuTotalAmount;
	}
	public Float getStuTotalRebate() {
		return stuTotalRebate;
	}
	public void setStuTotalRebate(Float stuTotalRebate) {
		this.stuTotalRebate = stuTotalRebate;
	}
	@Override
	public String toString() {
		return "StuTransColBean [sno=" + sno + ", vendorName=" + vendorName + ", vendorCode=" + vendorCode
				+ ", itemCode=" + itemCode + ", itemName=" + itemName + ", invoiceNumber=" + invoiceNumber
				+ ", invoiceDate=" + invoiceDate + ", invoiceDateString=" + invoiceDateString + ", stuTotalAmount="
				+ stuTotalAmount + ", stuTotalRebate=" + stuTotalRebate + ", firmName=" + firmName + ", quarter="
				+ quarter + ", month=" + month + ", stuName=" + stuName + ", year=" + year + ", stuCode=" + stuCode
				+ ", nodalCode=" + nodalCode + ", nodalName=" + nodalName + ", transactionDate=" + transactionDate
				+ ", transactionDateString=" + transactionDateString + ", infoReceiptDate=" + infoReceiptDate
				+ ", infoReceiptDateString=" + infoReceiptDateString + ", purchaseOrderDate=" + purchaseOrderDate
				+ ", purchaseOrderDateString=" + purchaseOrderDateString + ", purchaseOrderNumber="
				+ purchaseOrderNumber + "]";
	}
	public StuTransColBean(String vendorName, String itemName, String invoiceNumber, Float stuTotalAmount, Float stuTotalRebate) {
		super();
		this.vendorName = vendorName;
		this.itemName = itemName;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.stuTotalAmount = stuTotalAmount;
		this.stuTotalRebate = stuTotalRebate;
	}
	public StuTransColBean() {
		super();
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
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
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	public String getNodalCode() {
		return nodalCode;
	}
	public void setNodalCode(String nodalCode) {
		this.nodalCode = nodalCode;
	}
	public String getNodalName() {
		return nodalName;
	}
	public void setNodalName(String nodalName) {
		this.nodalName = nodalName;
	}
	public Date getPurchaseOrderDate() {
		return purchaseOrderDate;
	}
	public void setPurchaseOrderDate(Date purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Date getInfoReceiptDate() {
		return infoReceiptDate;
	}
	public void setInfoReceiptDate(Date infoReceiptDate) {
		this.infoReceiptDate = infoReceiptDate;
	}
	public String getInvoiceDateString() {
		return invoiceDateString;
	}
	public void setInvoiceDateString(String invoiceDateString) {
		this.invoiceDateString = invoiceDateString;
	}
	public String getTransactionDateString() {
		return transactionDateString;
	}
	public void setTransactionDateString(String transactionDateString) {
		this.transactionDateString = transactionDateString;
	}
	public String getInfoReceiptDateString() {
		return infoReceiptDateString;
	}
	public void setInfoReceiptDateString(String infoReceiptDateString) {
		this.infoReceiptDateString = infoReceiptDateString;
	}
	public String getPurchaseOrderDateString() {
		return purchaseOrderDateString;
	}
	public void setPurchaseOrderDateString(String purchaseOrderDateString) {
		this.purchaseOrderDateString = purchaseOrderDateString;
	}   

	
}
