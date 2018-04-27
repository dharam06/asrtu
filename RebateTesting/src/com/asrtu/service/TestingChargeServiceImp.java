package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.TestingSearch;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.TaxEntryDao;
import com.asrtu.dao.TestingChargeDao;
import com.asrtu.model.BankMaster;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.TestingTransaction;
import com.asrtu.model.Vendors;

@Service("testingChargeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TestingChargeServiceImp implements TestingChargeService {
	
	@Autowired
	private TestingChargeDao testingChargeDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer addTestCharge(TestingCharge testingCharge) {
		
		return testingChargeDao.addTestCharge(testingCharge);
	}

		
	@Override
	public List<TestingCharge> listTestCharge() {
		// TODO Auto-generated method stub
		return testingChargeDao.listTestCharge();
	}

	@Override
	public TestingCharge getTestCharge(int sno) {
		// TODO Auto-generated method stub
		return testingChargeDao.getTestCharge(sno);
	}

	@Override
	public void deleteTestCharge(TestingCharge testingCharge) {
		// TODO Auto-generated method stub
		
		testingChargeDao.deleteTestCharge(testingCharge);
		
	}


	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return testingChargeDao.listVendors();
	}


	@Override
	public List<ItemGroup> listItemGroup() {
		// TODO Auto-generated method stub
		return testingChargeDao.listItemGroup();
	}


	@Override
	public List<BankMaster> listBankMaster() {
		// TODO Auto-generated method stub
		return testingChargeDao.listBankMaster();
	}


	@Override
	public Integer addTestChargeTrans(TestingTransaction testingTransaction) {
		// TODO Auto-generated method stub
		
		Integer trnNumber = testingChargeDao.addTestChargeTrans(testingTransaction);
		return trnNumber;
		
	}


	@Override
	public TestingTransaction getTestTransByVendorItem(String vendorID, String itemID) {
		// TODO Auto-generated method stub
		return testingChargeDao.getTestTransByVendorItem(vendorID, itemID);
	}


	@Override
	public List<TestingCharge> searchTestingCharge(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		return testingChargeDao.searchTestingCharge(testingSearch);
	}

}
