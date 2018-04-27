package com.asrtu.bean;

public class ProdSubGroupBean {
	
	
	private Integer id;

	private String subGroupName;
	private String subGroupCode;
	private String itemGroupCode;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
	public String getSubGroupCode() {
		return subGroupCode;
	}
	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}
	public String getItemGroupCode() {
		return itemGroupCode;
	}
	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}

	
	@Override
	public String toString() {
		return "ProdSubGroupBean [id=" + id + ", subGroupName=" + subGroupName + ", subGroupCode=" + subGroupCode
				+ ", itemGroupCode=" + itemGroupCode + "]";
	}
	
	

}
