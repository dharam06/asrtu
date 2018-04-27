package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.RcperiodBean;
import com.asrtu.model.Employee;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.Vendors;

public interface RcperiodDao {
	
	public Integer addRcPeriod(RcPeriod rcPeriod);

	public List<RcPeriod> listRcPeriod();
	
	public RcPeriod getRcPeriod(int sno);
	
	public void deleteRcPeriod(RcPeriod rcPeriod);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();

	List<RcPeriod> rcPeriodForVendorItem(RcperiodBean rcperiodBean);

}
