package com.asrtu.dao;

import java.util.List;


import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemMaster;
import com.asrtu.model.ItemPgTab;

/**
 * @author ##
 *
 */
public interface ItemMasterDao {
	
	public void addItemMaster(ItemMaster itemMaster);

	//public List<ItemGroup> listItemGroup();
	
	public List<ItemMaster> listItemMaster();
	
	public ItemMaster getItemMaster(int sno);
	
	public void deleteItemMaster(ItemMaster itemMaster);
	
	public List<ItemPgTab> listItemGroup();
	
}
