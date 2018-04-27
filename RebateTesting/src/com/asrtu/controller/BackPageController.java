package com.asrtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackPageController {

	@RequestMapping(value="/adminBack", method= RequestMethod.GET)
	public ModelAndView adminBackPage(){
		
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/itemGroupBack", method= RequestMethod.GET)
	public ModelAndView itemGroupBackPage(){
		
		return new ModelAndView("itemGroup");
	}
	
	@RequestMapping(value="/editItemBack", method= RequestMethod.GET)
	public ModelAndView editItemGroupBackPage(){
		
		return new ModelAndView("redirect:/viewItemGroup.html");
	}
	
	@RequestMapping(value="/viewItemMasterBack", method= RequestMethod.GET)
	public ModelAndView viewItemMasterBackPage(){
		
		return new ModelAndView("redirect:/itemMaster.html");
	}
	
	@RequestMapping(value="/editItemMasterBack", method= RequestMethod.GET)
	public ModelAndView editItemMasterBackPage(){
		
		return new ModelAndView("redirect:/listItemMaster.html");
	}
	

	@RequestMapping(value="/viewTaxBack", method= RequestMethod.GET)
	public ModelAndView viewTaxBackPage(){
		
		return new ModelAndView("taxEntryForm");
	}
	
	@RequestMapping(value="/editTaxBack", method= RequestMethod.GET)
	public ModelAndView editTaxBackPage(){
		
		return new ModelAndView("redirect:/viewTax.html");
	}
	
	@RequestMapping(value="/editStoBack", method= RequestMethod.GET)
	public ModelAndView editStoBackPage(){
		
		return new ModelAndView("redirect:/viewStoForm.html");
	}
	
	@RequestMapping(value="/viewStoBack", method= RequestMethod.GET)
	public ModelAndView viewStoBackPage(){
		
		return new ModelAndView("redirect:/stoOrderForm.html");
	}
	
	@RequestMapping(value="/viewTestingBack", method= RequestMethod.GET)
	public ModelAndView viewTestingBackPage(){
		
		return new ModelAndView("redirect:/testingCharge.html");
	}
	
	@RequestMapping(value="/editTestingBack", method= RequestMethod.GET)
	public ModelAndView editTestingBackPage(){
		
		return new ModelAndView("redirect:/viewTesting.html");
	}
	
	@RequestMapping(value="/viewStuBack", method= RequestMethod.GET)
	public ModelAndView viewStuBackPage(){
		
		return new ModelAndView("stuMasterForm");
	}
	
	@RequestMapping(value="/viewStuMasterBack", method= RequestMethod.GET)
	public ModelAndView viewStuMasterBackPage(){
		
		return new ModelAndView("stuMasterForm");
	}
	
	@RequestMapping(value="/viewRCPeriodBack", method= RequestMethod.GET)
	public ModelAndView viewRcPeriodBackPage(){
		
		return new ModelAndView("redirect:/rcPeriod.html");
	}
	@RequestMapping(value="/editRcPeriodBack", method= RequestMethod.GET)
	public ModelAndView editRcPeriodBackPage(){
		
		return new ModelAndView("redirect:/viewRC.html");
	}
	
	@RequestMapping(value="/viewQuarterBack", method= RequestMethod.GET)
	public ModelAndView viewQuarrtBackPage(){
		
		return new ModelAndView("quarterEntryForm");
	}
	
	@RequestMapping(value="/viewProdSubGrBack", method= RequestMethod.GET)
	public ModelAndView viewSubGroupBackPage(){
		
		return new ModelAndView("prodSubGrp");
	}
	@RequestMapping(value="/editSubGroupBack", method= RequestMethod.GET)
	public ModelAndView editSubGroupBackPage(){
		
		return new ModelAndView("redirect:/viewSubGroup.html");
	}
	@RequestMapping(value="/viewRCTRCBack", method= RequestMethod.GET)
	public ModelAndView viewRCTRCBackPage(){
		
		return new ModelAndView("redirect:/rctrc.html");
	}
	@RequestMapping(value="/viewDebitBack", method= RequestMethod.GET)
	public ModelAndView viewDebitBackPage(){
		
		return new ModelAndView("redirect:/debit.html");
	}
	
	@RequestMapping(value="/ViewRCBack", method= RequestMethod.GET)
	public ModelAndView viewRCBackPage(){
		
		return new ModelAndView("redirect:/rcPeriod.html");
	}
	@RequestMapping(value="/viewRebateBack", method= RequestMethod.GET)
	public ModelAndView viewRebateBackPage(){
		
		return new ModelAndView("redirect:/rebateform.html");
	}
	@RequestMapping(value="/viewCirtBack", method= RequestMethod.GET)
	public ModelAndView viewCirtBackPage(){
		
		return new ModelAndView("redirect:/cirtBill.html");
	}
	
	@RequestMapping(value="/viewInvoiceBack", method= RequestMethod.GET)
	public ModelAndView viewInvoiceBackPage(){
		
		return new ModelAndView("redirect:/invoiceGeneration.html");
	}
	
	@RequestMapping(value="/viewVendorGstBack", method= RequestMethod.GET)
	public ModelAndView viewVendorGstBackPage(){
		
		return new ModelAndView("redirect:/vendorsgst.html");
	}
}
