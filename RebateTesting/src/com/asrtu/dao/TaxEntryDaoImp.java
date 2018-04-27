package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.Invoice;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;

@Repository("taxEntryDao")
public class TaxEntryDaoImp implements TaxEntryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTaxEntry(TaxEntry taxEntry) {
		sessionFactory.getCurrentSession().saveOrUpdate(taxEntry);
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxEntry> listTaxEntry() {
		List<TaxEntry> list=sessionFactory.getCurrentSession().createQuery("FROM TaxEntry").list();
		return list;
	}


	@Override
	public TaxEntry getTaxEntry(int sno) {
		// TODO Auto-generated method stub
		return (TaxEntry)sessionFactory.getCurrentSession().get(TaxEntry.class, sno);
	}
	
	@Override
	public void deleteTaxEntry(TaxEntry taxEntry) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TaxEntry WHERE sno = "+taxEntry.getSno()).executeUpdate();
	}
	
	@Override
	public Integer addInvoice(Invoice invoice){
		
		System.out.println("\n\n invoice===>>> "+invoice.toString());
		
		sessionFactory.getCurrentSession().saveOrUpdate(invoice);
		Integer invoiceNumber = invoice.getInvoiceNumber();
		
		System.out.println("\n\n invoiceNumber"+invoiceNumber);
		
		return invoiceNumber;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> listInvoices() {
		List<Invoice> list=sessionFactory.getCurrentSession().createQuery("FROM Invoice").list();
		return list;
	}

	@Override
	public TaxEntry getTaxByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub

		//List<TaxEntry> list=sessionFactory.getCurrentSession().createQuery("FROM TaxEntry where vendorCode=? and itemCode=? order by invoiceNumber asc ").setString(0, vendorID).setString(1, itemId).list();

		List<TaxEntry> list=sessionFactory.getCurrentSession().createQuery("FROM TaxEntry  where ? between from_date and to_date and ? between from_date and to_date ").setTimestamp(0, fromDate).setTimestamp(1, toDate).list();
		TaxEntry tax = null;
		if(list.size()>0){
			tax= list.get(0);
		}
		return tax;
	}

}
