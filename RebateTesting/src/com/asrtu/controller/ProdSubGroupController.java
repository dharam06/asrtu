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
import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.ProdSubGroupBean;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.ProdSubGroup;
import com.asrtu.service.ItemGroupService;
import com.asrtu.service.ProdSubGroupService;




@Controller
public class ProdSubGroupController {
	
	@Autowired
	private ProdSubGroupService prodSubGroupService;
	
	
	
	@RequestMapping(value = "/prodSubGroup", method = RequestMethod.GET)
	public ModelAndView stuSubProdGroupMg() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemGroup",  prepareListofBean1(prodSubGroupService.listItemGroup()));
		return new ModelAndView("prodSubGrp",model);
	}
	
	@RequestMapping(value = "/saveProdSubGroup", method = RequestMethod.POST)
	public ModelAndView saveItemGroup(@ModelAttribute("command") ProdSubGroupBean prodSubGroupBean, 
			BindingResult result) {
		ProdSubGroup  group = prepareModel(prodSubGroupBean);
		prodSubGroupService.addProdSubGroup(group);
		return new ModelAndView("redirect:/prodSubGroup.html");
	}
	
	@RequestMapping(value="/viewSubGroup", method = RequestMethod.GET)
	public ModelAndView listSubGroup() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("subGroups",  prepareListofBean(prodSubGroupService.listProdSubGroup()));
		return new ModelAndView("viewProdSubGroup", model);
	}
	
	@RequestMapping(value = "/deleteProdSubGroup", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  ProdSubGroupBean prodSubGroupBean,
			BindingResult result) {
		prodSubGroupService.deleteProdSubGroup(prepareModel(prodSubGroupBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("subGroup", null);
		model.put("subGroups",  prepareListofBean(prodSubGroupService.listProdSubGroup()));
		return new ModelAndView("viewProdSubGroup", model);
	}
	
	@RequestMapping(value = "/editProdSubGroup", method = RequestMethod.GET)
	public ModelAndView deleteItemGroup(@ModelAttribute("command")  ProdSubGroupBean prodSubGroupBean,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("subGroup", preparesubProdGroupBean(prodSubGroupService.getProdSubGroup(prodSubGroupBean.getId())));
		model.put("subGroups",  prepareListofBean(prodSubGroupService.listProdSubGroup()));
		return new ModelAndView("editProdSubGroup", model);
	}
	
	
	private ProdSubGroupBean preparesubProdGroupBean(ProdSubGroup group){
		ProdSubGroupBean bean = new ProdSubGroupBean();
		bean.setId(group.getId());
		bean.setSubGroupCode(group.getSubGroupCode());
		bean.setSubGroupName(group.getSubGroupName());
		bean.setItemGroupCode(group.getItemGroupCode());
		return bean;
	}
	
	private List<ProdSubGroupBean> prepareListofBean(List<ProdSubGroup> subGroup){
		List<ProdSubGroupBean> beans = null;
	
		if(subGroup != null && !subGroup.isEmpty()){
			beans = new ArrayList<ProdSubGroupBean>(); 
			ProdSubGroupBean bean = null;
			for(ProdSubGroup group : subGroup){
				bean = new ProdSubGroupBean();
				bean.setId(group.getId());
				bean.setSubGroupCode(group.getSubGroupCode());
				bean.setSubGroupName(group.getSubGroupName());
				bean.setItemGroupCode(group.getItemGroupCode());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ProdSubGroup prepareModel(ProdSubGroupBean subGroupBean){
		ProdSubGroup  sub = new ProdSubGroup ();
		sub.setId(subGroupBean.getId());
		sub.setItemGroupCode(subGroupBean.getItemGroupCode());
		sub.setSubGroupCode(subGroupBean.getSubGroupCode());
		sub.setSubGroupName(subGroupBean.getSubGroupName());
		return sub;
	}
	
	private List<ItemPgTabBean> prepareListofBean1(List<ItemPgTab> item){
		List<ItemPgTabBean> beans = null;
		System.out.println("List of Item group   "+item);
		if(item != null && !item.isEmpty()){
			beans = new ArrayList<ItemPgTabBean>(); 
			ItemPgTabBean bean = null;
			for(ItemPgTab it : item){
				bean = new ItemPgTabBean();
				bean.setItemCode(it.getItemCode());;

				bean.setItemName(it.getItemName());
				
				beans.add(bean);
			}
		}
		System.out.println("List of Item group   "+beans);
		
		return beans;
	}

}
