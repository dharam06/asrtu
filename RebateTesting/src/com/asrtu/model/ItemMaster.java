package com.asrtu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_master")
public class ItemMaster implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SLNO")
	private Integer sno;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_GROUP_CODE")
	private String itemGroupCode;
	
	
	@Column(name="ITEM_GROUP_NAME")
	private String itemGroupName;
	
	@Column(name="SPECIFICATION")
	private String specification;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="TCHARGE")
	private Integer tCharge;
	
	@Column(name="PARTNO")
	private Integer partNo;
	
	@Column(name="PRODUCT_SUBGROUP_CODE")
	private String productSubGroupId;

	public Integer getSno() {
		return sno;
	}


	public void setSno(Integer sno) {
		this.sno = sno;
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


	public String getItemGroupCode() {
		return itemGroupCode;
	}


	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}


	public String getItemGroupName() {
		return itemGroupName;
	}


	public void setItemGroupName(String itemGroupName) {
		this.itemGroupName = itemGroupName;
	}


	public String getSpecification() {
		return specification;
	}


	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer gettCharge() {
		return tCharge;
	}


	public void settCharge(Integer tCharge) {
		this.tCharge = tCharge;
	}


	public Integer getPartNo() {
		return partNo;
	}


	public void setPartNo(Integer partNo) {
		this.partNo = partNo;
	}


	

	
	
	

}
