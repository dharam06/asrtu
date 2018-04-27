package com.astru.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.astru.util.DbConnection;

public class AjaxGetItem {
	
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	Statement stmt = null;
	
	public String getName(String ITEM_GROUP_NAME)
	{
		
		System.out.println("====="+ITEM_GROUP_NAME);
		String name=null;
		String query="select ITEM_GROUP_NAME from item_group_master WHERE ITEM_GROUP_CODE=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, ITEM_GROUP_NAME);
			rs=pst.executeQuery();
			while(rs.next()){
				name=rs.getString("ITEM_GROUP_NAME");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+name);
		return name;
	}
	
	public String getVendorId(String vendorName)
	{
		
		System.out.println("====="+vendorName);
		String vendorNameId=null;
		String query="select VENDOR_ID from VENDORS WHERE NAME=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, vendorName);
			rs=pst.executeQuery();
			while(rs.next()){
				vendorNameId=rs.getString("VENDOR_ID");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+vendorNameId);
		return vendorNameId;
	}
	
	public String getVendorName(String vendorID)
	{
		
		System.out.println("====="+vendorID);
		String vendorName=null;
		String query="select NAME from VENDORS WHERE VENDOR_ID=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, vendorID);
			rs=pst.executeQuery();
			while(rs.next()){
				vendorName=rs.getString("NAME");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+vendorName);
		return vendorName;
	}
	
	
	public String getItemName(String itemNameId)
	{
		
		System.out.println("====="+itemNameId);
		String itemName=null;
		String query="select DESCRIPTION from PG_TABLE WHERE PG_ID=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, itemNameId);
			rs=pst.executeQuery();
			while(rs.next()){
				itemName=rs.getString("DESCRIPTION");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return itemName;
	}

	public String getBankName(String bankNameId)
	{
		
		System.out.println("====="+bankNameId);
		String bankName=null;
		String query="select BANK_NAME from BANK_MASTER WHERE BANK_CODE=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, bankNameId);
			rs=pst.executeQuery();
			while(rs.next()){
				bankName=rs.getString("BANK_NAME");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+bankName);
		return bankName;
	}
	
	public Integer getServiceTax(String fromDate)throws Exception
	{
		
		System.out.println("====="+fromDate);
		Integer serviceTax=null;
		//String query="select PERCENTAGE from tax_master WHERE between FROM_DATE=? and TO_DATE=?";
		SimpleDateFormat sdfSource=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MMM-yyyy");
		Date t1	=sdfSource.parse(fromDate);
		String t2=sdfDestination.format(t1);
		String query="select PERCENTAGE from tax_master WHERE '"+t2+"' between from_date and to_date" ;
		System.out.println("====="+query);
		try{
		
			con=DbConnection.getConnection();
			//pst=con.prepareStatement(query);
			//pst.setString(1, t2);
			//pst.setString(2, fromDate);
			stmt = con.createStatement();
			
			rs=stmt.executeQuery(query);
			while(rs.next()){
				serviceTax=rs.getInt("PERCENTAGE");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("====="+serviceTax);
		return serviceTax;
	}
	
	
	public static void main(String[] args){
		try{
			
		
		Integer st = new AjaxGetItem().getServiceTax("27/10/2016");
		} catch (Exception e){
			
			
			
			
		}
		
	}
	
	
	public String getGroupName(String groupID)
	{
		
		System.out.println("====="+groupID);
		String groupName=null;
		String query="select DISTINCT  P.description from  pg_table p where  p.PG_ID=?";
		try{
			con=DbConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, groupID);
			rs=pst.executeQuery();
			while(rs.next()){
				groupName=rs.getString("description");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return groupName;
	}
	
	//select DISTINCT  P.description from  pg_table p where  p.PG_ID='01400';
	
}
