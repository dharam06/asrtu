package com.asrtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.Employee;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemGroup;

/**
 * @author ##
 *
 */
@Repository("itemGroupDao")
public class ItemGroupDaoImpl implements ItemGroupDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addItmGrop(ItemGroup itemGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(itemGroup);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemGroup> listItmGrop() {
		
	return (List<ItemGroup>) sessionFactory.getCurrentSession().createCriteria(ItemGroup.class).list();
		
	/*
		ItemGroup item=new ItemGroup();
		item.setSno(1);
		item.setItemGroupCode("A123");
		item.setItemGroupName("Rajic");
		ItemGroup item1=new ItemGroup();
		item1.setSno(2);
		item1.setItemGroupCode("A123");
		item1.setItemGroupName("Rajiv");
		List<ItemGroup> list =new ArrayList<ItemGroup>();
		list.add(item);
		list.add(item1);
		return list;
		*/
		
	}

	
	
	public ItemGroup getItmGrop(int sno) {
		return (ItemGroup) sessionFactory.getCurrentSession().get(ItemGroup.class, sno);
	}

	

	

	@Override
	public void deleteItmGrop(ItemGroup itemGroup) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ItemGroup WHERE SLNO = "+itemGroup.getSno()).executeUpdate();
		
	}

	@Override
	public String itemGroupName(String itemCode) {
		System.out.println("DAO METHOD CALLL");
		ItemGroup ig = null;
		String grpName="";
		
		List<ItemGroup> list=sessionFactory.getCurrentSession().createQuery("FROM ItemGroup WHERE itemGroupCode=? ").setString(0,itemCode).list() ;
		
		if(null!= list && list.size()>0){
			ig = list.get(0);
			grpName = ig.getItemGroupName();
		}
		
		return grpName;
		
		//return "AJAX RETURN";
	}

	
	
}
