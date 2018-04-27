package com.asrtu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.model.FinanceYear;
import com.asrtu.model.Quarter;

@Repository("quarterDao")
public class QuarteDaoImp implements QuarterDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addQuarte(Quarter quarter) {
		sessionFactory.getCurrentSession().saveOrUpdate(quarter);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Quarter> listQuarter() {
		List<Quarter> list=sessionFactory.getCurrentSession().createQuery("FROM Quarter order by QFROM desc").list();
		return list;
	}

	@Override
	public Quarter getQuarter(int slNo) {
		Quarter quarter=(Quarter)sessionFactory.getCurrentSession().get(Quarter.class, slNo);
		return quarter;
	}
	
	@Override
	public Quarter getQuarterByDateRange(Date fromDate, Date toDate) {
		List<Quarter> list=sessionFactory.getCurrentSession().createQuery("FROM Quarter  where ? between qFrom and qtDate and ? between qFrom and qtDate ").setTimestamp(0, fromDate).setTimestamp(1, toDate).list();
		Quarter quarter = null;
		if(list.size()>0){
			quarter= list.get(0);
		}
		return quarter;
	}

	@Override
	public void deleteQuarter(Quarter quarter) {
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Quarter WHERE SLNO = "+quarter.getSlNo()).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinanceYear> listFinanceYear() {
		List<FinanceYear> list=sessionFactory.getCurrentSession().createQuery("FROM FinanceYear order by finFrom desc").list();
		return list;
	}

	@Override
	public FinanceYear getFinanceYear(int slNo) {
		FinanceYear financeYear=(FinanceYear)sessionFactory.getCurrentSession().get(FinanceYear.class, slNo);
		return financeYear;
	}

}
