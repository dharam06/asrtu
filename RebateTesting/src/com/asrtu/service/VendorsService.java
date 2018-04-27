package com.asrtu.service;

import java.util.List;



import com.asrtu.model.Vendors;

/**
 * @author ##
 *
 */
public interface VendorsService {
	
	public void addVendors(Vendors vendors);

	public List<Vendors> listVendors();
	
	public Vendors getVendors(String sno);
	
	public void deleteVendors(Vendors vendors);
	
	
	
}
