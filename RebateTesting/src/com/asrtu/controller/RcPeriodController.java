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


import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.RcperiodBean;
import com.asrtu.bean.VendorsBean;

import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.Vendors;
import com.asrtu.service.RcPeriodService;
import com.astru.util.AjaxGetItem;



@Controller
public class RcPeriodController {
	
	@Autowired
	private RcPeriodService rcPeriodService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/saveRcPeriod" , method=RequestMethod.POST)
	public ModelAndView saveRCPeriod(@ModelAttribute("command") RcperiodBean rcBean,BindingResult result ){
		String saveMessage="";
		try{
			
			RcPeriod rcPeriod=prepareModel(rcBean);
			Integer id = rcPeriodService.addRcPeriod(rcPeriod);
			saveMessage = "RC Period is saved successfully for Dispatch Number : "+id;
			
		}catch(Exception e){
			
		}
		
		System.out.println("\n\n saveRCPeriod Message"+saveMessage);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(rcPeriodService.listVendors()));
		model.put("items", prepareListItemPgBean(rcPeriodService.listItemPg()));
		model.put("successMessage", saveMessage);
		//return new ModelAndView("rcPeriod",model);
		
		return new ModelAndView("rcPeriod",model);
	}
	
	
	@RequestMapping(value = "/rcPeriod", method = RequestMethod.GET)
	public ModelAndView rcProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(rcPeriodService.listVendors()));
		model.put("items", prepareListItemPgBean(rcPeriodService.listItemPg()));
		return new ModelAndView("rcPeriod",model);
	}
	
	@RequestMapping(value="/viewRC", method = RequestMethod.GET)
	public ModelAndView listRateContract() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rcPeriods", prepareListofBean(rcPeriodService.listRcPeriod()));
		return new ModelAndView("viewRcList", model);
	}
	
	@RequestMapping(value = "/deleteRcp", method = RequestMethod.GET)
	public ModelAndView editRcPeriod(@ModelAttribute("command")  RcperiodBean rcBean,
			BindingResult result) {
		
		System.out.println("delete query fire by  controller");
		rcPeriodService.deleteRcPeriod(prepareModel1(rcBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rcPeriod", null);
		model.put("rcPeriods", prepareListofBean(rcPeriodService.listRcPeriod()));	
		return new ModelAndView("viewRcList", model);
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView updateRcPeriod(@ModelAttribute("command")  RcperiodBean rcpBean,
			BindingResult result) {
		
		return new ModelAndView("viewRcList");
	}
	
	@RequestMapping(value = "/editRcp", method = RequestMethod.GET)
	public ModelAndView deleteRcPeriod(@ModelAttribute("command")  RcperiodBean rcpBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rcp", prepareRcPeriodBean(rcPeriodService.getRcPeriod(rcpBean.getSno())));
		model.put("rcPeriods", prepareListofBean(rcPeriodService.listRcPeriod()));
		model.put("vendor", prepareListVendorBean(rcPeriodService.listVendors()));
		model.put("items", prepareListItemPgBean(rcPeriodService.listItemPg()));
		return new ModelAndView("editRcPeriod", model);
	}
	
	private RcperiodBean prepareRcPeriodBean(RcPeriod rcPeriod){
		RcperiodBean bean = new RcperiodBean();
		
		bean.setSno(rcPeriod.getSno());
		bean.setPgId(rcPeriod.getPgId());
		bean.setMeetingNo(rcPeriod.getMeetingNo());
		bean.setRcFromDate(rcPeriod.getRcFromDate());
		bean.setStatus(rcPeriod.getRcCell());
		bean.setToDate(rcPeriod.getToDate());
		bean.setTransDate(rcPeriod.getTransDate());
		bean.setVendorId(rcPeriod.getVendorId());
		return bean;
	}
	
	private List<RcperiodBean> prepareListofBean(List<RcPeriod> rcPeriod){
		List<RcperiodBean> beans = null;
	
		if(rcPeriod != null && !rcPeriod.isEmpty()){
			beans = new ArrayList<RcperiodBean>();
			RcperiodBean bean = null;
			for(RcPeriod  rcp: rcPeriod){
				bean = new RcperiodBean();
				
				bean.setStatus(rcp.getRcCell());
				bean.setSno(rcp.getSno());
				bean.setVendorId(rcp.getVendorId());
				bean.setVendorName(rcp.getVendorName());
				bean.setPgId(rcp.getPgId());
				bean.setDescription(rcp.getDescription());
				bean.setMeetingNo(rcp.getMeetingNo());
				bean.setRcFromDate(rcp.getRcFromDate());
			    bean.setRcFromDateString(formatDate(rcp.getRcFromDate()));
				bean.setToDate(rcp.getToDate());
				bean.setToDateString(formatDate(rcp.getToDate()));
				bean.setTransDate(rcp.getTransDate());
				bean.setTransDateString(formatDate(rcp.getTransDate()));
				bean.setRcCell(rcp.getRcCell());
				beans.add(bean);
				
			}
		}
		
		return beans;
	}
	
	private RcPeriod prepareModel(RcperiodBean rcBean)throws Exception{
		RcPeriod rc = new RcPeriod();
		
		rc.setSno(rcBean.getSno());
		rc.setVendorId(rcBean.getVendorId());
		
		rc.setVendorName(getVendorNameById(rcBean.getVendorId()));
		rc.setDescription(getItemNameById(rcBean.getItemCode()));
		
		rc.setPgId(rcBean.getItemCode());
		rc.setMeetingNo(rcBean.getMeetingNo());
		rc.setRcCell(rcBean.getRcCell());
		rc.setRcFromDate(rcBean.getRcFromDate());
		
		rc.setToDate(rcBean.getToDate());
		rc.setTransDate(rcBean.getTransDate());
		rc.setSno(rcBean.getSno());
		rcBean.setSno(null);
			return rc;
	}
	
	private RcPeriod prepareModel1(RcperiodBean rcBean){
		RcPeriod rc = new RcPeriod();
		
		rc.setSno(rcBean.getSno());
		rc.setVendorId(rcBean.getVendorId());
		rc.setPgId(rcBean.getPgId());
		rc.setMeetingNo(rcBean.getMeetingNo());
		rc.setRcCell(rcBean.getRcCell());
		rc.setRcFromDate(rcBean.getRcFromDate());
		rc.setToDate(rcBean.getToDate());
		rc.setTransDate(rcBean.getTransDate());
		rc.setSno(rcBean.getSno());
		rcBean.setSno(null);
		return rc;
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
	
	
	private String getVendorNameById(String vendorID){
		AjaxGetItem itemName=new AjaxGetItem();
		return itemName.getVendorName(vendorID);
		
	}
	
	private String getItemNameById(String itemID){
		AjaxGetItem itemName=new AjaxGetItem();
		return itemName.getItemName(itemID);
		
	}

	private String formatDate(Date date){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateString = sdf.format(date);
        System.out.println("=========="+dateString);
   
		return dateString;
	}
}
