package com.astru.util;





public class AjaxHelper {
	
	AjaxGetItem itemName=new AjaxGetItem();
	
	
	public String getGroupByItemDetails(String itemGroupCode){
		
		 return itemName.getName(itemGroupCode);
		
	}

	public String getVendorNameId(String vendorName){
	
		
		return itemName.getVendorId(vendorName);
		
	}
	
	public String getVendorNameById(String vendorID){
	
		
		return itemName.getVendorName(vendorID);
		
	}
	
	public String getItemNameId(String itemNameId){
		
		
		return itemName.getItemName(itemNameId) ;
		
	}
	
	public String getBankNameId(String bankNameId){
		
		
		return itemName.getBankName(bankNameId) ;
		
	}
	
	
	
	public String getItemGroupByVendorID(String vendorID){
		
		System.out.println("calling ajax method getItemGroupByVendorID");	
		return new DropDownUtil().getItemGroupByVendorID(vendorID);
		
	}
	
	
	public String getGstnumberByVendorID(String vendorID){
		
		System.out.println("calling ajax method getGstnumberByVendorID");	
		return new DropDownUtil().getGstnumberByVendorID(vendorID);
		
	}
	
	public String getBR(String bankNameId){
		
		
		return itemName.getBankName(bankNameId) ;
		
	}
	public Integer getServiceTax(String dateFrom)throws Exception{
		
		return itemName.getServiceTax(dateFrom);
	}
	
	public String getSubGroupByGroupID(String groupID){
		
		System.out.println("calling ajax method getSubGroupByGroupID");	
		return new DropDownUtil().getSubGroupByGroupID(groupID);
		
	}
	public String getItemBySubGroupID(String subGroupID){
		
		System.out.println("calling ajax method getItemBySubGroupID");	
		return new DropDownUtil().getItemBySubGroupID(subGroupID);
		
	}
	
	public String getTestChargeByItemID(String itemId){
		
		System.out.println("calling ajax method getTestChargeByItemID");	
		return new DropDownUtil().getTestChargeByItemID(itemId);
		
	}
	public Integer getNetAmountByStoDateID(String groupCodeId,String vendorId)throws Exception{
		
		System.out.println("calling ajax method getNetAmountByStoDateID");	
		return new DropDownUtil().getNetAmountByStoDate(groupCodeId,vendorId);
		
	}
	
	public String getSTUBystuID(String stuID){
		
		System.out.println("calling ajax method getSTUBystuID");	
		return new DropDownUtil().getSTUBystuID(stuID);
		
	}
	
	public Integer getRebatePercentByVenodorID(String vendorID, String itemID){
		
		System.out.println("calling ajax method getSTUBystuID");	
		return new DropDownUtil().getRebatePercentByVenodorID(vendorID, itemID);
		
	}
	
	public Float getTestTransByVendorItem(String vendorID, String itemID){
		
		System.out.println("calling ajax method getSTUBystuID");	
		return new DropDownUtil().getTestTransByVendorItem(vendorID, itemID);
		
	}
	
	
	
}
