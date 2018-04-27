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

import com.asrtu.bean.CirtBillBean;

import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.StoOrderFormBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.CirtBill;
import com.asrtu.model.Invoice;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.StoOrderForm;
import com.asrtu.model.Vendors;
import com.asrtu.service.CirtService;
import com.asrtu.service.StoOrderFormService;


@Controller
public class CirtController {
	
	@Autowired
	private CirtService cirtService;
	
	@Autowired
	private StoOrderFormService stoOrderFormService;
	
	
	@RequestMapping(value = "/cirtBill", method = RequestMethod.GET)
	public ModelAndView cirtProcess() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListVendorBean(cirtService.listVendors()));
		model.put("stoOrders",  prepareListofStoBean(stoOrderFormService.listOrderForm()));	
		return new ModelAndView("CIRTbill",model);
	}
	
	@RequestMapping(value="/saveCirt",method=RequestMethod.POST)
	public ModelAndView saveCirtForm(@ModelAttribute("command") CirtBillBean cirtBean,BindingResult result )throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String saveMessage="";
		
		if ("refreshPage".equals(cirtBean.getPageAction())) {
			System.out.println("\n\n refreshPage cirtBean ");
			StoOrderForm StoOrderForm = null;
			if(null != (cirtBean.getStoId())){
				
				// TO DO - Uncomment it after old data processed.
				//StoOrderForm = stoOrderFormService.getStoOrder(cirtBean.getStoNo());
				 
				 
				 // Please Note this is work around to handle old data as system makes STO No 0 in case of unsufficient amount
				 
				 StoOrderForm = stoOrderFormService.getStoOrderByStoId(cirtBean.getStoId());
				 
				 
			}
			
			
			StoOrderFormBean stoOrderFormBean = null;
			
			if(null!=StoOrderForm){
				 stoOrderFormBean =  prepareStoBean(StoOrderForm);
				
			}
			
			if(null != stoOrderFormBean && stoOrderFormBean.getStoNo()>0) {
				model.put("sto", stoOrderFormBean);
			} else{
				saveMessage = "No STO found for sto no .."+cirtBean.getStoNo();
				model.put("successMessage", saveMessage);
			}
			
			model.put("vendors", prepareListVendorBean(cirtService.listVendors()));
			model.put("stoOrders",  prepareListofStoBean(stoOrderFormService.listOrderForm()));	
			return new ModelAndView("CIRTbill",model);
	} else {
		CirtBill cirt=prepareModel(cirtBean);
		
		//Save CIRT 
		Integer transactionId = cirtService.addCIRT(cirt);
		// Update STO paid
		stoOrderFormService.updateSto(prepareModeSto(cirtBean.getStoNo()));
		
		model.put("vendors", prepareListVendorBean(cirtService.listVendors()));
		model.put("stoOrders",  prepareListofStoBean(stoOrderFormService.listOrderForm()));	
		
		saveMessage = "CIRT STO  saved successfully.."+transactionId;
		model.put("successMessage", saveMessage);
		
		return new ModelAndView("CIRTbill",model);
	}
	}
	
	@RequestMapping(value="/listCirt", method = RequestMethod.GET)
	public ModelAndView listStoForm() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cirtBills",  prepareListofBean(cirtService.listCIRT()));	
		return new ModelAndView("viewCirt", model);
	}
	
	@RequestMapping(value = "/deleteCirt", method = RequestMethod.GET)
	public ModelAndView editCIRT(@ModelAttribute("command")  CirtBillBean cirtBean,
			BindingResult result)throws Exception {
		cirtService.deleteCIRT(prepareModel(cirtBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cirtBills",  prepareListofBean(cirtService.listCIRT()));	
		return new ModelAndView("viewCirt", model);
	}
	
	@RequestMapping(value = "/editCirt", method = RequestMethod.GET)
	public ModelAndView deleteCirt(@ModelAttribute("command")  CirtBillBean cirtBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cirtBill", prepareCirtBillBean(cirtService.getCIRT(cirtBean.getTransId())));
		model.put("cirtBills",  prepareListofBean(cirtService.listCIRT()));
		model.put("vendors", prepareListVendorBean(cirtService.listVendors()));
		model.put("items", prepareListItemPgBean(cirtService.listItemPg()));
		return new ModelAndView("editDebit", model);
	}
	
	
	private List<CirtBillBean> prepareListofBean(List<CirtBill> cirtBill){
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
				bean.setStoId(cirt.getStoId());
				bean.setTestCharge(cirt.getTestCharge());
				bean.setVendorId(cirt.getVendorId());
				bean.setVendorName(cirt.getVendorName());
				bean.setRemarks(cirt.getRemarks());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CirtBill prepareModel(CirtBillBean cirtBean)throws Exception{
		CirtBill cirt=new CirtBill();

		cirt.setAsrtRefNo(cirtBean.getAsrtRefNo());
		cirt.setBillAmount(cirtBean.getBillAmount());
		
		cirt.setBillDate(cirtBean.getBillDate());
		
		cirt.setItemCode(cirtBean.getItemCode());
		cirt.setItemName(cirtBean.getItemName());
		cirt.setVendorName(cirtBean.getVendorName());
		cirt.setVendorId(cirtBean.getVendorId());
		
		cirt.setBillNo(cirtBean.getBillNo());
		cirt.setTestCharge(cirtBean.getTestCharge());
		cirt.setTransId(cirtBean.getTransId());
		cirt.setStONo(cirtBean.getStoNo());
		
		cirt.setStoId(cirtBean.getStoId());
		
		cirt.setRemarks(cirtBean.getRemarks());
		
		return cirt;
		
	}
	
	private CirtBill prepareModelToDelete(CirtBillBean cirtBean)throws Exception{
		CirtBill cirt=new CirtBill();

		cirt.setTransId(cirtBean.getTransId());
		
		return cirt;
		
	}
	private CirtBillBean prepareCirtBillBean(CirtBill cirt){
		CirtBillBean bean = new CirtBillBean();
		bean.setTransId(cirt.getTransId());
		bean.setAsrtRefNo(cirt.getAsrtRefNo());
		bean.setBillAmount(cirt.getBillAmount());
		bean.setBillDate(cirt.getBillDate());
		bean.setBillNo(cirt.getBillNo());
		bean.setItemCode(cirt.getItemCode());
		bean.setItemName(cirt.getItemName());
		bean.setStoNo(cirt.getStONo());
		bean.setTestCharge(cirt.getTestCharge());
		bean.setVendorId(cirt.getVendorId());
		bean.setVendorName(cirt.getVendorName());
		return bean;
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
	
	private List<StoOrderFormBean> prepareListofStoBean(List<StoOrderForm> orderForm){
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
				bean.setRemarks(order.getRemarks());
				bean.setQuantity(order.getQuantity());
				bean.setNetAmount(order.getNetAmount());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private StoOrderFormBean prepareStoBean(StoOrderForm order){

		StoOrderFormBean bean = new StoOrderFormBean();
				
				order.toString();
				
				bean = new StoOrderFormBean();
				bean.setStoTransId(order.getStoTransId());
				bean.setStoNo(order.getStoNo());
				
				bean.setStoId(order.getStoId());
				
				bean.setVendorId(order.getVendorId());
				bean.setVendorName(order.getVendorName());
				bean.setItemCode(order.getItemCode());
				bean.setItemName(order.getItemName());
				bean.setTestCharge(order.getTestCharge());
				bean.setTestDate(order.getTestDate());
				bean.setRemarks(order.getRemarks());
				bean.setQuantity(order.getQuantity());
				bean.setNetAmount(order.getNetAmount());
				
				bean.setRemarks(order.getRemarks());
				
		return bean;
	}	
	
private StoOrderForm prepareModeSto(Integer stoNo)throws Exception{
		
		StoOrderForm sto=new StoOrderForm();
		
		sto.setStoNo(stoNo);
		sto.setIsPaid("Y");
		
		return sto;
		
	}


private String formatDate(Date date) {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	String dateString = sdf.format(date);
	System.out.println("==========" + dateString);

	return dateString;
}


}
