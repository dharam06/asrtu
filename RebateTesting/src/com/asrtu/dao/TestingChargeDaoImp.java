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
import com.asrtu.model.BankMaster;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.RebateForm;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.TestingTransaction;
import com.asrtu.model.Vendors;
import com.astru.util.DbConnection;
import com.astru.util.HibernateUtil;

@Repository("testingChargeDao")
public class TestingChargeDaoImp implements TestingChargeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer  addTestCharge(TestingCharge testingCharge) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(testingCharge);
		
		return testingCharge.getReceiptNo();
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<TestingCharge> listTestCharge() {
		// TODO Auto-generated method stub
		return (List<TestingCharge>)sessionFactory.getCurrentSession().createQuery("FROM TestingCharge order by RECEIPT_NO asc").list();
	}
	


	@Override
	public TestingCharge getTestCharge(int sno) {
		// TODO Auto-generated method stub
		return (TestingCharge)sessionFactory.getCurrentSession().get(TestingCharge.class, sno);
	}



	@Override
	public void deleteTestCharge(TestingCharge testingCharge) {
	
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TestingCharge WHERE receiptNo = "+testingCharge.getReceiptNo()).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemGroup> listItemGroup() {
		// TODO Auto-generated method stub
		return (List<ItemGroup>) sessionFactory.getCurrentSession().createCriteria(ItemGroup.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankMaster> listBankMaster() {
		// TODO Auto-generated method stub
		return (List<BankMaster>) sessionFactory.getCurrentSession().createCriteria(BankMaster.class).list();
	}

	@Override
	public Integer addTestChargeTrans(TestingTransaction testingTransaction) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(testingTransaction);
		session.getTransaction().commit();
		Integer trnNumber = testingTransaction.getTransactionNumber();
		System.out.println("\n\n trnNumber"+trnNumber);
		return trnNumber; 

		
		//		sessionFactory.getCurrentSession().saveOrUpdate(testingTransaction);
			
	}

	@Override
	public TestingTransaction getTestTransByVendorItem(String vendorID, String itemID) {
		// TODO Auto-generated` method stub

		List<TestingTransaction> list = sessionFactory.getCurrentSession()
				.createQuery("FROM TestingTransaction where vendorId=? and itemCode=? order by transactionNumber desc ")
				.setString(0, vendorID).setString(1, itemID).list();

		if (null != list && list.size() > 0) {

			return list.get(0);

		} else {

			return null;
		}

	}

	@Override
	public List<TestingCharge> searchTestingCharge(TestingSearch testingSearch) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TestingCharge.class);
		
		if(testingSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("receiptDate",testingSearch.getTransactionDateFrom()));
		}
		if(testingSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("receiptDate",testingSearch.getTransactionDateTo()));
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
