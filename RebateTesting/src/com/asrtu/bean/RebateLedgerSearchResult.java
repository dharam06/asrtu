package com.asrtu.bean;

import java.util.Date;
import java.util.List;

import com.asrtu.model.Invoice;
import com.asrtu.model.RebateForm;

public class RebateLedgerSearchResult {
	
	List<Invoice>	invoiceList;
	List<RebateForm> rebateForm;	
	Date transactionDate;
	OpeningBalance openingBalance;
	
	String vendorName;
	String itemName;
	String finacialYear;
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getFinacialYear() {
		return finacialYear;
	}
	public void setFinacialYear(String finacialYear) {
		this.finacialYear = finacialYear;
	}
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public List<RebateForm> getRebateForm() {
		return rebateForm;
	}
	public void setRebateForm(List<RebateForm> rebateForm) {
		this.rebateForm = rebateForm;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public OpeningBalance getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(OpeningBalance openingBalance) {
		this.openingBalance = openingBalance;
	}
	@Override
	public String toString() {
		return "RebateLedgerSearchResult [invoiceList=" + invoiceList + ", rebateForm=" + rebateForm
				+ ", transactionDate=" + transactionDate + ", openingBalance=" + openingBalance + ", vendorName="
				+ vendorName + ", itemName=" + itemName + ", finacialYear=" + finacialYear + "]";
	}
	

}
