package com.asrtu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendor_trans")
public class VendorTrans {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private Integer sno;
	
	@Column(name="ASRTU_INVOICE_NO")
	private Integer asrtuInvoiceNumber;
	
	@Column(name="ASRTU_INVOICE_DATE")
	private Date asrtuInvoiceDate;
	
	@Column(name="QUARTER")
	private String quarter;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_CODE")
	private String itemCode;	
	
	@Column(name="QFDATE")
	private Date quarterFromDate;
	
	@Column(name="QTDATE")
	private Date quarterToDate;


	@Column(name="REGULAR_REBATE")
	private Float regularRebate;
	
	@Column(name="REBATE_OUTSTDG")
	private Float rebateOutstanding;
	
	@Column(name="FIRM_NAME")
	private String firmName;
	
	@Column(name="FIRM_CODE")
	private String firmCode;
	
	@Column(name="STU_NAME")
	private String stuName;
	
	@Column(name="STU_CODE")
	private String stuCode;
	
	@Column(name="VEND_TOT_AMT")
	private Float vendorTotalAmount;
	
	@Column(name="VEND_REB_AMT")
	private Float vendorRebateAmount;

	@Column(name="INVOICE_NO")
	private String invoiceNumber;
	
	@Column(name="INVOICE_DATE")
	private Date invoiceDate;
	
	
	@Column(name="PURCHASE_ORDER_NO")
	private String purchaseOrderNumber;
	
	@Column(name="PURCHASE_ORDER_DATE")
	private Date purchaseOrderDate;

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

	public String getFirmName() {
		return firmName;
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

	@Override
	public String toString() {
		return "VendorTrans [sno=" + sno + ", asrtuInvoiceNumber=" + asrtuInvoiceNumber + ", asrtuInvoiceDate="
				+ asrtuInvoiceDate + ", quarter=" + quarter + ", itemName=" + itemName + ", itemCode=" + itemCode
				+ ", quarterFromDate=" + quarterFromDate + ", quarterToDate=" + quarterToDate + ", regularRebate="
				+ regularRebate + ", rebateOutstanding=" + rebateOutstanding + ", firmName=" + firmName + ", firmCode="
				+ firmCode + ", stuName=" + stuName + ", stuCode=" + stuCode + ", vendorTotalAmount="
				+ vendorTotalAmount + ", vendorRebateAmount=" + vendorRebateAmount + ", invoiceNumber=" + invoiceNumber
				+ ", invoiceDate=" + invoiceDate + ", purchaseOrderNumber=" + purchaseOrderNumber
				+ ", purchaseOrderDate=" + purchaseOrderDate + "]";
	}
	
	
}
