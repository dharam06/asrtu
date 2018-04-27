package com.asrtu.controller;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.bean.StoOrderFormBean;
import com.asrtu.bean.StuBean;
import com.asrtu.bean.StuSearch;
import com.asrtu.bean.CirtBillBean;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.InvoiceSearch;
import com.asrtu.bean.MisSearchCriteria;
import com.asrtu.bean.MisSearchResult;
import com.asrtu.bean.MisYearlyResult;
import com.asrtu.bean.OpeningBalance;
import com.asrtu.bean.RcperiodBean;
import com.asrtu.bean.RebateFormBean;
import com.asrtu.bean.RebateInvoiceBean;
import com.asrtu.bean.RebateLedgerSearchResult;
import com.asrtu.bean.RebateReconSearchResult;
import com.asrtu.bean.StuTransColBean;
import com.asrtu.bean.StuTransactionBean;
import com.asrtu.bean.TestingChargeBean;
import com.asrtu.bean.TestingSearch;
import com.asrtu.bean.VendorsBean;
import com.asrtu.exception.CustomGenericException;
import com.asrtu.model.CirtBill;
import com.asrtu.model.FinanceYear;
import com.asrtu.model.Invoice;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.RebateForm;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.VendorTrans;
import com.asrtu.model.Vendors;
import com.asrtu.pdfGen.BankDetailStatementPDF;
import com.asrtu.pdfGen.BankStatementPDF;
import com.asrtu.pdfGen.CirtBillReportPdf;
import com.asrtu.pdfGen.IncentiveRebateLedgerPDF;
import com.asrtu.pdfGen.InterestRebateLedgerPDF;
import com.asrtu.pdfGen.InvoicePDF;
import com.asrtu.pdfGen.InvoiceStatementPDF;
import com.asrtu.pdfGen.MisComparativePDF;
import com.asrtu.pdfGen.MisYearlyPDF;
import com.asrtu.pdfGen.NodalOfficerStatementPDF;
import com.asrtu.pdfGen.RebateLedgerPDF;
import com.asrtu.pdfGen.RebateReconcLedgerPDF;
import com.asrtu.pdfGen.StoIssueLettersPdf;
import com.asrtu.pdfGen.InterestServiceTaxLedgerPDF;
import com.asrtu.pdfGen.StoOrderStatementPdf;
import com.asrtu.pdfGen.StuInfoLedgerPDF;
import com.asrtu.pdfGen.TestingChargeStatementPdf;
import com.asrtu.pdfGen.VendorTransLedgerPDF;
import com.asrtu.service.CirtService;
import com.asrtu.service.InvoiceService;
import com.asrtu.service.ItemGroupService;
import com.asrtu.service.QuarterService;
import com.asrtu.service.RcPeriodService;
import com.asrtu.service.RebateService;
import com.asrtu.service.RebateServiceImp;
import com.asrtu.service.StoOrderFormService;
import com.asrtu.service.StuService;
import com.asrtu.service.StuTransService;
import com.asrtu.service.TestingChargeService;
import com.asrtu.service.VendorTransService;
import com.asrtu.service.VendorsService;
import com.astru.util.DropDownUtil;

@Controller
public class ReportsController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private QuarterService quarterService;

	@Autowired
	private ItemGroupService itemGroupService;
	
	@Autowired
	private StuInfoLedgerPDF stuInfoLedgerPDF;

	@Autowired
	private NodalOfficerStatementPDF nodalOfficerStatementPDF;

	@Autowired
	private VendorTransLedgerPDF vendorTransLedgerPDF;
	

	@Autowired
	private VendorTransService vendorTransService;

	@Autowired
	private RcPeriodService rcPeriodService;

	@Autowired
	private TestingChargeService testingChargeService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private StoOrderFormService stoOrderFormService;

	@Autowired
	private CirtService cirtService;
	
	@Autowired
	ServletContext servletContext;

	@Autowired
	private RebateService rebateService;
	
	@Autowired
	private InterestRebateLedgerPDF interestRebateLedgerPDF;

	@Autowired
	private IncentiveRebateLedgerPDF incentiveRebateLedgerPDF;

	@Autowired
	private RebateReconcLedgerPDF rebateReconcLedgerPDF;

	@Autowired
	private StuTransService stuTransService;
	
	@Autowired
	private StuService stuService;
	
	@Autowired
	private VendorsService vendorsService;
	
	

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView reports() {
		return new ModelAndView("reports");
	}
	
	@RequestMapping(value = "/ledgers", method = RequestMethod.GET)
	public ModelAndView ledgers() {
		return new ModelAndView("ledgers");
	}
	
	
	@RequestMapping(value = "/testingreports", method = RequestMethod.GET)
	public ModelAndView testingReports() {
		return new ModelAndView("testingreports");
	}
	
	@RequestMapping(value = "/testingchargereport", method = RequestMethod.GET)
	public ModelAndView testingChargeReport() {
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("testingchargereport", model);
	}
	
	
	
	@RequestMapping(value = "/printtestingcharge", method = RequestMethod.POST)
	public ModelAndView printTestingCharge(@ModelAttribute("command") TestingSearch testingSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		//List<Invoice> invoiceList = invoiceService.searchInvoices(testingSearch);
		
		List<TestingCharge> testingChargeList = testingChargeService.searchTestingCharge(testingSearch);

		if (null != testingChargeList && testingChargeList.size() > 0) {
			try {
				String fileName = "TestingChargeStatement.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				TestingChargeStatementPdf.createPDF(temperotyFilePath + "\\" + fileName,	prepareTestingChargeBeanList(testingChargeList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("testingchargereport", model);
		}
	}


	@RequestMapping(value = "/stoissuereport", method = RequestMethod.GET)
	public ModelAndView stoSssueReport() {
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("stoissuereport", model);
	}
	
	
	
	@RequestMapping(value = "/printstoissuereport", method = RequestMethod.POST)
	public ModelAndView printStoIssueReport(@ModelAttribute("command") TestingSearch testingSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		
		List<StoOrderForm> stoOrderFormList = stoOrderFormService.searchStoOrder(testingSearch);

		if (null != stoOrderFormList && stoOrderFormList.size() > 0) {
			try {
				String fileName = "StoIssueReport.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				StoOrderStatementPdf.createPDF(temperotyFilePath + "\\" + fileName,	prepareStoOrderBeanList(stoOrderFormList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("stoissuereport", model);
		}
	}

	@RequestMapping(value = "/stoletterreport", method = RequestMethod.GET)
	public ModelAndView stoletterreport() {
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("stoletterreport", model);
	}

	@RequestMapping(value = "/printstoletterreport", method = RequestMethod.POST)
	public ModelAndView printStoLetterReport(@ModelAttribute("command") TestingSearch testingSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		
		if(testingSearch.getVendorCode().equalsIgnoreCase("0")){
			throw new CustomGenericException("E1003", "Vendor is empty. Please select valid vendor");
		}
		if(testingSearch.getItemCode().equalsIgnoreCase("0")){
			throw new CustomGenericException("E1004", "Item is empty. Please select valid Item");
		}
		
		List<StoOrderForm> stoOrderFormList = stoOrderFormService.searchStoOrder(testingSearch);

		if (null != stoOrderFormList && stoOrderFormList.size() > 0) {
			try {
				String fileName = "StoIssueLetters.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				StoIssueLettersPdf.createPDF(temperotyFilePath + "\\" + fileName,	prepareStoOrderBeanList(stoOrderFormList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("stoletterreport", model);
		}
	}


	
	

	@RequestMapping(value = "/cirtbillreport", method = RequestMethod.GET)
	public ModelAndView cirtBillReport() {
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("cirtbillreport", model);
	}
	
	
	
	@RequestMapping(value = "/printcirtbillreport", method = RequestMethod.POST)
	public ModelAndView printCirtBillReport(@ModelAttribute("command") TestingSearch testingSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		
		List<CirtBill> cirtBillList = cirtService.searchCirtBill(testingSearch);

		if (null != cirtBillList && cirtBillList.size() > 0) {
			try {
				String fileName = "CirtBillReport.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				CirtBillReportPdf.createPDF(temperotyFilePath + "\\" + fileName,	prepareCirtBeanList(cirtBillList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("cirtbillreport", model);
		}
	}




	
	@RequestMapping(value = "/invoicestatementreport", method = RequestMethod.GET)
	public ModelAndView invoiceStatementReport(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("invoicereport", model);

	}

	
	@RequestMapping(value = "/bankreport", method = RequestMethod.GET)
	public ModelAndView bankReport(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("bankreport", model);

	}
	
	@RequestMapping(value = "/bankdetailreport", method = RequestMethod.GET)
	public ModelAndView bankDetailReport(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("bankdetailreport", model);

	}

	
	@RequestMapping(value = "/printInvoiceStatement", method = RequestMethod.POST)
	public ModelAndView printInvoiceStatement(@ModelAttribute("command") InvoiceSearch invoiceSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		List<Invoice> invoiceList = invoiceService.searchInvoices(invoiceSearch);

		if (null != invoiceList && invoiceList.size() > 0) {
			try {
				String fileName = "InvoiceStatement.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				InvoiceStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	prepareInvoiceBeanList(invoiceService.searchInvoices(invoiceSearch)));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("bankreport", model);
		}
	}

	
	
	@RequestMapping(value = "/printBankStatement", method = RequestMethod.POST)
	public ModelAndView printBankStatement(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

		if (null != rebateList && rebateList.size() > 0) {
			try {
				String fileName = "BankReport.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				BankStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	prepareListofBeanForRebate(rebateList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("bankreport", model);
		}
	}

	@RequestMapping(value = "/printBankDetailStatement", method = RequestMethod.POST)
	public ModelAndView printBankDetailStatement(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

		if (null != rebateList && rebateList.size() > 0) {
			try {
				String fileName = "BankDetailReport.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				BankDetailStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	prepareListofBeanForDetailRebate(rebateList));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("bankreport", model);
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

	private List<RebateFormBean> prepareListofBeanForRebate(List<RebateForm> rebateForm) {
		List<RebateFormBean> beans = null;
		System.out.print("List ====   " + rebateForm.size());
		if (rebateForm != null && !rebateForm.isEmpty()) {
			beans = new ArrayList<RebateFormBean>();
			RebateFormBean bean = null;
			
			
			for (RebateForm reb : rebateForm) {
				bean = new RebateFormBean();
				bean.setAstruBankID(reb.getAstruBankID());
				bean.setAstruBankName(reb.getAstruBankName());
				bean.setBankcharge(reb.getBankcharge());

				bean.setChequeDate(reb.getChequeDate());
				if (null != reb.getChequeDate()) {
					bean.setChequeDateString(formatDate(reb.getChequeDate()));
				}

				bean.setChequeNo(reb.getChequeNo());
				bean.setComments(reb.getComments());
				bean.setDdChequeAmount(reb.getDdChequeAmount());
				bean.setEmdAmount(reb.getEmdAmount());
				bean.setIncAmount(reb.getIncAmount());
				bean.setInterestOnRebate(reb.getInterestOnRebate());
				bean.setInterestOnServiceTax(reb.getInterestOnServiceTax());
				bean.setItemCode(reb.getItemCode());
				bean.setItemName(reb.getItemName());

				bean.setQfdate(reb.getQfdate());
				if (null != reb.getQfdate()) {
					bean.setQfdateString(formatDate(reb.getQfdate()));
				}

				bean.setQtdate(reb.getQtdate());
				if (null != reb.getQtdate()) {
					bean.setQtdateString(formatDate(reb.getQtdate()));
				}

				bean.setReceiptDate(reb.getReceiptDate());
				if (null != reb.getReceiptDate()) {
					bean.setReceiptDateString(formatDate(reb.getReceiptDate()));
				}

				bean.setReceiptNo(reb.getReceiptNo());
				bean.setRemarks(reb.getRemarks());
				bean.setTdsAmount(reb.getTdsAmount());

				bean.setTransactionDate(reb.getTransactionDate());
				if (null != reb.getTransactionDate()) {
					bean.setTransactionDateString(formatDate(reb.getTransactionDate()));
				}

				bean.setTransactionNo(reb.getTransactionNo());
				bean.setInterestOnServiceTax(reb.getInterestOnServiceTax());
				bean.setVendorCode(reb.getVendorCode());
				bean.setVendorName(reb.getVendorName());
				bean.setRebateOutstanding(reb.getRebateOutstanding());
				bean.setInvoicePayment(reb.getInvoicePayment());
				
				
				// get list of receipt No and print
				
				RebateSearchCriteria rsc = new RebateSearchCriteria();
				rsc.setItemCode(reb.getItemCode());
				rsc.setVendorCode(reb.getVendorCode());
				rsc.setTransactionDate(reb.getTransactionDate());
				rsc.setChequeDate(reb.getChequeDate());
				rsc.setChequeNo(reb.getChequeNo());
				List<RebateForm> rblist = rebateService.listRebateIdsByCriteria(rsc);
				
				String rebids = "";
				
				for (RebateForm rid : rblist){
					
					rebids = rebids + rid.getReceiptNo() +"\n ";
					
				}
				bean.setTransactionIds(rebids);
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<RebateFormBean> prepareListofBeanForDetailRebate(List<RebateForm> rebateForm) {
		List<RebateFormBean> beans = null;
		System.out.print("List ====   " + rebateForm.size());
		if (rebateForm != null && !rebateForm.isEmpty()) {
			beans = new ArrayList<RebateFormBean>();
			RebateFormBean bean = null;
			
			
			for (RebateForm reb : rebateForm) {
					
				bean = new RebateFormBean();
				bean.setAstruBankID(reb.getAstruBankID());
				bean.setAstruBankName(reb.getAstruBankName());
				bean.setBankcharge(reb.getBankcharge());

				bean.setChequeDate(reb.getChequeDate());
				if (null != reb.getChequeDate()) {
					bean.setChequeDateString(formatDate(reb.getChequeDate()));
				}

				bean.setChequeNo(reb.getChequeNo());
				bean.setComments(reb.getComments());
				bean.setDdChequeAmount(reb.getDdChequeAmount());
				bean.setEmdAmount(reb.getEmdAmount());
				bean.setIncAmount(reb.getIncAmount());
				bean.setInterestOnRebate(reb.getInterestOnRebate());
				bean.setInterestOnServiceTax(reb.getInterestOnServiceTax());
				bean.setItemCode(reb.getItemCode());
				bean.setItemName(reb.getItemName());

				bean.setQfdate(reb.getQfdate());
				if (null != reb.getQfdate()) {
					bean.setQfdateString(formatDate(reb.getQfdate()));
				}

				bean.setQtdate(reb.getQtdate());
				if (null != reb.getQtdate()) {
					bean.setQtdateString(formatDate(reb.getQtdate()));
				}

				bean.setReceiptDate(reb.getReceiptDate());
				if (null != reb.getReceiptDate()) {
					bean.setReceiptDateString(formatDate(reb.getReceiptDate()));
				}

				bean.setReceiptNo(reb.getReceiptNo());
				bean.setRemarks(reb.getRemarks());
				bean.setTdsAmount(reb.getTdsAmount());

				bean.setTransactionDate(reb.getTransactionDate());
				if (null != reb.getTransactionDate()) {
					bean.setTransactionDateString(formatDate(reb.getTransactionDate()));
				}

				bean.setTransactionNo(reb.getTransactionNo());
				bean.setInterestOnServiceTax(reb.getInterestOnServiceTax());
				bean.setVendorCode(reb.getVendorCode());
				bean.setVendorName(reb.getVendorName());
				bean.setRebateOutstanding(reb.getRebateOutstanding());
				bean.setInvoicePayment(reb.getInvoicePayment());
				
				
				// get list of receipt No and print
				
				RebateSearchCriteria rsc = new RebateSearchCriteria();
				rsc.setItemCode(reb.getItemCode());
				rsc.setVendorCode(reb.getVendorCode());
				rsc.setTransactionDate(reb.getTransactionDate());
				rsc.setChequeDate(reb.getChequeDate());
				rsc.setChequeNo(reb.getChequeNo());
				List<RebateForm> rblist = rebateService.listRebateIdsByCriteria(rsc);
				
				String rebids = "";
				RebateInvoiceBean rebateInvoiceBean = null;
				List<RebateInvoiceBean> rebateInvoiceList = new ArrayList<RebateInvoiceBean>();
				
				Float invoiceTotal = 0f;
				Float interestOnRebate = 0f;
				Float interestOnServiceTax = 0f;
				Float bankcharge = 0f;
				String remarks = "";
				Integer tdsAmount= 0;
				Float incAmount= 0f;
				Integer emdAmount= 0;
				
				//TDS	Incentive	EMD	Total
				

				for (RebateForm rid : rblist){
					
					
					rebids = rebids + rid.getReceiptNo() +"\n ";
					
					if(null !=rid.getInvoicePayment() && rid.getInvoicePayment() > 0){
						rebateInvoiceBean = new RebateInvoiceBean();
						rebateInvoiceBean.setInvoiceNumber(rid.getInvoiceNumber());
						
						rebateInvoiceBean.setInvoicePayment(rid.getInvoicePayment());
						invoiceTotal = invoiceTotal + rid.getInvoicePayment();
						rebateInvoiceList.add(rebateInvoiceBean);
					}
					if(null != rid.getInterestOnServiceTax() && rid.getInterestOnServiceTax() > 0){
						interestOnServiceTax = rid.getInterestOnServiceTax();
					}
					if(null != rid.getInterestOnRebate() && rid.getInterestOnRebate() > 0){
						interestOnRebate = rid.getInterestOnRebate();
					}
					if(null != rid.getBankcharge() && rid.getBankcharge() > 0){
						bankcharge = rid.getBankcharge();
						remarks = rid.getRemarks();
					}
					if(null != rid.getTdsAmount() && rid.getTdsAmount() > 0){
						tdsAmount = rid.getTdsAmount();
					}
					if(null != rid.getIncAmount() && rid.getIncAmount() > 0){
						incAmount = rid.getIncAmount();
					}
					if(null != rid.getEmdAmount() && rid.getEmdAmount() > 0){
						emdAmount = rid.getEmdAmount();
					}
				}
				bean.setTdsAmount(tdsAmount);
				bean.setIncAmount(incAmount);
				bean.setEmdAmount(emdAmount);
				bean.setTotalDeductions(tdsAmount + incAmount + emdAmount);
				bean.setRemarks(remarks);
				bean.setBankcharge(bankcharge);
				bean.setInterestOnRebate(interestOnRebate);
				bean.setInterestOnServiceTax(interestOnServiceTax);
				bean.setAmountPaidTotal(interestOnRebate+interestOnServiceTax+invoiceTotal+bankcharge);
				bean.setInvoiceTotal(invoiceTotal);
				bean.setTransactionIds(rebids);
				bean.setInvoiceList(rebateInvoiceList);
				
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
				bean.setInterestOnServiceTax(invoice.getInterestOnServiceTax());

				beans.add(bean);
			}
		}
		return beans;
	}

	
	
	private List<TestingChargeBean> prepareTestingChargeBeanList(List<TestingCharge> testCharge){
		List<TestingChargeBean> beans = null;
		System.out.print("list of test Charge "+testCharge.size());
		if(testCharge != null && !testCharge.isEmpty()){
			beans = new ArrayList<TestingChargeBean>();
			TestingChargeBean bean = null;
			for(TestingCharge test : testCharge){
				bean = new TestingChargeBean();
				bean.setReceiptNo(test.getReceiptNo());
				
				bean.setReceiptDate(test.getReceiptDate());
				if(null!=test.getReceiptDate()){
					bean.setReceiptDateString(formatDate(test.getReceiptDate()));
				}
				
				bean.setVendorId(test.getVendorId());
				bean.setVendorName(test.getVendorName());
				bean.setItemCode(test.getItemCode());
				bean.setItemName(test.getItemName());
				bean.setTestCharge(test.getTestCharge());
				bean.setChqNo(test.getChqNo());
				System.out.print("Cheque Date from database  "+test.getChqDate());
				
				bean.setChqDate(test.getChqDate());
				if(null!=test.getChqDate()){
					bean.setChqDateString(formatDate(test.getChqDate()));
				}
				
				bean.setBankCode(test.getBankCode());
				bean.setBankName(test.getBankName());
				bean.setRemark(test.getRemark());
				bean.setNetTestCharge(test.getNetTestCharge());
				bean.setServiceTax(test.getServiceTax());
				
				bean.setServiceTaxAmount(test.getServiceTaxAmount());
				
				beans.add(bean);
			}
		}
		return beans;

	}
	
	private List<StoOrderFormBean> prepareStoOrderBeanList(List<StoOrderForm> orderForm){
		List<StoOrderFormBean> beans = null;
		System.out.print("list of sto "+orderForm.size());
		if(orderForm != null && !orderForm.isEmpty()){
			beans = new ArrayList<StoOrderFormBean>();
			StoOrderFormBean bean = null;
			for(StoOrderForm order : orderForm){
				
				order.toString();
				
				bean = new StoOrderFormBean();
				bean.setStoTransId(order.getStoTransId());
				bean.setStoNo(order.getStoNo());
				
				bean.setVendorId(order.getVendorId());
				bean.setVendorName(order.getVendorName());
				bean.setItemCode(order.getItemCode());
				bean.setItemName(order.getItemName());
				bean.setTestCharge(order.getTestCharge());
				
				bean.setTestDate(order.getTestDate());
				if(null != order.getTestDate()){
					bean.setTestDateString(formatDate(order.getTestDate()));
				}
				
				bean.setRemarks(order.getRemarks());
				bean.setQuantity(order.getQuantity());
				bean.setNetAmount(order.getNetAmount());
				
				// Vendor Address
				
				String vendorAddress = vendorsService.getVendors(order.getVendorId()).getAddress1() +" \n"
				+ vendorsService.getVendors(order.getVendorId()).getAddress2() 	+"\n "
				+  vendorsService.getVendors(order.getVendorId()).getAddress3()+"\n Pin Code : "
				+vendorsService.getVendors(order.getVendorId()).getPinCode()+"\n Fax : "
						+vendorsService.getVendors(order.getVendorId()).getFax() ;
				bean.setVendorAddress(vendorAddress.replaceAll("null", ""));
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private List<CirtBillBean> prepareCirtBeanList(List<CirtBill> cirtBill){
		List<CirtBillBean> beans = null;
		System.out.print("list of cirtBill "+cirtBill.size());
		if(cirtBill != null && !cirtBill.isEmpty()){
			beans = new ArrayList<CirtBillBean>();
			CirtBillBean bean = null;
			for(CirtBill cirt : cirtBill){
				bean = new CirtBillBean();
				bean.setTransId(cirt.getTransId());
				bean.setAsrtRefNo(cirt.getAsrtRefNo());
				bean.setBillAmount(cirt.getBillAmount());
				
				bean.setBillDate(cirt.getBillDate());
				if(null!=cirt.getBillDate()){
					bean.setBillDateString(formatDate(cirt.getBillDate()));
				}
				
				bean.setBillNo(cirt.getBillNo());
				bean.setItemCode(cirt.getItemCode());
				bean.setItemName(cirt.getItemName());
				bean.setStoNo(cirt.getStONo());
				bean.setTestCharge(cirt.getTestCharge());
				bean.setVendorId(cirt.getVendorId());
				bean.setVendorName(cirt.getVendorName());
				bean.setRemarks(cirt.getRemarks());
				beans.add(bean);
			}
		}
		return beans;
	}
	
//MIS Reports Starts	
	@RequestMapping(value = "/miscomparativereport", method = RequestMethod.GET)
	public ModelAndView misComparativeReport(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
		return new ModelAndView("miscomparativereport", model);

	}



	@RequestMapping(value = "/printmiscomparativereport", method = RequestMethod.POST)
	public ModelAndView printMisComparativeReport(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		Map<String, Object> model = new HashMap<String, Object>();
		String searchMessage = "";
		
		// get list of vendor item combinations
		//select distinct vendor_name, vendor_code, item_name, item_code  from REB_TRANSACTION_TABLE

		
		RebateSearchCriteria rebateSearchCriteria= new RebateSearchCriteria();
		rebateSearchCriteria.setVendorCode(misSearchCriteria.getVendorCode());
		rebateSearchCriteria.setItemCode(misSearchCriteria.getItemCode());
		rebateSearchCriteria.setTransactionDateFrom(misSearchCriteria.getTransactionDateFrom());
		rebateSearchCriteria.setTransactionDateTo(misSearchCriteria.getTransactionDateTo());

		List<RebateForm> rebateList = rebateService.listRebateVendorItemByCriteria(rebateSearchCriteria);
		
		List<MisSearchResult> misSearchResultList = new ArrayList<MisSearchResult>();
		MisSearchResult misSearchResult = null;
		DropDownUtil dropDownUtil = new DropDownUtil();
		
		
		for(RebateForm rebateForm :rebateList){
			misSearchResult = new MisSearchResult();
			
			misSearchResult.setRebateSearchCriteria(rebateSearchCriteria);
			
			misSearchResult.setVendorName(rebateForm.getVendorName());
			misSearchResult.setVendorCode(rebateForm.getVendorCode());
			misSearchResult.setItemName(rebateForm.getItemName());
			misSearchResult.setItemCode(rebateForm.getItemCode());
			
			// get present rate contract period
			
			RcperiodBean rcperiodBean = new RcperiodBean();
			rcperiodBean.setVendorId(rebateForm.getVendorCode());
			rcperiodBean.setPgId(rebateForm.getItemCode());
			List<RcPeriod> rcPeriodList = rcPeriodService.rcPeriodForVendorItem(rcperiodBean);
			
			RcPeriod rcPeriod = null;
			
			if(null != rcPeriodList && rcPeriodList.size()>0){
				rcPeriod = rcPeriodList.get(0);
				misSearchResult.setRateContractFrom(rcPeriod.getRcFromDate());
				misSearchResult.setRateContractTo(rcPeriod.getToDate());
			}
			
			
			//get cleared up to for Vendor Item - Receipt Invoice latest Qtr date	
			/* select max(i.QTR_TO_DATE) from INVOICE i left outer join REB_TRANSACTION_TABLE r on i.id=r.invoice_no where r.vendor_code='S0280' 
				and r.item_code='08000' order by i.QTR_TO_DATE desc */
			Date clearUpTo = dropDownUtil.getInvoiceClearUpto(rebateForm.getVendorCode(), rebateForm.getItemCode());
			misSearchResult.setClearedUpTo(clearUpTo);
			
			// calculate current period rebate total
			Float currentPeriodTotal = dropDownUtil.getRebateTotal(rebateForm.getVendorCode(), rebateForm.getItemCode(), misSearchCriteria.getTransactionDateFrom(), misSearchCriteria.getTransactionDateTo());
			misSearchResult.setCurrentPeriodRebate(currentPeriodTotal);
			
			
								Calendar calFrom = Calendar.getInstance();
								Date from = misSearchCriteria.getTransactionDateFrom();
								calFrom.add(Calendar.YEAR, -1); // to get previous year add -1
								
								Calendar calTo = Calendar.getInstance();
								Date to = misSearchCriteria.getTransactionDateTo();
								calTo.add(Calendar.YEAR, -1); // to get previous year add -1
								
			
			// calculate last privious rebate total
			Float lastPeriodTotal = dropDownUtil.getRebateTotal(rebateForm.getVendorCode(), rebateForm.getItemCode(), calFrom.getTime(), calTo.getTime());
			misSearchResult.setPreviousPeriodRebate(lastPeriodTotal);
			
			// set difference
			misSearchResult.setRebateDifference(currentPeriodTotal - lastPeriodTotal);
			misSearchResultList.add(misSearchResult);
		}
		
		if (null != rebateList && rebateList.size() > 0) {
			try {
				String fileName = "MisComparativeReport.pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);

				MisComparativePDF.createPDF(temperotyFilePath + "\\" + fileName,	misSearchResultList);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				return null;
			}
		} else {
			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			searchMessage = "Please check search criteria. No result returned.";
			model.put("successMessage", searchMessage);
			return new ModelAndView("miscomparativereport", model);
		}
	}

	//MIS Reports Ends

	//MIS Yearly Reports Starts	
		@RequestMapping(value = "/misyearlyreport", method = RequestMethod.GET)
		public ModelAndView misYearlyReport(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			Map<String, Object> model = new HashMap<String, Object>();

			model.put("financeyears",quarterService.listFinanceYear());
			return new ModelAndView("misyearlyreport", model);

		}

		@RequestMapping(value = "/printmisyearlyreport", method = RequestMethod.POST)
		public ModelAndView printMisYearlyReport(@ModelAttribute("command") RebateSearchCriteria misSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			final String temperotyFilePath = tempDirectory.getAbsolutePath();
			Map<String, Object> model = new HashMap<String, Object>();
			String searchMessage = "";

			MisYearlyResult misYearlyResult = null;
			List<MisYearlyResult> misYearlyResultList = new ArrayList<MisYearlyResult>();
			
			RebateSearchCriteria rebateSearchCriteria = null;
			RebateSearchCriteria rebateSearchPrevCriteria = null;
			
			// get budget
			Float budgetAmount = 0f;
			
			OpeningBalance budget = new DropDownUtil().getBudget();

			if(null != budget){
				budgetAmount = budget.getTotal();
			}
			
			Float budgetCummulative = 0f;
			
			Float actualCummulative = 0f;
			Float actualPrevCummulative = 0f;
			
			// get Monthly Rebate total for Current FY and Previous FY
			
			// Get Months for financial year
			FinanceYear financeYear = quarterService.getFinanceYear(misSearchCriteria.getFinanceYearId());
			Date finYearFrom = financeYear.getFinFrom();
			Date finYearTo =  financeYear.getFinTo();
		
			Calendar calFrom = Calendar.getInstance();
			calFrom.setTime(finYearFrom);
			
			//cal.add(Calendar.YEAR, -1); // to get previous year add -1
			
			Calendar calTo = Calendar.getInstance();
			calTo.setTime(finYearTo);
			
			Calendar temCal = Calendar.getInstance();
			temCal.setTime(finYearFrom);
			
			Calendar temPrevCal = Calendar.getInstance();
			temPrevCal.setTime(finYearFrom);
			temPrevCal.add(Calendar.YEAR, -1);
			
			for (int i = 0; i<12; i++) {
			    
				misYearlyResult = new MisYearlyResult();
				
				misYearlyResult.setFinanceYearName(financeYear.getFinanceYear());
				misYearlyResult.setMonthName(temCal.getDisplayName(temCal.MONTH, Calendar.LONG, Locale.getDefault()));
				
				rebateSearchCriteria = new RebateSearchCriteria();
				rebateSearchPrevCriteria = new RebateSearchCriteria();
				
				rebateSearchCriteria.setTransactionDateFrom(temCal.getTime());
				rebateSearchPrevCriteria.setTransactionDateFrom(temPrevCal.getTime());
	
				temCal.add(Calendar.MONTH, 1);
				temPrevCal.add(Calendar.MONTH, 1);
				
				rebateSearchCriteria.setTransactionDateTo(temCal.getTime());
				rebateSearchPrevCriteria.setTransactionDateTo(temPrevCal.getTime());
				
				
				List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);
				List<RebateForm> rebatePrevList = rebateService.listRebateByCriteria(rebateSearchPrevCriteria);
				
				
				Float rebateTotal = 0f;
				Float rebatePrevTotal = 0f;
				
				for(RebateForm  rebateForm : rebateList){
					
					if(null != rebateForm.getInvoicePayment()){
						rebateTotal = rebateTotal + rebateForm.getInvoicePayment();
					}
					
				}
				
				for(RebateForm  rebatePrevForm : rebatePrevList){
					
					if(null != rebatePrevForm.getInvoicePayment()){
						rebatePrevTotal = rebatePrevTotal + rebatePrevForm.getInvoicePayment();
					}
					
				}
				
				
				misYearlyResult.setCurrentYearRebate(rebateTotal);
				
				budgetCummulative = budgetCummulative + budgetAmount;
				actualCummulative = actualCummulative + rebateTotal;
				actualPrevCummulative = actualPrevCummulative + rebatePrevTotal;
				
				misYearlyResult.setBudgetCummulatitve(budgetCummulative);
				misYearlyResult.setActualCummulatitve(actualCummulative);
				
				misYearlyResult.setPrevCummulatitve(actualPrevCummulative);
				misYearlyResult.setPrevYearRebate(rebatePrevTotal);
		
				misYearlyResult.setCummulativeDifference(actualCummulative - actualPrevCummulative);
				
				misYearlyResultList.add(misYearlyResult);
			}
			
			if (null != misYearlyResultList && misYearlyResultList.size() > 0) {
				try {
					String fileName = "MisYearlyReport.pdf";
					response.setContentType("application/pdf");
					response.setHeader("Content-disposition", "attachment; filename=" + fileName);

					MisYearlyPDF.createPDF(temperotyFilePath + "\\" + fileName,	misYearlyResultList);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
					OutputStream os = response.getOutputStream();
					baos.writeTo(os);
					os.flush();

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					return null;
				}
			} else {
				model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
				searchMessage = "Please check search criteria. No result returned.";
				model.put("successMessage", searchMessage);
				return new ModelAndView("misyearlyreport", model);
			}
		}

		//MIS Yearly Reports Ends
		
		//STU -Vendor Comparative Reports starts

		@RequestMapping(value = "/misstuvendorreport", method = RequestMethod.GET)
		public ModelAndView misStuVendorreport(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			Map<String, Object> model = new HashMap<String, Object>();

			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			return new ModelAndView("misstuvendorreport", model);

		}

		@SuppressWarnings("finally")
		@RequestMapping(value = "/printmisstuvendorreport", method = RequestMethod.POST)
		public ModelAndView misStuVendorReport(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			final String temperotyFilePath = tempDirectory.getAbsolutePath();
			Map<String, Object> model = new HashMap<String, Object>();
			String searchMessage = "";
			List<RebateForm> rebateList = rebateService.listRebate();

			if (null != rebateList && rebateList.size() > 0) {
				try {
					String fileName = "MisStuVendorReport.pdf";
					response.setContentType("application/pdf");
					response.setHeader("Content-disposition", "attachment; filename=" + fileName);

					BankDetailStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	prepareListofBeanForDetailRebate(rebateList));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
					OutputStream os = response.getOutputStream();
					baos.writeTo(os);
					os.flush();

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					return null;
				}
			} else {
				model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
				searchMessage = "Please check search criteria. No result returned.";
				model.put("successMessage", searchMessage);
				return new ModelAndView("bankreport", model);
			}
		}

		//STU - Vendor Comparative Reports Ends
		
		//rebateledger Reports starts

		@RequestMapping(value = "/rebateledger", method = RequestMethod.GET)
		public ModelAndView rebateLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			Map<String, Object> model = new HashMap<String, Object>();

			model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
			model.put("financeyears",quarterService.listFinanceYear());
			
			return new ModelAndView("rebateledger", model);

		}

		@SuppressWarnings("finally")
		@RequestMapping(value = "/printrebateledger", method = RequestMethod.POST)
		public ModelAndView printRebateLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			final String temperotyFilePath = tempDirectory.getAbsolutePath();
			Map<String, Object> model = new HashMap<String, Object>();
			String searchMessage = "";
		
			FinanceYear financeYear = quarterService.getFinanceYear(rebateSearchCriteria.getFinanceYearId());
			rebateSearchCriteria.setTransactionDateFrom(financeYear.getFinFrom());
			rebateSearchCriteria.setTransactionDateTo(financeYear.getFinTo());
			
			// get Opening balance for Vendor Item
			
			OpeningBalance openingBalance = new DropDownUtil().getOpeningBalance(rebateSearchCriteria.getVendorCode(), rebateSearchCriteria.getItemCode());
			
			// Get Invoice Details Vendor Item
			
			InvoiceSearch invoiceSearch = new InvoiceSearch();
			invoiceSearch.setVendorCode(rebateSearchCriteria.getVendorCode());
			invoiceSearch.setItemCode(rebateSearchCriteria.getItemCode());
			invoiceSearch.setTransactionDateFrom(rebateSearchCriteria.getTransactionDateFrom());
			invoiceSearch.setTransactionDateTo(rebateSearchCriteria.getTransactionDateTo());
			
			List<Invoice> invoiceList = invoiceService.searchInvoices(invoiceSearch);
			
			// Get Receipt Details Vendor Item
			List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

			// Get list of transaction dates from Invoice and Rebate
			List<Date> dateToSort = new ArrayList<Date>();

			for(Invoice invoice: invoiceList){
				dateToSort.add(invoice.getInvoiceDate());
			}
			for(RebateForm rebateForm: rebateList){
				dateToSort.add(rebateForm.getReceiptDate());
			}
			
			
			Set<Calendar> sortedList = dateSort(dateToSort);

			// Prepare data for rebate ledger report
			List<RebateLedgerSearchResult> rebateLedgerSearchResultList = new ArrayList<RebateLedgerSearchResult>();
			
			
			RebateLedgerSearchResult rebateLedgerSearchResult = null;
			String vendorName = new DropDownUtil().getVendorNameByVendiorId(rebateSearchCriteria.getVendorCode());
			String itemName = new DropDownUtil().getItemNameByItemId(rebateSearchCriteria.getItemCode());
			//itemGroupService.itemGroupName(rebateSearchCriteria.getItemCode());
			
			for(Calendar date: sortedList){
				rebateLedgerSearchResult = new RebateLedgerSearchResult();
				rebateLedgerSearchResult.setFinacialYear(financeYear.getFinanceYear());
				rebateLedgerSearchResult.setVendorName(vendorName);
				rebateLedgerSearchResult.setItemName(itemName);
				
				rebateLedgerSearchResult.setTransactionDate(date.getTime());
				rebateLedgerSearchResult.setOpeningBalance(openingBalance);
				// Invoice details for date
				InvoiceSearch invoiceSearchDate = new InvoiceSearch();
				invoiceSearchDate.setVendorCode(rebateSearchCriteria.getVendorCode());
				invoiceSearchDate.setItemCode(rebateSearchCriteria.getItemCode());
				invoiceSearchDate.setTransactionDate(date.getTime());
				
				List<Invoice> invoiceListDate = invoiceService.searchInvoices(invoiceSearchDate);
				rebateLedgerSearchResult.setInvoiceList(invoiceListDate);				
				// rebate details for date
				rebateSearchCriteria.setTransactionDate(date.getTime());
				
				List<RebateForm> rebateListDate = rebateService.listRebateByCriteria(rebateSearchCriteria);
				rebateLedgerSearchResult.setRebateForm(rebateListDate);
				
				rebateLedgerSearchResultList.add(rebateLedgerSearchResult);
				
			}
			
			if (null != rebateList && rebateList.size() > 0) {
				try {
					String fileName = "RebateLedger.pdf";
					response.setContentType("application/pdf");
					response.setHeader("Content-disposition", "attachment; filename=" + fileName);

					RebateLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	rebateLedgerSearchResultList);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
					OutputStream os = response.getOutputStream();
					baos.writeTo(os);
					os.flush();

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					return null;
				}
			} else {
				model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
				searchMessage = "Please check search criteria. No result returned.";
				model.put("successMessage", searchMessage);
				return new ModelAndView("rebateledger", model);
			}
		}

		// rebate Ledger Ends
		
		//interestrebateledger Reports starts

				@RequestMapping(value = "/interestrebateledger", method = RequestMethod.GET)
				public ModelAndView interestRebateLedger(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("financeyears",quarterService.listFinanceYear());
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));

					return new ModelAndView("interestrebateledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printinterestrebateledger", method = RequestMethod.POST)
				public ModelAndView printInterestRebateLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					
					String vendorName = new DropDownUtil().getVendorNameByVendiorId(rebateSearchCriteria.getVendorCode());
					String itemName = new DropDownUtil().getItemNameByItemId(rebateSearchCriteria.getItemCode());


					FinanceYear financeYear = quarterService.getFinanceYear(rebateSearchCriteria.getFinanceYearId());
					rebateSearchCriteria.setTransactionDateFrom(financeYear.getFinFrom());
					rebateSearchCriteria.setTransactionDateTo(financeYear.getFinTo());
					rebateSearchCriteria.setVendorName(vendorName);
					rebateSearchCriteria.setItemName(itemName);
					
					// get Opening balance for Vendor Item
					
					OpeningBalance openingBalance = new DropDownUtil().getOpeningBalance(rebateSearchCriteria.getVendorCode(), rebateSearchCriteria.getItemCode());
					
					// Get Receipt Details Vendor Item
					List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

					if (null != rebateList && rebateList.size() > 0) {
						try {
							String fileName = "InterestRebateLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							interestRebateLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	rebateList, openingBalance, rebateSearchCriteria);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("interestrebateledger", model);
					}
				}

				//STU - rebate Ledger Ends

		
		
				//incentiveLedger Reports starts

				@RequestMapping(value = "/incentiveledger", method = RequestMethod.GET)
				public ModelAndView incentiveLedger(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("financeyears",quarterService.listFinanceYear());
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("incentiveledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printincentiveledger", method = RequestMethod.POST)
				public ModelAndView printIncentiveLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";

					String vendorName = new DropDownUtil().getVendorNameByVendiorId(rebateSearchCriteria.getVendorCode());
					String itemName = new DropDownUtil().getItemNameByItemId(rebateSearchCriteria.getItemCode());


					FinanceYear financeYear = quarterService.getFinanceYear(rebateSearchCriteria.getFinanceYearId());
					rebateSearchCriteria.setTransactionDateFrom(financeYear.getFinFrom());
					rebateSearchCriteria.setTransactionDateTo(financeYear.getFinTo());
					rebateSearchCriteria.setVendorName(vendorName);
					rebateSearchCriteria.setItemName(itemName);

					// get Opening balance for Vendor Item
					
					OpeningBalance openingBalance = new DropDownUtil().getOpeningBalance(rebateSearchCriteria.getVendorCode(), rebateSearchCriteria.getItemCode());
					
					// Get Receipt Details Vendor Item
					List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

					if (null != rebateList && rebateList.size() > 0) {
						try {
							String fileName = "incentiveLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							incentiveRebateLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName, rebateList, openingBalance, rebateSearchCriteria	);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("incentiveledger", model);
					}
				}

				//STU - rebate Ledger Ends

				//interestrebateledger Reports starts

				@RequestMapping(value = "/interestservicetaxledger", method = RequestMethod.GET)
				public ModelAndView interestServiceTaxLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("financeyears",quarterService.listFinanceYear());
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("interestservicetaxledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printinterestervicetaxledger", method = RequestMethod.POST)
				public ModelAndView printInterestServiceTaxLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					
					String vendorName = new DropDownUtil().getVendorNameByVendiorId(rebateSearchCriteria.getVendorCode());
					String itemName = new DropDownUtil().getItemNameByItemId(rebateSearchCriteria.getItemCode());

					FinanceYear financeYear = quarterService.getFinanceYear(rebateSearchCriteria.getFinanceYearId());
					rebateSearchCriteria.setTransactionDateFrom(financeYear.getFinFrom());
					rebateSearchCriteria.setTransactionDateTo(financeYear.getFinTo());
					rebateSearchCriteria.setVendorName(vendorName);
					rebateSearchCriteria.setItemName(itemName);
					

					// get Opening balance for Vendor Item
					
					OpeningBalance openingBalance = new DropDownUtil().getOpeningBalance(rebateSearchCriteria.getVendorCode(), rebateSearchCriteria.getItemCode());
					
					// Get Invoice Details Vendor Item
					
					InvoiceSearch invoiceSearch = new InvoiceSearch();
					invoiceSearch.setVendorCode(rebateSearchCriteria.getVendorCode());
					invoiceSearch.setItemCode(rebateSearchCriteria.getItemCode());
					invoiceSearch.setTransactionDateFrom(rebateSearchCriteria.getTransactionDateFrom());
					invoiceSearch.setTransactionDateTo(rebateSearchCriteria.getTransactionDateTo());
					
					List<Invoice> invoiceList = invoiceService.searchInvoices(invoiceSearch);
					
					// Get Receipt Details Vendor Item
					List<RebateForm> rebateList = rebateService.listRebateByCriteria(rebateSearchCriteria);

					// Get list of transaction dates from Invoice and Rebate
					List<Date> dateToSort = new ArrayList<Date>();

					for(Invoice invoice: invoiceList){
						dateToSort.add(invoice.getInvoiceDate());
					}
					for(RebateForm rebateForm: rebateList){
						dateToSort.add(rebateForm.getTransactionDate());
					}
					
					
					Set<Calendar> sortedList = dateSort(dateToSort);

					// Prepare data for rebate ledger report
					List<RebateLedgerSearchResult> rebateLedgerSearchResultList = new ArrayList<RebateLedgerSearchResult>();
					RebateLedgerSearchResult rebateLedgerSearchResult = null;
					for(Calendar date: sortedList){
						
						rebateLedgerSearchResult = new RebateLedgerSearchResult();
						rebateLedgerSearchResult.setTransactionDate(date.getTime());
						rebateLedgerSearchResult.setOpeningBalance(openingBalance);
						// Invoice details for date
						InvoiceSearch invoiceSearchDate = new InvoiceSearch();
						invoiceSearchDate.setVendorCode(rebateSearchCriteria.getVendorCode());
						invoiceSearchDate.setItemCode(rebateSearchCriteria.getItemCode());
						invoiceSearchDate.setTransactionDate(date.getTime());
						
						List<Invoice> invoiceListDate = invoiceService.searchInvoices(invoiceSearchDate);
						rebateLedgerSearchResult.setInvoiceList(invoiceListDate);				
						// rebate details for date
						rebateSearchCriteria.setTransactionDate(date.getTime());
						
						List<RebateForm> rebateListDate = rebateService.listRebateByCriteria(rebateSearchCriteria);
						rebateLedgerSearchResult.setRebateForm(rebateListDate);
						
						rebateLedgerSearchResultList.add(rebateLedgerSearchResult);
					}
					if (null != rebateList && rebateList.size() > 0) {
						try {
							String fileName = "InterestServiceTaxLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);
							
							InterestServiceTaxLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	rebateLedgerSearchResultList, rebateSearchCriteria);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("interestservicetaxledger", model);
					}
				}

				//incentiveLedger Ends
		
				//interestrebateledger Reports starts

				@RequestMapping(value = "/rebatereconciliationledger", method = RequestMethod.GET)
				public ModelAndView rebateReconciliationLedger(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();
					model.put("financeyears",quarterService.listFinanceYear());
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("rebatereconciliationledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printrebatereconciliationledger", method = RequestMethod.POST)
				public ModelAndView printRebateReconciliationLedger(@ModelAttribute("command") RebateSearchCriteria rebateSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					
					String vendorName = new DropDownUtil().getVendorNameByVendiorId(rebateSearchCriteria.getVendorCode());
					String itemName = new DropDownUtil().getItemNameByItemId(rebateSearchCriteria.getItemCode());


					FinanceYear financeYear = quarterService.getFinanceYear(rebateSearchCriteria.getFinanceYearId());
					rebateSearchCriteria.setTransactionDateFrom(financeYear.getFinFrom());
					rebateSearchCriteria.setTransactionDateTo(financeYear.getFinTo());
					rebateSearchCriteria.setVendorName(vendorName);
					rebateSearchCriteria.setItemName(itemName);

					//* STU Nodal Officer - Months coming under the first year of financial year  (All invoice dates between present contract plus three months and last contract)	
					//2016-17	jan-dec 16

					Date fromForStu = rebateSearchCriteria.getTransactionDateFrom();

					// Get date as 1 Jan
					Calendar calFrom = Calendar.getInstance();
					calFrom.setTime(fromForStu);
					calFrom.set(Calendar.DAY_OF_YEAR, 1); 
					
					// Get date as 31 dec
					Calendar calTo = Calendar.getInstance();
					calTo.setTime(fromForStu);
					calTo.set(Calendar.MONTH, 11); // 11 = december
					calTo.set(Calendar.DAY_OF_MONTH, 31); // new years eve
					
					StuSearch stuSearch = new StuSearch();
					stuSearch.setItemCode(rebateSearchCriteria.getItemCode());
					stuSearch.setVendorCode(rebateSearchCriteria.getVendorCode());
					stuSearch.setTransactionDateFrom(calFrom.getTime());
					stuSearch.setTransactionDateTo(calTo.getTime());
					
					List<RebateReconSearchResult> rebateReconSearchResultList= new ArrayList<RebateReconSearchResult>();
					RebateReconSearchResult rebateReconSearchResult;
					
					// Get list of STU
					Set<String> stuSet = new HashSet<String>();
					
					// Get List of STU used for transaction
					for(StuTransaction stuTrans : stuTransService.searchStuTrans(stuSearch)){
						
						stuSet.add(stuTrans.getStuCode());
					}
					for(VendorTrans vTrans : vendorTransService.searchVendorTrans(stuSearch)){
						
						stuSet.add(vTrans.getStuCode());
					}
					
					for(String stu : stuSet){
											
					rebateReconSearchResult = new RebateReconSearchResult();
					rebateReconSearchResult.setStuCode(stu);
					rebateReconSearchResult.setStuName(stuService.stuByStuCode(stu).get(0).getName());
					
					// get Opening balance for Vendor Item
					OpeningBalance openingBalance = new DropDownUtil().getStuOpeningBalance(stu);
					rebateReconSearchResult.setOpeningBalance(openingBalance);
					
					stuSearch.setStuCode(stu);
					
					// Nodal office Info
					List<StuTransaction> stuTransactionList = stuTransService.searchStuTrans(stuSearch);
					rebateReconSearchResult.setStuTransactionList(stuTransactionList);
					
					// Vendor Info for current year
					
					List<VendorTrans> currentVendorTransList = vendorTransService.searchVendorTrans(stuSearch);
					rebateReconSearchResult.setCurrentVendorTransList(currentVendorTransList);
					
					// Vendor info for last year
					
/*					Calendar cal = Calendar.getInstance();
					Date from = stuSearch.getTransactionDateFrom();
					cal.add(Calendar.YEAR, -1); // to get previous year add -1
					
					Calendar calTo = Calendar.getInstance();
					Date to = stuSearch.getTransactionDateTo();
					calTo.add(Calendar.YEAR, -1); // to get previous year add -1
					
					stuSearch.setTransactionDateFrom(cal.getTime());
					stuSearch.setTransactionDateTo(calTo.getTime());
					
					List<VendorTrans> previousVendorTransList = vendorTransService.searchVendorTrans(stuSearch);
					rebateReconSearchResult.setPreviousVendorTransList(previousVendorTransList);
			*/
					rebateReconSearchResultList.add(rebateReconSearchResult);
			
					}
					
					
					
					if (null != rebateReconSearchResultList && rebateReconSearchResultList.size() > 0) {
						try {
							String fileName = "rebateReconciliationLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							rebateReconcLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	rebateReconSearchResultList, rebateSearchCriteria);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("rebatereconciliationledger", model);
					}
				}

				//incentiveLedger Ends

				//stuInformationLedger Reports starts

				@RequestMapping(value = "/stuinformationledger", method = RequestMethod.GET)
				public ModelAndView stuInformationLedger(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("stuinformationledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printstuinformationledger", method = RequestMethod.POST)
				public ModelAndView printStuInformationLedger(@ModelAttribute("command") StuSearch stuSearch,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					RcperiodBean rcperiodBean = new RcperiodBean();
					List<StuTransaction> stuTransactionList = new ArrayList<StuTransaction>();
					List<StuTransaction> stuTransactionListRemove = new ArrayList<StuTransaction>();

					
					if(null != stuSearch.getAlternative() && stuSearch.getAlternative().equalsIgnoreCase("true")){
						// get rate contract period
						rcperiodBean.setVendorId(stuSearch.getVendorCode());
						rcperiodBean.setPgId(stuSearch.getItemCode());
						List<RcPeriod> rcPeriodList = rcPeriodService.rcPeriodForVendorItem(rcperiodBean);
						
						RcPeriod rcPeriod = null;
						RcPeriod rcPeriodLast = null;

						// get present rate contract period
						if(null != rcPeriodList && rcPeriodList.size()>0){
							rcPeriod = rcPeriodList.get(0);
						}
						// Add 3 months in present rate contract period
						Calendar calPrc = Calendar.getInstance();
						calPrc.setTime(rcPeriod.getToDate());
						calPrc.add(Calendar.MONTH, 3); 

						
						// get last rate contract period
						if(null != rcPeriodList && rcPeriodList.size()>1){
							rcPeriodLast = rcPeriodList.get(1);
						}
						
						// for all invoice dates between present contract plus three months and last contract
						//stuTransactionList = stuTransService.stuTransForDates(stuSearch, rcPeriod.getRcFromDate(), calPrc.getTime(), rcPeriodLast.getRcFromDate(), rcPeriodLast.getToDate());
						stuTransactionList = stuTransService.searchStuTrans(stuSearch);
						
						// remove records out of contract
						
						for(StuTransaction stuTransaction : stuTransactionList){
							if(!isDateWithinRange(stuTransaction.getInvoiceDate() , rcPeriod.getRcFromDate(), calPrc.getTime())){
								if(!isDateWithinRange(stuTransaction.getInvoiceDate() , rcPeriodLast.getRcFromDate(), rcPeriodLast.getToDate())){
									stuTransactionListRemove.add(stuTransaction);
								}
							}
						}
						
						stuTransactionList.removeAll(stuTransactionListRemove);
						
					} else{
						stuTransactionList = stuTransService.searchStuTrans(stuSearch);
						
					}

					if (null != stuTransactionList && stuTransactionList.size() > 0) {
						try {
							String fileName = "stuInformationLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							stuInfoLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	stuTransactionList);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("stuinformationledger", model);
					}
				}

				//incentiveLedger Ends

				//nodalOfficerstatement Reports starts

				@RequestMapping(value = "/nodalofficerstatement", method = RequestMethod.GET)
				public ModelAndView nodalOfficerStatement(@ModelAttribute("command") StuSearch stuSearch,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();
					model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
					return new ModelAndView("nodalofficerstatement", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printnodalofficerstatement", method = RequestMethod.POST)
				public ModelAndView printNodalOfficerstatement(@ModelAttribute("command") StuSearch stuSearch,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					
					// First day of month
					Calendar calFrom = Calendar.getInstance();
					calFrom.setTime(stuSearch.getTransactionDateFrom());
					calFrom.set(Calendar.DAY_OF_MONTH, 1);
					
					// last day of month
					Calendar calTo = Calendar.getInstance();
					calTo.setTime(stuSearch.getTransactionDateFrom());
					calTo.set(Calendar.DAY_OF_MONTH, 1);
					calTo.set(Calendar.DATE, calTo.getActualMaximum(Calendar.DATE));
					
					stuSearch.setTransactionDateFrom(calFrom.getTime());
					stuSearch.setTransactionDateTo(calTo.getTime());
					
					List<Stumaster> smList = stuService.stuByStuCode(stuSearch.getNodalCode());
					Stumaster sm = null;
					String nodalName = null;
					String nodalCode = null;
					
					if(null != smList && smList.size() >0){
						sm = smList.get(0);
						nodalName = sm.getModelName();
						nodalCode = sm.getModelCode();
					}

					stuSearch.setNodalCode(nodalCode);
					stuSearch.setNodalName(nodalName);
					
					List<StuTransaction> stuTransactionList = stuTransService.searchStuTrans(stuSearch);

					if (null != stuTransactionList && stuTransactionList.size() > 0) {
						try {
							String fileName = "nodalOfficerStatement.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							nodalOfficerStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	stuTransactionList, stuSearch );
														ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("nodalofficerstatement", model);
					}
				}

				//incentiveLedger Ends

				//abstractnodalofficerstatement Reports starts

				@RequestMapping(value = "/abstractnodalofficerstatement", method = RequestMethod.GET)
				public ModelAndView abstractNodalOfficerStatement(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("abstractnodalofficerstatement", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printabstractnodalofficerstatement", method = RequestMethod.POST)
				public ModelAndView printAbstractNodalOfficerStatement(@ModelAttribute("command") MisSearchCriteria misSearchCriteria,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					List<RebateForm> rebateList = rebateService.listRebate();

					if (null != rebateList && rebateList.size() > 0) {
						try {
							String fileName = "abstractNodalOfficerStatement.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							BankDetailStatementPDF.createPDF(temperotyFilePath + "\\" + fileName,	prepareListofBeanForDetailRebate(rebateList));
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("bankreport", model);
					}
				}

				//incentiveLedger Ends

				//vendorInformationLedger Reports starts

				@RequestMapping(value = "/vendorinformationledger", method = RequestMethod.GET)
				public ModelAndView vendorInformationLedger(@ModelAttribute("command") StuSearch stuSearch,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					Map<String, Object> model = new HashMap<String, Object>();

					model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
					model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
					return new ModelAndView("vendorinformationledger", model);

				}

				@SuppressWarnings("finally")
				@RequestMapping(value = "/printvendorinformationledger", method = RequestMethod.POST)
				public ModelAndView printVendorInformationLedger(@ModelAttribute("command") StuSearch stuSearch,
						HttpServletRequest request, HttpServletResponse response) throws IOException {

					final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
					final String temperotyFilePath = tempDirectory.getAbsolutePath();
					Map<String, Object> model = new HashMap<String, Object>();
					String searchMessage = "";
					
					List<VendorTrans> vendorTransList = vendorTransService.searchVendorTrans(stuSearch);
					
					String vendorName ="";
					if(null != stuSearch.getVendorCode() && !stuSearch.getVendorCode().equalsIgnoreCase("0")){
						vendorName = new DropDownUtil().getVendorNameByVendiorId(stuSearch.getVendorCode());
						stuSearch.setVendorName(vendorName);
					}
					
					String itemName = "";
					if(null != stuSearch.getItemCode() && !stuSearch.getItemCode().equalsIgnoreCase("0")){
						itemName = new DropDownUtil().getItemNameByItemId(stuSearch.getItemCode());
						stuSearch.setItemName(itemName);
					}
					String stuName = "";
					if(null != stuSearch.getStuCode() && !stuSearch.getStuCode().equalsIgnoreCase("0")){
						stuName = stuService.stuByStuCode(stuSearch.getStuCode()).get(0).getName();
						stuSearch.setStuName(stuName);
					}
					
					if (null != vendorTransList && vendorTransList.size() > 0) {
						try {
							String fileName = "vendorInformationLedger.pdf";
							response.setContentType("application/pdf");
							response.setHeader("Content-disposition", "attachment; filename=" + fileName);

							vendorTransLedgerPDF.createPDF(temperotyFilePath + "\\" + fileName,	vendorTransList, stuSearch);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
							OutputStream os = response.getOutputStream();
							baos.writeTo(os);
							os.flush();

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							return null;
						}
					} else {
						model.put("vendors", prepareListVendorBean(rebateService.listVendors()));
						searchMessage = "Please check search criteria. No result returned.";
						model.put("successMessage", searchMessage);
						return new ModelAndView("vendorinformationledger", model);
					}
				}

				//incentiveLedger Ends


				private List<RebateFormBean> prepareListForMisReport(List<RebateForm> rebateList, List<Invoice> invoiceList ) {
					List<MisSearchResult> misSearchResultList = null;
					System.out.print("List ==== invoiceList  " + invoiceList.size());
					System.out.print("List ==== rebateList  " + rebateList.size());
					
					// Assuming invoice list always greater than receipt
					
					
					return null;
				}	
				
				
				private Set<Calendar> dateSort(List<Date> dateToSort ){
					
					Calendar calenderSort = Calendar.getInstance();
					Set<Calendar> sortedList = new TreeSet<Calendar>();
					try {

						// We need to first format dates string into date object for sort
						// date parse() method is used to parse date
						for (Date strdate : dateToSort) {
							calenderSort = Calendar.getInstance();
							calenderSort.setTime(strdate);
							sortedList.add(calenderSort);
							System.out.println("Unsorted Date :" + strdate);
						}
						} catch (Exception e) {
						e.printStackTrace();
					}

					return sortedList;
					
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

				boolean isDateWithinRange(Date testDate, Date startDate , Date endDate) {
					return testDate.after(startDate) && testDate.before(endDate);
				}

				
}
