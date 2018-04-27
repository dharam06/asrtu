package com.asrtu.dao;

import java.util.List;

import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RcTrc;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;




public interface RcTrcDao {
	
	public void addRcTrc(RcTrc rcTrc);

	public List<RcTrc> listRcTrc();
	
	public RcTrc getRcTrc(int sno);
	
	public void deleteRcTrc(RcTrc rcTrc);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();
	

}
