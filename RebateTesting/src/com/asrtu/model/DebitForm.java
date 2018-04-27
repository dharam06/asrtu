package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class DebitForm implements Serializable {
	
	@Id
	@Column(name="")
	private Integer debitId;
	@Column(name="")
	private String vendorId;
	@Column(name="")
	private String vendorName;
	@Column(name="")
	private String itemCode;
	@Column(name="")
	private String itemName;
	@Column(name="")
	private Integer debitAmount;
	@Column(name="")
	private String transacDate;
	@Column(name="")
	private String remarks;
	
	public Integer getDebitId() {
		return debitId;
	}
	public void setDebitId(Integer debitId) {
		this.debitId = debitId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
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
	public Integer getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Integer debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getTransacDate() {
		return transacDate;
	}
	public void setTransacDate(String transacDate) {
		this.transacDate = transacDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	

}
