package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.CirtDao;
import com.asrtu.dao.DebitDao;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.TaxEntryDao;
import com.asrtu.dao.TestingChargeDao;
import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

@Service("debitService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DebitServiceImp implements DebitService {
	
	@Autowired
	private DebitDao debitDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDebit(DebitForm debitForm) {
		debitDao.addDebit(debitForm);
		
	}


	@Override
	public List<DebitForm> listDebit() {
		
		return debitDao.listDebit();
	}


	@Override
	public DebitForm getDebit(int sno) {
		
		return debitDao.getDebit(sno);
	}


	@Override
	public void deleteDebit(DebitForm debitForm) {
	
		debitDao.deleteDebit(debitForm);
		
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		
		return debitDao.listItemPg();
	}


	@Override
	public List<Vendors> listVendors() {
		
		return debitDao.listVendors();
	}


}
