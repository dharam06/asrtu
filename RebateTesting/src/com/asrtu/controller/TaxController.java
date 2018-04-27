package com.asrtu.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.asrtu.bean.TaxEntryBean;

import com.asrtu.model.TaxEntry;

import com.asrtu.service.TaxEntryService;

@Controller
public class TaxController {
	
	@Autowired
	private TaxEntryService taxEntryService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@RequestMapping(value = "/tax", method = RequestMethod.GET)
	public ModelAndView stuProcess() {
		return new ModelAndView("taxEntryForm");
	}
	
	@RequestMapping(value="/saveTax",method=RequestMethod.POST)
	public ModelAndView saveTax(@ModelAttribute("command") TaxEntryBean taxBean,BindingResult result )throws Exception{
		
		TaxEntry tax=prepareModel(taxBean);
		taxEntryService.addTaxEntry(tax);
		return new ModelAndView("taxEntryForm","message1","Successfull Save..");
	}
	
	@RequestMapping(value="/viewTax", method = RequestMethod.GET)
	public ModelAndView listTax() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("taxs",  prepareListofBean(taxEntryService.listTaxEntry()));	
		return new ModelAndView("viewTax", model);
	}
	
	@RequestMapping(value = "/deleteTax", method = RequestMethod.GET)
	public ModelAndView editStuMaster(@ModelAttribute("command")  TaxEntryBean taxBean,
			BindingResult result)throws Exception {
		taxEntryService.deleteTaxEntry(prepareModel(taxBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tax", null);
		model.put("taxs",  prepareListofBean(taxEntryService.listTaxEntry()));
		return new ModelAndView("viewTax", model);
	}
	@RequestMapping(value = "/editTax", method = RequestMethod.GET)
	public ModelAndView deleteStuMaster(@ModelAttribute("command")  TaxEntryBean taxBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tax", prepareTaxBean(taxEntryService.getTaxEntry(taxBean.getSno())));
		model.put("taxs",  prepareListofBean(taxEntryService.listTaxEntry()));
		return new ModelAndView("editTaxEntryForm", model);
	}
	
	private List<TaxEntryBean> prepareListofBean(List<TaxEntry> tax){
		List<TaxEntryBean> beans = null;
		System.out.print("list of tax "+ tax.size());
		if( tax != null && ! tax.isEmpty()){
			beans = new ArrayList<TaxEntryBean>();
			TaxEntryBean bean = null;
			for(TaxEntry test :  tax){
				bean = new TaxEntryBean();
				bean.setSno(test.getSno());
				bean.setTaxPercent(test.getTaxPercent());
				bean.setFromDate(test.getFromDate());
				bean.setToDate(test.getToDate());
				
				bean.setFromDateString(formatDate(test.getFromDate()));
				bean.setToDateString(formatDate(test.getToDate()));
				
				bean.setTax1(test.getTax1());
				bean.setTax2(test.getTax2());
				bean.setTax3(test.getTax3());
				bean.setTax4(test.getTax4());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private TaxEntry prepareModel(TaxEntryBean taxBean)throws Exception{
		TaxEntry tax=new TaxEntry();
		tax.setSno(taxBean.getSno());
		tax.setTaxPercent(taxBean.getTaxPercent());
		tax.setFromDate(taxBean.getFromDate());
		tax.setToDate(taxBean.getToDate());
		
		tax.setTax1(taxBean.getTax1());
		tax.setTax2(taxBean.getTax2());
		tax.setTax3(taxBean.getTax3());
		tax.setTax4(taxBean.getTax4());
		tax.setTaxPercent(taxBean.getTaxPercent());
		
		return tax;
		
	}
	
	private TaxEntryBean prepareTaxBean(TaxEntry test){
		TaxEntryBean bean = new TaxEntryBean();
		bean.setSno(test.getSno());
		bean.setTaxPercent(test.getTaxPercent());
		bean.setFromDate(test.getFromDate());
		bean.setToDate(test.getToDate());
		return bean;
	}

	private String formatDate(Date date){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
       String dateString = sdf.format(date);
       System.out.println("=========="+dateString);
  
		return dateString;
	}
}
