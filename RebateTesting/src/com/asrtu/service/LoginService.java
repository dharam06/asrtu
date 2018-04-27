package com.asrtu.service;

import com.asrtu.model.Login;
import java.util.*;

public interface LoginService {
	
	public void addLogin(Login login);
	
	public List<Login> listLogin();
	
	public Login getLogin(String name);
	
	public void deleteLogin(Login login);
	
	
}
