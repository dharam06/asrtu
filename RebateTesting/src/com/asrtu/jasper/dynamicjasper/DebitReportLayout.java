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
public class DebitReportLayout {

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
		drb.addColumn("Debit Id", "debitId",  Integer.class.getName(), 50)
		.addColumn("Vendor Code", "vendorId", String.class.getName(), 50)
		.addColumn("Vendor Name", "vendorName" , String.class.getName(), 50)
		.addColumn("Item  Code", "itemCode", String.class.getName(), 50)
		.addColumn("Item  Name", "itemName", String.class.getName(), 50)
		.addColumn("Debit Amount", "debitAmount" , Integer.class.getName(), 50)
		.addColumn("Transaction Date", "transacDate", String.class.getName(), 50)
		.addColumn("Remarks", "remarks", String.class.getName(), 50)
        .setPrintColumnNames(true)
        
         // Disables pagination
        .setIgnorePagination(true)
        
        // Experiment with this numbers to see the effect
        .setMargins(0, 0, 0, 0) 
        
        // Set the title shown inside the Excel file
        .setTitle("Debit Report") 
        
        // Set the subtitle shown inside the Excel file
        .setSubtitle("This report was generated at " + new Date()) 
        
		// Set to true if you want to constrain your report within the page boundaries
		// For longer reports, set it to false
        .setUseFullPageWidth(true);

		// Set the name of the file
        drb.setReportName("Debit Report");
        
     // Create a Hibernate HQL query
       // StringBuilder hqlQuery = new StringBuilder();
      //hqlQuery.append("SELECT p.sno, ");
    //  hqlQuery.append("p.itemGroupCode, ");
     // hqlQuery.append("p.itemGroupName, ");
      //hqlQuery.append("p.maximumPower as maximumPower, ");
      //hqlQuery.append("p.price as price, ");
     // hqlQuery.append("p.efficiency as efficiency ");
     // hqlQuery.append("FROM ItemGroup p");
      String hqlQuery="FROM DebitForm";
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
