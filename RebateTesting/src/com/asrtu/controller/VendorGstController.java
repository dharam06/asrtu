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

import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.VendorGst;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.TaxEntry;
import com.asrtu.model.Vendors;

import com.asrtu.service.QuarterService;
import com.asrtu.service.RebateService;
import com.asrtu.service.StuTransService;
import com.asrtu.service.TaxEntryService;
import com.asrtu.service.VendorGstService;
import com.astru.util.DropDownUtil;
import com.asrtu.exception.CustomGenericException;

@Controller
public class VendorGstController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private VendorGstService vendorGstService;
	
	@Autowired
	private StuTransService stuTransService;
	
	@Autowired
    ServletContext servletContext; 
	
	@RequestMapping(value = "/vendorsgst", method = RequestMethod.GET)
	public ModelAndView VendorGstGenerationProcess(@ModelAttribute("command") VendorGst vendorGst) {

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));

		return new ModelAndView("vendorgst", model);
	}

	@RequestMapping(value = "/savevendorgst", method = RequestMethod.POST)
	public ModelAndView saveVendorGst(@ModelAttribute("command") VendorGst vendorGst, BindingResult result) {

		System.out.println("\n\n VendorGst"+vendorGst.toString());
		
		vendorGst.setVendorName(new DropDownUtil().getVendorNameByVendiorId(vendorGst.getVendorId()));
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		String saveMessage="";
		try {
			String id = vendorGstService.addVendorGst(vendorGst);
			saveMessage = "VendorGst is saved successfully for VendorGst Number : "+id;
		} catch (CustomGenericException e) {

			throw e;

		} catch(Exception e){
			
			throw new CustomGenericException("A1002", "VendorGst is not saved. Please contact System Administrator");
			
		}
		
		System.out.println("\n\n successMessage "+saveMessage.toString());
		model.put("successMessage", saveMessage);
		model.put("vendorgstList",  vendorGstService.listVendorGstsByVendor(vendorGst.getVendorId()));	
		model.put("vendorId", vendorGst.getVendorId());
		model.put("vendorType", vendorGst.getVendorType());
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
		return new ModelAndView("vendorgstsearch", model);

	}

	@RequestMapping(value="/viewvendorgstlist", method = RequestMethod.GET)
	public ModelAndView listInvoice(@ModelAttribute("command") VendorGst vendorGst) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("vendorgstList",  vendorGstService.listVendorGstsByVendor(vendorGst.getVendorId()));	
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
		model.put("vendorId", vendorGst.getVendorId());
		

		return new ModelAndView("vendorgstsearch", model);
	}

	@RequestMapping(value = "/deleteVendorGst", method = RequestMethod.GET)
	public ModelAndView deleteVendorGst(@ModelAttribute("command") VendorGst VendorGst, BindingResult result)
			throws Exception {

		vendorGstService.deleteVendorGst(VendorGst);

		HashMap<String, Object> model = new HashMap<String, Object>();
		
		model.put("vendorgstList",  vendorGstService.listVendorGstsByVendor(VendorGst.getVendorId()));	

		
		return new ModelAndView("vendorgstsearch", model);

	}
	

	//editVendorGst


	@RequestMapping(value = "/editVendorGst", method = RequestMethod.GET)
	public ModelAndView editVendorGst(@ModelAttribute("command") VendorGst VendorGst, BindingResult result) {

		System.out.println("\n\n editVendorGst VendorGst"+VendorGst.toString());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
	
		VendorGst vendorGstToEdit = vendorGstService.getVendorGst(VendorGst.getId());
		
		model.put("vendorGstToEdit",  vendorGstToEdit);
		model.put("vendorId",  vendorGstToEdit.getVendorId());
		model.put("vendorType", vendorGstToEdit.getVendorType());		
		return new ModelAndView("vendorgstedit", model);

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

}
