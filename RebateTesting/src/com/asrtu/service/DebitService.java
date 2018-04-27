package com.asrtu.service;

import java.util.List;

import com.asrtu.model.BankMaster;
import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;

public interface DebitService {
	
	public void addDebit(DebitForm debitForm);

	public List<DebitForm> listDebit();
	
	public DebitForm getDebit(int sno);
	
	public void deleteDebit(DebitForm debitForm);
	
	public List<Vendors> listVendors();
	
	public List<ItemPgTab> listItemPg();
	
	
}
