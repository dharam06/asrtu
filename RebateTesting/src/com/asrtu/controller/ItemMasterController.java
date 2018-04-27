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
import com.asrtu.bean.ItemMasterBean;
import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemMaster;
import com.asrtu.model.ItemPgTab;
import com.asrtu.service.ItemMasterService;
import com.asrtu.service.ProdSubGroupService;


@Controller
public class ItemMasterController {
	
	@Autowired
	private ItemMasterService itemMasterService;
	
	
	
	@RequestMapping(value = "/itemMaster", method = RequestMethod.GET)
	public ModelAndView itemMasterProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemGroup",  prepareListofBean12(itemMasterService.listItemGroup()));
		
		return new ModelAndView("itemMaster",model);
	}
	
	
	@RequestMapping(value = "/saveItmMaster", method = RequestMethod.POST)
	public ModelAndView saveItemMaster(@ModelAttribute("command") ItemMasterBean itemBean, 
			BindingResult result) {
		ItemMaster  item = prepareModel(itemBean);
		itemMasterService.addItemMaster(item);
		return new ModelAndView("redirect:/itemMaster.html","message1","Successfull Save..");
	}
	
	@RequestMapping(value="/listItemMaster", method = RequestMethod.GET)
	public ModelAndView listItemMaster() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemMasters",  prepareListofBean(itemMasterService.listItemMaster()));
		return new ModelAndView("itemMasterList", model);
	}
	
	@RequestMapping(value = "/deleteItemMaster", method = RequestMethod.GET)
	public ModelAndView editItemMaster(@ModelAttribute("command")  ItemMasterBean itemMasterBean,
			BindingResult result) {
		itemMasterService.deleteItemMaster(prepareModel(itemMasterBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemMaster", null);
		model.put("itemMasters",  prepareListofBean(itemMasterService.listItemMaster()));
		return new ModelAndView("itemMasterList", model);
	}
	
	@RequestMapping(value = "/editItemMaster", method = RequestMethod.GET)
	public ModelAndView deleteItemGroup(@ModelAttribute("command")  ItemMasterBean itemMasterBean,
			BindingResult result) {
		System.out.println("Edit method process.....");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemMaster", prepareItemMasterBean(itemMasterService.getItemMaster(itemMasterBean.getSno())));
		model.put("itemMasters",  prepareListofBean(itemMasterService.listItemMaster()));
		model.put("itemGroup",  prepareListofBean12(itemMasterService.listItemGroup()));
		return new ModelAndView("editItemMaster", model);
	}
	
	private ItemMasterBean prepareItemMasterBean(ItemMaster it){
		ItemMasterBean bean = new ItemMasterBean();
		bean.setItemCode(it.getItemCode());
		bean.setItemName(it.getItemName());
		bean.setItemGroupCode(it.getItemGroupCode());
		bean.setSno(it.getSno());
		bean.setItemGroupName(it.getItemGroupName());
		bean.setQuantity(it.getQuantity());
		bean.setSpecification(it.getSpecification());
		bean.settCharge(it.gettCharge());
		bean.setPartNo(it.getPartNo());
		return bean;
	}
	
	private ItemMaster prepareModel(ItemMasterBean itemBean){
		ItemMaster  item = new ItemMaster ();
		item.setSno(itemBean.getSno());
		item.setItemCode(itemBean.getItemCode());
		item.setItemName(itemBean.getItemName());
		item.setItemGroupCode(itemBean.getItemGroupCode());
		item.setItemGroupName(itemBean.getItemGroupName());
		item.setSpecification(itemBean.getSpecification());
		item.setQuantity(itemBean.getQuantity());
		item.settCharge(itemBean.gettCharge());
		item.setPartNo(itemBean.getPartNo());
		item.setSno(itemBean.getSno());
		itemBean.setSno(null);
		return item;
	}
	
	
	
	private List<ItemMasterBean> prepareListofBean(List<ItemMaster> item){
		List<ItemMasterBean> beans = null;
	
		if(item != null && !item.isEmpty()){
			beans = new ArrayList<ItemMasterBean>(); 
			ItemMasterBean bean = null;
			for(ItemMaster it : item){
				bean = new ItemMasterBean();
				bean.setItemCode(it.getItemCode());
				bean.setItemName(it.getItemName());
				bean.setItemGroupCode(it.getItemGroupCode());
				bean.setSno(it.getSno());
				bean.setItemGroupName(it.getItemGroupName());
				bean.setQuantity(it.getQuantity());
				bean.setSpecification(it.getSpecification());
				bean.settCharge(it.gettCharge());
				bean.setPartNo(it.getPartNo());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ItemGroupBean> prepareListofBean1(List<ItemGroup> item){
		List<ItemGroupBean> beans = null;
		System.out.println("List of Item group   "+item);
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
		System.out.println("List of Item group   "+beans);
		
		return beans;
	}
	
	private List<ItemPgTabBean> prepareListofBean12(List<ItemPgTab> item){
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
