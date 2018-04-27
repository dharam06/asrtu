package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RCTRC")
public class RcTrc implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private Integer sno;
	@Column(name="VENDORID")
	private String vendorId;
	@Column(name="VENDORNAME")
	private String vendorName;
	@Column(name="ITEMCODE")
	private String itemCode;
	@Column(name="ITEMNAME")
	private String itemName;
	@Column(name="STATUS")
	private String status;
	@Column(name="CLEARDATE")
	private String clearDate;
	@Column(name="FROMDATE")
	private String fromDate;
	
	@Column(name="REMARKS")
	private String remarks; 
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "RcTrc [sno=" + sno + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", itemCode=" + itemCode
				+ ", itemName=" + itemName + ", status=" + status + ", clearDate=" + clearDate + ", fromDate="
				+ fromDate + ", remarks=" + remarks + "]";
	}
	
	
	
	
	

}
