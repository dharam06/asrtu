package com.asrtu.jasper.exporter;

import java.io.ByteArrayOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * Everything under the package org.krams.tutorial.jasper are settings imposed by Jasper (not DynamicJasper)
 * <p>
 * An exporter for exporting the report in various formats, i.e Excel, PDF, CSV. Here we declare a PDF exporter
 */
public class ExporterPdf {

	/**
	 * Exports a report to XLS (Excel) format. You can declare another export here, i.e PDF or CSV.
	 * You don't really need to create a separate class or method for the exporter. You can call it
	 * directly within your Service or Controller.
	 * 
	 * @param jp the JasperPrint object
	 * @param baos the ByteArrayOutputStream where the report will be written
	 */
	public void export(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
		// Create a JRXlsExporter instance
		
		JRExporter pexporter = new JRPdfExporter(); 
		// Here we assign the parameters jp and baos to the exporter
	
		pexporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        pexporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        pexporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print()");
        
        // Retrieve the exported report in pdf format
   
        pexporter.exportReport();
	}
}
