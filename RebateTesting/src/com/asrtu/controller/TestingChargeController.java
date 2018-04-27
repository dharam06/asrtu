package com.asrtu.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.asrtu.bean.BankMasterBean;
import com.asrtu.bean.ItemGroupBean;

import com.asrtu.bean.TestingChargeBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.BankMaster;
import com.asrtu.model.ItemGroup;

import com.asrtu.model.TestingCharge;
import com.asrtu.model.TestingTransaction;
import com.asrtu.model.Vendors;

import com.asrtu.service.TestingChargeService;
import com.astru.util.AjaxGetItem;

@Controller
public class TestingChargeController {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	
	@Autowired 
	private TestingChargeService testingChargeService;
	
	@RequestMapping(value = "/testingCharge", method = RequestMethod.GET)
	public ModelAndView testingProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(testingChargeService.listVendors()));
		model.put("itemGroup", prepareListofItemGroup(testingChargeService.listItemGroup()));
		model.put("bankNames", prepareListBankBean(testingChargeService.listBankMaster()));
		
		
		
		return new ModelAndView("tastingChargeForm",model);
	}
	
	@RequestMapping(value="/saveTestings",method=RequestMethod.POST)
	public ModelAndView saveTestingForm(@ModelAttribute("command") TestingChargeBean testingChargeBean,BindingResult result )throws Exception{
		
		String saveMessage="";
		HashMap<String, Object> model = new HashMap<String, Object>();
		
		TestingCharge testCharge=prepareModel(testingChargeBean);
		Integer receiptNumber = testingChargeService.addTestCharge(testCharge);
		saveMessage = "Testing Charge is saved successfully for Receipt Number : "+receiptNumber;
		
		// Update Testing Transaction.
		
		// Get existing test
		TestingTransaction testingTransaction = null;
		TestingTransaction testingTransactionNew = new TestingTransaction();
		
		testingTransaction = testingChargeService.getTestTransByVendorItem(testingChargeBean.getVendorId(), testingChargeBean.getItemCode());
		
		if(null != testingTransaction){
			
			testingTransactionNew.setVendorId(testingTransaction.getVendorId());
			testingTransactionNew.setVendorName(testingTransaction.getVendorName());
			testingTransactionNew.setItemCode(testingTransaction.getItemCode());
			testingTransactionNew.setItemName(testingTransaction.getItemName());
			testingTransactionNew.setOpeningBalance(testingTransaction.getClosingBalance());
			
			testingTransactionNew.setClosingBalance(testingTransaction.getClosingBalance() + testingChargeBean.getNetTestCharge());
			
			testingTransactionNew.setRemarks("Credited by Test Chanrge ");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date transactionDate = new Date();

			testingTransactionNew.setTransactionDate(transactionDate);
			testingChargeService.addTestChargeTrans(testingTransactionNew);
		}
		
		else{
			testingTransactionNew = getTestingTransaction(testingChargeBean);
			testingChargeService.addTestChargeTrans(testingTransactionNew);
		}
		
		
		
		model.put("successMessage", saveMessage);
		
		model.put("vendors", prepareListVendorBean(testingChargeService.listVendors()));
		model.put("itemGroup", prepareListofItemGroup(testingChargeService.listItemGroup()));
		model.put("bankNames", prepareListBankBean(testingChargeService.listBankMaster()));
			
		return new ModelAndView("tastingChargeForm",model);
	}
	
	@RequestMapping(value="/viewTesting", method = RequestMethod.GET)
	public ModelAndView listTesting() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("testingCharges",  prepareListofBean(testingChargeService.listTestCharge()));	
		return new ModelAndView("viewTestingCharge", model);
	}
	
	@RequestMapping(value = "/deleteTestingCharge", method = RequestMethod.GET)
	public ModelAndView editTesting(@ModelAttribute("command")  TestingChargeBean testingChargeBean,
			BindingResult result)throws Exception {
		testingChargeService.deleteTestCharge(prepareModel_1(testingChargeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("testingCharge", null);
		model.put("testingCharges",  prepareListofBean(testingChargeService.listTestCharge()));
		return new ModelAndView("viewTestingCharge", model);
	}
	@RequestMapping(value = "/editTestingCharge", method = RequestMethod.GET)
	public ModelAndView deleteTesting(@ModelAttribute("command")  TestingChargeBean testingChargeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(testingChargeService.listVendors()));
		model.put("itemGroup", prepareListofItemGroup(testingChargeService.listItemGroup()));
		model.put("bankNames", prepareListBankBean(testingChargeService.listBankMaster()));
		model.put("testingCharge", prepareTestingChargeBean(testingChargeService.getTestCharge(testingChargeBean.getReceiptNo())));
		model.put("testingCharges",  prepareListofBean(testingChargeService.listTestCharge()));
		return new ModelAndView("editTestingCharge", model);
	}
	
	
	private List<TestingChargeBean> prepareListofBean(List<TestingCharge> testCharge){
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
	
	private List<BankMasterBean> prepareListBankBean(List<BankMaster> bank){
		List<BankMasterBean> beans=null;
		System.out.println("List of Bank   "+bank.size());
		if(bank != null && !bank.isEmpty() ){
			beans=new ArrayList<BankMasterBean>();
			BankMasterBean bean = null;
			for(BankMaster ban: bank){
				bean=new BankMasterBean();
				bean.setBankCode(ban.getBankCode());
				bean.setBankName(ban.getBankName());
				
				beans.add(bean);
			}
			
		}
		
		return beans;
		
	}
	
	private List<VendorsBean> prepareListVendorBean(List<Vendors> vendor){
		List<VendorsBean> beans=null;
		System.out.println("List of Vendor   "+vendor.size());
		if(vendor != null && !vendor.isEmpty() ){
			beans=new ArrayList<VendorsBean>();
			VendorsBean bean = null;
			for(Vendors ven: vendor){
				bean=new VendorsBean();
				bean.setVendorId(ven.getVendorId());
				bean.setVendorName(ven.getVendorName());
				beans.add(bean);
			}
			
		}
		
		return beans;
		
	}
	
	private TestingTransaction getTestingTransaction(TestingChargeBean testingChargeBean)throws Exception{
		TestingTransaction test=new TestingTransaction();

		test.setVendorId(testingChargeBean.getVendorId());
		test.setVendorName(getVendorNameById(testingChargeBean.getVendorId()));
		test.setItemCode(testingChargeBean.getItemCode());
		test.setItemName(getItemNameById(testingChargeBean.getItemCode()));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date transactionDate = new Date();
		System.out.println(dateFormat.format(transactionDate)); //2016/11/16 12:08:43

		test.setTransactionDate(transactionDate);
		test.setOpeningBalance(testingChargeBean.getNetTestCharge()+0f);
		test.setClosingBalance(testingChargeBean.getNetTestCharge()+0f);
		test.setCreditAmount(testingChargeBean.getNetTestCharge()+0f);
		
		test.setRemarks("Testing Charge added by CHQ "+testingChargeBean.getChqNo());
		return test;
		
	}

	private TestingCharge prepareModel(TestingChargeBean testingChargeBean)throws Exception{
		TestingCharge test=new TestingCharge();
		//test.setSno(testingChargeBean.getSno());
		//test.setReceiptNo(testingChargeBean.getReceiptNo());
		test.setVendorId(testingChargeBean.getVendorId());
		test.setVendorName(getVendorNameById(testingChargeBean.getVendorId()));
		test.setItemCode(testingChargeBean.getItemCode());
		test.setItemName(getItemNameById(testingChargeBean.getItemCode()));
		test.setTestCharge(testingChargeBean.getTestCharge());
		test.setChqNo(testingChargeBean.getChqNo());

		
		test.setChqDate(testingChargeBean.getChqDate());
		
		test.setReceiptDate(testingChargeBean.getReceiptDate());
		
		test.setBankCode(testingChargeBean.getBankCode());
		test.setBankName(testingChargeBean.getBankName());
		test.setRemark(testingChargeBean.getRemark());
		test.setNetTestCharge(testingChargeBean.getNetTestCharge());
		test.setServiceTax(testingChargeBean.getServiceTax());
		
		test.setServiceTaxAmount(testingChargeBean.getServiceTaxAmount());
		
		//test.setSno(testingChargeBean.getSno());

		return test;
		
	}
	private TestingCharge prepareModel_1(TestingChargeBean testingChargeBean)throws Exception{
		TestingCharge test=new TestingCharge();
		test.setReceiptNo(testingChargeBean.getReceiptNo());
		
		test.setVendorId(testingChargeBean.getVendorId());
		test.setVendorName(testingChargeBean.getVendorName());
		test.setItemCode(testingChargeBean.getItemCode());
		test.setItemName(testingChargeBean.getItemName());
		test.setTestCharge(testingChargeBean.getTestCharge());
		test.setChqNo(testingChargeBean.getChqNo());
		test.setChqDate(testingChargeBean.getChqDate());
		test.setReceiptDate(testingChargeBean.getReceiptDate());
		test.setBankCode(testingChargeBean.getBankCode());
		test.setBankName(testingChargeBean.getBankName());
		test.setRemark(testingChargeBean.getRemark());
		test.setNetTestCharge(testingChargeBean.getNetTestCharge());
		test.setServiceTax(testingChargeBean.getServiceTax());
		testingChargeBean.setSno(null);
		return test;
		
	}
	private List<ItemGroupBean> prepareListofItemGroup(List<ItemGroup> item){
		List<ItemGroupBean> beans = null;
		System.out.println("List of Item group   "+item.size());
		if(item != null && !item.isEmpty()){
			beans = new ArrayList<ItemGroupBean>(); 
			ItemGroupBean bean = null;
			for(ItemGroup it : item){
				bean = new ItemGroupBean();
				bean.setItemGroupCode(it.getItemGroupCode());
				bean.setSno(it.getSno());
				bean.setItemGroupName(it.getItemGroupName());
				
				beans.add(bean);
			}
		}
				
		return beans;
	}
	
	private TestingChargeBean prepareTestingChargeBean(TestingCharge test){
		TestingChargeBean bean = new TestingChargeBean();
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
		
		bean.setChqDate(test.getChqDate());
		if(null!=test.getChqDate()){
			bean.setChqDateString(formatDate(test.getChqDate()));
		}
		
		bean.setBankCode(test.getBankCode());
		bean.setBankName(test.getBankName());
		bean.setRemark(test.getRemark());
		bean.setNetTestCharge(test.getNetTestCharge());
		bean.setServiceTax(test.getServiceTax());
		return bean;
	}

	
	private String getVendorNameById(String vendorID){
		AjaxGetItem itemName=new AjaxGetItem();
		return itemName.getVendorName(vendorID);
		
	}
	
	private String getItemNameById(String itemID){
		AjaxGetItem itemName=new AjaxGetItem();
		return itemName.getItemName(itemID);
		
	}
	
	private String formatDate(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = sdf.format(date);
		System.out.println("==========" + dateString);

		return dateString;
	}


}
