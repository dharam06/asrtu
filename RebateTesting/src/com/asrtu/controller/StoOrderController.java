package com.asrtu.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.StoOrderFormBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.TestingTransaction;
import com.asrtu.model.Vendors;
import com.asrtu.service.StoOrderFormService;
import com.asrtu.service.TestingChargeService;
import com.astru.util.AjaxGetItem;


@Controller
public class StoOrderController {
	
	@Autowired
	private StoOrderFormService stoOrderFormService;
	
	@Autowired 
	private TestingChargeService testingChargeService;
	
	
	@RequestMapping(value = "/stoOrderForm", method = RequestMethod.GET)
	public ModelAndView stoProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(stoOrderFormService.listVendors()));
		model.put("items", prepareListItemPgBean(stoOrderFormService.listItemPg()));
		return new ModelAndView("StoOrderForm",model);
	}
	
	@RequestMapping(value="/saveStoOrder",method=RequestMethod.POST)
	public ModelAndView saveStoForm(@ModelAttribute("command") StoOrderFormBean orderBean,BindingResult result )throws Exception{
		
		System.out.println(orderBean.toString());
		
		StoOrderForm order=prepareModel_1(orderBean);
		stoOrderFormService.addOrderForm(order);
		
		// Update Testing Transaction only If sto No > 0
		if(null!= orderBean.getStoNo()  && orderBean.getStoNo() != 0){
			TestingTransaction testingTransaction = new TestingTransaction();
			testingTransaction.setVendorId(orderBean.getVendorId());
			testingTransaction.setVendorName(getVendorNameById(orderBean.getVendorId()));
			testingTransaction.setItemCode(orderBean.getProducGroupCode());
			testingTransaction.setItemName(getGroupName(orderBean.getProducGroupCode()));
			testingTransaction.setClosingBalance(orderBean.getNetAmount() - orderBean.getTestCharge());
			testingTransaction.setRemarks("Debited for STO Test Charge "+orderBean.getTestCharge());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date transactionDate = new Date();
			System.out.println(dateFormat.format(transactionDate)); //2016/11/16 12:08:43
	
			testingTransaction.setTransactionDate(transactionDate);
			testingChargeService.addTestChargeTrans(testingTransaction);
		}
		
		return new ModelAndView("redirect:/stoOrderForm.html","message1","Successfull Save..");
	}
	
	@RequestMapping(value="/viewStoForm", method = RequestMethod.GET)
	public ModelAndView listStoForm() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stoOrders",  prepareListofBean(stoOrderFormService.listOrderForm()));	
		return new ModelAndView("viewStoOrderForm", model);
	}
	
	@RequestMapping(value = "/deleteStoOrder", method = RequestMethod.GET)
	public ModelAndView editStoForm(@ModelAttribute("command")  StoOrderFormBean orderBean,
			BindingResult result)throws Exception {
		stoOrderFormService.deleteOrderForm(prepareModel(orderBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stoOrder", null);
		model.put("stoOrders",  prepareListofBean(stoOrderFormService.listOrderForm()));
		return new ModelAndView("viewStoOrderForm", model);
	}
	@RequestMapping(value = "/editStoOrder", method = RequestMethod.GET)
	public ModelAndView deleteStoForm(@ModelAttribute("command")  StoOrderFormBean orderBean,
			BindingResult result)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(stoOrderFormService.listVendors()));
		model.put("items", prepareListItemPgBean(stoOrderFormService.listItemPg()));
		model.put("stoOrder", prepareTestingChargeBean(stoOrderFormService.getOrderForm(orderBean.getStoTransId())));
		model.put("stoOrders",  prepareListofBean(stoOrderFormService.listOrderForm()));
		return new ModelAndView("editStoOrderForm", model);
	}
	
	private List<StoOrderFormBean> prepareListofBean(List<StoOrderForm> orderForm){
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
				
				bean.setStoId(order.getStoId());
				bean.setTestType(order.getTestType());
				bean.setRctrc(order.getRctrc());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
	private StoOrderForm prepareModel(StoOrderFormBean orderBean)throws Exception{
		StoOrderForm sto=new StoOrderForm();
		sto.setStoTransId(orderBean.getStoTransId());
		sto.setStoNo(orderBean.getStoNo());
		
		sto.setProductSubGroupCode(orderBean.getProductSubGroupCode());
		
		sto.setVendorId(orderBean.getVendorId());
		
		sto.setTestCharge(orderBean.getTestCharge());
		sto.setTestDate(orderBean.getTestDate());
		sto.setRemarks(orderBean.getRemarks());
		sto.setQuantity(orderBean.getQuantity());
		sto.setNetAmount(orderBean.getNetAmount());
		sto.setStoTransId(orderBean.getStoTransId());
		orderBean.setStoTransId(null);
		return sto;
		
	}
	private StoOrderForm prepareModel_1(StoOrderFormBean orderBean)throws Exception{
		
		System.out.println(orderBean.toString());
		
		StoOrderForm sto=new StoOrderForm();
		sto.setStoTransId(orderBean.getStoTransId());
		sto.setStoNo(orderBean.getStoNo());
		
		// Please Note PROD group is going to item
		sto.setItemCode(orderBean.getProducGroupCode());
		sto.setItemName(getGroupName(orderBean.getProducGroupCode()));
		
		sto.setProductSubGroupCode(orderBean.getProductSubGroupCode());
		sto.setVendorId(orderBean.getVendorId());
		
		sto.setVendorName(getVendorNameById(orderBean.getVendorId()));
		
		sto.setTestCharge(orderBean.getTestCharge());
		
		sto.setTestDate(orderBean.getTestDate());
		
		sto.setRemarks(orderBean.getRemarks());
		sto.setQuantity(orderBean.getQuantity());
		sto.setNetAmount(orderBean.getNetAmount());
		sto.setStoTransId(orderBean.getStoTransId());
		
		sto.setStoId(orderBean.getStoId());
		sto.setTestType(orderBean.getTestType());
		sto.setRctrc(orderBean.getRctrc());
		
		sto.setIsPaid("N"); 
		
		orderBean.setStoTransId(null);
		return sto;
		
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
	
	private List<ItemPgTabBean> prepareListItemPgBean(List<ItemPgTab> item){
		List<ItemPgTabBean> beans=null;
		System.out.println("List of item Pg Table   "+item.size());
		if(item != null && !item.isEmpty() ){
			beans=new ArrayList<ItemPgTabBean>();
			ItemPgTabBean bean = null;
			for(ItemPgTab it: item){
				bean=new ItemPgTabBean();
				bean.setItemCode(it.getItemCode());
				bean.setItemName(it.getItemName());
				beans.add(bean);
			}
			
		}
		
		return beans;
		
	}
	
	
	private StoOrderFormBean prepareTestingChargeBean(StoOrderForm order){
		StoOrderFormBean bean = new StoOrderFormBean();
		bean.setStoTransId(order.getStoTransId());
		bean.setStoNo(order.getStoNo());
		//bean.setProducGroupCode(order.getProducGroupCode());
		bean.setProductSubGroupCode(order.getProductSubGroupCode());
		
		bean.setVendorId(order.getVendorId());
		
		bean.setTestCharge(order.getTestCharge());
		bean.setTestDate(order.getTestDate());
		bean.setRemarks(order.getRemarks());
		bean.setQuantity(order.getQuantity());
		bean.setNetAmount(order.getNetAmount());
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
	
	private String getGroupName(String groupID){
		AjaxGetItem itemName=new AjaxGetItem();
		return itemName.getItemName(groupID);
		
	}
	
	private String formatDate(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = sdf.format(date);
		System.out.println("==========" + dateString);

		return dateString;
	}
}
