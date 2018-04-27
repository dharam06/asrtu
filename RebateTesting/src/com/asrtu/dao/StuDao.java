package com.asrtu.dao;

import java.util.List;

import com.asrtu.bean.StuSearch;
import com.asrtu.model.Stumaster;

public interface StuDao {
	
	public void addStu(Stumaster sm);

	public List<Stumaster> listStu();
	
	public Stumaster getStu(int sno);
	
	public void deleteStu(Stumaster sm);

	List<Stumaster> stuByStuCode(String stuCode);

}
