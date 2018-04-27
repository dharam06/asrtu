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

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.model.Invoice;
import com.astru.util.DropDownUtil;
import com.astru.util.HibernateUtil;

@Repository("invoiceDao")
public class InvoiceDaoImpl implements InvoiceDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer addInvoice(Invoice invoice){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		
		// SP -- >> InvoiceNo 13  -- select max(nvl(invoiceNumber,0)) from invoice 
		invoice.setAsrtuInvoiceNumber(new DropDownUtil().getMaxInvoice()+1);
		
		session.beginTransaction();
		session.saveOrUpdate(invoice);
		session.getTransaction().commit();

		
//		sessionFactory.getCurrentSession().saveOrUpdate(invoice);
		
		Integer invoiceNumber = invoice.getInvoiceNumber();
		
		System.out.println("\n\n invoiceNumber"+invoiceNumber);
		
		return invoiceNumber; 
	}
	
	@Override
	public Integer updateInvoice(Invoice invoice){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("update Invoice set rebateRemainingOutstanding=:rebateRemOutstanding, rebatePrRemainingOutstanding=:rebatePrRemainingOutstanding, rebateTaxRemainingOutstanding=:rebateTaxRemainingOutstanding where invoiceNumber=:Id");
		q.setFloat("rebateRemOutstanding", invoice.getRebateRemainingOutstanding());
		q.setFloat("rebatePrRemainingOutstanding", invoice.getRebatePrRemainingOutstanding());
		q.setFloat("rebateTaxRemainingOutstanding", invoice.getRebateTaxRemainingOutstanding());
		q.setInteger("Id", invoice.getInvoiceNumber());
		q.executeUpdate();

		session.getTransaction().commit();
		return 1; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> listInvoices() {
		List<Invoice> list=sessionFactory.getCurrentSession().createQuery("FROM Invoice order by invoiceNumber desc").setMaxResults(100).list();
		
		System.out.println("\n \n Invoices list"+list.toString());
		
		return list;
	}
	@Override
	public void deleteInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Invoice WHERE invoiceNumber = "+invoice.getInvoiceNumber()).executeUpdate();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Invoice getInvoice(Integer invoiceNumber) {
		
		Invoice invoice = (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, invoiceNumber);

		if(null != invoice){
		System.out.println("\n \n Invoices list"+invoice.toString());
		} else {
			
			System.out.println("\n \n Invoice Number does not exist "+invoiceNumber);
			
		}
		
		return invoice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> listInvoicesByVendorItem(String vendorID, String itemId) {
		List<Invoice> list=sessionFactory.getCurrentSession().createQuery("FROM Invoice where vendorCode=? and itemCode=? order by invoiceNumber asc ").setString(0, vendorID).setString(1, itemId).list();
		
		System.out.println("\n \n listInvoicesByVendorItem list"+list.toString());
		
		return list;
	}

	@Override
	public List<Invoice> searchInvoices(InvoiceSearch invoiceSearch) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
		
		if(invoiceSearch.getTransactionDate() !=null){
			criteria.add(Restrictions.eq("invoiceDate",invoiceSearch.getTransactionDate()));
		}
		
		if(invoiceSearch.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("invoiceDate",invoiceSearch.getTransactionDateFrom()));
		}
		if(invoiceSearch.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("invoiceDate",invoiceSearch.getTransactionDateTo()));
		}
		
		if(invoiceSearch.getQuarterFromDate()!=null){
			criteria.add(Restrictions.ge("quarterFromDate",invoiceSearch.getQuarterFromDate()));
		}
		if(invoiceSearch.getQuarterToDate()!=null){
			criteria.add(Restrictions.le("quarterToDate",invoiceSearch.getQuarterToDate()));
		}

		if(invoiceSearch.getVendorCode()!=null && !invoiceSearch.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("vendorCode",invoiceSearch.getVendorCode()));
		}
		if(invoiceSearch.getItemCode()!=null && !invoiceSearch.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("itemCode",invoiceSearch.getItemCode()));
		}
		//criteria.addOrder(Order.asc("date"));

		return criteria.list();
	}

	
}
