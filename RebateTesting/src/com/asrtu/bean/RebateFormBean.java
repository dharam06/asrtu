package com.asrtu.bean;

import java.util.Date;
import java.util.List;

import com.asrtu.model.Invoice;

public class RebateFormBean {
	
	private Integer receiptNo;
	private String transactionNo;
	private String vendorCode;
	private String vendorName;
	private String itemCode;
	private String itemName;
	private String astruBankName;
	private Integer astruBankID;
	private String chequeNo;
	private Float ddChequeAmount;
	private Float interestOnRebate;
	private Float interestOnServiceTax;
	private Integer tdsAmount;
	private Float incAmount;
	private Integer emdAmount;
	private Float bankcharge;
	private String remarks;
	private String comments;
	
	private String transactionDateString;
	private String receiptDateString;
	private String qfdateString;
	private String qtdateString;
	private String chequeDateString;
	
	private Date transactionDate;
	private Date receiptDate;
	private Date qfdate;
	private Date qtdate;
	private Date chequeDate;
	
	private Float regularRebate;                       
	private Float rebateOutstanding;
	
	private Float invoicePayment;
	
	private String pageAction;
	
	private String transactionIds;
	
	private List<RebateInvoiceBean> rebateInvoiceBean;
	private Float invoiceTotal;
	private Float amountPaidTotal;
	private Float totalDeductions = 0f;
	private Float interestOnRebateInvoice;
		
	public Float getInterestOnRebateInvoice() {
		return interestOnRebateInvoice;
	}

	public void setInterestOnRebateInvoice(Float interestOnRebateInvoice) {
		this.interestOnRebateInvoice = interestOnRebateInvoice;
	}

	public Float getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(Float totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public Float getAmountPaidTotal() {
		return amountPaidTotal;
	}

	public void setAmountPaidTotal(Float amountPaidTotal) {
		this.amountPaidTotal = amountPaidTotal;
	}

	public Float getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(Float invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public List<RebateInvoiceBean> getRebateInvoiceBean() {
		return rebateInvoiceBean;
	}

	public void setRebateInvoiceBean(List<RebateInvoiceBean> rebateInvoiceBean) {
		this.rebateInvoiceBean = rebateInvoiceBean;
	}

	public String getTransactionIds() {
		return transactionIds;
	}

	public void setTransactionIds(String transactionIds) {
		this.transactionIds = transactionIds;
	}

	public String getTransactionDateString() {
		return transactionDateString;
	}

	public void setTransactionDateString(String transactionDateString) {
		this.transactionDateString = transactionDateString;
	}

	public String getReceiptDateString() {
		return receiptDateString;
	}

	public void setReceiptDateString(String receiptDateString) {
		this.receiptDateString = receiptDateString;
	}

	public String getQfdateString() {
		return qfdateString;
	}

	public void setQfdateString(String qfdateString) {
		this.qfdateString = qfdateString;
	}

	public String getQtdateString() {
		return qtdateString;
	}

	public void setQtdateString(String qtdateString) {
		this.qtdateString = qtdateString;
	}

	public String getChequeDateString() {
		return chequeDateString;
	}

	public void setChequeDateString(String chequeDateString) {
		this.chequeDateString = chequeDateString;
	}

	public Float getRegularRebate() {
		return regularRebate;
	}

	public void setRegularRebate(Float regularRebate) {
		this.regularRebate = regularRebate;
	}

	public Float getRebateOutstanding() {
		return rebateOutstanding;
	}

	public void setRebateOutstanding(Float rebateOutstanding) {
		this.rebateOutstanding = rebateOutstanding;
	}

	public Float getInvoicePayment() {
		return invoicePayment;
	}

	public void setInvoicePayment(Float invoicePayment) {
		this.invoicePayment = invoicePayment;
	}

	private List<RebateInvoiceBean> invoiceList;

	public RebateFormBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public Integer getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Integer receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getQfdate() {
		return qfdate;
	}

	public void setQfdate(Date qfdate) {
		this.qfdate = qfdate;
	}

	public Date getQtdate() {
		return qtdate;
	}

	public void setQtdate(Date qtdate) {
		this.qtdate = qtdate;
	}

	public String getAstruBankName() {
		return astruBankName;
	}

	public void setAstruBankName(String astruBankName) {
		this.astruBankName = astruBankName;
	}

	public Integer getAstruBankID() {
		return astruBankID;
	}

	public void setAstruBankID(Integer astruBankID) {
		this.astruBankID = astruBankID;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Float getDdChequeAmount() {
		return ddChequeAmount;
	}

	public void setDdChequeAmount(Float ddChequeAmount) {
		this.ddChequeAmount = ddChequeAmount;
	}

	public Float getInterestOnRebate() {
		return interestOnRebate;
	}

	public void setInterestOnRebate(Float interestOnRebate) {
		this.interestOnRebate = interestOnRebate;
	}

	public Float getInterestOnServiceTax() {
		return interestOnServiceTax;
	}

	public void setInterestOnServiceTax(Float interestOnServiceTax) {
		this.interestOnServiceTax = interestOnServiceTax;
	}

	public Integer getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(Integer tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Float getIncAmount() {
		return incAmount;
	}

	public void setIncAmount(Float incAmount) {
		this.incAmount = incAmount;
	}

	public Integer getEmdAmount() {
		return emdAmount;
	}

	public void setEmdAmount(Integer emdAmount) {
		this.emdAmount = emdAmount;
	}

	public Float getBankcharge() {
		return bankcharge;
	}

	public void setBankcharge(Float bankcharge) {
		this.bankcharge = bankcharge;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<RebateInvoiceBean> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<RebateInvoiceBean> invoiceList) {
		this.invoiceList = invoiceList;
	}

	@Override
	public String toString() {
		return "RebateFormBean [receiptNo=" + receiptNo + ", transactionNo=" + transactionNo + ", vendorCode="
				+ vendorCode + ", vendorName=" + vendorName + ", itemCode=" + itemCode + ", itemName=" + itemName
				+ ", astruBankName=" + astruBankName + ", astruBankID=" + astruBankID + ", chequeNo=" + chequeNo
				+ ", ddChequeAmount=" + ddChequeAmount + ", interestOnRebate=" + interestOnRebate
				+ ", interestOnServiceTax=" + interestOnServiceTax + ", tdsAmount=" + tdsAmount + ", incAmount="
				+ incAmount + ", emdAmount=" + emdAmount + ", bankcharge=" + bankcharge + ", remarks=" + remarks
				+ ", comments=" + comments + ", transactionDateString=" + transactionDateString + ", receiptDateString="
				+ receiptDateString + ", qfdateString=" + qfdateString + ", qtdateString=" + qtdateString
				+ ", chequeDateString=" + chequeDateString + ", transactionDate=" + transactionDate + ", receiptDate="
				+ receiptDate + ", qfdate=" + qfdate + ", qtdate=" + qtdate + ", chequeDate=" + chequeDate
				+ ", regularRebate=" + regularRebate + ", rebateOutstanding=" + rebateOutstanding + ", invoicePayment="
				+ invoicePayment + ", pageAction=" + pageAction + ", transactionIds=" + transactionIds
				+ ", rebateInvoiceBean=" + rebateInvoiceBean + ", invoiceTotal=" + invoiceTotal + ", amountPaidTotal="
				+ amountPaidTotal + ", totalDeductions=" + totalDeductions + ", interestOnRebateInvoice="
				+ interestOnRebateInvoice + ", invoiceList=" + invoiceList + "]";
	}

	
}
