package com.asrtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asrtu.bean.InvoiceSearch;
import com.asrtu.bean.MisSearchCriteria;
import com.asrtu.bean.MisSearchResult;
import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.model.BankMaster;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RebateForm;
import com.asrtu.model.Vendors;
import com.astru.util.DbConnection;
import com.astru.util.HibernateUtil;


@Repository("rebateDao")
public class RebateDaoImp implements RebateDao {
	
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Integer  addRebate(RebateForm rebateForm) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(rebateForm);
		return rebateForm.getReceiptNo();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<RebateForm> listRebate() {
		return (List<RebateForm>)sessionFactory.getCurrentSession().createCriteria(RebateForm.class).list();
	}

	@Override
	public RebateForm getRebate(int receiptNo) {
		return (RebateForm)sessionFactory.getCurrentSession().get(RebateForm.class, receiptNo);
	}



	@Override
	public void deleteRebate(RebateForm rebateForm) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM RebateForm WHERE RECEIPT_NO = "+rebateForm.getReceiptNo()).executeUpdate();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Vendors> listVendors() {
		// TODO Auto-generated method stub
		return (List<Vendors>) sessionFactory.getCurrentSession().createCriteria(Vendors.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPgTab> listItemPg() {
		// TODO Auto-generated method stub
		return (List<ItemPgTab>)sessionFactory.getCurrentSession().createCriteria(ItemPgTab.class).list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<BankMaster> listBankMaster() {
		// TODO Auto-generated method stub
		return (List<BankMaster>) sessionFactory.getCurrentSession().createCriteria(BankMaster.class).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public  List<ItemPgTab> getItemGroupByVendorID(String vendorID) {
	
	List<ItemPgTab> itemPgTab = new ArrayList<ItemPgTab>();
	String query="select DISTINCT  P.description, T.PG_ID from vendors V, TENDER_FORM T, pg_table p where T.VENDOR_ID=V.VENDOR_ID AND P.pg_id=T.pg_id   AND v.vendor_id=?";
	System.out.println("====="+query);

	try{
		con=DbConnection.getConnection();
		pst=con.prepareStatement(query);
		pst.setString(1, vendorID);
		rs=pst.executeQuery();
		
		ItemPgTab itemPg = null;
		while(rs.next()){
			
			itemPg = new ItemPgTab();
			itemPg.setItemCode(rs.getString("PG_ID"));
			itemPg.setItemName(rs.getString("description"));	
			itemPgTab.add(itemPg);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return itemPgTab;
}

	@Override
	public List<RebateForm> listRebateByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RebateForm.class);
		
		//criteria.createAlias("rebates", "rebates");
		
		
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("receiptNo"), "receiptNo");
		projList.add(Projections.property("transactionDate"), "transactionDate");
		projList.add(Projections.property("vendorCode"), "vendorCode");
		projList.add(Projections.property("itemCode"), "itemCode");
		projList.add(Projections.property("vendorName"), "vendorName");
		projList.add(Projections.property("itemName"), "itemName");
		projList.add(Projections.property("chequeNo"), "chequeNo");
		projList.add(Projections.property("chequeDate"), "chequeDate");
		projList.add(Projections.property("ddChequeAmount"), "ddChequeAmount");
		projList.add(Projections.property("astruBankName"), "astruBankName");
		projList.add(Projections.property("invoiceNumber"), "invoiceNumber");
		projList.add(Projections.property("invoicePayment"), "invoicePayment");
		projList.add(Projections.property("receiptDate"), "receiptDate");
		projList.add(Projections.property("interestOnRebateInvoice"), "interestOnRebateInvoice");
		projList.add(Projections.property("interestOnServiceTax"), "interestOnServiceTax");
		projList.add(Projections.property("tdsAmount"), "tdsAmount");
		
		criteria.setProjection(Projections.distinct(projList));

		if(rebateSearchCriteria.getTransactionDate()!=null){
			criteria.add(Restrictions.eq("this.transactionDate",rebateSearchCriteria.getTransactionDate()));
		}

		
		if(rebateSearchCriteria.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("this.transactionDate",rebateSearchCriteria.getTransactionDateFrom()));
		}
		if(rebateSearchCriteria.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("this.transactionDate",rebateSearchCriteria.getTransactionDateTo()));
		}
		if(rebateSearchCriteria.getVendorCode()!=null && !rebateSearchCriteria.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("this.vendorCode",rebateSearchCriteria.getVendorCode()));
		}
		if(rebateSearchCriteria.getItemCode()!=null && !rebateSearchCriteria.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("this.itemCode",rebateSearchCriteria.getItemCode()));
		}
		
		
		criteria.addOrder(Order.asc("transactionDate"));
		
		criteria.setResultTransformer(Transformers.aliasToBean(RebateForm.class));
		

		return criteria.list();
	}

	
	@Override	
	public List<RebateForm> listRebateIdsByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub

		Session session = null;
		if(null != sessionFactory) {
			session= sessionFactory.getCurrentSession();
		} else {
			session = HibernateUtil.getSessionFactory().openSession();
		}
				
		Criteria criteria = session.createCriteria(RebateForm.class);
		
		if(rebateSearchCriteria.getTransactionDate()!=null){
			criteria.add(Restrictions.eq("transactionDate",rebateSearchCriteria.getTransactionDate()));
		}
		if(rebateSearchCriteria.getVendorCode()!=null){
			criteria.add(Restrictions.eq("vendorCode",rebateSearchCriteria.getVendorCode()));
		}
		if(rebateSearchCriteria.getItemCode()!=null){
			criteria.add(Restrictions.eq("itemCode",rebateSearchCriteria.getItemCode()));
		}
		
		return criteria.list();
	}
	@Override
	public List<MisSearchResult> listMisSearchResultByCriteria(MisSearchCriteria misSearchCriteria) {
		// TODO Auto-generated method stub
		
		return null;
	}



	@Override
	public List<RebateForm> listRebateVendorItemByCriteria(RebateSearchCriteria rebateSearchCriteria) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RebateForm.class);
		
		//criteria.createAlias("rebates", "rebates");
		
		
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("vendorCode"), "vendorCode");
		projList.add(Projections.property("itemCode"), "itemCode");
		projList.add(Projections.property("vendorName"), "vendorName");
		projList.add(Projections.property("itemName"), "itemName");
		
		
		criteria.setProjection(Projections.distinct(projList));

		
		if(rebateSearchCriteria.getTransactionDateFrom()!=null){
			criteria.add(Restrictions.ge("this.transactionDate",rebateSearchCriteria.getTransactionDateFrom()));
		}
		if(rebateSearchCriteria.getTransactionDateTo()!=null){
			criteria.add(Restrictions.le("this.transactionDate",rebateSearchCriteria.getTransactionDateTo()));
		}
		if(rebateSearchCriteria.getVendorCode()!=null && !rebateSearchCriteria.getVendorCode().equals("0")){
			criteria.add(Restrictions.eq("this.vendorCode",rebateSearchCriteria.getVendorCode()));
		}
		if(rebateSearchCriteria.getItemCode()!=null && !rebateSearchCriteria.getItemCode().equals("0")){
			criteria.add(Restrictions.eq("this.itemCode",rebateSearchCriteria.getItemCode()));
		}
		
		
		criteria.addOrder(Order.asc("vendorName"));
		
		criteria.setResultTransformer(Transformers.aliasToBean(RebateForm.class));
		return criteria.list();
	}

	}

