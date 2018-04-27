package com.asrtu.controller;


import java.util.ArrayList;
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


import com.asrtu.bean.ItemGroupBean;

import com.asrtu.model.ItemGroup;
import com.asrtu.service.ItemGroupService;




@Controller
public class ItemGroupController {
	
	@Autowired
	private ItemGroupService itemGroupService;
	
	
	
	@RequestMapping(value = "/itemGroup", method = RequestMethod.GET)
	public ModelAndView stuProcess() {
		return new ModelAndView("itemGroup");
	}
	
	@RequestMapping(value = "/saveItmGrop", method = RequestMethod.POST)
	public ModelAndView saveItemGroup(@ModelAttribute("command") ItemGroupBean itemGroupBean, 
			BindingResult result) {
		ItemGroup  item = prepareModel(itemGroupBean);
		itemGroupService.addItmGrop(item);
		return new ModelAndView("itemGroup","message1","Successfull Save..");
	}
	
	@RequestMapping(value="/viewItemGroup", method = RequestMethod.GET)
	public ModelAndView listItemGroup() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemGroups",  prepareListofBean(itemGroupService.listItmGrop()));
		return new ModelAndView("itemGroupList", model);
	}
	
	@RequestMapping(value = "/deleteItemGroup", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  ItemGroupBean itemGroupBean,
			BindingResult result) {
		itemGroupService.deleteItmGrop(prepareModel(itemGroupBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemGroup", null);
		model.put("itemGroups",  prepareListofBean(itemGroupService.listItmGrop()));
		return new ModelAndView("itemGroupList", model);
	}
	
	@RequestMapping(value = "/editItemGroup", method = RequestMethod.GET)
	public ModelAndView deleteItemGroup(@ModelAttribute("command")  ItemGroupBean itemGroupBean,
			BindingResult result) {
		System.out.println("Edit method process.....");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemGroup", prepareItemGroupBean(itemGroupService.getItmGrop(itemGroupBean.getSno())));
		model.put("itemGroups",  prepareListofBean(itemGroupService.listItmGrop()));
		return new ModelAndView("editItemGroup", model);
	}
	
	
	private ItemGroupBean prepareItemGroupBean(ItemGroup it){
		ItemGroupBean bean = new ItemGroupBean();
		bean.setItemGroupCode(it.getItemGroupCode());
		bean.setSno(it.getSno());
		bean.setItemGroupName(it.getItemGroupName());
		return bean;
	}
	
	private List<ItemGroupBean> prepareListofBean(List<ItemGroup> item){
		List<ItemGroupBean> beans = null;
	
		if(item != null && !item.isEmpty()){
			beans = new ArrayList<ItemGroupBean>(); 
			ItemGroupBean bean = null;
			for(ItemGroup it : item){
				bean = new ItemGroupBean();
				bean.setItemGroupCode(it.getItemGroupCode());
				bean.setSno(it.getSno());
				bean.setItemGroupName(it.getItemGroupName());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ItemGroup prepareModel(ItemGroupBean itemBean){
		ItemGroup  item = new ItemGroup ();
		item.setSno(itemBean.getSno());
		item.setItemGroupCode(itemBean.getItemGroupCode());
		item.setItemGroupName(itemBean.getItemGroupName());
		item.setSno(itemBean.getSno());
		itemBean.setSno(null);
		return item;
	}
	

}
