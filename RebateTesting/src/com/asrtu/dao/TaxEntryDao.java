package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import com.asrtu.model.Invoice;
import com.asrtu.model.TaxEntry;




public interface TaxEntryDao {
	
	public void addTaxEntry(TaxEntry taxEntry);

	public List<TaxEntry> listTaxEntry();
	
	public TaxEntry getTaxEntry(int sno);
	
	public void deleteTaxEntry(TaxEntry taxEntry);
	
	public Integer addInvoice(Invoice invoice);
	
	public List<Invoice> listInvoices();
	
	public TaxEntry getTaxByDate(Date fromDate, Date toDate);
	

}
