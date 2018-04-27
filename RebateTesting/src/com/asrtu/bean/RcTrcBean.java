package com.asrtu.bean;

public class RcTrcBean {
	
	private Integer sno;
	private String vendorId;
	private String vendorName;
	private String itemCode;
	private String itemName;
	private String status;
	private String clearDate;
	private String fromDate;
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
		return "RcTrcBean [sno=" + sno + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", itemCode="
				+ itemCode + ", itemName=" + itemName + ", status=" + status + ", clearDate=" + clearDate
				+ ", fromDate=" + fromDate + ", remarks=" + remarks + "]";
	}
	
	
	

}
