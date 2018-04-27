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
@Table(name ="FINANCE_YEAR")
public class FinanceYear implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SLNO")
	private Integer slNo;
	
	@Column(name ="FINANCE_YEAR")
	private String financeYear;
	
	@Column(name ="FINFROM")
	private Date finFrom;
	
	@Column(name="FINDATE")
	private Date finTo;

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getFinanceYear() {
		return financeYear;
	}

	public void setFinanceYear(String financeYear) {
		this.financeYear = financeYear;
	}

	public Date getFinFrom() {
		return finFrom;
	}

	public void setFinFrom(Date finFrom) {
		this.finFrom = finFrom;
	}

	public Date getFinTo() {
		return finTo;
	}

	public void setFinTo(Date finTo) {
		this.finTo = finTo;
	}

	@Override
	public String toString() {
		return "FinanceYear [slNo=" + slNo + ", financeYear=" + financeYear + ", finFrom=" + finFrom + ", finTo="
				+ finTo + "]";
	}
	
	
		
}
