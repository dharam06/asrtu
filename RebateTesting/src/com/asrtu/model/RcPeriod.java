package com.asrtu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="REBATE_RCPERIOD")
public class RcPeriod implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer sno;
	
	@Column(name ="VENDOR_ID")
	private String vendorId;
	
	@Column(name ="PG_ID")
	private String pgId;
	
	@Column(name ="MEETING_NO")
	private String meetingNo;
	
	@Column(name ="STATUS")
	private String rcCell;

	@DateTimeFormat(pattern="dd/MM/YY")
	@Column(name ="RC_FROM")
	private Date rcFromDate;
	
	@Column(name="TO_DATE")
	private Date toDate;
	
	@Column(name ="TRANS_DATE")
	private Date transDate;

	public String getVendorName() {
		return vendorName;
	}

	@Column(name ="VENDOR_NAME")
	private String vendorName;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	// Item Group code is description for vendor name
	
	
	
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

	

	public Date getRcFromDate() {
		return rcFromDate;
	}

	public void setRcFromDate(Date rcFromDate) {
		this.rcFromDate = rcFromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
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
		return "RcPeriod [sno=" + sno + ", vendorId=" + vendorId + ", pgId=" + pgId + ", meetingNo=" + meetingNo
				+ ", rcCell=" + rcCell + ", rcFromDate=" + rcFromDate + ", toDate=" + toDate + ", transDate="
				+ transDate + ", vendorName=" + vendorName + ", description=" + description + "]";
	}

	public String getRcCell() {
		return rcCell;
	}

	public void setRcCell(String rcCell) {
		this.rcCell = rcCell;
	}
	
}
