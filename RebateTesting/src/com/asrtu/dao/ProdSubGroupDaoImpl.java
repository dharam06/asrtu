package com.asrtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.Employee;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.ProdSubGroup;
import com.astru.util.DropDownUtil;

/**
 * @author ##
 *
 */
@Repository("prodSubGroupDao")
public class ProdSubGroupDaoImpl implements ProdSubGroupDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProdSubGroup(ProdSubGroup subGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(subGroup);
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProdSubGroup> listProdSubGroup() {
		
		return (List<ProdSubGroup>) sessionFactory.getCurrentSession().createCriteria(ProdSubGroup.class).list();
	}

	
	@Override
	public ProdSubGroup getProdSubGroup(int id) {
		
		return (ProdSubGroup) sessionFactory.getCurrentSession().get(ProdSubGroup.class, id);
	}
	

	@Override
	public void deleteProdSubGroup(ProdSubGroup subGroup) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ProdSubGroup WHERE id= "+subGroup.getId()).executeUpdate();
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
