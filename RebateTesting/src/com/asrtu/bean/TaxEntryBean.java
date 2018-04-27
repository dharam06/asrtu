package com.asrtu.bean;

import java.util.Date;

public class TaxEntryBean {

	private Integer sno;
	
	private Date fromDate;
	private Date toDate;
	private String fromDateString;
	private String toDateString;
	
	private Float taxPercent;
	private Float tax1;
	private Float tax2;
	private Float tax3;
	private Float tax4;
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getFromDateString() {
		return fromDateString;
	}
	public void setFromDateString(String fromDateString) {
		this.fromDateString = fromDateString;
	}
	public String getToDateString() {
		return toDateString;
	}
	public void setToDateString(String toDateString) {
		this.toDateString = toDateString;
	}
	public Float getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(Float taxPercent) {
		this.taxPercent = taxPercent;
	}
	public Float getTax1() {
		return tax1;
	}
	public void setTax1(Float tax1) {
		this.tax1 = tax1;
	}
	public Float getTax2() {
		return tax2;
	}
	public void setTax2(Float tax2) {
		this.tax2 = tax2;
	}
	public Float getTax3() {
		return tax3;
	}
	public void setTax3(Float tax3) {
		this.tax3 = tax3;
	}
	public Float getTax4() {
		return tax4;
	}
	public void setTax4(Float tax4) {
		this.tax4 = tax4;
	}
	@Override
	public String toString() {
		return "TaxEntryBean [sno=" + sno + ", fromDate=" + fromDate + ", toDate=" + toDate + ", fromDateString="
				+ fromDateString + ", toDateString=" + toDateString + ", taxPercent=" + taxPercent + ", tax1=" + tax1
				+ ", tax2=" + tax2 + ", tax3=" + tax3 + ", tax4=" + tax4 + "]";
	}
	
	
	
	}
