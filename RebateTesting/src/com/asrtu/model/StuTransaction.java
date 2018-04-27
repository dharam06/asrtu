package com.asrtu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ElementCollection;


@Entity
@Table(name="stu_trans")
public class StuTransaction implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private Integer sno;
	
	@Column(name="QUARTER")
	private String quarter;
	
	@Column(name="MONTH")
	private String month;
	
	@Column(name="STU_NAME")
	private String stuName;
	
	/*@Column(name="YEAR")
	private Integer year;*/
	
	@Column(name="STU_CODE")
	private String stuCode;
	
	@Column(name="NODAL_CODE")
	private String nodalCode;
	
	             
	@Column(name="NODAL_NAME")
	private String nodalName;
	
	@Column(name="VENDOR_CODE")
	private String vendorCode;
	
	            
	@Column(name="ITEM_CODE")
	private String itemCode;              
	     
	@Column(name="ITEM_NAME")
	private String itemName;              

	@Column(name="INVOICE_NO")
	private String invoiceNumber;  

	@DateTimeFormat(pattern="dd/MM/YY")
	@Column(name="INVOICE_DATE")
	private Date invoiceDate;  

	@Column(name="TRANS_DATE")
	private Date transactionDate; 

	@Column(name="INFO_RCPT_DATE")
	private Date infoReceiptDate; 

	@Column(name="PUR_ORDER_DATE")
	private Date purchaseOrderDate; 

    
@Column(name="STU_TOTAL_AMT")
private Float stuTotalAmount;                       
	
@Column(name="STU_TOTAL_REB")
private Float stuTotalRebate;   




@Column(name="FIRM_NAME")
private String firmName; 


@Column(name="PUR_ORDER_NO")
private String purchaseOrderNumber;

public Integer getSno() {
	return sno;
}

public void setSno(Integer sno) {
	this.sno = sno;
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

public Date getInvoiceDate() {
	return invoiceDate;
}

public void setInvoiceDate(Date invoiceDate) {
	this.invoiceDate = invoiceDate;
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

public String getFirmName() {
	return firmName;
}

public void setFirmName(String firmName) {
	this.firmName = firmName;
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

@Override
public String toString() {
	return "StuTransaction [sno=" + sno + ", quarter=" + quarter + ", month=" + month + ", stuName=" + stuName
			+ ", stuCode=" + stuCode + ", nodalCode=" + nodalCode + ", nodalName=" + nodalName + ", vendorCode="
			+ vendorCode + ", itemCode=" + itemCode + ", itemName=" + itemName + ", invoiceNumber=" + invoiceNumber
			+ ", invoiceDate=" + invoiceDate + ", stuTotalAmount=" + stuTotalAmount + ", stuTotalRebate="
			+ stuTotalRebate + ", transactionDate=" + transactionDate + ", infoReceiptDate=" + infoReceiptDate
			+ ", firmName=" + firmName + ", purchaseOrderDate=" + purchaseOrderDate + ", purchaseOrderNumber="
			+ purchaseOrderNumber + "]";
} 

/*
@Column(name="VEND_TOTAL_REB")
private Integer nodalCode;   
	          
	 
@Column(name="VEND_TOTAL_AMT")
private Integer nodalCode;   
	
@Column(name="QFDATE")
private Integer nodalCode;   
	 
@Column(name="QTDATE")
private Integer nodalCode;   
	   


@Column(name="RCPTDATE")
private Integer nodalCode;  
	             
	
@Column(name="DIVISION")
private Integer nodalCode;  
	 
@Column(name="NODEL_NAME")
private Integer nodalCode;  
	               
	
@Column(name="DTYPE")
private Integer nodalCode;  
	               
	

@Column(name="TRANS_DATE")
private Integer nodalCode;  
	                  */
	             
	/*
	@Column(name="FIRM_NAME")
	private String firmName1;
	
	@Column(name="ITEM_NAME")
	private String itemName1;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo1;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate1;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt1;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt1;
	*/

}
