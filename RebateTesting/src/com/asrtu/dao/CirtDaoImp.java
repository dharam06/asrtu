package com.asrtu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.TestingSearch;
import com.asrtu.model.CirtBill;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.Vendors;

@Repository("cirtDao")
public class CirtDaoImp implements CirtDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	
	public Integer addCIRT(CirtBill cirtBill) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(cirtBill);
		Integer transId  = cirtBill.getTransId();
		return transId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CirtBill> listCIRT() {
		
		return (List<CirtBill>)sessionFactory.getCurrentSession().createCriteria(CirtBill.class).list();
	}

	@Override
	public CirtBill getCIRT(int sno) {
		
		return (CirtBill)sessionFactory.getCurrentSession().get(CirtBill.class, sno);
	}

	@Override
	public void deleteCIRT(CirtBill cirtBill) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM CirtBill WHERE transId = "+cirtBill.getTransId()).executeUpdate();
		
		
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

	@Override
	public List<CirtBill> searchCirtBill(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CirtBill.class);
		
		if(testingSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("billDate",testingSearch.getTransactionDateFrom()));
		}
		if(testingSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("billDate",testingSearch.getTransactionDateTo()));
		}
		
		if(testingSearch.getVendorCode()!=null && !testingSearch.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("vendorId",testingSearch.getVendorCode()));
		}
		if(testingSearch.getItemCode()!=null && !testingSearch.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("itemCode",testingSearch.getItemCode()));
		}
		//criteria.addOrder(Order.asc("date"));

		return criteria.list();
	}

}
