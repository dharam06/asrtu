package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.VendorGstSearch;
import com.asrtu.model.VendorGst;
import com.astru.util.HibernateUtil;
import com.astru.util.DropDownUtil;

@Repository("VendorGstDao")
public class VendorGstDaoImpl implements VendorGstDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String addVendorGst(VendorGst VendorGst){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.saveOrUpdate(VendorGst);
		session.getTransaction().commit();
		
//		sessionFactory.getCurrentSession().saveOrUpdate(VendorGst);
		
		String VendorGstNumber = VendorGst.getGstNumber();
		
		System.out.println("\n\n VendorGstNumber"+VendorGstNumber);
		/*if(null != VendorGst.getId() && VendorGst.getId() >0){
			Integer id = new DropDownUtil().updateVendorGst(VendorGst);
			return VendorGst.getId()+"";
			
		} else {
			
			Integer id = new DropDownUtil().insertVendorGst(VendorGst);
			return id+"";
		}*/
		
		return VendorGstNumber; 
	}
	
	@Override
	public Integer updateVendorGst(VendorGst VendorGst){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("update VendorGst set rebateRemainingOutstanding=:rebateRemOutstanding where VendorGstNumber=:Id");
		q.executeUpdate();

		session.getTransaction().commit();
		return 1; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorGst> listVendorGsts() {
		List<VendorGst> list=sessionFactory.getCurrentSession().createQuery("FROM VendorGst order by VendorGstNumber desc").list();
		
		System.out.println("\n \n VendorGsts list"+list.toString());
		
		return list;
	}
	@Override
	public void deleteVendorGst(VendorGst VendorGst) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM VendorGst WHERE id = "+VendorGst.getId()).executeUpdate();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public VendorGst getVendorGst(Integer id) {
		
		VendorGst VendorGst = (VendorGst) sessionFactory.getCurrentSession().get(VendorGst.class, id);

		if(null != VendorGst){
		System.out.println("\n \n VendorGsts list"+VendorGst.toString());
		} else {
			
			System.out.println("\n \n VendorGst Number does not exist "+id);
			
		}
		
		return VendorGst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorGst> listVendorGstsByVendor(String vendorID) {
		List<VendorGst> list=sessionFactory.getCurrentSession().createQuery("FROM VendorGst where vendorId=? order by id asc ").setString(0, vendorID).list();
		
		System.out.println("\n \n listVendorGstsByVendor list"+list.toString());
		
		return list;
	}

	@Override
	public List<VendorGst> searchVendorGsts(VendorGstSearch VendorGstSearch) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VendorGst.class);
		
		if(VendorGstSearch.getTransactionDate() !=null){
			criteria.add(Restrictions.eq("VendorGstDate",VendorGstSearch.getTransactionDate()));
		}
		
		if(VendorGstSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("VendorGstDate",VendorGstSearch.getTransactionDateFrom()));
		}
		if(VendorGstSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("VendorGstDate",VendorGstSearch.getTransactionDateTo()));
		}
		
		if(VendorGstSearch.getQuarterFromDate()!=null){
			criteria.add(Restrictions.ge("quarterFromDate",VendorGstSearch.getQuarterFromDate()));
		}
		if(VendorGstSearch.getQuarterToDate()!=null){
			criteria.add(Restrictions.le("quarterToDate",VendorGstSearch.getQuarterToDate()));
		}

		if(VendorGstSearch.getVendorCode()!=null && !VendorGstSearch.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("vendorCode",VendorGstSearch.getVendorCode()));
		}
		if(VendorGstSearch.getItemCode()!=null && !VendorGstSearch.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("itemCode",VendorGstSearch.getItemCode()));
		}
		//criteria.addOrder(Order.asc("date"));

		return criteria.list();
	}

	
}
