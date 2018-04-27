package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.MisSearchCriteria;
import com.asrtu.bean.MisSearchResult;
import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.dao.RebateDao;
import com.asrtu.model.BankMaster;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RebateForm;
import com.asrtu.model.Vendors;



@Service("rebateService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RebateServiceImp implements RebateService {

	@Autowired
	private RebateDao rebateDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer addRebate(RebateForm rebateForm) {
		return rebateDao.addRebate(rebateForm);
		
	}
	
	@Override
	public List<RebateForm> listRebate() {
		// TODO Auto-generated method stub
		return rebateDao.listRebate();
	}

	@Override
	public RebateForm getRebate(int receiptNo) {
		// TODO Auto-generated method stub
		return rebateDao.getRebate(receiptNo);
	}

	@Override
	public void deleteRebate(RebateForm rebateForm) {
		// TODO Auto-generated method stub
		rebateDao.deleteRebate(rebateForm);
		
	}

	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return rebateDao.listVendors();
	}

	
	@Override
	public List<BankMaster> listBankMaster() {
		// TODO Auto-generated method stub
		return rebateDao.listBankMaster();
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return rebateDao.listItemPg();
	}

	@Override
	public List<ItemPgTab> getItemGroupByVendorID(String vendorID) {
		// TODO Auto-generated method stub
		return rebateDao.getItemGroupByVendorID(vendorID);
	}

	@Override
	public List<RebateForm> listRebateByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub
		return rebateDao.listRebateByCriteria(rebateSearchCriteria);
	}

	@Override
	public List<RebateForm> listRebateIdsByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub
		return rebateDao.listRebateIdsByCriteria(rebateSearchCriteria);
	}

	@Override
	public List<MisSearchResult> listMisSearchResultByCriteria(MisSearchCriteria misSearchCriteria) {
		// TODO Auto-generated method stub
		return rebateDao.listMisSearchResultByCriteria(misSearchCriteria);
	}

	@Override
	public List<RebateForm> listRebateVendorItemByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub
		return rebateDao.listRebateVendorItemByCriteria(rebateSearchCriteria);
	}

	}
