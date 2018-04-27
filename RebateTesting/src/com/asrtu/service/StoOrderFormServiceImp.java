package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.TestingSearch;
import com.asrtu.dao.StoOrderFormDao;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.Vendors;

@Service("stoOrderFormService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StoOrderFormServiceImp implements StoOrderFormService {

	@Autowired
	private StoOrderFormDao stoOrderFormDao;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	@Override
	public void addOrderForm(StoOrderForm oredrForm) {
		
		stoOrderFormDao.addOrderForm(oredrForm);
	}

	@Override
	public List<StoOrderForm> listOrderForm() {
		// TODO Auto-generated method stub
		return stoOrderFormDao.listOrderForm();
	}

	@Override
	public StoOrderForm getOrderForm(int sno) {
		// TODO Auto-generated method stub
		return stoOrderFormDao.getOrderForm(sno);
	}

	@Override
	public void deleteOrderForm(StoOrderForm oredrForm) {
		// TODO Auto-generated method stub
		stoOrderFormDao.deleteOrderForm(oredrForm);
	}

	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return stoOrderFormDao.listVendors();
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return stoOrderFormDao.listItemPg();
	}

	@Override
	public StoOrderForm getStoOrder(Integer stoNumber) {
		// TODO Auto-generated method stub
		return stoOrderFormDao.getStoOrder(stoNumber);
	}

	@Override
	public Integer updateSto(StoOrderForm oredrForm) {
		// TODO Auto-generated method stub
		return stoOrderFormDao.updateSto(oredrForm);
	}

	@Override
	public List<StoOrderForm> searchStoOrder(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		return stoOrderFormDao.searchStoOrder(testingSearch);
	}

	@Override
	public StoOrderForm getStoOrderByStoId(String stoId) {
		// TODO Auto-generated method stub
		return stoOrderFormDao.getStoOrderByStoId(stoId);
	}

}
