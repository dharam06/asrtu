package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_trans")
public class StuTransInv5 extends StuTransaction implements Serializable{

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
	private String firmName5;
	
	@Column(name="ITEM_NAME")
	private String itemName5;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo5;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate5;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt5;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt5;
	
	
	
	
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
	public String getFirmName5() {
		return firmName5;
	}
	public void setFirmName5(String firmName5) {
		this.firmName5 = firmName5;
	}
	public String getItemName5() {
		return itemName5;
	}
	public void setItemName5(String itemName5) {
		this.itemName5 = itemName5;
	}
	public String getInvoiceNo5() {
		return invoiceNo5;
	}
	public void setInvoiceNo5(String invoiceNo5) {
		this.invoiceNo5 = invoiceNo5;
	}
	public String getInvoiceDate5() {
		return invoiceDate5;
	}
	public void setInvoiceDate5(String invoiceDate5) {
		this.invoiceDate5 = invoiceDate5;
	}
	public Integer getStu_Tot_Amt5() {
		return stu_Tot_Amt5;
	}
	public void setStu_Tot_Amt5(Integer stu_Tot_Amt5) {
		this.stu_Tot_Amt5 = stu_Tot_Amt5;
	}
	public Integer getStu_Reb_Amt5() {
		return stu_Reb_Amt5;
	}
	public void setStu_Reb_Amt5(Integer stu_Reb_Amt5) {
		this.stu_Reb_Amt5 = stu_Reb_Amt5;
	}
	
	

	
}

