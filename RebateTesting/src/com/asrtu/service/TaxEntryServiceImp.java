package com.asrtu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.QuarterDao;
import com.asrtu.dao.TaxEntryDao;
import com.asrtu.model.Invoice;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;

@Service("taxEntryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaxEntryServiceImp implements TaxEntryService {
	
	@Autowired
	private TaxEntryDao taxEntryDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTaxEntry(TaxEntry taxEntry) {
		
		 taxEntryDao.addTaxEntry(taxEntry);
	}

	@Override
	public List<TaxEntry> listTaxEntry() {
		// TODO Auto-generated method stub
		return  taxEntryDao.listTaxEntry();
	}

	@Override
	public TaxEntry getTaxEntry(int sno) {
		// TODO Auto-generated method stub
		return  taxEntryDao.getTaxEntry(sno);
	}

	@Override
	public void deleteTaxEntry(TaxEntry taxEntry) {
		// TODO Auto-generated method stub
		 taxEntryDao.deleteTaxEntry(taxEntry);
	}
	
	@Override
	public Integer addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return taxEntryDao.addInvoice(invoice);
	}
	
	@Override
	public List<Invoice> listInvoices() {
		// TODO Auto-generated method stub
		return  taxEntryDao.listInvoices();
	}

	@Override
	public TaxEntry getTaxByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		
		return taxEntryDao.getTaxByDate(fromDate, toDate);
	}
	
}
