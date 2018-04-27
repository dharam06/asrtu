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
@Table(name ="QUARTER")
public class Quarter implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SLNO")
	private Integer slNo;
	
	@Column(name ="QUARTER")
	private String quarter;
	
	@Column(name ="QFROM")
	private Date qFrom;
	
	@Column(name="QTDATE")
	private Date qtDate;
	
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public Date getqFrom() {
		return qFrom;
	}
	public void setqFrom(Date qFrom) {
		this.qFrom = qFrom;
	}
	public Date getQtDate() {
		return qtDate;
	}
	public void setQtDate(Date qtDate) {
		this.qtDate = qtDate;
	}
	@Override
	public String toString() {
		return "Quarter [slNo=" + slNo + ", quarter=" + quarter + ", qFrom=" + qFrom + ", qtDate=" + qtDate + "]";
	}
	
}
