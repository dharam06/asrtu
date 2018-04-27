package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.MisSearchCriteria;
import com.asrtu.bean.MisSearchResult;
import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.model.BankMaster;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RebateForm;
import com.asrtu.model.Vendors;


public interface RebateService {
	
	public Integer addRebate(RebateForm rebateForm);

	public List<RebateForm> listRebate();
	
	public RebateForm getRebate(int receiptNo);
	
	public void deleteRebate(RebateForm rebateForm);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();
	
	public List<BankMaster> listBankMaster();
	
	public  List<ItemPgTab> getItemGroupByVendorID(String vendorID);
	
	public List<RebateForm> listRebateByCriteria(RebateSearchCriteria rebateSearchCriteria);

	public List<RebateForm> listRebateVendorItemByCriteria(RebateSearchCriteria rebateSearchCriteria);

	public List<RebateForm> listRebateIdsByCriteria(RebateSearchCriteria rebateSearchCriteria);

	public List<MisSearchResult> listMisSearchResultByCriteria(MisSearchCriteria misSearchCriteria);

}
