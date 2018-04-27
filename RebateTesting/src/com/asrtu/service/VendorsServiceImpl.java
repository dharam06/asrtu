package com.asrtu.service;

import java.util.List;


import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.EmployeeDao;
import com.asrtu.dao.ItemGroupDao;
import com.asrtu.dao.ItemGroupDaoImpl;
import com.asrtu.dao.VendorsDao;
import com.asrtu.model.Employee;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.Vendors;

/**
 * @author ##
 *
 */

@Service("vendorsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VendorsServiceImpl implements VendorsService {

	@Autowired
	private VendorsDao vendorsDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addVendors(Vendors vendors) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return vendorsDao.listVendors();
	}

	@Override
	public Vendors getVendors(String sno) {
		// TODO Auto-generated method stub
		return vendorsDao.getVendors(sno);
	}

	@Override
	public void deleteVendors(Vendors vendors) {
		// TODO Auto-generated method stub
		
	}
}
