package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_trans")
public class StuTransInv4 extends StuTransaction implements Serializable{

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
	private String firmName4;
	
	@Column(name="ITEM_NAME")
	private String itemName4;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo4;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate4;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt4;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt4;
	
	
	
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
	public String getFirmName4() {
		return firmName4;
	}
	public void setFirmName4(String firmName4) {
		this.firmName4 = firmName4;
	}
	public String getItemName4() {
		return itemName4;
	}
	public void setItemName4(String itemName4) {
		this.itemName4 = itemName4;
	}
	public String getInvoiceNo4() {
		return invoiceNo4;
	}
	public void setInvoiceNo4(String invoiceNo4) {
		this.invoiceNo4 = invoiceNo4;
	}
	public String getInvoiceDate4() {
		return invoiceDate4;
	}
	public void setInvoiceDate4(String invoiceDate4) {
		this.invoiceDate4 = invoiceDate4;
	}
	public Integer getStu_Tot_Amt4() {
		return stu_Tot_Amt4;
	}
	public void setStu_Tot_Amt4(Integer stu_Tot_Amt4) {
		this.stu_Tot_Amt4 = stu_Tot_Amt4;
	}
	public Integer getStu_Reb_Amt4() {
		return stu_Reb_Amt4;
	}
	public void setStu_Reb_Amt4(Integer stu_Reb_Amt4) {
		this.stu_Reb_Amt4 = stu_Reb_Amt4;
	}
	
		
}

