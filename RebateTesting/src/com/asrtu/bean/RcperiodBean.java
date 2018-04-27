package com.asrtu.bean;

import java.util.Date;

public class RcperiodBean {
	
	private Integer sno;
	private String vendorId;
	private String pgId;
	private String meetingNo;
	private String status;
	private Date rcFromDate;
	private String rcFromDateString;
	private Date toDate;
	private String toDateString;
	private Date transDate;
	private String transDateString;
	private String itemCode;
	private String rcCell;
	private String vendorName;
	private String description;
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
	public String getPgId() {
		return pgId;
	}
	public void setPgId(String pgId) {
		this.pgId = pgId;
	}
	public String getMeetingNo() {
		return meetingNo;
	}
	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRcFromDate() {
		return rcFromDate;
	}
	public void setRcFromDate(Date rcFromDate) {
		this.rcFromDate = rcFromDate;
	}
	public String getRcFromDateString() {
		return rcFromDateString;
	}
	public void setRcFromDateString(String rcFromDateString) {
		this.rcFromDateString = rcFromDateString;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getToDateString() {
		return toDateString;
	}
	public void setToDateString(String toDateString) {
		this.toDateString = toDateString;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransDateString() {
		return transDateString;
	}
	public void setTransDateString(String transDateString) {
		this.transDateString = transDateString;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getRcCell() {
		return rcCell;
	}
	public void setRcCell(String rcCell) {
		this.rcCell = rcCell;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RcperiodBean [sno=" + sno + ", vendorId=" + vendorId + ", pgId=" + pgId + ", meetingNo=" + meetingNo
				+ ", status=" + status + ", rcFromDate=" + rcFromDate + ", rcFromDateString=" + rcFromDateString
				+ ", toDate=" + toDate + ", toDateString=" + toDateString + ", transDate=" + transDate
				+ ", transDateString=" + transDateString + ", itemCode=" + itemCode + ", rcCell=" + rcCell
				+ ", vendorName=" + vendorName + ", description=" + description + "]";
	}
	
	
}
