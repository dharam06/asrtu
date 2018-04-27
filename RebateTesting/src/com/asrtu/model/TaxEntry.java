package com.asrtu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tax_master")
public class TaxEntry implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer sno;
	
	@Column(name="PERCENTAGE")
	private Float taxPercent;
	
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	@Column(name="TO_DATE")
	private Date toDate;

	@Column(name="TAX1")
	private Float tax1;
	
	@Column(name="TAX12")
	private Float tax2;
	
	@Column(name="TAX3")
	private Float tax3;
	
	@Column(name="TAX4")
	private Float tax4;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Float getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(Float taxPercent) {
		this.taxPercent = taxPercent;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TaxEntry [sno=" + sno + ", taxPercent=" + taxPercent + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", tax1=" + tax1 + ", tax2=" + tax2 + ", tax3=" + tax3 + ", tax4=" + tax4 + "]";
	}
		
	
}
