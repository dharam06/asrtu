package com.asrtu.controller;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.InvoiceSearch;
import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.Vendors;
import com.asrtu.pdfGen.InvoicePDF;
import com.asrtu.service.InvoiceService;
import com.asrtu.service.QuarterService;
import com.asrtu.service.RebateService;
import com.asrtu.service.StuTransService;
import com.asrtu.service.TaxEntryService;
import com.asrtu.service.VendorGstService;
import com.astru.util.DropDownUtil;
import com.asrtu.exception.CustomGenericException;


@Controller
public class InvoiceController {
	

	private static Integer MAX_ROWS = 100;
	private static String GST_IDENTIFIER = "07";
	private static Boolean STATE_GST = false;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private QuarterService quarterService;

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private StuTransService stuTransService;
	
	@Autowired
	private RebateService rebateService;

	@Autowired
	private TaxEntryService taxEntryService;
	
	@Autowired
    ServletContext servletContext; 
	
	@Autowired
	private VendorGstService vendorGstService;
	
	@RequestMapping(value = "/invoiceGeneration", method = RequestMethod.GET)
	public ModelAndView invoiceGenerationProcess() {

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));

		return new ModelAndView("invoice", model);
	}

	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
	public ModelAndView saveInvoice(@ModelAttribute("command") InvoiceBean invoiceBean, BindingResult result) {

		System.out.println("\n\n invoiceBean"+invoiceBean.toString());
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		String saveMessage="";
		try {
			Invoice invoice = prepareModelToSaveInvoice(invoiceBean);
			Integer id = invoiceService.addInvoice(invoice);
			saveMessage = "Invoice is saved successfully for Invoice Number : "+invoice.getAsrtuInvoiceNumber();
		} catch (CustomGenericException e) {

			throw e;

		} catch(Exception e){
			
			throw new CustomGenericException("A1002", "Invoice is not saved. Please contact System Administrator");
			
		}
		
		System.out.println("\n\n successMessage "+saveMessage.toString());
		model.put("successMessage", saveMessage);
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
		return new ModelAndView("invoice", model);

	}

	
	@RequestMapping(value="/viewInvoiceList", method = RequestMethod.GET)
	public ModelAndView listInvoice() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("invoiceList",  prepareInvoiceBeanList(invoiceService.listInvoices()));	
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));

		return new ModelAndView("viewInvoices", model);
	}
	
	
	@RequestMapping(value="/searchInvoice", method = RequestMethod.POST)
	public ModelAndView searchInvoice(@ModelAttribute("command") InvoiceSearch invoiceSearch, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("invoiceList",  prepareInvoiceBeanList(invoiceService.searchInvoices(invoiceSearch)));	
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));

		return new ModelAndView("viewInvoices", model);
	}
	
	@RequestMapping(value = "/deleteInvoice", method = RequestMethod.GET)
	public ModelAndView deleteInvoice(@ModelAttribute("command") InvoiceBean invoiceBean, BindingResult result)
			throws Exception {

		invoiceService.deleteInvoice(prepareModelInvoiceDelete(invoiceBean));

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("invoiceList",  prepareInvoiceBeanList(invoiceService.listInvoices()));	
		return new ModelAndView("viewInvoices", model);

	}
	

	//editInvoice


	@RequestMapping(value = "/editInvoice", method = RequestMethod.GET)
	public ModelAndView editInvoice(@ModelAttribute("command") InvoiceBean invoiceBean, BindingResult result) {

		System.out.println("\n\n editInvoice invoiceBean"+invoiceBean.toString());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
	
		Invoice invoice = invoiceService.getInvoice(invoiceBean.getInvoiceNumber());
		
		model.put("invoice",  prepareInvoiceBean(invoice));	
	
		model.put("items", prepareListItemPgBean(rebateService.getItemGroupByVendorID(invoice.getVendorCode())));

		return new ModelAndView("editinvoice", model);

	}

	@RequestMapping(value = "/printInvoice", method =RequestMethod.GET)
	public void downloadPDF(@ModelAttribute("command") InvoiceBean invoiceBean, HttpServletRequest request, HttpServletResponse response) throws IOException {
 
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	    final String temperotyFilePath = tempDirectory.getAbsolutePath();

	    
		Invoice invoice = invoiceService.getInvoice(invoiceBean.getInvoiceNumber());
		prepareInvoiceBean(invoice);
				
	    String fileName = "Invoice"+invoice.getInvoiceNumber()+".pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);
 
	    try {
 
	        InvoicePDF.createPDF(temperotyFilePath+"\\"+fileName, prepareInvoiceBean(invoice));
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        os.flush();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
 
	}
	
	private List<ItemPgTabBean> prepareListItemPgBean(List<ItemPgTab> item) {
		List<ItemPgTabBean> beans = null;
		System.out.println("List of item Pg Table   " + item.size());
		if (item != null && !item.isEmpty()) {
			beans = new ArrayList<ItemPgTabBean>();
			ItemPgTabBean bean = null;
			for (ItemPgTab it : item) {
				bean = new ItemPgTabBean();
				bean.setItemCode(it.getItemCode());
				bean.setItemName(it.getItemName());
				beans.add(bean);
			}

		}

		return beans;

	}
	private String formatDate(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = sdf.format(date);
		System.out.println("==========" + dateString);

		return dateString;
	}

	private List<VendorsBean> prepareListVendorBean(List<Vendors> vendor) {
		List<VendorsBean> beans = null;
		System.out.println("List of Vendor   " + vendor.size());
		System.out.println("List of Vendor   " + vendor);
		if (vendor != null && !vendor.isEmpty()) {
			beans = new ArrayList<VendorsBean>();
			VendorsBean bean = null;
			for (Vendors ven : vendor) {
				bean = new VendorsBean();
				bean.setVendorId(ven.getVendorId());
				bean.setVendorName(ven.getVendorName());
				beans.add(bean);
			}

		}

		return beans;

	}

	private Invoice prepareModelToSaveInvoice(InvoiceBean invoiceBean) {

		Invoice invoice = new Invoice();
		
		if(null != invoiceBean.getInvoiceNumber()){
			
			if(invoiceBean.getInvoiceNumber() > 0){
				invoice.setInvoiceNumber(invoiceBean.getInvoiceNumber());
				invoice.setAsrtuInvoiceNumber(invoiceBean.getAsrtuInvoiceNumber());
				
			}
			
		}

		invoice.setVendorCode((invoiceBean.getVendorCode()));
		invoice.setFirmName(new DropDownUtil().getVendorNameByVendiorId(invoiceBean.getVendorCode()));
		
		invoice.setInvoiceDate(invoiceBean.getInvoiceDate());
		invoice.setItemCode(invoiceBean.getItemCode());

		invoice.setItemName(new DropDownUtil().getItemNameByItemId(invoiceBean.getItemCode()));

		invoice.setQuarterFromDate(invoiceBean.getQuarterFromDate());
		invoice.setQuarterToDate(invoiceBean.getQuarterToDate());
		
		Quarter quarter = quarterService.getQuarterByDateRange(invoiceBean.getQuarterFromDate(),invoiceBean.getQuarterToDate());
		if(null !=quarter) {
			invoice.setQuarter(quarter.getQuarter());
		} else {
			
			throw new CustomGenericException("A1001", "There is no Quarter defined for selected dates range");
			
		}
		
		invoiceBean.setGstNumber(vendorGstService.getVendorGst(invoiceBean.getGstId()).getGstNumber());
		
		// Get tax components
		
		TaxEntry taxEntry = taxEntryService.getTaxByDate(invoiceBean.getQuarterFromDate(),invoiceBean.getQuarterToDate());
		
		if(invoiceBean.getGstNumber() !=null && "07".equals(invoiceBean.getGstNumber().substring(0, 2)) ){
			
			STATE_GST = true;
		}
		
		if(null != taxEntry){
			
			if(STATE_GST){
				
				//CGST
				invoice.setTax1(getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTax1()));
				//SGST
				invoice.setTax2(getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTax2()));
				
				invoice.setTax3(0f);
				
				invoice.setTaxPercentage1(taxEntry.getTax1());
				invoice.setTaxPercentage2(taxEntry.getTax2());
				
				invoice.setTotalTaxPercentage(taxEntry.getTax1() + taxEntry.getTax2());
			
				
			} else {
				
				//IGST
				invoice.setTax3(getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTax3()));
				invoice.setTaxPercentage3(taxEntry.getTax3());
				invoice.setTotalTaxPercentage(taxEntry.getTax3());
				
				invoice.setTax1(0f);
				invoice.setTax2(0f);
		
				
			}
	
			invoice.setTotalTax(getAmountByPercentage(invoiceBean.getRebateOutstanding(),invoice.getTotalTaxPercentage()));
			
		}
		invoice.setRebateOutstanding(invoiceBean.getRebateOutstanding() + getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTaxPercent()));
		invoice.setRegularRebate(invoiceBean.getRegularRebate());
		invoice.setRebateRemainingOutstanding(invoiceBean.getRebateOutstanding() + getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTaxPercent()));

		invoice.setRebateType(invoiceBean.getRebateType());
		invoice.setAmount(invoiceBean.getRebateOutstanding());
		
		// Set Interest on Service Tax
		
		Float interestOnServiceTax = 0f;
		
		Calendar invoiceDay = Calendar.getInstance();
		invoiceDay.setTime(invoiceBean.getInvoiceDate());
		invoiceDay.set(Calendar.DAY_OF_MONTH, invoiceDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Calendar qrtToDay = Calendar.getInstance();
		if(null != quarter.getQtDate()){
			qrtToDay.setTime(quarter.getQtDate());
		}
		
		invoiceDay.set(Calendar.HOUR_OF_DAY, 0);
		invoiceDay.set(Calendar.MINUTE, 0);
		invoiceDay.set(Calendar.SECOND, 0);
		invoiceDay.set(Calendar.MILLISECOND, 0);

		qrtToDay.set(Calendar.HOUR_OF_DAY, 0);
		qrtToDay.set(Calendar.MINUTE, 0);
		qrtToDay.set(Calendar.SECOND, 0);
		qrtToDay.set(Calendar.MILLISECOND, 0);
		
		long totalDaysForSt = TimeUnit.MILLISECONDS.toDays(
	            Math.abs(qrtToDay.getTimeInMillis() - invoiceDay.getTimeInMillis()));
		
		if(totalDaysForSt > 365){
			//getAmountByPerForDays
			//(totalDaysForSt - 365)*30 + (183*24) + (182*18);
			interestOnServiceTax = getAmountByPerForDays(invoice.getTotalTax(),totalDaysForSt - 365 , 30f) + getAmountByPerForDays(invoice.getTotalTax(), 183 , 24f) + getAmountByPerForDays(invoice.getTotalTax(),182 , 18f);
			
		} else if (totalDaysForSt > 182){
			
			// ((totalDaysForSt - 182)*24) + (182*18);
			interestOnServiceTax = getAmountByPerForDays(invoice.getTotalTax(),totalDaysForSt - 182 , 24f) + getAmountByPerForDays(invoice.getTotalTax(),182 , 18f);

			
		} else {
			
			//totalDaysForSt*18
			interestOnServiceTax =  getAmountByPerForDays(invoice.getTotalTax(),totalDaysForSt , 18f);
		}
		invoice.setInterestOnServiceTax(interestOnServiceTax);
		
		invoice.setGstId(invoiceBean.getGstId());
		invoice.setGstNumber(vendorGstService.getVendorGst(invoiceBean.getGstId()).getGstNumber());
		
		invoice.setRebatePrOutstanding(invoiceBean.getRebateOutstanding());
		invoice.setRebateTaxOutstanding( getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTaxPercent()));
		invoice.setRebatePrRemainingOutstanding(invoiceBean.getRebateOutstanding());
		invoice.setRebateTaxRemainingOutstanding( getAmountByPercentage(invoiceBean.getRebateOutstanding(),taxEntry.getTaxPercent()));
		
		return invoice;
	}
	
	private List<InvoiceBean> prepareInvoiceBeanList(List<Invoice> invoiceList) {
		List<InvoiceBean> beans = null;
		System.out.print("list of Invoice " + invoiceList.size());
		if (invoiceList != null && !invoiceList.isEmpty()) {
			beans = new ArrayList<InvoiceBean>();
			InvoiceBean bean = null;
			for (Invoice invoice : invoiceList) {
				bean = new InvoiceBean();

				bean.setFirmName(invoice.getFirmName());
				bean.setInvoiceDate(invoice.getInvoiceDate());
				
				if(null!=invoice.getInvoiceDate()){
					bean.setInvoiceDateString(formatDate(invoice.getInvoiceDate()));
				}
				
				bean.setInvoiceNumber(invoice.getInvoiceNumber());
				bean.setAsrtuInvoiceNumber(invoice.getAsrtuInvoiceNumber());
				bean.setItemCode(invoice.getItemCode());
				bean.setItemName(invoice.getItemName());
				
				bean.setQuarter(invoice.getQuarter());
				
				bean.setQuarterFromDate(invoice.getQuarterFromDate());
				
				
				if(null!=invoice.getQuarterFromDate()){
					bean.setQuarterFromDateString(formatDate(invoice.getQuarterFromDate()));
				}
				
				bean.setQuarterToDate(invoice.getQuarterToDate());
				
				if(null!=invoice.getQuarterToDate()){
					bean.setQuarterToDateString(formatDate(invoice.getQuarterToDate()));
				}
				
				
				bean.setRebateOutstanding(invoice.getRebateOutstanding());
				bean.setRegularRebate(invoice.getRegularRebate());
				bean.setVendorCode(invoice.getVendorCode());
				bean.setRebateType(invoice.getRebateType());
				
				bean.setTax1(invoice.getTax1());
				bean.setTax2(invoice.getTax2());
				bean.setTax3(invoice.getTax3());
				bean.setTax4(invoice.getTax4());
				bean.setTotalTax(invoice.getTotalTax());
				

				bean.setTaxPercentage1(invoice.getTaxPercentage1());
				bean.setTaxPercentage2(invoice.getTaxPercentage2());
				bean.setTaxPercentage3(invoice.getTaxPercentage3());
				bean.setTaxPercentage4(invoice.getTaxPercentage4());
				bean.setTotalTaxPercentage(invoice.getTotalTaxPercentage());
				bean.setAmount(invoice.getAmount());
				
				bean.setGstId(invoice.getGstId());
				bean.setGstNumber(invoice.getGstNumber());
				
				bean.setRebatePrOutstanding(invoice.getRebatePrOutstanding());
				bean.setRebatePrRemainingOutstanding(invoice.getRebatePrRemainingOutstanding());
				bean.setRebateTaxOutstanding(invoice.getRebateTaxOutstanding());
				bean.setRebateTaxRemainingOutstanding(invoice.getRebateTaxRemainingOutstanding());

				beans.add(bean);
			}
		}
		return beans;
	}

	private InvoiceBean prepareInvoiceBean(Invoice invoice) {
			InvoiceBean bean = new InvoiceBean();

				bean.setFirmName(invoice.getFirmName());
				bean.setInvoiceDate(invoice.getInvoiceDate());
				
				if(null!=invoice.getInvoiceDate()){
					bean.setInvoiceDateString(formatDate(invoice.getInvoiceDate()));
				}
				
				bean.setInvoiceNumber(invoice.getInvoiceNumber());
				bean.setAsrtuInvoiceNumber(invoice.getAsrtuInvoiceNumber());
				bean.setItemCode(invoice.getItemCode());
				bean.setItemName(invoice.getItemName());
				
				bean.setQuarter(invoice.getQuarter());
				
				bean.setQuarterFromDate(invoice.getQuarterFromDate());
				
				
			if(null!=invoice.getQuarterFromDate()){
				bean.setQuarterFromDateString(formatDate(invoice.getQuarterFromDate()));
			}
				
				bean.setQuarterToDate(invoice.getQuarterToDate());
				
				if(null!=invoice.getQuarterToDate()){
				bean.setQuarterToDateString(formatDate(invoice.getQuarterToDate()));
				}
				
				
				bean.setRebateOutstanding(invoice.getRebateOutstanding());
				bean.setRegularRebate(invoice.getRegularRebate());
				bean.setVendorCode(invoice.getVendorCode());
				bean.setRebateType(invoice.getRebateType());
				
				bean.setTax1(invoice.getTax1());
				bean.setTax2(invoice.getTax2());
				bean.setTax3(invoice.getTax3());
				bean.setTax4(invoice.getTax4());
				bean.setTotalTax(invoice.getTotalTax());
				
				bean.setTaxPercentage1(invoice.getTaxPercentage1());
				bean.setTaxPercentage2(invoice.getTaxPercentage2());
				bean.setTaxPercentage3(invoice.getTaxPercentage3());
				bean.setTaxPercentage4(invoice.getTaxPercentage4());
				bean.setTotalTaxPercentage(invoice.getTotalTaxPercentage());
				bean.setAmount(invoice.getAmount());


	
				return bean;
	}
		//return 
				


	private Invoice prepareModelInvoiceDelete(InvoiceBean invoiceBean) {

		Invoice invoice = new Invoice();
		
		
		invoice.setInvoiceNumber(invoiceBean.getInvoiceNumber());
		
		return invoice;
	}
	
	private Float getAmountByPercentage(Float amount, Float percentage){
		
		if(amount == null || percentage == null ) {
			return 0f;
		}
		
		else{
			
			return amount*percentage/100;
		}
		
		
	}
	
	private Float getAmountByPerForDays(Float amount, long days, Float percentage){
		
		if(amount == null || percentage == null ) {
			return 0f;
		}
		
		else{
			
			return days*amount*percentage/36000;
		}
		
		
	}
	
	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {
		 
		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
 
			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();
 
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	private Float getInterestRateForSt(long numberOfDays){
		
		Float rate = 0f;
		
		if(numberOfDays > 100 ){
			
		}
				
				
		return rate;
	}
	

	
}
