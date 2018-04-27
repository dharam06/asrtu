package com.asrtu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asrtu.bean.EmployeeBean;
import com.asrtu.bean.LoginBean;
import com.asrtu.model.Employee;
import com.asrtu.model.Login;
import com.asrtu.service.EmployeeService;
import com.asrtu.service.LoginService;

@Controller

public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminProcess() {
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/loginform",method= RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("command") LoginBean loginBean,BindingResult result,HttpServletRequest request,HttpServletResponse response){
		
		LoginBean bean=new LoginBean();
		String userName=request.getParameter("name");
		String password=request.getParameter("pass");
		System.out.println("\nBean Class value  =>  "+userName+"\t"+password);
		
		List<LoginBean> list=prepareListofBean(loginService.listLogin());
		String name=null;
		String pass=null;
		String userType=null;
		String message="Welcome";
		for (LoginBean value : list) {
			name=value.getName();
			pass=value.getPass();
			userType=value.getUserType();
			System.out.print("List ====   "+name+"\t"+pass+"\t"+userType);
			if( userType.equalsIgnoreCase("admin") && (userName.equals(name) && password.equals(pass)))
			{
				
				
				System.out.println("Check condition in data  =>  "+userType+"\t"+name+"\t"+pass);
				ModelAndView mav=new ModelAndView("admin","message","Welcome");
				HttpSession  session=request.getSession();
				session.setAttribute("userName", userName);
				session.setAttribute("message", message);
				return  mav;
			}
			else if(userType.equalsIgnoreCase("REBATE") &&(userName.equals(name) && password.equals(pass)))
	        {
				
				HttpSession  session=request.getSession();
				session.setAttribute("userName", userName);
				session.setAttribute("message", message);
				return new ModelAndView("rebatePage","message","Welcome");
			}
			 else if(userType.equalsIgnoreCase("testing") &&(userName.equals(name) && password.equals(pass)))
	         {
				 HttpSession  session=request.getSession();
					session.setAttribute("userName", userName);
					session.setAttribute("message", message);
				 return new ModelAndView("testingPage","message","Welcome");
	         }
	         else if(userType.equalsIgnoreCase("rc") &&(userName.equals(name) && password.equals(pass)))
	         {
	        	 HttpSession  session=request.getSession();
	     		session.setAttribute("userName", userName);
	     		session.setAttribute("message", message);
	        	 return new ModelAndView("rcPage","message","Welcome");
	         }
			
					
		}
		
		
			
		return new ModelAndView("index","message","Name & Password is not valid");

	
		
	}
	
	 @RequestMapping(value="/SignOut",method=RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("command") LoginBean loginBean,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
       
		 HttpSession session = request.getSession(false); 
		 Map outParams = new HashMap();       
		  if (session != null){            
		
		 session.invalidate();      
		   }        
	
        return  new ModelAndView("index");
      }
	
	
	private List<LoginBean> prepareListofBean(List<Login> login){
		List<LoginBean> beans = null;
		System.out.print("List ====   "+ login);
		if(login != null && !login.isEmpty()){
			beans = new ArrayList<LoginBean>();
			LoginBean bean = null;
			for(Login log : login){
				bean = new LoginBean();
				bean.setName(log.getName());
				bean.setPass(log.getPass());
				bean.setUserType(log.getUserType());
				beans.add(bean);
			}
		}
		return beans;
	}

	
}
