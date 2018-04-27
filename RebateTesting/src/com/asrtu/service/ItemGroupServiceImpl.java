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
import com.asrtu.model.Employee;
import com.asrtu.model.ItemGroup;

/**
 * @author ##
 *
 */

@Service("itemGroupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemGroupServiceImpl implements ItemGroupService {

	@Autowired
	private ItemGroupDao itemGroupDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addItmGrop(ItemGroup itemGroup) {
		
		 itemGroupDao.addItmGrop(itemGroup);
		
	}
	
	
	public List<ItemGroup> listItmGrop() {
		
		return itemGroupDao.listItmGrop();
	}
	
	
	@Override
	public ItemGroup getItmGrop(int sno) {
		// TODO Auto-generated method stub
		return itemGroupDao.getItmGrop(sno);
	}

	@Override
	public void deleteItmGrop(ItemGroup itemGroup) {
		itemGroupDao.deleteItmGrop(itemGroup);
		
	}

	
	@Override
	public String itemGroupName(String itemCode) {
		// TODO Auto-generated method stub
		ItemGroupDaoImpl item=new ItemGroupDaoImpl();
		
		//return item.itemGroupName(itemCode);
		System.out.println("SERVICE METHOD CALLL");
		return itemGroupDao.itemGroupName(itemCode);
	}

}
