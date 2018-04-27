package com.asrtu.ajax.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.asrtu.model.Employee;
import com.asrtu.model.ItemGroup;

public class AjaxDao {
	
	
	
	
	SessionFactory sessionFactory = HibernateUtil.getInstance();
	
	//Session session = sessionFactory.getCurrentSession();
	
	public ItemGroup getName(String code)
	{
		
		String hql="FROM ItemGroup WHERE ITEM_GROUP_CODE='"+code+"'";
		ItemGroup item=null;
		System.out.println("====="+code);
		//ItemGroup iiem=(ItemGroup) sessionFactory.getCurrentSession().get(Employee.class, code);
		//return (ItemGroup) sessionFactory.getCurrentSession().get(Employee.class, code);
		//System.out.println(iiem);.
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List list=query.list();
		System.out.println("====lIST=== "+list);
		Iterator it=list.iterator();
		while(it.hasNext()){
			 item=(ItemGroup)it.next();
		}
		return item;
	}
	

}
