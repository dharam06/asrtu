package com.asrtu.dao;

import java.util.*;
import com.asrtu.model.*;

public interface LoginDao {
	
	
	public void addLogin(Login login);
	
	public List<Login> listLogin();
	
	public Login getLogin(String name);
	
	public void deleteLogin(Login login);
	

}
