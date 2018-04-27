package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.model.Invoice;

public interface InvoiceDao {
	
	public Integer addInvoice(Invoice invoice);
	
	public List<Invoice> listInvoices();
	
	
	public void deleteInvoice(Invoice invoice);

	Invoice getInvoice(Integer invoiceNumber);

	List<Invoice> listInvoicesByVendorItem(String vendorID, String itemId);

	Integer updateInvoice(Invoice invoice);

	List<Invoice> searchInvoices(InvoiceSearch invoiceSearch);

}
