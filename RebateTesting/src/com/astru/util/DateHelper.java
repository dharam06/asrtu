package com.astru.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {


	String formatDate(Date date){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
         String dateString = sdf.format(date);
         System.out.println("=========="+dateString);
    
		return dateString;
	}

    public static void main(String[] args) {

        try {
            Calendar currentdate = Calendar.getInstance();
            String strdate = null;
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            strdate = formatter.format(currentdate.getTime());
             
            
            
            TimeZone obj = TimeZone.getTimeZone("CST");

            formatter.setTimeZone(obj);
            //System.out.println(strdate);
            //System.out.println(formatter.parse(strdate));
            Date theResult = formatter.parse(strdate);
            
            System.out.println("The India is  :: " +new DateHelper().formatDate(theResult));

            System.out.println("The current time in India is  :: " +currentdate.getTime());

            System.out.println("The date and time in :: "+ obj.getDisplayName() + "is ::" + theResult);
            
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String date = sdf.format(new Date());
            System.out.println("=========="+date);
            
            
        } catch (ParseException e) {
           e.printStackTrace();
        }
    }
}
    
