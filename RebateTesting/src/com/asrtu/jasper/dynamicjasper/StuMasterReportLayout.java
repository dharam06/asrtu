package com.asrtu.jasper.dynamicjasper;

import java.util.Date;

import ar.com.fdvs.dj.core.DJConstants;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

/**
 * Everything under the package org.krams.tutorial.dynamicjasper are settings imposed by DynamicJasper (not Jasper)
 *<p>
 * Builds the report layout, the template, the design, the pattern or whatever synonym you may want to call it.
 */
public class StuMasterReportLayout {

	/**
	 * Builds the report layout. This doesn't have any data yet. This is your template.
	 * 
	 * @return the layout
	 */
	public DynamicReport buildReportLayout() throws ColumnBuilderException, ClassNotFoundException {
		
		// The column fields must match the name of the  properties in your datasource
		// For example, if in you're datasource, you have a field name firstName, then the column
		// field must have a fieldName as well

		// Create an instance of FastReportBuilder
		System.out.println("create the FastReportBuilde object");
		FastReportBuilder drb = new FastReportBuilder();
		
		// Format when adding columns:
		// Friendly column name,  Field name (case-sensitive), Type, Width of the column
		drb.addColumn("S.No.", "sno",  Integer.class.getName(), 50)
		.addColumn("Name", "name", String.class.getName(), 50)
        .addColumn("Code", "code", String.class.getName(), 50)
        .addColumn("Model Code", "modelCode" , String.class.getName(), 50)
        .addColumn("Model Name", "modelName" , String.class.getName(), 50)
        .addColumn("Division", "division", String.class.getName(), 50)
        .addColumn("Address", "add1" , String.class.getName(), 50)
        .addColumn("Address", "add2", String.class.getName(), 50)
        .addColumn("Address", "add3", String.class.getName(), 50)
        .addColumn("Pincode", "pincode", String.class.getName(), 50)
        .addColumn("Phone No.", "phoneNo", Integer.class.getName(), 50)
        .addColumn("E-mail", "email", String.class.getName(), 50)
        .setPrintColumnNames(true)
        
         // Disables pagination
        .setIgnorePagination(true)
        
        // Experiment with this numbers to see the effect
        .setMargins(0, 0, 0, 0) 
        
        // Set the title shown inside the Excel file
        .setTitle("Stu Master Report") 
        
        // Set the subtitle shown inside the Excel file
        .setSubtitle("This report was generated at " + new Date()) 
        
		// Set to true if you want to constrain your report within the page boundaries
		// For longer reports, set it to false
        .setUseFullPageWidth(true);

		// Set the name of the file
        drb.setReportName("Stu Master Report");
        
     // Create a Hibernate HQL query
       // StringBuilder hqlQuery = new StringBuilder();
      //hqlQuery.append("SELECT p.sno, ");
    //  hqlQuery.append("p.itemGroupCode, ");
     // hqlQuery.append("p.itemGroupName, ");
      //hqlQuery.append("p.maximumPower as maximumPower, ");
      //hqlQuery.append("p.price as price, ");
     // hqlQuery.append("p.efficiency as efficiency ");
     // hqlQuery.append("FROM ItemGroup p");
      String hqlQuery="FROM Stumaster ";
      // Assign the HQL query
        drb.setQuery(hqlQuery.toString(), DJConstants.QUERY_LANGUAGE_HQL);
        

        
        // Build the report layout
        // Note this just the layout. It doesn't have any data yet!
    	System.out.println("create the Dynamic Report object");
        DynamicReport dr = drb.build();
        
        // Return the layout
        return dr;
	}
}
