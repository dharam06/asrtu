package com.asrtu.dao;

import java.util.List;

import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.ProdSubGroup;

/**
 * @author ##
 *
 */
public interface ProdSubGroupDao {
	
	public void addProdSubGroup(ProdSubGroup subGroup);

	public List<ProdSubGroup> listProdSubGroup();
	
	public ProdSubGroup getProdSubGroup(int id);
	
	public void deleteProdSubGroup(ProdSubGroup subGroup);
	
	public List<ItemPgTab> listItemGroup();
	
	

	
}
