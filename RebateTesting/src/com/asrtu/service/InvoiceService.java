package com.asrtu.service;

import java.util.List;

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.model.Invoice;

public interface InvoiceService {
	
	
	
	
	public Integer addInvoice(Invoice invoice);
	public List<Invoice> listInvoices();
	
	public void deleteInvoice(Invoice invoice);
	Invoice getInvoice(Integer invoiceNumber);
	List<Invoice> listInvoicesByVendorItem(String vendorID, String itemId);
	
	
	public List<Invoice> searchInvoices(InvoiceSearch invoiceSearch);
	
	public Integer updateInvoice(Invoice invoice);
	
}
