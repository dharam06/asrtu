package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.Employee;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;

import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.Vendors;

public interface StuTransDao {
	
	public void addStuTrans(StuTransaction stuTrans);
	
	public List<Quarter> listQuarter();
	
	public StuTransaction getStuTransaction(int slNo);
	
	public void deleteStuTran(StuTransaction stuTrans);
	
	public List<Stumaster> listStuMaster();
	
	public List<ItemPgTab> listItemPg();
	
	public List<Vendors> listVendors();

	List<StuTransaction> listStuTransactions();

	List<StuTransaction> searchStuTrans(StuSearch stuSearch);

	List<StuTransaction> stuTransForDates(StuSearch stuSearch, Date from1, Date to1, Date from2, Date to2);

}
