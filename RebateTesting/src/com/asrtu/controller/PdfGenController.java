package com.asrtu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import net.sf.jasperreports.engine.JRException;
import org.apache.log4j.Logger;

import com.asrtu.pdfGen.Book;

@Controller
public class PdfGenController {
	


	/**
	 * Handle request to the default page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHome() {
		return "home";
	}

	/**
	 * Handle request to download a PDF document 
	 */

	@RequestMapping(value = "/downloadPDFD", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		// create some sample data
		List<Book> listBooks = new ArrayList<Book>();
		listBooks.add(new Book("Spring in Action", "Craig Walls", "1935182358",
				"June 29th 2011", 31.98F));
		listBooks.add(new Book("Spring in Practice", "Willie Wheeler, Joshua White",
				"1935182056", "May 16th 2013", 31.95F));
		listBooks.add(new Book("Pro Spring 3",
				"Clarence Ho, Rob Harrop", "1430241071", "April 18th 2012", 31.85F));
		listBooks.add(new Book("Spring Integration in Action", "Mark Fisher", "1935182439",
				"September 26th 2012", 28.73F));

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "listBooks", listBooks);
	}
	
	 
}