package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.VendorTrans;

public interface VendorTransService {
	
	public void addVenTrans(VendorTrans venTrans);
	
	public List<VendorTrans> listVendorTrn();
	
	public VendorTrans getVendorTrans(int sno);
	
	public void deleteVendorTran(VendorTrans venTrans);

	List<VendorTrans> searchVendorTrans(StuSearch stuSearch);

}
