package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.Employee;
import com.asrtu.model.Quarter;

import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.VendorTrans;
import com.asrtu.model.Vendors;

public interface VendorTransDao {
	
	public void addVenTrans(VendorTrans venTrans);
	
	public List<VendorTrans> listVendorTrn();
	
	public VendorTrans getVendorTrans(int sno);
	
	public void deleteVendorTran(VendorTrans venTrans);

	List<VendorTrans> searchVendorTrans(StuSearch stuSearch);
	
	

}
