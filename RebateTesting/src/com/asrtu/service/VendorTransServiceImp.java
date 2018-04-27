package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.StuSearch;
import com.asrtu.dao.VendorTransDao;

import com.asrtu.model.VendorTrans;

@Service("vendorTransService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VendorTransServiceImp implements VendorTransService {
	
	@Autowired
	private VendorTransDao vendorTransDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addVenTrans(VendorTrans venTrans) {
	
		vendorTransDao.addVenTrans(venTrans);
		
	}

	@Override
	public List<VendorTrans> listVendorTrn() {
				return vendorTransDao.listVendorTrn();
	}

	@Override
	public VendorTrans getVendorTrans(int sno) {
		
		return vendorTransDao.getVendorTrans(sno);
	}

	@Override
	public void deleteVendorTran(VendorTrans venTrans) {
		vendorTransDao.deleteVendorTran(venTrans);
		
	}

	
	@Override
	public List<VendorTrans> searchVendorTrans(StuSearch stuSearch){
		
		return vendorTransDao.searchVendorTrans(stuSearch);
		
	}
	

	

	

}
