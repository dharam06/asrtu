package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.dao.InvoiceDao;
import com.asrtu.model.Invoice;

@Service("invoiceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Integer addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceDao.addInvoice(invoice);
	}

	@Override
	public List<Invoice> listInvoices() {
		// TODO Auto-generated method stub
		return invoiceDao.listInvoices();
	}

	@Override
	public void  deleteInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		 invoiceDao.deleteInvoice(invoice);
	}

	@Override
	public Invoice  getInvoice(Integer invoiceNumber) {
		// TODO Auto-generated method stub
		 return invoiceDao.getInvoice(invoiceNumber);
	}
	@Override
	public List<Invoice> listInvoicesByVendorItem(String vendorID, String itemId) {
		// TODO Auto-generated method stub
		return invoiceDao.listInvoicesByVendorItem(vendorID,itemId);
	}

	@Override
	public Integer updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceDao.updateInvoice(invoice);
	}

	@Override
	public List<Invoice> searchInvoices(InvoiceSearch invoiceSearch) {
		// TODO Auto-generated method stub
		return invoiceDao.searchInvoices(invoiceSearch);
	}

}
