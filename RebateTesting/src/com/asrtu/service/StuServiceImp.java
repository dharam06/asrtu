package com.asrtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.EmployeeDao;
import com.asrtu.dao.StuDao;
import com.asrtu.model.Employee;
import com.asrtu.model.Stumaster;


@Service("stuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StuServiceImp implements StuService {

	@Autowired
	private StuDao stuDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStu(Stumaster sm) {
		stuDao.addStu(sm);
		
	}

	@Override
	public List<Stumaster> listStu() {
		
		return stuDao.listStu();
	}

	@Override
	public Stumaster getStu(int sno) {
		
		return stuDao.getStu(sno);
	}

	@Override
	public void deleteStu(Stumaster sm) {
		
		stuDao.deleteStu(sm);
	}
	
	@Override
	public List<Stumaster> stuByStuCode(String stuCode){
		return stuDao.stuByStuCode(stuCode);
	}

}
