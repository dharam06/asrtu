package com.asrtu.bean;

import java.util.Date;

import javax.persistence.Column;

public class OpeningBalance {

	private String vendorCode;
	private String itemCode;
	private Date openBalanceDate;
	private Float rebateBalance;                       
	private Float taxBalance;
	private Float total;

	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Date getOpenBalanceDate() {
		return openBalanceDate;
	}
	public void setOpenBalanceDate(Date openBalanceDate) {
		this.openBalanceDate = openBalanceDate;
	}
	public Float getRebateBalance() {
		return rebateBalance;
	}
	public void setRebateBalance(Float rebateBalance) {
		this.rebateBalance = rebateBalance;
	}
	public Float getTaxBalance() {
		return taxBalance;
	}
	public void setTaxBalance(Float taxBalance) {
		this.taxBalance = taxBalance;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "OpeningBalance [vendorCode=" + vendorCode + ", itemCode=" + itemCode + ", openBalanceDate="
				+ openBalanceDate + ", rebateBalance=" + rebateBalance + ", taxBalance=" + taxBalance + ", total="
				+ total + "]";
	}
	
	

}
