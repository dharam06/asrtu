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
@Table(name="reb_transaction_table")
public class RebateForm implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECEIPT_NO")
	private Integer receiptNo;
	
	@Column(name="TRANSACTION_NO")
	private String transactionNo;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;

	@Column(name="RCPTDATE")
	private Date receiptDate;

	@Column(name="VENDOR_CODE")
	private String vendorCode;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="QFDATE")
	private Date qfdate;
	
	@Column(name="QTDATE")
	private Date qtdate;
	
	
	@Column(name="BANK_NAME")
	private String astruBankName;
	
	@Column(name="BANK_ID")
	private Integer astruBankID;

	@Column(name="DD_NO")
	private String chequeNo;
	
	@Column(name="DD_DATE")
	private Date chequeDate;
	
	@Column(name="DD_CHQ_AMT")
	private Float ddChequeAmount;
	
	@Column(name="REBATE_INT")
	private Float interestOnRebate;

	@Column(name="SERVICETAX_INT")
	private Float interestOnServiceTax;

	@Column(name="TDS_AMT")
	private Integer tdsAmount;

	@Column(name="INCENTIVE_AMT")
	private Float incAmount;
	
	@Column(name="EMD_AMT")
	private Integer emdAmount;
	
	@Column(name="BANK_CHARGE")
	private Float bankcharge;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="COMMENTS")
	private String comments;
	
	@Column(name="INVOICE_PAYMNT")
	private Float invoicePayment;
	
	@Column(name="INVOICE_NO")
	private Integer invoiceNumber;

	@Column(name="REBATE_OUSTNDG")
	private Float rebateOutstanding;
	
	@Column(name="INT_REBATE_INVOICE")
	private Float interestOnRebateInvoice;
	
	
		public Float getInterestOnRebateInvoice() {
		return interestOnRebateInvoice;
	}

	public void setInterestOnRebateInvoice(Float interestOnRebateInvoice) {
		this.interestOnRebateInvoice = interestOnRebateInvoice;
	}

		public Float getRebateOutstanding() {
		return rebateOutstanding;
	}

	public void setRebateOutstanding(Float rebateOutstanding) {
		this.rebateOutstanding = rebateOutstanding;
	}

		public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Float getInvoicePayment() {
		return invoicePayment;
	}

	public void setInvoicePayment(Float invoicePayment) {
		this.invoicePayment = invoicePayment;
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

	@Override
	public String toString() {
		return "RebateForm [receiptNo=" + receiptNo + ", transactionNo=" + transactionNo + ", transactionDate="
				+ transactionDate + ", receiptDate=" + receiptDate + ", vendorCode=" + vendorCode + ", vendorName="
				+ vendorName + ", itemCode=" + itemCode + ", itemName=" + itemName + ", qfdate=" + qfdate + ", qtdate="
				+ qtdate + ", astruBankName=" + astruBankName + ", astruBankID=" + astruBankID + ", chequeNo="
				+ chequeNo + ", chequeDate=" + chequeDate + ", ddChequeAmount=" + ddChequeAmount + ", interestOnRebate="
				+ interestOnRebate + ", interestOnServiceTax=" + interestOnServiceTax + ", tdsAmount=" + tdsAmount
				+ ", incAmount=" + incAmount + ", emdAmount=" + emdAmount + ", bankcharge=" + bankcharge + ", remarks="
				+ remarks + ", comments=" + comments + ", invoicePayment=" + invoicePayment + ", invoiceNumber="
				+ invoiceNumber + ", rebateOutstanding=" + rebateOutstanding + ", interestOnRebateInvoice="
				+ interestOnRebateInvoice + "]";
	}
	
	
		
}
