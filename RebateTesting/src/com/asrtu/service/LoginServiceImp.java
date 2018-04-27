package com.asrtu.service;

import java.util.List;

import com.asrtu.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.model.Login;


@Service("loginService")
@Transactional(propagation =Propagation.SUPPORTS,readOnly =false)
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	
	
	@Transactional(propagation =Propagation.SUPPORTS,readOnly =false)
	@Override
	public void addLogin(Login login) {
		loginDao.addLogin(login);
		
	}

	
	@Override
	public List<Login> listLogin() {
		
		return loginDao.listLogin();
	}

	
	public Login getLogin(String name) {
		
		return loginDao.getLogin(name);
	}


	@Override
	public void deleteLogin(Login login) {
		loginDao.deleteLogin(login);
	}


	}


	
	
	
	
	
	
	


