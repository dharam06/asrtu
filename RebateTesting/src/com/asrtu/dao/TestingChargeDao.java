package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.TestingSearch;
import com.asrtu.model.BankMaster;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.TestingTransaction;
import com.asrtu.model.Vendors;




public interface TestingChargeDao {
	
	public Integer addTestCharge(TestingCharge testingCharge);

	public List<TestingCharge> listTestCharge();
	
	public TestingCharge getTestCharge(int sno);
	
	public void deleteTestCharge(TestingCharge testingCharge);
	
	public List<Vendors> listVendors();
	
	public List<ItemGroup> listItemGroup();
	
	public List<BankMaster> listBankMaster();
	
	public Integer addTestChargeTrans(TestingTransaction testingTransaction);
	
	public TestingTransaction getTestTransByVendorItem(String vendorID, String itemID) ;

	public List<TestingCharge> searchTestingCharge(TestingSearch testingSearch);

}
