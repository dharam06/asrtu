package com.asrtu.report.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asrtu.bean.ItemGroupBean;
import com.asrtu.jasper.service.ItemGroupDownloadService;
import com.asrtu.jasper.service.ItemGroupPdfDownloadService;
import com.asrtu.model.ItemGroup;
import com.asrtu.service.ItemGroupService;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;

/**
 * Handles and retrieves download request
 */
@Controller
//@RequestMapping("/main")
public class ItemGroupReportController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="downloadService")
	private ItemGroupDownloadService downloadService;
	@Resource(name="pdfDownloadService")
	private ItemGroupPdfDownloadService pdfDownloadService;

	@Autowired
	private ItemGroupService itemGroupService;
	
	
	
	
	
	/**
     * Retrieves the download file
     * 
     * @return
     */
   //@RequestMapping(value = "/download/xls", method = RequestMethod.GET)
    @RequestMapping(value = "/downloadXls", method = RequestMethod.GET)
    public void doSalesReportXLS(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download Excel report");
		
		System.out.println("Received request to download Excel report");
		//List<ItemGroupBean> list = prepareListofBean(itemGroupService.listItmGrop());
		//ItemGroupDAO item=new ItemGroupDAO();
		//item.setBeans(list);
	
		// Call DownloadService to do the actual report processing
		downloadService.downloadXLS(response);
	}
    @RequestMapping(value = "/downloadPdf", method = RequestMethod.GET)
    public void doSalesReportPdf(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download pdf report");
		//List<ItemGroupBean> list = prepareListofBean(itemGroupService.listItmGrop());
		//prepareListofBean(itemGroupService.listItmGrop());
		//ItemGroupDAO item=new ItemGroupDAO();
		//item.setBeans(list);
	
		System.out.println("----------"+itemGroupService.listItmGrop());
		// Call DownloadService to do the actual report processing
		pdfDownloadService.downloadXLS(response);
	}
    
    
public List<ItemGroupBean> prepareListofBean(List<ItemGroup> item){
	List<ItemGroupBean> beans=null;
		System.out.println("Reoort List"+item);
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
		System.out.println("Reoort Bean List"+beans);
		//List<ItemGroupBean> items = prepareListofBean(it.listItmGrop());
		
		return beans;
	}
    
 
    
    

 
	
  
}
