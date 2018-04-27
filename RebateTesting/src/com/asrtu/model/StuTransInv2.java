package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_trans")
public class StuTransInv2 extends StuTransaction implements Serializable{

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
	private String firmName2;
	
	@Column(name="ITEM_NAME")
	private String itemName2;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo2;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate2;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt2;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt2;
	
	
	
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
	public String getFirmName2() {
		return firmName2;
	}
	public void setFirmName2(String firmName2) {
		this.firmName2 = firmName2;
	}
	public String getItemName2() {
		return itemName2;
	}
	public void setItemName2(String itemName2) {
		this.itemName2 = itemName2;
	}
	public String getInvoiceNo2() {
		return invoiceNo2;
	}
	public void setInvoiceNo2(String invoiceNo2) {
		this.invoiceNo2 = invoiceNo2;
	}
	public String getInvoiceDate2() {
		return invoiceDate2;
	}
	public void setInvoiceDate2(String invoiceDate2) {
		this.invoiceDate2 = invoiceDate2;
	}
	public Integer getStu_Tot_Amt2() {
		return stu_Tot_Amt2;
	}
	public void setStu_Tot_Amt2(Integer stu_Tot_Amt2) {
		this.stu_Tot_Amt2 = stu_Tot_Amt2;
	}
	public Integer getStu_Reb_Amt2() {
		return stu_Reb_Amt2;
	}
	public void setStu_Reb_Amt2(Integer stu_Reb_Amt2) {
		this.stu_Reb_Amt2 = stu_Reb_Amt2;
	}
	
	
	
	
	
		
}

