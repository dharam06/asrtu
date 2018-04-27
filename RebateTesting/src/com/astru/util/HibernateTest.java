package com.astru.util;

import com.asrtu.model.Invoice;

import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jmx.HibernateService;
public class HibernateTest {
	
	
	
	public static List<Invoice> getInvoiceCriteria(InvoiceSearch invoiceSearch, Session session){
	
	Criteria criteria = session.createCriteria(Invoice.class);
	if(invoiceSearch.getQuarterFromDate()!=null){
		criteria.add(Restrictions.ge("quarterFromDate",invoiceSearch.getQuarterFromDate()));
	}
	if(invoiceSearch.getQuarterToDate()!=null){
		criteria.add(Restrictions.le("quarterToDate",invoiceSearch.getQuarterToDate()));
	}
/*	if(invoiceSearch.getVolume()!=null){
		criteria.add(Restrictions.ge("volume",invoiceSearch.getVolume()));
	}
*/	if(invoiceSearch.getVendorCode()!=null){
		criteria.add(Restrictions.eq("vendorCode",invoiceSearch.getVendorCode()));
	}
	if(invoiceSearch.getItemCode()!=null){
		criteria.add(Restrictions.eq("itemCode",invoiceSearch.getItemCode()));
	}
	//criteria.addOrder(Order.asc("date"));

	return criteria.list();
	  }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		InvoiceSearch invoiceSearch = new InvoiceSearch();
		invoiceSearch.setVendorCode("S0280");
		System.out.println("======== "+new HibernateTest().getInvoiceCriteria(invoiceSearch, session).toString());

	}

}
