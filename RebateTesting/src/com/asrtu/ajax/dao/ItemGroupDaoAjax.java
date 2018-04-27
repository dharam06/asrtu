package com.asrtu.ajax.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.asrtu.model.ItemGroup;





/**
 * @author ##
 *
 */

public class ItemGroupDaoAjax  {

	
	public ItemGroup  itemGroupName(String itemCode) {
	
		AjaxDao ad=new AjaxDao();
		return ad.getName(itemCode);
	}

	
	
}
