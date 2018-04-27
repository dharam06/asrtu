package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.VendorGstSearch;
import com.asrtu.model.VendorGst;

public interface VendorGstDao {
	
	public String addVendorGst(VendorGst VendorGst);
	
	public List<VendorGst> listVendorGsts();
	
	
	public void deleteVendorGst(VendorGst VendorGst);

	VendorGst getVendorGst(Integer VendorGstNumber);

	List<VendorGst> listVendorGstsByVendor(String vendorID);

	Integer updateVendorGst(VendorGst VendorGst);

	List<VendorGst> searchVendorGsts(VendorGstSearch VendorGstSearch);

}
