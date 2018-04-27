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


import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.RcTrcBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.RcTrc;
import com.asrtu.model.Vendors;
import com.asrtu.service.RcTrcService;
import com.astru.util.AjaxGetItem;


@Controller
public class RcTrcController {
	
	@Autowired
	private RcTrcService rcTrcService;
	
	
	@RequestMapping(value = "/rctrc", method = RequestMethod.GET)
	public ModelAndView rcTrcProcess() {
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(rcTrcService.listVendors()));
		model.put("items", prepareListItemPgBean(rcTrcService.listItemPg()));
		return new ModelAndView("rc-trc",model);
	}
	
	@RequestMapping(value="/listRcTrc", method = RequestMethod.GET)
	public ModelAndView listStoForm() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rcTrcs", prepareListofBean(rcTrcService.listRcTrc()));
		return new ModelAndView("viewRcTrc", model);
	}
	
	@RequestMapping(value="/saveRcTrc",method=RequestMethod.POST)
	public ModelAndView saveCirtForm(@ModelAttribute("command") RcTrcBean rcTrcBean,BindingResult result )throws Exception{
		
		RcTrc rcTrc=prepareModel(rcTrcBean);
		rcTrcService.addRcTrc(rcTrc);
		
		return new ModelAndView("redirect:/rctrc.html","message1","Successfull Save..");
	}
	
	@RequestMapping(value = "/deleteRcTrc", method = RequestMethod.GET)
	public ModelAndView editCIRT(@ModelAttribute("command")  RcTrcBean rcTrcBean,
			BindingResult result)throws Exception {
		rcTrcService.deleteRcTrc(prepareModel(rcTrcBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rcTrc", null);
		model.put("rcTrcs", prepareListofBean(rcTrcService.listRcTrc()));
		return new ModelAndView("viewRcTrc", model);
	}
	@RequestMapping(value = "/editRcTrc", method = RequestMethod.GET)
	public ModelAndView deleteCirt(@ModelAttribute("command")  RcTrcBean rcTrcBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(rcTrcService.listVendors()));
		model.put("items", prepareListItemPgBean(rcTrcService.listItemPg()));
		model.put("rcTrc", prepareRctTrcBean(rcTrcService.getRcTrc(rcTrcBean.getSno())));
		model.put("rcTrcs", prepareListofBean(rcTrcService.listRcTrc()));
		return new ModelAndView("editRc-trc", model);
	}
	
	
	private RcTrc prepareModel(RcTrcBean rcTrcBean)throws Exception{
		RcTrc rcTrc=new RcTrc();
		rcTrc.setSno(rcTrcBean.getSno());
	
		
		rcTrc.setVendorId(rcTrcBean.getVendorId());
		rcTrc.setVendorName(getVendorNameById(rcTrcBean.getVendorId()));
		rcTrc.setItemCode(rcTrcBean.getItemCode());
		rcTrc.setItemName(getItemNameById(rcTrcBean.getItemCode()));
		rcTrc.setRemarks((rcTrcBean.getRemarks()));

		
		rcTrc.setStatus(rcTrcBean.getStatus());
		SimpleDateFormat sdfSource=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MMM-yyyy");
		Date t1	=sdfSource.parse(rcTrcBean.getFromDate());
		Date t2=sdfSource.parse(rcTrcBean.getClearDate());
		rcTrc.setFromDate(sdfDestination.format(t1));
		rcTrc.setClearDate(sdfDestination.format(t2));
		
		System.out.println("rcTrcBean :"+rcTrcBean.toString());
		System.out.println("rcTrc :"+rcTrc.toString());
		
		return rcTrc;
		
	}
	
	private RcTrcBean prepareRctTrcBean(RcTrc rc){
		RcTrcBean bean = new RcTrcBean();
		bean.setSno(rc.getSno());
		bean.setVendorId(rc.getVendorId());
		bean.setVendorName(rc.getVendorName());
		bean.setItemCode(rc.getItemCode());
		bean.setItemName(rc.getItemName());
		bean.setStatus(rc.getStatus());
		bean.setFromDate(rc.getFromDate());
		bean.setClearDate(rc.getClearDate());
		return bean;
	}
	
	private List<RcTrcBean> prepareListofBean(List<RcTrc> rcTrc){
		List<RcTrcBean> beans = null;
		System.out.print("list of RCTRC "+rcTrc.size());
		if(rcTrc != null && !rcTrc.isEmpty()){
			beans = new ArrayList<RcTrcBean>();
			RcTrcBean bean = null;
			for(RcTrc rc : rcTrc){
				bean = new RcTrcBean();
				bean.setSno(rc.getSno());
				bean.setVendorId(rc.getVendorId());
				bean.setVendorName(rc.getVendorName());
				bean.setItemCode(rc.getItemCode());
				bean.setItemName(rc.getItemName());
				bean.setStatus(rc.getStatus());
				bean.setFromDate(rc.getFromDate());
				bean.setClearDate(rc.getClearDate());
				bean.setRemarks(rc.getRemarks());
				beans.add(bean);
			}
		}
		return beans;
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
	

}
