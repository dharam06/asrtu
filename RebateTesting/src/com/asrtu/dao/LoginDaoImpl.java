package com.asrtu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.Employee;
import com.asrtu.model.Login;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addLogin(Login login) {
		sessionFactory.getCurrentSession().saveOrUpdate(login);
		
	}

	@Override
	public List<Login> listLogin() {
		
		return (List<Login>) sessionFactory.getCurrentSession().createCriteria(Login.class).list();
	}

	@Override
	public Login getLogin(String name) {
		
		System.out.print("!!!! Start the Processing");
		return (Login) sessionFactory.getCurrentSession().get(Login.class, name);
		
		
	}



	@Override
	public void deleteLogin(Login login) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE from Login where  =").executeUpdate();
		
	}

}
