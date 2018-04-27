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


import com.asrtu.bean.QuarterBean;
import com.asrtu.model.Quarter;
import com.asrtu.service.QuarterService;


@Controller
public class QuarterController {
	
	@Autowired
	private QuarterService quarterService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@RequestMapping(value="/saveQuarter" , method=RequestMethod.POST)
	public ModelAndView saveQuarter(@ModelAttribute("command") QuarterBean quarterBean,BindingResult result ){
		try{
			
			Quarter quarter=prepareModel(quarterBean);
			quarterService.addQuarte(quarter);
			
		}catch(Exception e){
			
		}
		
		return new ModelAndView("quarterEntryForm","message1","Successfull save");
	}
	
	
	@RequestMapping(value = "/Quarter", method = RequestMethod.GET)
	public ModelAndView stuProcess() {
		return new ModelAndView("quarterEntryForm");
	}
	
	@RequestMapping(value="/listQuarter", method = RequestMethod.GET)
	public ModelAndView listQuarterEntry() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quarters", prepareListofBean(quarterService.listQuarter()));
		System.out.println("Print model size "+model.size());
		return new ModelAndView("viewQuarter", model);
	}
	
	@RequestMapping(value = "/deleteQuarter", method = RequestMethod.GET)
	public ModelAndView editRcPeriod(@ModelAttribute("command")  QuarterBean quarterBean,
			BindingResult result) {
		
		System.out.println("delete query fire by  controller");
		quarterService.deleteQuarter(prepareModel1(quarterBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quarter", null);
		model.put("quarters", prepareListofBean(quarterService.listQuarter()));	
		return new ModelAndView("viewQuarter", model);
	}
	
	
	@RequestMapping(value = "/editQuarter", method = RequestMethod.GET)
	public ModelAndView deleteRcPeriod(@ModelAttribute("command")  QuarterBean quarterBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quarter", prepareQuarterBean(quarterService.getQuarter(quarterBean.getSlNo())));
		model.put("quarters", prepareListofBean(quarterService.listQuarter()));
		return new ModelAndView("editRcPeriod", model);
	}
	
	private QuarterBean prepareQuarterBean(Quarter quarter){
		QuarterBean bean = new QuarterBean();
		bean.setSlNo(quarter.getSlNo());
		bean.setQuarter(quarter.getQuarter());
		bean.setqFrom(quarter.getqFrom());
		bean.setQtDate(quarter.getQtDate());
		return bean;
	}
	
	private Quarter prepareModel1(QuarterBean quarterBean){
		Quarter employee = new Quarter();
		employee.setSlNo(quarterBean.getSlNo());
		employee.setQuarter(quarterBean.getQuarter());
		employee.setqFrom(quarterBean.getqFrom());
		employee.setQtDate(quarterBean.getQtDate());
		employee.setSlNo(quarterBean.getSlNo());
		quarterBean.setSlNo(null);
		return employee;
	}
	
	private Quarter prepareModel(QuarterBean quarterBean)throws Exception{
		Quarter employee = new Quarter();
		employee.setSlNo(quarterBean.getSlNo());
		employee.setQuarter(quarterBean.getQuarter());
		employee.setqFrom(quarterBean.getqFrom());
		employee.setQtDate(quarterBean.getQtDate());
		return employee;
	}
	
	private List<QuarterBean> prepareListofBean(List<Quarter> quarter){
		List<QuarterBean> beans = null;
		System.out.print("quarter of size  "+quarter.size());
		if(quarter != null && !quarter.isEmpty()){
			beans = new ArrayList<QuarterBean>();
			QuarterBean bean = null;
			
			for(Quarter  quar: quarter){
				System.out.print("quarter of size  "+quarter);
				
				bean = new QuarterBean();
				
				if(null != quar){
				bean.setSlNo(quar.getSlNo());
				bean.setQuarter(quar.getQuarter());
				bean.setqFrom(quar.getqFrom());
				bean.setQtDate(quar.getQtDate());
				
				bean.setqFromString(formatDate(quar.getqFrom()));
				bean.setQtDateString(formatDate(quar.getQtDate()));
				
				
				beans.add(bean);
				}
				
			}
		}
		System.out.print("List of beans  "+beans.size());
		return beans;
	}
	

	private String formatDate(Date date){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
       String dateString = sdf.format(date);
       System.out.println("=========="+dateString);
  
		return dateString;
	}

}
