package com.asrtu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.model.CirtBill;
import com.asrtu.model.DebitForm;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Vendors;

@Repository("debitDao")
public class DebitDaoImp implements DebitDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addDebit(DebitForm debitForm) {
		sessionFactory.getCurrentSession().saveOrUpdate(debitForm);
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<DebitForm> listDebit() {
	
		return(List<DebitForm>)sessionFactory.getCurrentSession().createCriteria(DebitForm.class).list();
	}

	
	@Override
	public DebitForm getDebit(int sno) {
		
		return (DebitForm)sessionFactory.getCurrentSession().get(DebitForm.class, sno);
	}
	

	@Override
	public void deleteDebit(DebitForm debitForm) {
		sessionFactory.getCurrentSession().createQuery("").executeUpdate();
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		
		return (List<Vendors>)sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}

	
	


	
	
	

	

}
