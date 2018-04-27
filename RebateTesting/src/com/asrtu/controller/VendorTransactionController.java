package com.asrtu.controller;

import java.text.SimpleDateFormat;

import com.asrtu.service.InvoiceService;
import com.asrtu.service.QuarterService;
import com.asrtu.service.StuTransService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asrtu.bean.VendorTransBeanDetail;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.QuarterBean;
import com.asrtu.bean.StuBean;
import com.asrtu.bean.StuTransColBean;
import com.asrtu.bean.StuTransactionBean;
import com.asrtu.bean.TaxEntryBean;
import com.asrtu.bean.VendorTransBean;
import com.asrtu.bean.VendorTransBean2;
import com.asrtu.model.Invoice;
import com.asrtu.model.Quarter;
import com.asrtu.model.StuTransInv1;
import com.asrtu.model.Stumaster;
import com.asrtu.model.VendorTrans;
import com.asrtu.service.VendorTransService;
import com.astru.util.DropDownUtil;

@Controller
public class VendorTransactionController {

	@Autowired
	private VendorTransService vendorTransService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private StuTransService stuTransService;

	@Autowired
	private QuarterService quarterService;
	
	private static List<VendorTransBeanDetail> vendorTransBeanDetailList = new ArrayList<VendorTransBeanDetail>();

	static {
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		vendorTransBeanDetailList.add(new VendorTransBeanDetail("", 0f, 0f));
		
	}

	@RequestMapping(value = "/saveVendTrans", method = RequestMethod.POST)
	public ModelAndView saveVendorTransaction(@ModelAttribute("command") VendorTransBean vendorTransBean, BindingResult result) {

		HashMap<String, Object> model = new HashMap<String, Object>();

		if("refreshPage".equals(vendorTransBean.getPageAction())){
			System.out.println("\n\n refreshPage vendorTran ");
			vendorTransBean.setVendorTransBeanDetail(vendorTransBeanDetailList);
			model.put("invoiceList", prepareInvoiceBeanList(invoiceService.listInvoices()));
			model.put("invoiceDetail", prepareInvoiceBean(invoiceService.getInvoice(vendorTransBean.getAsrtuInvoiceNumber()), vendorTransBean));
			model.put("vendorTransactions", vendorTransBean);
			model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));

			return new ModelAndView("vendorTransDetail", model);
		} else{
			
			prepareInvoiceBean(invoiceService.getInvoice(vendorTransBean.getAsrtuInvoiceNumber()), vendorTransBean);
			List<VendorTransBeanDetail> vendorTransBeanList = vendorTransBean.getVendorTransBeanDetail();
			if (null != vendorTransBeanList && vendorTransBeanList.size() > 0) {
				VendorTransactionController.vendorTransBeanDetailList = vendorTransBeanList;
				for (VendorTransBeanDetail vendorTransBeanDetail : vendorTransBeanList) {
					if(vendorTransBeanDetail.getStuCode()!=null && vendorTransBeanDetail.getStuCode().trim() !=""){
						VendorTrans vendor = prepareModel(vendorTransBean,vendorTransBeanDetail);
						vendorTransService.addVenTrans(vendor);
					}
				}
			}
			return new ModelAndView("vendorTransDetail", "message1", "Successfull save");
		}
	}

	@RequestMapping(value = "/vendTran", method = RequestMethod.GET)
	public ModelAndView venTransacProcess() {

		System.out.println("\n\n vendorTran ");

		VendorTransBean vendorTransBean = new VendorTransBean();
		vendorTransBean.setVendorTransBeanDetail(vendorTransBeanDetailList);
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("vendorTransactions", vendorTransBean);
		// model.put("quarter",
		// prepareListofQuarterBean(stuTransService.listQuarter()));

		model.put("invoiceList", prepareInvoiceBeanList(invoiceService.listInvoices()));
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));

		System.out.println("\n\n prepareInvoiceBeanList(invoiceService.listInvoices()) "
				+ prepareInvoiceBeanList(invoiceService.listInvoices()).toString());

			return new ModelAndView("vendorTransDetail", model);
	}

	@RequestMapping(value = "/vendTranForInvoice", method = RequestMethod.GET)
	public ModelAndView venTransacForInvoiceProcess() {

		HashMap<String, Object> model = new HashMap<String, Object>();

		System.out.println("\n\n vendTranForInvoice ");

		VendorTransBean vendorTransBean = new VendorTransBean();
		vendorTransBean.setVendorTransBeanDetail(vendorTransBeanDetailList);
		model.put("vendorTransactions", vendorTransBean);
		model.put("invoiceList", prepareInvoiceBeanList(invoiceService.listInvoices()));
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));

		return new ModelAndView("vendorTransDetail", model);
	}

	@RequestMapping(value = "/viewVendTr", method = RequestMethod.GET)
	public ModelAndView listVendorTrans(@ModelAttribute("command") VendorTransBean venTransBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListOfBean(vendorTransService.listVendorTrn()));
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));

		return new ModelAndView("viewVendorTr", model);
	}

	
	
	@RequestMapping(value = "/deleteVendorTrn", method = RequestMethod.GET)
	public ModelAndView deleteVendorTransaction(@ModelAttribute("command") VendorTransBean venTransBean, BindingResult result)
			throws Exception {

		VendorTransBeanDetail vendorTransBeanDetail = (VendorTransBeanDetail) venTransBean.getVendorTransBeanDetail().get(0);
		vendorTransService.deleteVendorTran(prepareModelToDelete(vendorTransBeanDetail.getSno()));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListOfBean(vendorTransService.listVendorTrn()));
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
		return new ModelAndView("viewVendorTr", model);
	}

	private VendorTrans prepareModel(VendorTransBean vendorTransBean, VendorTransBeanDetail vendorTransBeanDetail) {
		VendorTrans vdr = new VendorTrans();

		try {

			vdr.setAsrtuInvoiceNumber(vendorTransBean.getAsrtuInvoiceNumber());
			vdr.setAsrtuInvoiceDate(vendorTransBean.getAsrtuInvoiceDate());
			vdr.setItemCode(vendorTransBean.getItemCode());
			vdr.setItemName(vendorTransBean.getItemName());
			vdr.setQuarterFromDate(vendorTransBean.getQuarterFromDate());
			vdr.setQuarterToDate(vendorTransBean.getQuarterToDate());
			
			vdr.setQuarter(vendorTransBean.getQuarter());
			
			vdr.setRegularRebate(vendorTransBean.getRegularRebate());
			vdr.setRebateOutstanding(vendorTransBean.getRebateOutstanding());
			vdr.setFirmName(vendorTransBean.getFirmName());
			vdr.setFirmCode(vendorTransBean.getFirmCode());
			vdr.setStuCode(vendorTransBeanDetail.getStuCode());
			vdr.setStuName(new DropDownUtil().getSTUNameBystuID(vendorTransBeanDetail.getStuCode()));
			vdr.setVendorTotalAmount(vendorTransBeanDetail.getVendorTotalAmount());
			vdr.setVendorRebateAmount(vendorTransBeanDetail.getVendorRebateAmount());
			vdr.setInvoiceNumber(vendorTransBeanDetail.getInvoiceNumber());
			vdr.setInvoiceDate(vendorTransBeanDetail.getInvoiceDate());
			vdr.setPurchaseOrderNumber(vendorTransBeanDetail.getPurchaseOrderNumber());
			vdr.setPurchaseOrderDate(vendorTransBeanDetail.getPurchaseOrderDate());
			

		} catch (Exception e) {

		}

		return vdr;

	}

	public VendorTransBean prepareListOfBean(List<VendorTrans> vendor) {

		VendorTransBean vendorTransBean = new VendorTransBean();;
		List<VendorTransBeanDetail> beanDetails = new ArrayList<VendorTransBeanDetail>();

		System.out.println("Size of Vendor List " + vendor.size());
		if (vendor != null && !vendor.isEmpty()) {
			VendorTransBeanDetail beanDetail = null;
			
			for (VendorTrans vendors : vendor) {
				
				if (null != vendors && null != vendorTransBean) {
				
					beanDetail = new VendorTransBeanDetail();
					
					beanDetail.setSno(vendors.getSno());
					beanDetail.setAsrtuInvoiceNumber(vendors.getAsrtuInvoiceNumber());
					
					beanDetail.setAsrtuInvoiceDate(vendors.getAsrtuInvoiceDate());
					if(null != vendors.getAsrtuInvoiceDate()){
						beanDetail.setAsrtuInvoiceDateString(formatDate(vendors.getAsrtuInvoiceDate()));
					}
					
					beanDetail.setFirmCode(vendors.getFirmCode());
					beanDetail.setFirmName(vendors.getFirmName());
					
					beanDetail.setInvoiceDate(vendors.getInvoiceDate());
					if(null != vendors.getInvoiceDate()){
						beanDetail.setInvoiceDateString(formatDate(vendors.getInvoiceDate()));
					}
					
					beanDetail.setInvoiceNumber(vendors.getInvoiceNumber());
					beanDetail.setItemCode(vendors.getItemCode());
					beanDetail.setItemName(vendors.getItemCode());
					
					beanDetail.setPurchaseOrderDate(vendors.getPurchaseOrderDate());
					if(null != vendors.getPurchaseOrderDate()){
						beanDetail.setPurchaseOrderDateString(formatDate(vendors.getPurchaseOrderDate()));
					}
					
					beanDetail.setPurchaseOrderNumber(vendors.getPurchaseOrderNumber());
					beanDetail.setQuarter(vendors.getQuarter());
					
					beanDetail.setQuarterFromDate(vendors.getQuarterFromDate());
					if(null != vendors.getQuarterFromDate()){
						beanDetail.setQuarterFromDateString(formatDate(vendors.getQuarterFromDate()));
					}
					
					beanDetail.setQuarterToDate(vendors.getQuarterToDate());
					if(null != vendors.getQuarterToDate()){
						beanDetail.setQuarterToDateString(formatDate(vendors.getQuarterToDate()));
					}
					
					beanDetail.setRegularRebate(vendors.getRegularRebate());
					beanDetail.setRebateOutstanding(vendors.getRebateOutstanding());
					beanDetail.setStuName(vendors.getStuName());
					beanDetail.setStuCode(vendors.getStuCode());
					beanDetail.setVendorTotalAmount(vendors.getVendorTotalAmount());
					beanDetail.setVendorRebateAmount(vendors.getVendorRebateAmount());

					beanDetails.add(beanDetail);
				}

			}
			vendorTransBean.setVendorTransBeanDetail(beanDetails);
		}
		return vendorTransBean;
	}

	private VendorTrans prepareModelToDelete(Integer sno) {
		VendorTrans vdr = new VendorTrans();

		try {

			vdr.setSno(sno);

		} catch (Exception e) {

		}

		return vdr;

	}

	
	private List<InvoiceBean> prepareInvoiceBeanList(List<Invoice> invoiceList) {
		List<InvoiceBean> beans = null;
		System.out.print("list of Invoice " + invoiceList.size());
		if (invoiceList != null && !invoiceList.isEmpty()) {
			beans = new ArrayList<InvoiceBean>();
			InvoiceBean bean = null;
			for (Invoice invoice : invoiceList) {
				bean = new InvoiceBean();
				bean.setInvoiceNumber(invoice.getInvoiceNumber());
				beans.add(bean);
			}
		}
		return beans;
	}

	private VendorTransBean prepareInvoiceBean(Invoice invoice, VendorTransBean vendorTransBean) {
	
		System.out.println("\n\n invoice"+invoice.toString());
		
		vendorTransBean.setFirmCode(invoice.getVendorCode());
		vendorTransBean.setFirmName(invoice.getFirmName());
		vendorTransBean.setItemCode(invoice.getItemCode());
		vendorTransBean.setItemName(invoice.getItemName());
		vendorTransBean.setAsrtuInvoiceDate(invoice.getInvoiceDate());
		
		if(null != invoice.getInvoiceDate())
		vendorTransBean.setAsrtuInvoiceDateString(formatDate(invoice.getInvoiceDate()));
		
		vendorTransBean.setQuarter(invoice.getQuarter());
		vendorTransBean.setQuarterFromDate(invoice.getQuarterFromDate());
		
		if(null != invoice.getQuarterFromDate())
		vendorTransBean.setQuarterFromDateString(formatDate(invoice.getQuarterFromDate()));
		
		vendorTransBean.setQuarterToDate(invoice.getQuarterToDate());
		
		if(null != invoice.getQuarterToDate())
		vendorTransBean.setQuarterToDateString(formatDate(invoice.getQuarterToDate()));
		
		vendorTransBean.setRegularRebate(invoice.getRegularRebate());
		vendorTransBean.setRebateOutstanding(invoice.getRebateOutstanding());
		System.out.println("\n\n bean"+vendorTransBean.toString());
		return vendorTransBean;
	}
	
	private List<StuBean> prepareListofStuBean(List<Stumaster> stu) {
		List<StuBean> beans = null;
		System.out.println("list of stu" + stu.size());
		if (stu != null && !stu.isEmpty()) {
			beans = new ArrayList<StuBean>();
			StuBean bean = null;
			for (Stumaster st : stu) {
				bean = new StuBean();
				bean.setSno(st.getSno());
				bean.setName(st.getName());
				bean.setCode(st.getCode());
				bean.setModelCode(st.getModelCode());
				bean.setModelName(st.getModelName());
				bean.setDivision(st.getDivision());
				bean.setAdd1(st.getAdd1());
				bean.setAdd2(st.getAdd2());
				bean.setAdd3(st.getAdd3());
				bean.setPincode(st.getPincode());
				bean.setPhoneNo(st.getPhoneNo());
				bean.setEmail(st.getEmail());
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

}
