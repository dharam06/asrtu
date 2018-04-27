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
@Table(name="invoice")
public class Invoice implements Serializable {
		
		private static final long serialVersionUID = -723583058586873479L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ID")
		private Integer invoiceNumber;
		
		@Column(name="INVOICE_NO")
		private Integer asrtuInvoiceNumber;
		
		@Column(name="INVOICE_DATE")
		private Date invoiceDate;
		
		@Column(name="VENDOR_CODE")
		private String vendorCode;
		
		@Column(name="FIRM_NAME")
		private String firmName; 
		
		@Column(name="ITEM_CODE")
		private String itemCode;              
		     
		@Column(name="ITEM_NAME")
		private String itemName;    
		
		@Column(name ="QTR_FROM_DATE")
		private Date quarterFromDate;
		
		@Column(name="QTR_TO_DATE")
		private Date quarterToDate;
		
		@Column(name="QTR")
		private String quarter;
	
		@Column(name="Rebate_Type")
		private String rebateType;

		@Column(name="RGR_REBATE")
		private Float regularRebate;                       
			
		@Column(name="AMOUNT")
		private Float amount;

		@Column(name="REBATE_OUSTNDG")
		private Float rebateOutstanding;

		@Column(name="REBATE_REMAINING_OUSTNDG")
		private Float rebateRemainingOutstanding;
		
		@Column(name="REBATE_P_OUSTNDG")
		private Float rebatePrOutstanding;

		@Column(name="REBATE_P_REMAINING_OUSTNDG")
		private Float rebatePrRemainingOutstanding;
		
		@Column(name="REBATE_T_OUSTNDG")
		private Float rebateTaxOutstanding;

		@Column(name="REBATE_T_REMAINING_OUSTNDG")
		private Float rebateTaxRemainingOutstanding;

		@Column(name="TOTAL_TAX")
		private Float totalTax;
		
		@Column(name="TAX1")
		private Float tax1;
		
		@Column(name="TAX2")
		private Float tax2;
		
		@Column(name="TAX3")
		private Float tax3;
		
		@Column(name="TAX4")
		private Float tax4;
		
		@Column(name="TOTAL_TAX_PER")
		private Float totalTaxPercentage;
		
		@Column(name="TAX1_PER")
		private Float taxPercentage1;
		
		@Column(name="TAX2_PER")
		private Float taxPercentage2;
		
		@Column(name="TAX3_PER")
		private Float taxPercentage3;
		
		@Column(name="TAX4_PER")
		private Float taxPercentage4;
		
		@Column(name="INT_ON_ST")
		private Float interestOnServiceTax;
		
		@Column(name="GSTNO")
		private String gstNumber;

		@Column(name="GSTID")
		private Integer gstId;
		


		public Float getRebatePrOutstanding() {
			return rebatePrOutstanding;
		}

		public void setRebatePrOutstanding(Float rebatePrOutstanding) {
			this.rebatePrOutstanding = rebatePrOutstanding;
		}

		public Float getRebatePrRemainingOutstanding() {
			return rebatePrRemainingOutstanding;
		}

		public void setRebatePrRemainingOutstanding(Float rebatePrRemainingOutstanding) {
			this.rebatePrRemainingOutstanding = rebatePrRemainingOutstanding;
		}

		public Float getRebateTaxOutstanding() {
			return rebateTaxOutstanding;
		}

		public void setRebateTaxOutstanding(Float rebateTaxOutstanding) {
			this.rebateTaxOutstanding = rebateTaxOutstanding;
		}

		public Float getRebateTaxRemainingOutstanding() {
			return rebateTaxRemainingOutstanding;
		}

		public void setRebateTaxRemainingOutstanding(Float rebateTaxRemainingOutstanding) {
			this.rebateTaxRemainingOutstanding = rebateTaxRemainingOutstanding;
		}

		public String getGstNumber() {
			return gstNumber;
		}

		public void setGstNumber(String gstNumber) {
			this.gstNumber = gstNumber;
		}

		public Integer getGstId() {
			return gstId;
		}

		public void setGstId(Integer gstId) {
			this.gstId = gstId;
		}

		public Integer getAsrtuInvoiceNumber() {
			return asrtuInvoiceNumber;
		}

		public void setAsrtuInvoiceNumber(Integer asrtuInvoiceNumber) {
			this.asrtuInvoiceNumber = asrtuInvoiceNumber;
		}

		public Float getInterestOnServiceTax() {
			return interestOnServiceTax;
		}

		public void setInterestOnServiceTax(Float interestOnServiceTax) {
			this.interestOnServiceTax = interestOnServiceTax;
		}

		public Float getAmount() {
			return amount;
		}

		public void setAmount(Float amount) {
			this.amount = amount;
		}

		public Float getTaxPercentage1() {
			return taxPercentage1;
		}

		public void setTaxPercentage1(Float taxPercentage1) {
			this.taxPercentage1 = taxPercentage1;
		}

		public Float getTaxPercentage2() {
			return taxPercentage2;
		}

		public void setTaxPercentage2(Float taxPercentage2) {
			this.taxPercentage2 = taxPercentage2;
		}

		public Float getTaxPercentage3() {
			return taxPercentage3;
		}

		public void setTaxPercentage3(Float taxPercentage3) {
			this.taxPercentage3 = taxPercentage3;
		}

		public Float getTaxPercentage4() {
			return taxPercentage4;
		}

		public void setTaxPercentage4(Float taxPercentage4) {
			this.taxPercentage4 = taxPercentage4;
		}

		public Float getTotalTaxPercentage() {
			return totalTaxPercentage;
		}

		public void setTotalTaxPercentage(Float totalTaxPercentage) {
			this.totalTaxPercentage = totalTaxPercentage;
		}

		public Float getTotalTax() {
			return totalTax;
		}

		public void setTotalTax(Float totalTax) {
			this.totalTax = totalTax;
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

		public String getRebateType() {
			return rebateType;
		}

		public void setRebateType(String rebateType) {
			this.rebateType = rebateType;
		}

		public Float getRebateRemainingOutstanding() {
			return rebateRemainingOutstanding;
		}

		public void setRebateRemainingOutstanding(Float rebateRemainingOutstanding) {
			this.rebateRemainingOutstanding = rebateRemainingOutstanding;
		}

		public Integer getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(Integer invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		public Date getInvoiceDate() {
			return invoiceDate;
		}

		public void setInvoiceDate(Date invoiceDate) {
			this.invoiceDate = invoiceDate;
		}

		public String getVendorCode() {
			return vendorCode;
		}

		public void setVendorCode(String vendorCode) {
			this.vendorCode = vendorCode;
		}

		public String getFirmName() {
			return firmName;
		}

		public void setFirmName(String firmName) {
			this.firmName = firmName;
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

		public Date getQuarterFromDate() {
			return quarterFromDate;
		}

		public void setQuarterFromDate(Date quarterFromDate) {
			this.quarterFromDate = quarterFromDate;
		}

		public Date getQuarterToDate() {
			return quarterToDate;
		}

		public void setQuarterToDate(Date quarterToDate) {
			this.quarterToDate = quarterToDate;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getQuarter() {
			return quarter;
		}

		public void setQuarter(String quarter) {
			this.quarter = quarter;
		}

		@Override
		public String toString() {
			return "Invoice [invoiceNumber=" + invoiceNumber + ", asrtuInvoiceNumber=" + asrtuInvoiceNumber
					+ ", invoiceDate=" + invoiceDate + ", vendorCode=" + vendorCode + ", firmName=" + firmName
					+ ", itemCode=" + itemCode + ", itemName=" + itemName + ", quarterFromDate=" + quarterFromDate
					+ ", quarterToDate=" + quarterToDate + ", quarter=" + quarter + ", rebateType=" + rebateType
					+ ", regularRebate=" + regularRebate + ", amount=" + amount + ", rebateOutstanding="
					+ rebateOutstanding + ", rebateRemainingOutstanding=" + rebateRemainingOutstanding
					+ ", rebatePrOutstanding=" + rebatePrOutstanding + ", rebatePrRemainingOutstanding="
					+ rebatePrRemainingOutstanding + ", rebateTaxOutstanding=" + rebateTaxOutstanding
					+ ", rebateTaxRemainingOutstanding=" + rebateTaxRemainingOutstanding + ", totalTax=" + totalTax
					+ ", tax1=" + tax1 + ", tax2=" + tax2 + ", tax3=" + tax3 + ", tax4=" + tax4
					+ ", totalTaxPercentage=" + totalTaxPercentage + ", taxPercentage1=" + taxPercentage1
					+ ", taxPercentage2=" + taxPercentage2 + ", taxPercentage3=" + taxPercentage3 + ", taxPercentage4="
					+ taxPercentage4 + ", interestOnServiceTax=" + interestOnServiceTax + ", gstNumber=" + gstNumber
					+ ", gstId=" + gstId + "]";
		}


}
