package com.asrtu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.StuSearch;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.StuTransDao;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.StuTransInv1;
import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.Vendors;

@Service("stuTransService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StuTransServiceImp implements StuTransService {
	
	@Autowired
	private StuTransDao stuTransDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStuTrans(StuTransaction stuTrans) {
		stuTransDao.addStuTrans(stuTrans);
		
	}

	@Override
	public List<Quarter> listQuarter() {
		// TODO Auto-generated method stub
		return stuTransDao.listQuarter();
	}


	@Override
	public void deleteStuTran(StuTransaction stuTrans) {
		
		stuTransDao.deleteStuTran(stuTrans);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Stumaster> listStuMaster() {
		// TODO Auto-generated method stub
		return stuTransDao.listStuMaster();
	}

	@Override
	public StuTransaction getStuTransaction(int slNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return stuTransDao.listItemPg();
	}

	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return stuTransDao.listVendors();
	}


	@Override
	public List<StuTransaction>  listStuTransactions() {
		// TODO Auto-generated method stub
		return stuTransDao.listStuTransactions();
	}
	
	@Override
	public List<StuTransaction> searchStuTrans(StuSearch stuSearch){ 
		// TODO Auto-generated method stub
	return stuTransDao.searchStuTrans(stuSearch);
}

	@Override
	public List<StuTransaction> stuTransForDates(StuSearch stuSearch,Date from1, Date to1, Date from2, Date to2){
		return stuTransDao.stuTransForDates(stuSearch, from1, to1, from2, to2);
	}
	
	
	
}
