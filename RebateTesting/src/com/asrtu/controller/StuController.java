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

import com.asrtu.bean.StuBean;
import com.asrtu.model.Stumaster;
import com.asrtu.service.StuService;

@Controller
public class StuController {
	
	@Autowired
	private StuService stuService;
	
	@RequestMapping(value="/saveStu",method=RequestMethod.POST)
	public ModelAndView saveStuMaster(@ModelAttribute("command") StuBean stuBean,BindingResult result ) throws Exception {
		System.out.println(stuBean.getSno());
		Stumaster sm=prepareModel(stuBean);
		stuService.addStu(sm);
		return new ModelAndView("stuMasterForm","message1","Successfull Save..");
	}
	
	@RequestMapping(value = "/stu", method = RequestMethod.GET)
	public ModelAndView stuProcess() {
		return new ModelAndView("stuMasterForm");
	}
	
	
	@RequestMapping(value="/viewStu", method = RequestMethod.GET)
	public ModelAndView listStuMaster() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stuMasters",  prepareListofBean(stuService.listStu()));
		
		System.out.println("Value of model "+model);
		return new ModelAndView("viewStuForm", model);
	}
	
	/*
	@RequestMapping(value = "/stu", method = RequestMethod.GET)
	public ModelAndView addStuMaster(@ModelAttribute("command")  StuBean stuBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listStuMaster",  prepareListofBean(stuService.listStu()));
		return new ModelAndView("stuMasterForm", model);
	}
	*/
	
	@RequestMapping(value = "/deleteStu", method = RequestMethod.GET)
	public ModelAndView editStuMaster(@ModelAttribute("command")  StuBean stuBean,
			BindingResult result) throws Exception{
		stuService.deleteStu(prepareModel(stuBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stuMaster", null);
		model.put("stuMasters",  prepareListofBean(stuService.listStu()));
		return new ModelAndView("viewStuForm", model);
	}
	@RequestMapping(value = "/editStu", method = RequestMethod.GET)
	public ModelAndView deleteStuMaster(@ModelAttribute("command")  StuBean stuBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.print("stu "+stuBean.getSno());
		model.put("stuMaster", prepareStuBean(stuService.getStu(stuBean.getSno())));
		model.put("stuMasters",  prepareListofBean(stuService.listStu()));
		return new ModelAndView("editStuMaster", model);
	}
	
	private List<StuBean> prepareListofBean(List<Stumaster> stu){
		List<StuBean> beans = null;
		System.out.print("list of stu"+stu.size());
		if(stu != null && !stu.isEmpty()){
			beans = new ArrayList<StuBean>();
			StuBean bean = null;
			for(Stumaster st : stu){
				bean = new StuBean();
				bean.setSno(st.getSno());
				bean.setName(st.getName());
				bean.setCode(st.getCode());
				bean.setModelCode(st.getModelCode());
				bean.setModelName(st.getModelName());
				bean.setDivision(st.getDivision());
				bean.setAdd1(st.getAdd1());
				bean.setAdd2(st.getAdd2());
				bean.setAdd3(st.getAdd3());
				bean.setPincode(st.getPincode());
				bean.setPhoneNo(st.getPhoneNo());
				bean.setEmail(st.getEmail());
				
				bean.setRemarks(st.getRemarks());
				bean.setFromDate(st.getFromDate());
				bean.setToDate(st.getToDate());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Stumaster prepareModel(StuBean stuBean) throws Exception{
		Stumaster sm=new Stumaster();
		sm.setSno(stuBean.getSno());
		sm.setName(stuBean.getName());
		sm.setCode(stuBean.getCode());
		sm.setModelCode(stuBean.getModelCode());
		sm.setModelName(stuBean.getModelName());
		sm.setDivision(stuBean.getDivision());
		sm.setAdd1(stuBean.getAdd1());
		sm.setAdd2(stuBean.getAdd2());
		sm.setAdd3(stuBean.getAdd3());
		sm.setPincode(stuBean.getPincode());
		sm.setPhoneNo(stuBean.getPhoneNo());
		sm.setEmail(stuBean.getEmail());
		sm.setSno(stuBean.getSno());
		
		SimpleDateFormat sdfSource=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MMM-yyyy");
		Date t1	=sdfSource.parse(stuBean.getFromDate());
		Date t2=sdfSource.parse(stuBean.getToDate());
		sm.setFromDate(sdfDestination.format(t1));
		sm.setToDate(sdfDestination.format(t2));
		
		sm.setRemarks(stuBean.getRemarks());
	
		stuBean.setSno(null);
		return sm;
		
	}
	
	private StuBean prepareStuBean(Stumaster stu){
		StuBean bean = new StuBean();
		bean.setSno(stu.getSno());
		bean.setName(stu.getName());
		bean.setCode(stu.getCode());
		bean.setModelCode(stu.getModelCode());
		bean.setModelName(stu.getModelName());
		bean.setDivision(stu.getDivision());
		bean.setAdd1(stu.getAdd1());
		bean.setAdd2(stu.getAdd2());
		bean.setAdd3(stu.getAdd3());
		bean.setPincode(stu.getPincode());
		bean.setPhoneNo(stu.getPhoneNo());
		bean.setEmail(stu.getEmail());
		return bean;
	}


}
