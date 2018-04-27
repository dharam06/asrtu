package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_master")
public class BankMaster implements Serializable {

	@Id
	@Column(name="BANK_CODE")
	private Integer bankCode;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	
	//private String tPgId;

	public Integer getBankCode() {
		return bankCode;
	}

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	
	
}
