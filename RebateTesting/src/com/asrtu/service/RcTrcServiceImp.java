package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.CirtDao;
import com.asrtu.dao.DebitDao;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.RcTrcDao;
import com.asrtu.dao.TaxEntryDao;
import com.asrtu.dao.TestingChargeDao;
import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcTrc;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

@Service("rcTrcService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RcTrcServiceImp implements RcTrcService {
	
	@Autowired
	private RcTrcDao rcTrcDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addRcTrc(RcTrc rcTrc) {
		rcTrcDao.addRcTrc(rcTrc);
		
	}

	@Override
	public List<RcTrc> listRcTrc() {
		
		return rcTrcDao.listRcTrc();
	}

	@Override
	public RcTrc getRcTrc(int sno) {
		
		return rcTrcDao.getRcTrc(sno);
	}

	@Override
	public void deleteRcTrc(RcTrc rcTrc) {
		rcTrcDao.deleteRcTrc(rcTrc);
		
	}

	@Override
	public List<Vendors> listVendors() {
		
		return rcTrcDao.listVendors();
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		
		return rcTrcDao.listItemPg();
	}


	
	

}
