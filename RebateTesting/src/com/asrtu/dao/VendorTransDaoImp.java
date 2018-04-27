package com.asrtu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.Quarter;
import com.asrtu.model.StuTransInv1;
import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.VendorTrans;
import com.asrtu.model.Vendors;

@Repository("vendorTransDao")
public class VendorTransDaoImp implements VendorTransDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void addVenTrans(VendorTrans venTrans) {
		System.out.println("Now,The Process is starting for save instance...");
		sessionFactory.getCurrentSession().saveOrUpdate(venTrans);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorTrans> listVendorTrn() {
		//List<VendorTrans> list=sessionFactory.getCurrentSession().createCriteria(VendorTrans.class).list();
		List<VendorTrans> list=sessionFactory.getCurrentSession().createQuery("FROM VendorTrans where sno > 1 ").list();
		
		//List<Quarter> list= (List<Quarter>)sessionFactory.getCurrentSession().createQuery("FROM Quarter order by substr(quarter,10) desc").list();
		System.out.println(list.toString());
		return list;
	}


	@Override
	public VendorTrans getVendorTrans(int sno) {
		VendorTrans quarter=(VendorTrans)sessionFactory.getCurrentSession().get(VendorTrans.class, sno);
		return quarter;
	}

	

	@Override
	public void deleteVendorTran(VendorTrans venTrans) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM VendorTrans WHERE SNO = "+venTrans.getSno()).executeUpdate();
	}

	@Override
	public List<VendorTrans> searchVendorTrans(StuSearch stuSearch) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VendorTrans.class);
		
	
		if(stuSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("invoiceDate",stuSearch.getTransactionDateFrom()));
		}
		if(stuSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("invoiceDate",stuSearch.getTransactionDateTo()));
		}
		
		if(stuSearch.getVendorCode()!=null && !stuSearch.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("firmCode",stuSearch.getVendorCode()));
		}
		if(stuSearch.getItemCode()!=null && !stuSearch.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("itemCode",stuSearch.getItemCode()));
		}
		if(stuSearch.getStuCode()!=null && !stuSearch.getStuCode().equals("0")){
			criteria.add(Restrictions.eq("stuCode",stuSearch.getStuCode()));
		}
		criteria.addOrder(Order.asc("asrtuInvoiceNumber"));

		return criteria.list();
	}
}
