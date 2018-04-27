package com.asrtu.service;

import java.util.Date;
import java.util.List;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;

import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.Vendors;

public interface StuTransService {
	
	public void addStuTrans(StuTransaction stuTrans);
	
	public List<Quarter> listQuarter();
	
	public StuTransaction getStuTransaction(int slNo);
	
	public void deleteStuTran(StuTransaction stuTrans);
	
	public List<Stumaster> listStuMaster();
	
	public List<ItemPgTab> listItemPg();
	
	public List<Vendors> listVendors();
	
	
	public List<StuTransaction>  listStuTransactions();

	List<StuTransaction> searchStuTrans(StuSearch stuSearch);

	List<StuTransaction> stuTransForDates(StuSearch stuSearch, Date from1, Date to1, Date from2, Date to2);

}
