package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.StuTransInv1;
import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

@Repository("stuTransDao")
public class StuTransDaoImp implements StuTransDao{

	@Autowired
	private SessionFactory sessionFactory;
	


	
	@Override
	public void addStuTrans(StuTransaction stuTrans) {
		System.out.println("Now,The Process is starting for save instance..."+stuTrans.toString());
		
		System.out.println("\n\n stuTrans ====>>>> "+stuTrans.toString());
		
		sessionFactory.getCurrentSession().saveOrUpdate(stuTrans);
		
	}




	@Override
	public void deleteStuTran(StuTransaction stuTrans) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM StuTransaction WHERE sno = "+stuTrans.getSno()).executeUpdate();
	
		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Stumaster> listStuMaster() {
		// TODO Auto-generated method stub
		//return (List<Stumaster>)sessionFactory.getCurrentSession().createCriteria(Stumaster.class).list();
		
		List<Stumaster> stuList;
		
		System.out.println("Stumaster starts"+System.currentTimeMillis());;
		stuList = (List<Stumaster>)sessionFactory.getCurrentSession().createQuery("FROM Stumaster order by sno asc").list();

		System.out.println("Stumaster starts"+System.currentTimeMillis());;
		
		return stuList;
	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}



	@Override
	public StuTransaction getStuTransaction(int slNo) {
		// TODO Auto-generated method stub
		return null;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Quarter> listQuarter() {
		
		System.out.println("\n\n DAO listQuarter");
		
		//List<Quarter> list=sessionFactory.getCurrentSession().createCriteria(Quarter.class).list();
		
		List<Quarter> list= (List<Quarter>)sessionFactory.getCurrentSession().createQuery("FROM Quarter order by substr(quarter,10) desc").list();

		
		System.out.println("\n\n DAO listQuarter list "+list);
		
		
		for(Quarter  quar: list){
			System.out.print("quarter of size  "+list);
	
			if(null != quar){
			System.out.println("\n\n DAO listQuarter "+quar.getSlNo());
			System.out.println("\n\n DAO listQuarter "+quar.getQuarter());
			}
		
			
		}
		
		return list;
	}




	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<StuTransaction> listStuTransactions() {
		// TODO Auto-generated method stub
		
		List<StuTransaction> stuTransactionList = null;
		System.out.println("listStuTransactions starts : "+System.currentTimeMillis());;
		stuTransactionList = (List<StuTransaction>)sessionFactory.getCurrentSession().createQuery("FROM StuTransaction order by sno desc").setMaxResults(1000).list();

		
		for(StuTransaction stuTransaction : stuTransactionList){
			
			System.out.println("stuTransaction bean : "+stuTransaction.toString());
			
		}
		
		System.out.println("listStuTransactions ends : "+System.currentTimeMillis());;
		return stuTransactionList;
	}


	@Override
	public List<StuTransaction> searchStuTrans(StuSearch stuSearch) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StuTransaction.class);
		
		if(stuSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("invoiceDate",stuSearch.getTransactionDateFrom()));
		}
		if(stuSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("invoiceDate",stuSearch.getTransactionDateTo()));
		}
		
		if(stuSearch.getVendorCode()!=null && !stuSearch.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("vendorCode",stuSearch.getVendorCode()));
		}
		if(stuSearch.getItemCode()!=null && !stuSearch.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("itemCode",stuSearch.getItemCode()));
		}
		if(stuSearch.getStuCode()!=null && !stuSearch.getStuCode().equals("0")){
			criteria.add(Restrictions.eq("stuCode",stuSearch.getStuCode()));
		}
		
		if(stuSearch.getNodalCode()!=null && !stuSearch.getNodalCode().equals("0")){
			criteria.add(Restrictions.eq("nodalCode",stuSearch.getNodalCode()));
		}
		
		criteria.addOrder(Order.asc("invoiceDate"));

		return criteria.list();
	}


	@Override
	public List<StuTransaction> stuTransForDates(StuSearch stuSearch, Date from1, Date to1, Date from2, Date to2) {
		// TODO Auto-generated method stub
		// A sequence of restrictions linked with or is called a disjunction. A sequence of restrictions linked with and is called a conjunction.
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StuTransaction.class);

		Criterion rest=null;
		
		Criterion rest1=null;
		Criterion rest2=null;
		
		Criterion midCondition=null;
		Criterion completeCondition=null;
		
		
		if(stuSearch.getTransactionDateFrom()!=null){
			rest = Restrictions.ge("invoiceDate",stuSearch.getTransactionDateFrom());
		}
		if(stuSearch.getTransactionDateTo()!=null){
			rest = Restrictions.le("invoiceDate",stuSearch.getTransactionDateTo());
		}
		if(stuSearch.getVendorCode()!=null && !stuSearch.getVendorCode().equals("0")){
			rest = Restrictions.eq("vendorCode",stuSearch.getVendorCode());
		}
		if(stuSearch.getItemCode()!=null && !stuSearch.getItemCode().equals("0")){
			rest = Restrictions.eq("itemCode",stuSearch.getItemCode());
		}
		if(stuSearch.getStuCode()!=null && !stuSearch.getStuCode().equals("0")){
			rest = Restrictions.eq("stuCode",stuSearch.getStuCode());
		}
		
		if(stuSearch.getNodalCode()!=null && !stuSearch.getNodalCode().equals("0")){
			rest = Restrictions.eq("nodalCode",stuSearch.getNodalCode());
		}

		if(from1!=null){
			rest1 = Restrictions.ge("invoiceDate",from1);
		}
		if(to1!=null){
			rest1 = Restrictions.le("invoiceDate",to1);
		}
		
		if(from2!=null){
			rest2 = Restrictions.ge("invoiceDate",from2);
		}
		if(to2 !=null){
			rest2 = Restrictions.le("invoiceDate",to2);
		}

		if(null != rest1 &&  null != rest2){
			midCondition = Restrictions.or(rest1, rest2);
			completeCondition = Restrictions.conjunction().add(midCondition).add(rest);
			criteria.add(completeCondition);
		}else {
			completeCondition = Restrictions.conjunction().add(rest1).add(rest);
			criteria.add(completeCondition);
			}
		criteria.addOrder(Order.asc("invoiceDate"));

		return criteria.list();
	}


	

}
