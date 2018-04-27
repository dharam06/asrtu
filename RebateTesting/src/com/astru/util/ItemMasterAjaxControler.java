package com.astru.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.asrtu.bean.ItemGroupBean;
import com.asrtu.model.ItemGroup;
import com.asrtu.service.ItemGroupService;
import com.sun.org.apache.regexp.internal.recompile;

@RemoteProxy(name="dwrItemCode")
public class ItemMasterAjaxControler {
	
	@Autowired
	private ItemGroupService itemGroupService;
	
	@RemoteMethod
	public ItemGroupBean getItemCode(){
		ItemGroupBean item=new ItemGroupBean();
		
		List<ItemGroupBean> list=prepareListofBean(itemGroupService.listItmGrop());
		Iterator<ItemGroupBean> it=list.iterator();
		while(it.hasNext()){
			item=it.next();
		}
		return item;		
	
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
		System.out.println("List Beans of class Ajax Helper  "+beans);
		return beans;
	}
	

}
