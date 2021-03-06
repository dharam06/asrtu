package com.asrtu.controller;


import java.util.ArrayList;
import java.util.List;

import com.asrtu.bean.Contact;
import com.asrtu.bean.ContactForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	
	private static List<Contact> contacts = new ArrayList<Contact>();

	static {
		contacts.add(new Contact("", "", "", ""));
		contacts.add(new Contact("", "", "george.b@whitehouse.com", "785-985-652"));
		contacts.add(new Contact("", "", "bill.c@whitehouse.com", "236-587-412"));
		contacts.add(new Contact("", "", "ronald.r@whitehouse.com", "369-852-452"));
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView get() {
		
		ContactForm contactForm = new ContactForm();
		contactForm.setContacts(contacts);
		
		return new ModelAndView("add_contact" , "contactForm", contactForm);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {
		System.out.println(contactForm);
		System.out.println(contactForm.getContacts());
		List<Contact> contacts = contactForm.getContacts();
		
		if(null != contacts && contacts.size() > 0) {
			ContactController.contacts = contacts;
			for (Contact contact : contacts) {
				System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
			}
		}
		
		return new ModelAndView("show_contact", "contactForm", contactForm);
	}
}

