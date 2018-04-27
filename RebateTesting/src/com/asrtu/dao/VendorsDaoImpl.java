package com.asrtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.Employee;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.Vendors;

/**
 * @author ##
 *
 */
@Repository("vendorsDao")
public class VendorsDaoImpl implements VendorsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
		@Override
	public void addVendors(Vendors vendors) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@Override
	public Vendors getVendors(String sno) {
		// TODO Auto-generated method stub
		
		Vendors vendor = (Vendors) sessionFactory.getCurrentSession().get(Vendors.class, sno);

		if(null != vendor){
		System.out.println("\n \n vendor"+vendor.toString());
		} else {
			
			System.out.println("\n \n vendor does not exist "+sno);
			
		}
		
		return vendor;
	}

	@Override
	public void deleteVendors(Vendors vendors) {
		// TODO Auto-generated method stub
		
	}

	
	
}
