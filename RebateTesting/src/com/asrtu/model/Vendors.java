package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VENDORS")
public class Vendors implements Serializable {
	
	@Id
	@Column(name="VENDOR_ID")
	private String vendorId;
	
	@Column(name="NAME")
	private String vendorName;

	@Column(name="ADDRESS1")
	private String address1;

	@Column(name="ADDRESS2")
	private String address2;

	@Column(name="ADDRESS3")
	private String address3;

	@Column(name="PIN_CODE")
	private String pinCode;

	@Column(name="F_TELEFAX")
	private String fax;
	
	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", address1=" + address1 + ", address2=" + address2 + ", address3="
				+ address3 + ", pinCode=" + pinCode + ", fax=" + fax + "]";
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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
	
	
	

}
