package com.asrtu.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asrtu.bean.DebitFormBean;

import com.asrtu.bean.ItemPgTabBean;


import com.asrtu.bean.VendorsBean;
import com.asrtu.model.DebitForm;

import com.asrtu.model.ItemPgTab;

import com.asrtu.model.Vendors;
import com.asrtu.service.DebitService;



@Controller
public class DebitController {
	
	@Autowired
	private DebitService debitService;
	
	
	@RequestMapping(value = "/debit", method = RequestMethod.GET)
	public ModelAndView debitProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(debitService.listVendors()));
		model.put("items", prepareListItemPgBean(debitService.listItemPg()));
		return new ModelAndView("debitForm",model);
	}
	
	@RequestMapping(value="/saveDabit",method=RequestMethod.POST)
	public ModelAndView saveTesting(@ModelAttribute("command") DebitFormBean debitFormBean,BindingResult result )throws Exception{
		
		DebitForm debit=prepareModel(debitFormBean);
		debitService.addDebit(debit);
		return new ModelAndView("redirect:/debitForm.html","message1","Successfull Save..");
	}
	
	@RequestMapping(value="/listDebit", method = RequestMethod.GET)
	public ModelAndView listDebitForm() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("debits", prepareListofBean(debitService.listDebit()));
		return new ModelAndView("viewDebit", model);
	}
	
	@RequestMapping(value = "/deleteDebit", method = RequestMethod.GET)
	public ModelAndView editTesting(@ModelAttribute("command")  DebitFormBean debitFormBean,
			BindingResult result)throws Exception {
		debitService.deleteDebit(prepareModel(debitFormBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("debit", null);
		model.put("debits", prepareListofBean(debitService.listDebit()));
		return new ModelAndView("viewDebit", model);
	}
	
	@RequestMapping(value = "/editDebit", method = RequestMethod.GET)
	public ModelAndView deleteTesting(@ModelAttribute("command")  DebitFormBean debitFormBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(debitService.listVendors()));
		model.put("items", prepareListItemPgBean(debitService.listItemPg()));
		model.put("debit", prepareDebitFormBean(debitService.getDebit(debitFormBean.getDebitId())));
		model.put("debits", prepareListofBean(debitService.listDebit()));
		return new ModelAndView("editDebit", model);
	}
	
	
	private List<DebitFormBean> prepareListofBean(List<DebitForm> debitForm){
		List<DebitFormBean> beans = null;
		System.out.print("list of test Charge "+debitForm.size());
		if(debitForm != null && !debitForm.isEmpty()){
			beans = new ArrayList<DebitFormBean>();
			DebitFormBean bean = null;
			for(DebitForm debit : debitForm){
				bean = new DebitFormBean();
				bean.setDebitId(debit.getDebitId());
				bean.setDebitAmount(debit.getDebitAmount());
				bean.setItemCode(debit.getItemCode());
				bean.setItemName(debit.getItemName());
				bean.setRemarks(debit.getRemarks());
				bean.setTransacDate(debit.getTransacDate());
				bean.setVendorId(debit.getVendorId());
				bean.setVendorName(debit.getVendorName());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private DebitForm prepareModel(DebitFormBean debitBean)throws Exception{
		DebitForm debit=new DebitForm();
		debit.setDebitId(debitBean.getDebitId());
		debit.setDebitAmount(debitBean.getDebitAmount());
		debit.setItemCode(debitBean.getItemCode());
		debit.setItemName(debitBean.getItemName());
		debit.setVendorId(debitBean.getVendorId());
		debit.setVendorName(debitBean.getVendorName());
		SimpleDateFormat sdfSource=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MMM-yyyy");
		Date t1	=sdfSource.parse(debitBean.getTransacDate());
		debit.setTransacDate(sdfDestination.format(t1));
		debit.setRemarks(debitBean.getRemarks());
		debit.setDebitId(debitBean.getDebitId());
		debitBean.setDebitId(null);
		return debit;
		
	}
	
	private DebitFormBean prepareDebitFormBean(DebitForm debit){
		DebitFormBean bean = new DebitFormBean();
		bean.setDebitId(debit.getDebitId());
		bean.setDebitAmount(debit.getDebitAmount());
		bean.setItemCode(debit.getItemCode());
		bean.setItemName(debit.getItemName());
		bean.setRemarks(debit.getRemarks());
		bean.setTransacDate(debit.getTransacDate());
		bean.setVendorId(debit.getVendorId());
		bean.setVendorName(debit.getVendorName());
		
		return bean;
	}

	
	private List<VendorsBean> prepareListVendorBean(List<Vendors> vendor){
		List<VendorsBean> beans=null;
		System.out.println("List of Vendor   "+vendor.size());
		if(vendor != null && !vendor.isEmpty() ){
			beans=new ArrayList<VendorsBean>();
			VendorsBean bean = null;
			for(Vendors ven: vendor){
				bean=new VendorsBean();
				bean.setVendorId(ven.getVendorId());
				bean.setVendorName(ven.getVendorName());
				beans.add(bean);
			}
			
		}
		
		return beans;
		
	}
	
	private List<ItemPgTabBean> prepareListItemPgBean(List<ItemPgTab> item){
		List<ItemPgTabBean> beans=null;
		System.out.println("List of item Pg Table   "+item.size());
		if(item != null && !item.isEmpty() ){
			beans=new ArrayList<ItemPgTabBean>();
			ItemPgTabBean bean = null;
			for(ItemPgTab it: item){
				bean=new ItemPgTabBean();
				bean.setItemCode(it.getItemCode());
				bean.setItemName(it.getItemName());
				beans.add(bean);
			}
			
		}
		return beans;
		
		}

}
