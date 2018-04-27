package com.asrtu.dao;

import java.util.List;


import com.asrtu.model.ItemGroup;
import com.asrtu.model.Vendors;

/**
 * @author ##
 *
 */
public interface VendorsDao {
	
	public void addVendors(Vendors vendors);

	public List<Vendors> listVendors();
	
	public Vendors getVendors(String sno);
	
	public void deleteVendors(Vendors vendors);
	
	
	
}
