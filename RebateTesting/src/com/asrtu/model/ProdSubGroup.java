package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_subgroup")
public class ProdSubGroup implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	@Column(name="SUBGROUP_CODE")
	private String subGroupCode;
	@Column(name="SUBGROUP_NAME")
	private String subGroupName;
	@Column(name="PRODUCT_GROUP_ID")
	private String itemGroupCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubGroupCode() {
		return subGroupCode;
	}
	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
	public String getItemGroupCode() {
		return itemGroupCode;
	}
	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}
	@Override
	public String toString() {
		return "ProdSubGroup [id=" + id + ", subGroupCode=" + subGroupCode + ", subGroupName=" + subGroupName
				+ ", itemGroupCode=" + itemGroupCode + "]";
	}
	
	
	
	
	

}
