package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VENDORGST")

public class VendorGst implements Serializable {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
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
	private Integer pinCode;

	@Column(name="GSTNO")
	private String gstNumber;
	
	@Column(name="CONTACTPERSON")
	private String contactPerson;

	@Column(name="EMAIL")
	private String email;

	@Column(name="VENDOR_TYPE")
	private String vendorType;
	
	@Column(name="firstcontact")
	private String firstContact;
	
	public String getFirstContact() {
		return firstContact;
	}

	public void setFirstContact(String firstContact) {
		this.firstContact = firstContact;
	}

	@Column(name="OTHER_CONTACTS")
	private String otherContacts;
	
	public String getOtherContacts() {
		return otherContacts;
	}

	public void setOtherContacts(String otherContacts) {
		this.otherContacts = otherContacts;
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

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	@Override
	public String toString() {
		return "VendorGst [id=" + id + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", pinCode=" + pinCode
				+ ", gstNumber=" + gstNumber + ", contactPerson=" + contactPerson + ", email=" + email + ", vendorType="
				+ vendorType + ", contactNumber=" +  ", firstContact=" + firstContact
				+ ", otherContacts=" + otherContacts + ", getFirstContact()=" + getFirstContact()
				+ ", getOtherContacts()=" + getOtherContacts() + ", getAddress1()=" + getAddress1() + ", getAddress2()="
				+ getAddress2() + ", getAddress3()=" + getAddress3() + ", getPinCode()=" + getPinCode()
				+ ", getVendorId()=" + getVendorId() + ", getVendorName()=" + getVendorName() + ", getId()=" + getId()
				+ ", getContactNumber()=" +  ", getGstNumber()=" + getGstNumber()
				+ ", getContactPerson()=" + getContactPerson() + ", getEmail()=" + getEmail() + ", getVendorType()="
				+ getVendorType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
