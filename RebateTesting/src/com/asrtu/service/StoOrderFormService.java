package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.TestingSearch;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;


public interface StoOrderFormService {
	
	public void addOrderForm(StoOrderForm oredrForm);

	public List<StoOrderForm> listOrderForm();
	
	public StoOrderForm getOrderForm(int sno);
	
	public void deleteOrderForm(StoOrderForm oredrForm);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();
	
	public  StoOrderForm getStoOrder(Integer stoNumber);

	public  StoOrderForm getStoOrderByStoId(String stoId);

	public   Integer updateSto(StoOrderForm oredrForm);
	
	public List<StoOrderForm> searchStoOrder(TestingSearch testingSearch);
	



}
