package com.asrtu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.RcperiodBean;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.Vendors;
import com.asrtu.service.RcPeriodService;

@Repository("rcPeriodDao")
public class RcPeriodDaoImp implements RcperiodDao{

	@Autowired
	private SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer addRcPeriod(RcPeriod rcPeriod) {
		sessionFactory.getCurrentSession().saveOrUpdate(rcPeriod);
		
		return rcPeriod.getSno();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RcPeriod> listRcPeriod() {
		List<RcPeriod> list=sessionFactory.getCurrentSession().createQuery("from RcPeriod order by sno desc").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RcPeriod> rcPeriodForVendorItem(RcperiodBean rcperiodBean) {
		List<RcPeriod> list=sessionFactory.getCurrentSession().createQuery("from RcPeriod where VENDOR_ID=? and PG_ID=? order by sno desc").setString(0, rcperiodBean.getVendorId()).setString(1, rcperiodBean.getPgId()).list();
		return list;
	}

	
	@Override
	public RcPeriod getRcPeriod(int sno) {
		RcPeriod rc=(RcPeriod)sessionFactory.getCurrentSession().get(RcPeriod.class, sno);
		return rc;
	}

	
	@Override
	public void deleteRcPeriod(RcPeriod rcPeriod) {
		
		System.out.println("Delete  Query fire  ");
		sessionFactory.getCurrentSession().createQuery("DELETE FROM RcPeriod WHERE ID = "+rcPeriod.getSno()).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}
	

}
