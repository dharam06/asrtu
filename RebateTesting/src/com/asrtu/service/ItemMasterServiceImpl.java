package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.asrtu.dao.ItemMasterDao;

import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemMaster;
import com.asrtu.model.ItemPgTab;

/**
 * @author ##
 *
 */
@Service("itemMasterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemMasterServiceImpl implements ItemMasterService {

	@Autowired
	private ItemMasterDao itemMasterDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addItemMaster(ItemMaster itemMaster) {
		
		itemMasterDao.addItemMaster(itemMaster);
		
	}

/*	@Override
	public List<ItemGroup> listItemGroup() {
		
		return itemMasterDao.listItemGroup();
	}*/

	@Override
	public List<ItemMaster> listItemMaster() {
		
		return itemMasterDao.listItemMaster();
	}

	@Override
	public ItemMaster getItemMaster(int sno) {
		
		return itemMasterDao.getItemMaster(sno);
	}

	@Override
	public void deleteItemMaster(ItemMaster itemMaster) {
		
		itemMasterDao.deleteItemMaster(itemMaster);
		
		
	}
	
	@Override
	public List<ItemPgTab> listItemGroup() {
		// TODO Auto-generated method stub
		return itemMasterDao.listItemGroup();
	}


}
