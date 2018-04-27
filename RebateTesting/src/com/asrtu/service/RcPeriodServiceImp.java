package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.RcperiodBean;
import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.RcperiodDao;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.Vendors;

@Service("rcPeriodService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RcPeriodServiceImp implements RcPeriodService {
	
	@Autowired
	private RcperiodDao rcPeriodDao;


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Integer addRcPeriod(RcPeriod rcPeriod) {
		return rcPeriodDao.addRcPeriod(rcPeriod);
		
	}

	@Override
	public List<RcPeriod> listRcPeriod() {
		
		return rcPeriodDao.listRcPeriod() ;
	}

	@Override
	public RcPeriod getRcPeriod(int sno) {
		
		return rcPeriodDao.getRcPeriod(sno);
	}

	@Override
	public void deleteRcPeriod(RcPeriod rcPeriod) {
		rcPeriodDao.deleteRcPeriod(rcPeriod);
		
	}

	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return rcPeriodDao.listVendors();
	}

	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return rcPeriodDao.listItemPg();
	}

	@Override
	public List<RcPeriod> rcPeriodForVendorItem(RcperiodBean rcperiodBean) {
		// TODO Auto-generated method stub
		return rcPeriodDao.rcPeriodForVendorItem(rcperiodBean);
	}
	
	

}
