package com.asrtu.bean;

import java.util.Date;
import java.util.List;

import com.asrtu.model.Invoice;
import com.asrtu.model.RebateForm;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.VendorTrans;

public class RebateReconSearchResult {
	
	String stuCode;
	String stuName;
	List<StuTransaction>	stuTransactionList;
	List<VendorTrans> currentVendorTransList;	
	List<VendorTrans> previousVendorTransList;	
	OpeningBalance openingBalance;

	public List<StuTransaction> getStuTransactionList() {
		return stuTransactionList;
	}
	public void setStuTransactionList(List<StuTransaction> stuTransactionList) {
		this.stuTransactionList = stuTransactionList;
	}
	public List<VendorTrans> getCurrentVendorTransList() {
		return currentVendorTransList;
	}
	public void setCurrentVendorTransList(List<VendorTrans> currentVendorTransList) {
		this.currentVendorTransList = currentVendorTransList;
	}
	public List<VendorTrans> getPreviousVendorTransList() {
		return previousVendorTransList;
	}
	public void setPreviousVendorTransList(List<VendorTrans> previousVendorTransList) {
		this.previousVendorTransList = previousVendorTransList;
	}
	public OpeningBalance getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(OpeningBalance openingBalance) {
		this.openingBalance = openingBalance;
	}
	
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	@Override
	public String toString() {
		return "RebateReconSearchResult [stuCode=" + stuCode + ", stuName=" + stuName + ", stuTransactionList="
				+ stuTransactionList + ", currentVendorTransList=" + currentVendorTransList
				+ ", previousVendorTransList=" + previousVendorTransList + ", openingBalance=" + openingBalance + "]";
	}

}
