package com.astru.util;

import java.util.Date
;
import org.hibernate.Session;
import com.astru.util.HibernateUtil;
import  com.asrtu.model.DBUser;
import com.asrtu.model.Invoice;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		/*DBUser user = new DBUser();

		user.setUserId(100);
		user.setUsername("Hibernate101");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());*/
		
		Invoice user  = new Invoice();
		user.setInvoiceNumber(300);
		user.setInvoiceDate(new Date());
		user.setVendorCode("ABC");

		session.save(user);
		session.getTransaction().commit();
	}
}
