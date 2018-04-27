package com.asrtu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemMaster;
import com.asrtu.model.ItemPgTab;
import com.astru.util.DropDownUtil;

/**
 * @author ##
 *
 */
@Repository("itemMasterDao")
public class ItemMasterDaoImpl implements ItemMasterDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addItemMaster(ItemMaster itemMaster) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(itemMaster);
	}
	
/*	@SuppressWarnings("unchecked")
	@Override
	public List<ItemGroup> listItemGroup() {
		// TODO Auto-generated method stub
		return (List<ItemGroup>) sessionFactory.getCurrentSession().createCriteria(ItemGroup.class).list();

	}*/
	@Override
	public List<ItemMaster> listItemMaster() {
		return (List<ItemMaster>) sessionFactory.getCurrentSession().createCriteria(ItemMaster.class).list();

		
	}
	
	

	@Override
	public ItemMaster getItemMaster(int sno) {
		
		return (ItemMaster) sessionFactory.getCurrentSession().get(ItemMaster.class, sno);
	}


	@Override
	public void deleteItemMaster(ItemMaster itemMaster) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ItemMaster WHERE SLNO = "+itemMaster.getSno()).executeUpdate();
		
	}


	@Override
	public List<ItemPgTab> listItemGroup() {
		
		//return (List<ItemGroup>) sessionFactory.getCurrentSession().createCriteria(ItemGroup.class).list();
	
		DropDownUtil ddl = new DropDownUtil();
		return ddl.getProductGroupList();
		
		//return (List<ItemPgTab>)  sessionFactory.getCurrentSession().createQuery("select distinct description,pg_id from pg_table where pg_id like '%00'");
		//select distinct description,pg_id from pg_table where pg_id like '%00'
		

	}
	
	
}
