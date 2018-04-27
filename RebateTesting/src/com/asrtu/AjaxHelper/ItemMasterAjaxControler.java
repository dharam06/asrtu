package com.asrtu.AjaxHelper;

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
	public String getItemCode(String groupCode){
	
		System.out.print("Execute method from ajax and get item Group Name");
		return itemGroupService.itemGroupName(groupCode);		
	
	}
	
	

}
