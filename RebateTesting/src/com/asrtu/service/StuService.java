package com.asrtu.service;

import java.util.List;



import com.asrtu.model.Stumaster;

public interface StuService {
	
	public void addStu(Stumaster sm);

	public List<Stumaster> listStu();
	
	public Stumaster getStu(int sno);
	
	public void deleteStu(Stumaster sm);

	List<Stumaster> stuByStuCode(String stuCode);

}
