package com.asrtu.service;

import java.util.List;

import com.asrtu.model.Employee;
import com.asrtu.model.ItemGroup;

/**
 * @author ##
 *
 */
public interface ItemGroupService {
	
	public void addItmGrop(ItemGroup itemGroup);

	public List<ItemGroup> listItmGrop();
	
	public ItemGroup getItmGrop(int sno);
	
	public void deleteItmGrop(ItemGroup itemGroup);
	
	//create the method for ajax using and get the item group name
		public String itemGroupName(String itemCode);
}
