package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StuTransCol implements Serializable {
	
	@Column(name="FIRM_NAME")
	private String vendorName;
	
	private String vendorCode;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	private String itemCode;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt;
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
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
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Integer getStu_Tot_Amt() {
		return stu_Tot_Amt;
	}
	public void setStu_Tot_Amt(Integer stu_Tot_Amt) {
		this.stu_Tot_Amt = stu_Tot_Amt;
	}
	public Integer getStu_Reb_Amt() {
		return stu_Reb_Amt;
	}
	public void setStu_Reb_Amt(Integer stu_Reb_Amt) {
		this.stu_Reb_Amt = stu_Reb_Amt;
	}
	
	

}
