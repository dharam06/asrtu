package com.asrtu.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class StuTransactionBean {
	
	 
	private String quarter;
	private String month;
	private String stuName;
	private Integer year;
	private String stuCode;
	private String nodalCode;
	private String nodalName;
	private Date transactionDate;
	private Date infoReceiptDate;
	
	private List<StuTransColBean> stuColl;

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

	public List<StuTransColBean> getStuColl() {
		return stuColl;
	}
	public void setStuColl(List<StuTransColBean> stuColl) {
		this.stuColl = stuColl;
	}
	@Override
	public String toString() {
		return "StuTransactionBean [quarter=" + quarter + ", month=" + month + ", stuName=" + stuName + ", year=" + year
				+ ", stuCode=" + stuCode + ", nodalCode=" + nodalCode + ", nodalName=" + nodalName
				+ ", transactionDate=" + transactionDate + ", infoReceiptDate=" + infoReceiptDate + ", stuColl="
				+ stuColl + "]";
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


}
