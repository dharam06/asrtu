package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.bean.VendorGstSearch;
import com.asrtu.dao.VendorGstDao;
import com.asrtu.model.VendorGst;

@Service("VendorGstService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class VendorGstServiceImpl implements VendorGstService {

	@Autowired
	private VendorGstDao VendorGstDao;

	@Override
	public String addVendorGst(VendorGst VendorGst) {
		// TODO Auto-generated method stub
		return VendorGstDao.addVendorGst(VendorGst);
	}

	@Override
	public List<VendorGst> listVendorGsts() {
		// TODO Auto-generated method stub
		return VendorGstDao.listVendorGsts();
	}

	@Override
	public void  deleteVendorGst(VendorGst VendorGst) {
		// TODO Auto-generated method stub
		 VendorGstDao.deleteVendorGst(VendorGst);
	}

	@Override
	public List<VendorGst> listVendorGstsByVendor(String vendorID) {
		// TODO Auto-generated method stub
		return VendorGstDao.listVendorGstsByVendor(vendorID);
	}

	@Override
	public Integer updateVendorGst(VendorGst VendorGst) {
		// TODO Auto-generated method stub
		return VendorGstDao.updateVendorGst(VendorGst);
	}

	@Override
	public List<VendorGst> searchVendorGsts(VendorGstSearch VendorGstSearch) {
		// TODO Auto-generated method stub
		return VendorGstDao.searchVendorGsts(VendorGstSearch);
	}

	@Override
	public VendorGst getVendorGst(Integer id) {
		// TODO Auto-generated method stub
		return VendorGstDao.getVendorGst(id);
	}

}
