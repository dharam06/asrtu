package com.asrtu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.TestingSearch;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;
import com.astru.util.HibernateUtil;

@Repository("stoOrderFormDao")
public class StoOrderFormDaoImp implements StoOrderFormDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrderForm(StoOrderForm oredrForm) {
		
		System.out.println(oredrForm.toString());
		
		sessionFactory.getCurrentSession().saveOrUpdate(oredrForm);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoOrderForm> listOrderForm() {
		
		//return (List<StoOrderForm>)sessionFactory.getCurrentSession().createCriteria(StoOrderForm.class).list();
		
		return (List<StoOrderForm>)sessionFactory.getCurrentSession().createQuery("FROM StoOrderForm order by testDate desc").list();
		
		//List<Quarter> list=sessionFactory.getCurrentSession().createQuery("FROM Quarter order by QFROM desc").list();
	}

	@Override
	public StoOrderForm getOrderForm(int sno) {
		
		return (StoOrderForm)sessionFactory.getCurrentSession().get(StoOrderForm.class, sno);
	}

	@Override
	public void deleteOrderForm(StoOrderForm oredrForm) {
		
		sessionFactory.getCurrentSession().createQuery("delete from StoOrderForm where stoTransId="+oredrForm.getStoTransId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public StoOrderForm getStoOrder(Integer stoNumber) {
		List<StoOrderForm> list=sessionFactory.getCurrentSession().createQuery("FROM StoOrderForm where stoNo=? and isPaid!='Y' order by stoNo desc ").setInteger(0, stoNumber).list();
		
		if(list.size()>0){
			return list.get(0);
			
		} else{
			
			return null;
		}

		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public StoOrderForm getStoOrderByStoId(String stoId) {
		List<StoOrderForm> list=sessionFactory.getCurrentSession().createQuery("FROM StoOrderForm where stoId=? and isPaid!='Y' order by stoId desc ").setString(0, stoId).list();
		
		if(list.size()>0){
			return list.get(0);
			
		} else{
			
			return null;
		}

		
	}

	@Override
	public Integer updateSto(StoOrderForm oredrForm){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("update StoOrderForm set isPaid=:isPaid where stoNo=:stoNo");
		q.setString("isPaid", oredrForm.getIsPaid());
		q.setInteger("stoNo", oredrForm.getStoNo());
		q.executeUpdate();

		session.getTransaction().commit();
		return 1; 
	}

	@Override
	public List<StoOrderForm> searchStoOrder(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StoOrderForm.class);
		
		if(testingSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("testDate",testingSearch.getTransactionDateFrom()));
		}
		if(testingSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("testDate",testingSearch.getTransactionDateTo()));
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
