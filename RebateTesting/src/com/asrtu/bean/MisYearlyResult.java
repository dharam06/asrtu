package com.asrtu.bean;

import java.util.Date;

public class MisYearlyResult {
	
	private String financeYearName;

	private String monthName;

	private float budgetCummulatitve;
	private float actualCummulatitve;
	private float currentYearRebate;

	private float prevCummulatitve;
	private float prevYearRebate;
	
	private float cummulativeDifference;

	public String getFinanceYearName() {
		return financeYearName;
	}

	public void setFinanceYearName(String financeYearName) {
		this.financeYearName = financeYearName;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public float getBudgetCummulatitve() {
		return budgetCummulatitve;
	}

	public void setBudgetCummulatitve(float budgetCummulatitve) {
		this.budgetCummulatitve = budgetCummulatitve;
	}

	public float getActualCummulatitve() {
		return actualCummulatitve;
	}

	public void setActualCummulatitve(float actualCummulatitve) {
		this.actualCummulatitve = actualCummulatitve;
	}

	public float getCurrentYearRebate() {
		return currentYearRebate;
	}

	public void setCurrentYearRebate(float currentYearRebate) {
		this.currentYearRebate = currentYearRebate;
	}

	public float getPrevCummulatitve() {
		return prevCummulatitve;
	}

	public void setPrevCummulatitve(float prevCummulatitve) {
		this.prevCummulatitve = prevCummulatitve;
	}

	public float getPrevYearRebate() {
		return prevYearRebate;
	}

	public void setPrevYearRebate(float prevYearRebate) {
		this.prevYearRebate = prevYearRebate;
	}

	public float getCummulativeDifference() {
		return cummulativeDifference;
	}

	public void setCummulativeDifference(float cummulativeDifference) {
		this.cummulativeDifference = cummulativeDifference;
	}

	@Override
	public String toString() {
		return "MisYearlyResult [financeYearName=" + financeYearName + ", monthName=" + monthName
				+ ", budgetCummulatitve=" + budgetCummulatitve + ", actualCummulatitve=" + actualCummulatitve
				+ ", currentYearRebate=" + currentYearRebate + ", prevCummulatitve=" + prevCummulatitve
				+ ", prevYearRebate=" + prevYearRebate + ", cummulativeDifference=" + cummulativeDifference + "]";
	}
	


}
