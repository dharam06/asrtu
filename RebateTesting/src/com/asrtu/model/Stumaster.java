package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stumaster")
public class Stumaster implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private Integer sno;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="NODEL_CODE")
	private String modelCode;
	
	@Column(name="NODEL_NAME")
	private String modelName;
	
	@Column(name="DIVISION")
	private String division;
	
	@Column(name="ADDR1")
	private String add1;
	
	@Column(name="ADDR2")
	private String add2;
	
	@Column(name="ADDR3")
	private String add3;
	
	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="PHONE_NO")
	private Integer phoneNo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FROMDATE")
	private String fromDate;
	
	@Column(name="TODATE")
	private String toDate;
	
	@Column(name="REMARKS")
	private String remarks;
	
	
	
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getAdd3() {
		return add3;
	}
	public void setAdd3(String add3) {
		this.add3 = add3;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Stumaster [sno=" + sno + ", name=" + name + ", code=" + code + ", modelCode=" + modelCode
				+ ", modelName=" + modelName + ", division=" + division + ", add1=" + add1 + ", add2=" + add2
				+ ", add3=" + add3 + ", pincode=" + pincode + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", remarks=" + remarks + "]";
	}
	
	
}
