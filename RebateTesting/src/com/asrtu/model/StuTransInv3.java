package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_trans")
public class StuTransInv3 extends StuTransaction implements Serializable{

	@Id
	@Column(name="QUARTER")
	
	private String quarter;
	
	@Column(name="MONTH")
	private String month;
	
	@Column(name="STU_NAME")
	private String stuName;
	
	@Column(name="YEAR")
	private Integer year;
	
	@Column(name="STU_CODE")
	private String stuCode;
	
	@Column(name="NODAL_CODE")
	private String nodalCode;
	
	@Column(name="FIRM_NAME")
	private String firmName3;
	
	@Column(name="ITEM_NAME")
	private String itemName3;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo3;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate3;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt3;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt3;
	
	
	
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
	public String getFirmName3() {
		return firmName3;
	}
	public void setFirmName3(String firmName3) {
		this.firmName3 = firmName3;
	}
	public String getItemName3() {
		return itemName3;
	}
	public void setItemName3(String itemName3) {
		this.itemName3 = itemName3;
	}
	public String getInvoiceNo3() {
		return invoiceNo3;
	}
	public void setInvoiceNo3(String invoiceNo3) {
		this.invoiceNo3 = invoiceNo3;
	}
	public String getInvoiceDate3() {
		return invoiceDate3;
	}
	public void setInvoiceDate3(String invoiceDate3) {
		this.invoiceDate3 = invoiceDate3;
	}
	public Integer getStu_Tot_Amt3() {
		return stu_Tot_Amt3;
	}
	public void setStu_Tot_Amt3(Integer stu_Tot_Amt3) {
		this.stu_Tot_Amt3 = stu_Tot_Amt3;
	}
	public Integer getStu_Reb_Amt3() {
		return stu_Reb_Amt3;
	}
	public void setStu_Reb_Amt3(Integer stu_Reb_Amt3) {
		this.stu_Reb_Amt3 = stu_Reb_Amt3;
	}
	
	
	
	
		
}

