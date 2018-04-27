package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.VendorGstSearch;
import com.asrtu.model.VendorGst;

public interface VendorGstService {
	
	
	
	
	public String addVendorGst(VendorGst VendorGst);
	public List<VendorGst> listVendorGsts();
	
	public void deleteVendorGst(VendorGst VendorGst);
	VendorGst getVendorGst(Integer VendorGstNumber);
	List<VendorGst> listVendorGstsByVendor(String vendorID);
	
	
	public List<VendorGst> searchVendorGsts(VendorGstSearch VendorGstSearch);
	
	public Integer updateVendorGst(VendorGst VendorGst);
	
}
