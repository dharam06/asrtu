package com.asrtu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.asrtu.bean.Contact;
import com.asrtu.bean.ItemPgTabBean;
import com.asrtu.bean.QuarterBean;
import com.asrtu.bean.RcperiodBean;
import com.asrtu.bean.StuBean;
import com.asrtu.bean.StuTransColBean;
import com.asrtu.bean.StuTransactionBean;
import com.asrtu.bean.TestingChargeBean;
import com.asrtu.bean.VendorTransBean;
import com.asrtu.bean.VendorsBean;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.Quarter;
import com.asrtu.model.RcPeriod;
import com.asrtu.model.StuTransInv1;
import com.asrtu.model.StuTransInv2;
import com.asrtu.model.StuTransInv3;
import com.asrtu.model.StuTransInv4;
import com.asrtu.model.StuTransInv5;
import com.asrtu.model.StuTransaction;
import com.asrtu.model.Stumaster;
import com.asrtu.model.TestingCharge;
import com.asrtu.model.Vendors;
import com.asrtu.service.RcPeriodService;
import com.asrtu.service.StuService;
import com.asrtu.service.StuTransService;
import com.astru.util.DropDownUtil;

@Controller
public class StuTransactionController {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@Autowired
	private StuTransService stuTransService;

	private static List<StuTransColBean> stuTransColBeans = new ArrayList<StuTransColBean>();

	static {
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
		stuTransColBeans.add(new StuTransColBean("", "", "", 0.0f, 0.0f));
	
	
	}

	@RequestMapping(value = "/saveStuTrans", method = RequestMethod.POST)
	public ModelAndView saveStuTransaction(@ModelAttribute("command") StuTransactionBean stutransBean,
			BindingResult result) {
		try {

			System.out.println("\n\n saving stu list");

			List<StuTransColBean> stuTransColBeans = stutransBean.getStuColl();

			System.out.println("\n\n stuTransColBeans " + stuTransColBeans.size());

			if (null != stuTransColBeans && stuTransColBeans.size() > 0) {
				StuTransactionController.stuTransColBeans = stuTransColBeans;
				for (StuTransColBean stuTransCBean : stuTransColBeans) {

					System.out.println("\n\n stuTransCBean " + stuTransCBean.toString());
					if(stuTransCBean.getInvoiceNumber()!=null && stuTransCBean.getInvoiceNumber().trim() !=""){
						StuTransaction stuTrans = prepareModel(stutransBean, stuTransCBean);
						stuTransService.addStuTrans(stuTrans);
					}
				}
			}

		} catch (Exception e) {

		}

		StuTransactionBean stuTransactionBean = new StuTransactionBean();
		stuTransactionBean.setStuColl(stuTransColBeans);

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
		// model.put("item",
		// prepareListofItemBean(stuTransService.listItemPg()));
		model.put("quarter", prepareListofQuarterBean(stuTransService.listQuarter()));

		model.put("stuTransactionBean", stuTransactionBean);

		return new ModelAndView("StuTransaction", model);

		// return new ModelAndView("StuTransaction","message","Successfull
		// save");
	}

	@RequestMapping(value = "/stuTransac", method = RequestMethod.GET)
	public ModelAndView stuTransacProcess() {

		StuTransactionBean stuTransactionBean = new StuTransactionBean();
		stuTransactionBean.setStuColl(stuTransColBeans);

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("stuMaster", prepareListofStuBean(stuTransService.listStuMaster()));
		model.put("vendor", prepareListVendorBean(stuTransService.listVendors()));
		// model.put("item",
		// prepareListofItemBean(stuTransService.listItemPg()));
		model.put("quarter", prepareListofQuarterBean(stuTransService.listQuarter()));

		model.put("stuTransactionBean", stuTransactionBean);

		return new ModelAndView("StuTransaction", model);
	}

	@RequestMapping(value = "/listStuTr", method = RequestMethod.GET)
	public ModelAndView listStuTrans() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		// model.put("listStuTran", );
		model.put("stuTransactionBean", prepareListofStuTranBean(stuTransService.listStuTransactions()));
		return new ModelAndView("viewStuTrans", model);
	}

	@RequestMapping(value = "/deletestuTrn", method = RequestMethod.GET)
	public ModelAndView deleteSTUTrn(@ModelAttribute("command") StuTransactionBean stuTranBean, BindingResult result)
			throws Exception {

		StuTransColBean stb = (StuTransColBean) stuTranBean.getStuColl().get(0);
		stuTransService.deleteStuTran(prepareModelToDelete(stuTranBean, stb));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stuTransactionBean", prepareListofStuTranBean(stuTransService.listStuTransactions()));
		return new ModelAndView("viewStuTrans", model);

	}

	private StuTransaction prepareModel(StuTransactionBean stuTranBean, StuTransColBean stuTransCBean)
			throws Exception {
		StuTransaction str = new StuTransaction();

		
		System.out.println("\n\n stuTranBean ====>>>> "+stuTranBean.toString());
		System.out.println("\n\n stuTransCBean ====>>>> "+stuTransCBean.toString());
		
		// StuTransColBean
		str.setSno(stuTransCBean.getSno());
		str.setFirmName(new DropDownUtil().getVendorNameByVendiorId(stuTransCBean.getVendorCode()));

		str.setVendorCode((stuTransCBean.getVendorCode()));
		str.setItemName(new DropDownUtil().getItemNameByItemId(stuTransCBean.getItemCode()));
		str.setItemCode(stuTransCBean.getItemCode());

		str.setInvoiceDate(stuTransCBean.getInvoiceDate());

		str.setInvoiceNumber(stuTransCBean.getInvoiceNumber());
		str.setStuTotalAmount(stuTransCBean.getStuTotalAmount());
		str.setStuTotalRebate(stuTransCBean.getStuTotalRebate());

		// stuTranBean

		str.setQuarter(stuTranBean.getQuarter());
		str.setMonth(stuTranBean.getMonth());
		str.setStuName(new DropDownUtil().getSTUNameBystuID(stuTranBean.getStuName()));
		str.setStuCode(stuTranBean.getStuCode());
		// str.setYear(stuTranBean.getYear());
		str.setNodalCode(stuTranBean.getNodalCode());
		str.setNodalName(stuTranBean.getNodalName());

		str.setTransactionDate((stuTranBean.getTransactionDate()));

		str.setInfoReceiptDate(stuTranBean.getInfoReceiptDate());
		
		str.setPurchaseOrderNumber(stuTransCBean.getPurchaseOrderNumber());

		str.setPurchaseOrderDate(stuTransCBean.getPurchaseOrderDate());

		return str;
	}

	private StuTransaction prepareModelToDelete(StuTransactionBean stuTranBean, StuTransColBean stuTransCBean)
			throws Exception {
		StuTransaction str = new StuTransaction();

		str.setSno(stuTransCBean.getSno());

		return str;
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

	private List<QuarterBean> prepareListofQuarterBean(List<Quarter> quarter) {
		System.out.print("bean creating   ");
		List<QuarterBean> qBeans = new ArrayList<QuarterBean>();
		System.out.print("bean creating qBeans  " + qBeans);
		System.out.println("quarter of size  " + quarter.size());
		if (quarter != null && !quarter.isEmpty()) {

			Iterator it = quarter.iterator();

			for (Quarter quar : quarter) {

				if (null != quar) {
					System.out.print("quarter of size  " + quarter);

					System.out.print("bean creating   ");
					QuarterBean bean = new QuarterBean();

					System.out.print("bean of size  " + bean);
					System.out.print("quar of size  " + quar);

					bean.setSlNo(quar.getSlNo());

					bean.setQuarter(quar.getQuarter());
					bean.setqFrom(quar.getqFrom());
					bean.setQtDate(quar.getQtDate());

					qBeans.add(bean);
				}

			}
		}
		System.out.print("List of beans  " + qBeans.size());
		return qBeans;
	}

	private List<ItemPgTabBean> prepareListofItemBean(List<ItemPgTab> itemPg) {
		List<ItemPgTabBean> beans = null;
		System.out.println("Item of size  " + itemPg.size());
		System.out.println("Item of size  " + itemPg);
		if (itemPg != null && !itemPg.isEmpty()) {
			beans = new ArrayList<ItemPgTabBean>();
			ItemPgTabBean bean = null;
			for (ItemPgTab item : itemPg) {

				bean = new ItemPgTabBean();
				bean.setItemCode(item.getItemCode());
				bean.setItemName(item.getItemName());

				beans.add(bean);

			}
		}
		System.out.print("List of beans  " + beans.size());
		return beans;
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

	private StuTransactionBean prepareListofStuTranBean(List<StuTransaction> stuTransaction) {
		StuTransactionBean stuTransactionBean = new StuTransactionBean();
		List<StuTransColBean> strCBbeans = new ArrayList<StuTransColBean>();

		System.out.print("list of StuTransactionBean " + stuTransaction.size());
		if (stuTransaction != null && !stuTransaction.isEmpty()) {

			StuTransColBean strCB = null;

			for (StuTransaction test : stuTransaction) {

				strCB = new StuTransColBean();
				if (null != test) {
					System.out.println("\n\n stuTransaction : " + test.toString());

					strCB.setQuarter(test.getQuarter());
					strCB.setMonth(test.getMonth());
					strCB.setStuName(test.getStuName());
					strCB.setStuCode(test.getStuCode());
					// str.setYear(test.getYear());
					strCB.setNodalCode(test.getNodalCode());

					strCB.setNodalName(test.getNodalName());

					
					strCB.setInvoiceDate(test.getInvoiceDate());
					
					if(null != test.getInvoiceDate()){
						strCB.setInvoiceDateString(formatDate(test.getInvoiceDate()));
					}
					
					strCB.setInvoiceNumber(test.getInvoiceNumber());
					strCB.setItemName(test.getItemName());
					strCB.setStuTotalAmount(test.getStuTotalAmount());
					strCB.setStuTotalRebate(test.getStuTotalRebate());
					strCB.setVendorCode(test.getVendorCode());
					strCB.setFirmName(test.getFirmName());
					strCB.setSno(test.getSno());
					strCB.setTransactionDate(test.getTransactionDate());
					
					if(null != test.getTransactionDate()){
						strCB.setTransactionDateString(formatDate(test.getTransactionDate()));
					}

					strCB.setInfoReceiptDate(test.getInfoReceiptDate());
					
					if(null != test.getInfoReceiptDate()){
						strCB.setInfoReceiptDateString(formatDate(test.getInfoReceiptDate()));
					}
					
					strCB.setPurchaseOrderDate(test.getPurchaseOrderDate());
					
					if(null != test.getPurchaseOrderDate()){
						strCB.setPurchaseOrderDateString(formatDate(test.getPurchaseOrderDate()));
					}
					
					strCB.setPurchaseOrderNumber(test.getPurchaseOrderNumber());

					strCBbeans.add(strCB);
				}
			}
		}

		stuTransactionBean.setStuColl(strCBbeans);
		for (StuTransColBean b : stuTransactionBean.getStuColl()) {

			System.out.println(b.toString());

		}

		return stuTransactionBean;
	}


	private String formatDate(Date date){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateString = sdf.format(date);
        System.out.println("=========="+dateString);
   
		return dateString;
	}
}
