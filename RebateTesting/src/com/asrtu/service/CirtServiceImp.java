package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.TestingSearch;
import com.asrtu.dao.CirtDao;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.TaxEntryDao;
import com.asrtu.dao.TestingChargeDao;
import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

@Service("cirtService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CirtServiceImp implements CirtService {
	
	@Autowired
	private CirtDao cirtDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer addCIRT(CirtBill cirtBill) {
		return cirtDao.addCIRT(cirtBill);
		
	}


	@Override
	public List<CirtBill> listCIRT() {
		
		return cirtDao.listCIRT();
	}


	@Override
	public CirtBill getCIRT(int sno) {
		
		return cirtDao.getCIRT(sno);
	}


	@Override
	public void deleteCIRT(CirtBill cirtBill) {
		cirtDao.deleteCIRT(cirtBill);
	}


	@Override
	public List<ItemPgTab> listItemPg() {
		
		return cirtDao.listItemPg();
	}


	@Override
	public List<Vendors> listVendors() {
		
		return cirtDao.listVendors();
	}


	@Override
	public List<CirtBill> searchCirtBill(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		return cirtDao.searchCirtBill(testingSearch);
	}


	

	

}
