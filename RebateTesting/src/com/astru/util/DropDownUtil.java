package com.astru.util;
/*******************************************************************************
 * Copyright (c) 2009 Apria Healthcare                                          *
 * As an unpublished work. All Rights Reserved.                                 *
 * This media contains an authorized copy or copies of material copyrighted by  *
 * Apria Healthcare and is the unpublished, confidential property of            *
 * Apria Healthcare. You may not disclose, copy or use any portion of           *
 * these materials for any purpose without the express written consent of Apria *
 * Healthcare.  You must reproduce this copyright notice and any other          *
 * copyright notices included in machine-readable copies on all authorized      *
 * copies.                                                                      *
 *******************************************************************************/



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import com.asrtu.bean.DropDownBean;
import com.asrtu.bean.OpeningBalance;
import com.asrtu.model.ItemPgTab;

import org.apache.commons.lang.StringEscapeUtils;
import com.asrtu.model.VendorGst;


public class DropDownUtil {
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;

	

	private static String PRODUCT_DROPDOWN_LIST_JSON = null;
	
	
	


	public  void refreshCache(String vendorID){
			try {
				
				List<DropDownBean> tempOCAttribListProduct = new ArrayList<DropDownBean>();
				
				DropDownBean oca1 = new DropDownBean();
				oca1.setDisplayValue("Hello1");
				oca1.setCode(1);
				tempOCAttribListProduct.add( oca1 );
				
				DropDownBean oca2 = new DropDownBean();
				oca2.setDisplayValue("Hello2");
				oca2.setCode(2);
				tempOCAttribListProduct.add( oca2 );

				DropDownBean oca3 = new DropDownBean();
				oca3.setDisplayValue("Hello3");
				oca3.setCode(3);
				tempOCAttribListProduct.add( oca3 );

				DropDownBean oca4 = new DropDownBean();
				oca4.setDisplayValue("Hello4");
				oca4.setCode(4);
				tempOCAttribListProduct.add( oca4 );
				
								
				/* Prepare JSON string for the Dropdowns */
				PRODUCT_DROPDOWN_LIST_JSON = prepareJSON( tempOCAttribListProduct );
				
			System.out.println(PRODUCT_DROPDOWN_LIST_JSON);
			} catch (Exception e){
				// Handle exception
			}
			
			//return PRODUCT_DROPDOWN_LIST_JSON;
		}
	
	
	
	
	private  String prepareJSON( List< DropDownBean> attribs  ) {
		
		  
		StringBuilder buffer = new StringBuilder();
		  
		buffer.append("{");
		Iterator<DropDownBean> iter = attribs.iterator();
		
		while(iter.hasNext()){
			DropDownBean ocAttrib = iter.next();
			
			buffer.append( getJSONEntry( ocAttrib.getCode(), ocAttrib.getDisplayValue() ));
			
			if(iter.hasNext())
				buffer.append(",");
		}
		
		buffer.append("}");
		
		buffer.toString();
	  
		
		return buffer.toString();
	}
	
	private  String getJSONEntry( long code, String displayValue ) {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("\"" + code + "\"");
		buffer.append(":");
		buffer.append("\"" + displayValue + "\"");
	
		return StringEscapeUtils.escapeJavaScript(buffer.toString());
	}



	public  String getItemGroupByVendorID(String vendorID) {
		
			//refreshCache(vendorID);
			
		//return PRODUCT_DROPDOWN_LIST_JSON;
		
		StringBuffer options = new StringBuffer("<option value=0>--Please Select--</option>");
		System.out.println("====="+vendorID);
		
		String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id   AND v.vendor_id=?";
//select DISTINCT  P.description from  pg_table p where  p.PG_ID='01400';
		System.out.println("====="+query);

		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, vendorID);
			rs=pst.executeQuery();
			while(rs.next()){
				
				options=options.append("<option value='");
				options=options.append(rs.getString("PG_ID"));
				options=options.append("'>");
				options=options.append(rs.getString("description"));		
				options=options.append("</option>");		
		
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+options);
		
		return options.toString();
	}

	
	
	public  String getGstnumberByVendorID(String vendorID) {
		
		//refreshCache(vendorID);
		
	//return PRODUCT_DROPDOWN_LIST_JSON;
	
	StringBuffer options = new StringBuffer("<option value=0>--Please Select--</option>");
	System.out.println("====="+vendorID);
	
	String query="select distinct id, (gstno || ' : ' || ADDRESS1 || ' : ' || ADDRESS2 || ' : ') as gstn from vendorgst where vendor_id=?";
//select DISTINCT  P.description from  pg_table p where  p.PG_ID='01400';
	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		rs=pst.executeQuery();
		while(rs.next()){
			
			options=options.append("<option value='");
			options=options.append(rs.getString("id"));
			options=options.append("'>");
			options=options.append(rs.getString("gstn"));		
			options=options.append("</option>");		
	
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return options.toString();
}


	public  String getSubGroupByGroupID(String groupID) {
		
		//refreshCache(vendorID);
		
	//return PRODUCT_DROPDOWN_LIST_JSON;
	
	StringBuffer options = new StringBuffer("<option value=0>--Please Select--</option>");
	System.out.println(" getSubGroupByGroupID ====="+groupID);
	
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select SUBGROUP_CODE, SUBGROUP_NAME from product_subgroup where PRODUCT_GROUP_ID=?";
	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, groupID);
		rs=pst.executeQuery();
		while(rs.next()){
			
			options=options.append("<option value='");
			options=options.append(rs.getString("SUBGROUP_CODE"));
			options=options.append("'>");
			options=options.append(rs.getString("SUBGROUP_NAME"));		
			options=options.append("</option>");		
	
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return options.toString();
}

	public  String getItemBySubGroupID(String subGroupID) {
		
		//refreshCache(vendorID);
		
	//return PRODUCT_DROPDOWN_LIST_JSON;
	
	StringBuffer options = new StringBuffer("<option value=0>--Please Select--</option>");
	System.out.println(" getSubGroupByGroupID ====="+subGroupID);
	
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select  ITEM_CODE, ITEM_NAME from item_master where PRODUCT_SUBGROUP_CODE=?";
	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, subGroupID);
		rs=pst.executeQuery();
		while(rs.next()){
			
			options=options.append("<option value='");
			options=options.append(rs.getString("ITEM_CODE"));
			options=options.append("'>");
			options=options.append(rs.getString("ITEM_NAME"));		
			options=options.append("</option>");		
	
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return options.toString();
}
	
	
	
	public  List<ItemPgTab> getProductGroupList() {
		
		List<ItemPgTab> itemPgTabList = new ArrayList<ItemPgTab>();
	
	StringBuffer options = new StringBuffer("<option value=0>--Please Select--</option>");
		
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select distinct description,pg_id from pg_table where pg_id like '%00'";
	System.out.println("====="+query);

	ItemPgTab ipt = null;
		
	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
		while(rs.next()){
			
			ipt = new ItemPgTab();
			ipt.setItemCode(rs.getString("pg_id"));
			ipt.setItemName(rs.getString("description"));
			/*options=options.append("<option value='");
			options=options.append(rs.getString("pg_id"));
			options=options.append("'>");
			options=options.append(rs.getString("description"));		
			options=options.append("</option>");		*/
	
			itemPgTabList.add(ipt);
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return itemPgTabList;
}
	
	
	
	
	// select cl_bal from ledger where vendor_code='B0004' and item_code='01400'
	
	public Integer getNetAmountByStoDate(String groupCodeId,String vendorId )throws Exception
	{
		
	
		Integer serviceTax=null;
		//String query="select PERCENTAGE from tax_master WHERE between FROM_DATE=? and TO_DATE=?";
		//select cl_bal from ledger where vendor_code='B0004' and item_code='
		
		// PLEASE NOTE HERE item_code is Product Group Code here
		String query="select cl_bal from ledger where vendor_code=? and item_code=?" ;
		System.out.println("====="+query);
		System.out.println("====="+vendorId);
		System.out.println("====="+groupCodeId);
		try{
		
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, vendorId);
			pst.setString(2, groupCodeId);
						
			rs=pst.executeQuery();
			
			while(rs.next()){
				serviceTax=rs.getInt("cl_bal");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+serviceTax);
		return serviceTax;
	}
	
	
	public  String getTestChargeByItemID(String itemId) {
		
	
	
		StringBuffer options = new StringBuffer();
			
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select TCHARGE,QUANTITY  from item_master where ITEM_CODE=?";
	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, itemId);
		rs=pst.executeQuery();
		while(rs.next()){
			
			options=options.append(rs.getString("QUANTITY"));
			System.out.println("====="+options);
			//options=rs.getString("QUANTITY");
			options=options.append(":");
			options=options.append(rs.getInt("TCHARGE"));
			System.out.println("====="+options);
			//testCharge=rs.getInt("TCHARGE");		
					
	
			
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return  options.toString();
}
	
	
	
	public  String getSTUBystuID(String stuID) {
		
		
		
		StringBuffer options = new StringBuffer();
			
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select code, name,NODEL_CODE,NODEL_NAME from stumaster   where code=?";



	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, stuID);
		rs=pst.executeQuery();
		while(rs.next()){
			
			
			
			/*System.out.println(rs.getString("name"));
			System.out.println(rs.getString("NODEL_CODE"));
			System.out.println(rs.getString("NODEL_NAME"));
*/
			
			options=options.append(rs.getString("code"));
			System.out.println("====="+options);
	
			options=options.append(":");
			options=options.append(rs.getString("name"));
			System.out.println("====="+options);


			options=options.append(":");
			options=options.append(rs.getString("NODEL_CODE"));
			System.out.println("====="+options);
			
			options=options.append(":");
			options=options.append(rs.getString("NODEL_NAME"));
			System.out.println("====="+options);

	
					
	
			
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+options);
	
	return  options.toString();
}
	 
	public  String getSTUNameBystuID(String stuID) {
		
 		StringBuffer options = new StringBuffer();
			
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select name from stumaster   where code=?";
 	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, stuID);
		rs=pst.executeQuery();
		while(rs.next()){
			
	
		options=options.append(rs.getString("name"));
		System.out.println("====="+options);
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return  options.toString();
}
	
	
	public  String getVendorNameByVendiorId(String vendorID) {
		
 		StringBuffer options = new StringBuffer();
			
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select NAME from VENDORS   where VENDOR_ID=?";
 	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		rs=pst.executeQuery();
		while(rs.next()){
			
	
		options=options.append(rs.getString("NAME"));
		System.out.println("====="+options);
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return  options.toString();
}
	
	
	
	public  String getItemNameByItemId(String itemID) {
		
 		StringBuffer options = new StringBuffer();
			
	//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
	String query="select DISTINCT  P.description from  pg_table p where  p.PG_ID=?";
 	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, itemID);
		rs=pst.executeQuery();
		while(rs.next()){
			
	
		options=options.append(rs.getString("description"));
		System.out.println("====="+options);
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return  options.toString();
}
	
	
	public  Integer getRebatePercentByVenodorID(String vendorID, String itemID) {
		
 		Integer rebatePercentage = 2;
			
	String query="select per from rebate_condition where vendor_code=? and pg_id=?";
 	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		pst.setString(2, itemID);
		rs=pst.executeQuery();
		while(rs.next()){
			
		rebatePercentage = rs.getInt("per");
		
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+rebatePercentage);
	return  rebatePercentage;
}
	
	

	
	
	public static void main(String ar[]) {
	
		//new DropDownUtil().getSubGroupByGroupID("B0004");
		
		//new DropDownUtil().getSTUNameBystuID("A124");
		
		//new DropDownUtil().getVendorNameByVendiorId("B0004"); 
		
		//new DropDownUtil().getItemNameByItemId("01400"); //01400
		
		//new DropDownUtil().getRebatePercentByVenodorID("E0009","08400");
		//new DropDownUtil().getRebatePercentByVenodorID("E0009111111","08400");
		
		new DropDownUtil().getMaxInvoice();
		
		/*VendorGst vg = new VendorGst();
		vg.setId(1000);
		vg.setGstNumber("testDropDown");
		vg.setAddress1("tst");
		vg.setAddress2("tst");
		vg.setAddress3("tst");
		//vg.setContactNumber(123);
		vg.setContactPerson("tst");
		vg.setEmail("tst");
		vg.setPinCode(123);
		vg.setVendorId("tst");
		vg.setVendorName("tst");
		vg.setVendorType("tst");
		
		new DropDownUtil().insertVendorGst(vg);*/
		
	}
	
	
	public  String getBankById(Integer bankID) {
		
 	String query="select bank_name from bank_master where bank_code=?";
 	String bankName=""; 
	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setInt(1, bankID);
		rs=pst.executeQuery();
		while(rs.next()){
			
	
			bankName = rs.getString("BANK_NAME");
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("bankName "+bankName);
	return  bankName;
}
	
	
	
	public  Integer getMaxInvoice() {
		
	 	String query="select max(INVOICE_NO) from invoice";
	 	Integer invoiceNo=0; 
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
		
				invoiceNo = rs.getInt(1);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("invoiceNo "+invoiceNo);
		return  invoiceNo;
	}
	
	
	public  Float getTestTransByVendorItem(String vendorID, String itemID) {
		
 		Float closingBalance = 0f;
			
	String query="SELECT CLOSE_BALANCE FROM TESTING_TRANS WHERE VENDOR_CODE=? AND ITEM_GROUP_CODE=? ORDER BY TRANS_ID DESC";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		pst.setString(2, itemID);
		rs=pst.executeQuery();
		//while(rs.next()){
			
			rs.next();
			closingBalance = rs.getFloat("CLOSE_BALANCE");
		
		//}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+closingBalance);
	return  closingBalance;
}

	public  Date getInvoiceClearUpto(String vendorID, String itemID) {
		
 		Date closingUpTo = null;
			
	String query="select max(i.QTR_TO_DATE) as QTR_TO_DATE from INVOICE i left outer join REB_TRANSACTION_TABLE r on i.id=r.invoice_no where "
			+ "r.vendor_code=? "
			+ "and r.item_code=? order by i.QTR_TO_DATE desc";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		pst.setString(2, itemID);
		rs=pst.executeQuery();
		//while(rs.next()){
			
			rs.next();
			closingUpTo = rs.getDate("QTR_TO_DATE");
		
		//}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+closingUpTo);
	return  closingUpTo;
}

	//select sum(INVOICE_PAYMNT) as Payment from REB_TRANSACTION_TABLE where vendor_code='S0280' and item_code='08000'

	public  Float getRebateTotal(String vendorID, String itemID, Date fromDate, Date toDate) {
		
		Float reabteTotal = 0f;
	
	String query="select sum(INVOICE_PAYMNT) as Payment from REB_TRANSACTION_TABLE where vendor_code=? and item_code=? and TRANSACTION_DATE between ? and ?";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		pst.setString(2, itemID);
		pst.setDate(3, new java.sql.Date(fromDate.getTime()));
		pst.setDate(4, new java.sql.Date(toDate.getTime()));
		
		rs=pst.executeQuery();
		//while(rs.next()){
			
			rs.next();
			reabteTotal = reabteTotal + rs.getFloat("Payment");
		
		//}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("====="+reabteTotal);
	return  reabteTotal;
}
	
	
	//select rebate_balance, tax_balance, total from rebate_op_bal
	
public  OpeningBalance getOpeningBalance(String vendorID, String itemID) {
		
	OpeningBalance openingBalance = new OpeningBalance();
	Float reabteTotal = 0f;
			
	String query="select rebate_balance, tax_balance, total from rebate_op_bal";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
		//while(rs.next()){
			
			rs.next();
			openingBalance.setRebateBalance(rs.getFloat("rebate_balance"));
			openingBalance.setTaxBalance(rs.getFloat("tax_balance"));
			openingBalance.setTotal(rs.getFloat("total"));
			
		//}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return  openingBalance;
}

public  OpeningBalance getStuOpeningBalance(String stuCode) {
	
	OpeningBalance openingBalance = new OpeningBalance();
	Float reabteTotal = 0f;
			
	String query="select balance, tax_balance, total from STU_OP_BAL";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
		//while(rs.next()){
			
			rs.next();
			openingBalance.setRebateBalance(rs.getFloat("balance"));
			openingBalance.setTaxBalance(rs.getFloat("tax_balance"));
			openingBalance.setTotal(rs.getFloat("total"));
			
		//}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return  openingBalance;
}	


public  OpeningBalance getBudget() {
	
	OpeningBalance openingBalance = new OpeningBalance();
	Float budget = 0f;
			
	String query="select amount from budget";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
			rs.next();
			openingBalance.setTotal(rs.getFloat("amount"));
	}catch(Exception e){
		e.printStackTrace();
	}
	return  openingBalance;
}	


public  Integer updateVendorGst(VendorGst vendorGST) {
	
	Integer id = 0;	
//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
String query="update  VendorGst set firstcontact=?,VENDOR_ID=?,NAME=?,ADDRESS1=?,ADDRESS2=?,ADDRESS3=?,PIN_CODE=?,GSTNO=?,CONTACTPERSON=?,EMAIL=?,VENDOR_TYPE=?, OTHER_CONTACTS=? WHERE id =? ";

System.out.println("====="+query);

try{
	con=DbConnection.getConnection();
	pst=con.prepareStatement(query);
	pst.setString(1, vendorGST.getFirstContact() == null ? "" : vendorGST.getFirstContact());
	pst.setString(2, vendorGST.getVendorId() == null ? "" : vendorGST.getVendorId());
	pst.setString(3, vendorGST.getVendorName() == null ? "" : vendorGST.getVendorName());
	pst.setString(4, vendorGST.getAddress1() == null ?  "" : vendorGST.getAddress1());
	pst.setString(5, vendorGST.getAddress2() == null ? "" : vendorGST.getAddress2());
	pst.setString(6, vendorGST.getAddress3() == null ? "" : vendorGST.getAddress3());
	pst.setInt(7, vendorGST.getPinCode() == null ? 0 : vendorGST.getPinCode());
	pst.setString(8, vendorGST.getGstNumber() == null ?  "" : vendorGST.getGstNumber());
	pst.setString(9, vendorGST.getContactPerson() == null ?  "" : vendorGST.getContactPerson());
	pst.setString(10, vendorGST.getEmail() == null ?  "" : vendorGST.getEmail());
	pst.setString(11, vendorGST.getVendorType() == null ?  "" : vendorGST.getVendorType());
	pst.setString(12, vendorGST.getOtherContacts() == null ?  "" : vendorGST.getOtherContacts());
	pst.setInt(13, vendorGST.getId());
	
	id=pst.executeUpdate();

	
}catch(Exception e){
	e.printStackTrace();
}
return  id;
}

public  Integer insertVendorGst(VendorGst vendorGST) {
	
	Integer id = 0;	
//String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id and P.PG_ID LIKE '%00' AND v.vendor_id=?";
String query="insert into  VendorGst (id,firstcontact, VENDOR_ID, NAME, ADDRESS1, ADDRESS2, ADDRESS3, PIN_CODE, GSTNO, CONTACTPERSON, EMAIL, VENDOR_TYPE, OTHER_CONTACTS) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	System.out.println("====="+query);

try{
	con=DbConnection.getConnection();
	pst=con.prepareStatement(query);

	Integer nextID = getMaxVendorGstId()+1;
	pst.setInt(1, nextID);
	
	pst.setString(2, vendorGST.getFirstContact() == null ? "" : vendorGST.getFirstContact());
	pst.setString(3, vendorGST.getVendorId() == null ? "" : vendorGST.getVendorId());
	pst.setString(4, vendorGST.getVendorName() == null ? "" : vendorGST.getVendorName());
	pst.setString(5, vendorGST.getAddress1() == null ?  "" : vendorGST.getAddress1());
	pst.setString(6, vendorGST.getAddress2() == null ? "" : vendorGST.getAddress2());
	pst.setString(7, vendorGST.getAddress3() == null ? "" : vendorGST.getAddress3());
	pst.setInt(8, vendorGST.getPinCode() == null ? 0 : vendorGST.getPinCode());
	pst.setString(9, vendorGST.getGstNumber() == null ?  "" : vendorGST.getGstNumber());
	pst.setString(10, vendorGST.getContactPerson() == null ?  "" : vendorGST.getContactPerson());
	pst.setString(11, vendorGST.getEmail() == null ?  "" : vendorGST.getEmail());
	pst.setString(12, vendorGST.getVendorType() == null ?  "" : vendorGST.getVendorType());
	pst.setString(13, vendorGST.getOtherContacts() == null ?  "" : vendorGST.getOtherContacts());
	
	
	id=pst.executeUpdate();

	
}catch(Exception e){
	e.printStackTrace();
}
return  id;
}

public  Integer getMaxVendorGstId() {
	
	OpeningBalance openingBalance = new OpeningBalance();
	Integer id = 0;
			
	String query="select max(id) from VENDORGST";
 	System.out.println("====="+query); //08000 S0280

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
			rs.next();
			
			id = rs.getInt(1);
			
	}catch(Exception e){
		e.printStackTrace();
	}
	return  id;
}	


}
