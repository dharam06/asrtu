package com.asrtu.report.controller;

import java.io.IOException
;
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

import com.asrtu.jasper.service.RebateDownloadService;
import com.asrtu.jasper.service.RebatePdfDownloadService;



import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;

/**
 * Handles and retrieves download request
 */
@Controller
//@RequestMapping("/main")
public class RebateReportController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="rebateDownloadService")
	private RebateDownloadService downloadService;
	@Resource(name="rebatePdfDownloadService")
	private RebatePdfDownloadService  pdfDownloadService;

	
	
	
	
	
	
	/**
     * Retrieves the download file
     * 
     * @return
     */
   
    @RequestMapping(value = "/rebateDownloadXls", method = RequestMethod.GET)
    public void doSalesReportXLS(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download Excel report");
		
		System.out.println("Received request to download Excel report");
	
		// Call DownloadService to do the actual report processing
		downloadService.downloadXLS(response);
	}
    @RequestMapping(value = "/rebateDownloadPdf", method = RequestMethod.GET)
    public void doSalesReportPdf(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download pdf report");
	
		// Call DownloadService to do the actual report processing
		pdfDownloadService.downloadXLS(response);
	}
    
      
}
