package com.asrtu.ajax.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static{
		
		try{

			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getInstance(){
		
		return sessionFactory;
	}

}
