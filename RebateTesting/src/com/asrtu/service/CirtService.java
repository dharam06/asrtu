package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.TestingSearch;
import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

public interface CirtService {
	
	public Integer addCIRT(CirtBill cirtBill);

	public List<CirtBill> listCIRT();
	
	public CirtBill getCIRT(int sno);
	
	public void deleteCIRT(CirtBill cirtBill);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();
	
	public List<CirtBill> searchCirtBill(TestingSearch testingSearch);

	
}
