package com.asrtu.report.controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.asrtu.jasper.service.RcTrcDownloadService;
import com.asrtu.jasper.service.RcTrcPdfDownloadService;


import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;

/**
 * Handles and retrieves download request
 */
@Controller
//@RequestMapping("/main")
public class RcTrcReportController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="rcTrcDownloadService")
	private RcTrcDownloadService downloadService;
	@Resource(name="rcTrcPdfDownloadService")
	private RcTrcPdfDownloadService  pdfDownloadService;

	
	
	
	
	
	
	/**
     * Retrieves the download file
     * 
     * @return
     */
   
    @RequestMapping(value = "/rcTrcDownloadXls", method = RequestMethod.GET)
    public void doSalesReportXLS(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download Excel report");
		
		System.out.println("Received request to download Excel report");
	
		// Call DownloadService to do the actual report processing
		downloadService.downloadXLS(response);
	}
    @RequestMapping(value = "/rcTrcDownloadPdf", method = RequestMethod.GET)
    public void doSalesReportPdf(HttpServletResponse response
    	) throws ServletException, IOException,
		ClassNotFoundException, SQLException, ColumnBuilderException, JRException {
    	
		logger.debug("Received request to download pdf report");
	
		// Call DownloadService to do the actual report processing
		pdfDownloadService.downloadXLS(response);
	}
    
      
}
