package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stu_trans")
@DiscriminatorValue(value="2")
public class StuTransInv1 extends StuTransaction implements Serializable{

	@Column(name="FIRM_NAME")
	private String firmName1;
	
	@Column(name="ITEM_NAME")
	private String itemName1;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo1;
	
	@Column(name="INVOICE_DATE")
	private String invoiceDate1;
	
	@Column(name="STU_TOTAL_AMT")
	private Integer stu_Tot_Amt1;
	
	@Column(name="STU_TOTAL_REB")
	private Integer stu_Reb_Amt1;
	
	public String getFirmName1() {
		return firmName1;
	}
	public void setFirmName1(String firmName1) {
		this.firmName1 = firmName1;
	}
	public String getItemName1() {
		return itemName1;
	}
	public void setItemName1(String itemName1) {
		this.itemName1 = itemName1;
	}
	public String getInvoiceNo1() {
		return invoiceNo1;
	}
	public void setInvoiceNo1(String invoiceNo1) {
		this.invoiceNo1 = invoiceNo1;
	}
	public String getInvoiceDate1() {
		return invoiceDate1;
	}
	public void setInvoiceDate1(String invoiceDate1) {
		this.invoiceDate1 = invoiceDate1;
	}
	public Integer getStu_Tot_Amt1() {
		return stu_Tot_Amt1;
	}
	public void setStu_Tot_Amt1(Integer stu_Tot_Amt1) {
		this.stu_Tot_Amt1 = stu_Tot_Amt1;
	}
	public Integer getStu_Reb_Amt1() {
		return stu_Reb_Amt1;
	}
	public void setStu_Reb_Amt1(Integer stu_Reb_Amt1) {
		this.stu_Reb_Amt1 = stu_Reb_Amt1;
	}
		

	
}

