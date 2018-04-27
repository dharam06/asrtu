package com.asrtu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.bean.StuSearch;
import com.asrtu.model.Invoice;
import com.asrtu.model.Stumaster;

@Repository("stuDao")
public class StuDaoImp implements StuDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStu(Stumaster sm) {
		sessionFactory.getCurrentSession().saveOrUpdate(sm);
		
	}

	@Override
	public List<Stumaster> listStu() {
		
		return (List<Stumaster>)sessionFactory.getCurrentSession().createCriteria(Stumaster.class).list();
	}

	

	@Override
	public void deleteStu(Stumaster sm) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Stumaster WHERE SNO = "+sm.getSno()).executeUpdate();
		
	}

	@Override
	public Stumaster getStu(int sno) {
		// TODO Auto-generated method stub
		return (Stumaster)sessionFactory.getCurrentSession().get(Stumaster.class, sno);
	}

	@Override
	public List<Stumaster> stuByStuCode(String stuCode) {
		// TODO Auto-generated method stub
		
		List<Stumaster> list=sessionFactory.getCurrentSession().createQuery("FROM Stumaster where code=? ").setString(0, stuCode).list();
		
		return list;
		
	}



}
