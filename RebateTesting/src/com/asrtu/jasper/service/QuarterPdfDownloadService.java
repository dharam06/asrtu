package com.asrtu.jasper.service;

import java.io.ByteArrayOutputStream;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.jasper.dynamicjasper.ItemGroupReportLayout;
import com.asrtu.jasper.dynamicjasper.ItemMasterPdfReportLayout;
import com.asrtu.jasper.dynamicjasper.QuarterPdfReportLayout;
import com.asrtu.jasper.dynamicjasper.StuMasterPdfReportLayout;
import com.asrtu.jasper.dynamicjasper.ItemGroupPdfReportLayout;
import com.asrtu.jasper.exporter.Exporter;
import com.asrtu.jasper.exporter.ExporterPdf;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;


/**
 * Service for processing DynamicJasper  reports
 * Issues
 * http://jasperforge.org/plugins/espforum/view.php?group_id=102&forumid=103&topicid=80305
 * http://dynamicjasper.com/forum/viewtopic.php?f=8&t=7248
 */
@Service("quarterPdfDownloadService")
@Transactional
public class QuarterPdfDownloadService {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	/**
	 * Processes the download for Excel format
	 */
	public void downloadXLS(HttpServletResponse response) throws ColumnBuilderException, ClassNotFoundException, JRException {

		logger.debug("Downloading Excel report");
		
		
		
		// Retrieve our data source
		//ItemGroupDAO  datasource = new ItemGroupDAO();
		//JRDataSource ds = datasource.getDataSource();

		// Create our report layout
		// We delegate the reporting layout to a custom ReportLayout instance
		// The ReportLayout is a wrapper class I made. Feel free to remove or modify it
		QuarterPdfReportLayout layout = new QuarterPdfReportLayout();
		DynamicReport dr = layout.buildReportLayout();

		// params is used for passing extra parameters like when passing
		// a custom datasource, such as Hibernate datasource
		// In this application we won't utilize this parameter
		// 2. Add the datasource to a HashMap parameter
		  HashMap params = new HashMap(); 
		  // Here we're adding Hibernate session as the datasource
		  params.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, sessionFactory.getCurrentSession());
		
		// Compile our report layout
		JasperReport jr = DynamicJasperHelper.generateJasperReport(dr,
				new ClassicLayoutManager(), params);

		// Creates the JasperPrint object
		// It needs a JasperReport layout and a datasource
		JasperPrint jp = JasperFillManager.fillReport(jr, params);

		// Create our output byte stream
		// This is the stream where the data will be written
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Export to output stream
		// The data will be exported to the ByteArrayOutputStream baos
		// We delegate the exporting  to a custom Exporter instance
		// The Exporter is a wrapper class I made. Feel free to remove or modify it
		ExporterPdf exporter = new ExporterPdf();
		exporter.export(jp, baos);

		// Set our response properties
		// Here you can declare a custom filename
		String fileName = "QuarterReport.pdf";
		response.setHeader("Content-Disposition", "inline; filename="
				+ fileName);
		// Make sure to set the correct content type
		// Each format has its own content type
		response.setContentType("application/pdf");
		response.setContentLength(baos.size());

		// Write to reponse stream
		writeReportToResponseStream(response, baos);
	}
	
	/**
	 * Writes the report to the output stream
	 */
	private void writeReportToResponseStream(HttpServletResponse response,
			ByteArrayOutputStream baos) {
		
		logger.debug("Writing report to the stream");
		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			baos.writeTo(outputStream);
			// Flush the stream
			outputStream.flush();

		} catch (Exception e) {
			logger.error("Unable to write report to the output stream");
		}
	}

}
