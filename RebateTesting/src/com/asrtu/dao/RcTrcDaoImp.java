package com.asrtu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RcTrc;
import com.asrtu.model.Vendors;

@Repository("rcTrcDao")
public class RcTrcDaoImp implements RcTrcDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addRcTrc(RcTrc rcTrc) {
		sessionFactory.getCurrentSession().saveOrUpdate(rcTrc);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RcTrc> listRcTrc() {
	
			return(List<RcTrc>)sessionFactory.getCurrentSession().createCriteria(RcTrc.class).list();
			
			
	}

	
	@Override
	public RcTrc getRcTrc(int sno) {
		return (RcTrc)sessionFactory.getCurrentSession().get(RcTrc.class, sno);
	}


	@Override
	public void deleteRcTrc(RcTrc rcTrc) {
		sessionFactory.getCurrentSession().createQuery("").executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		
		return (List<Vendors>)sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}


}
