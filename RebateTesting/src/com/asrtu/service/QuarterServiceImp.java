package com.asrtu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.QuarterDao;
import com.asrtu.model.FinanceYear;
import com.asrtu.model.Quarter;

@Service("quarterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuarterServiceImp implements QuarterService {
	
	@Autowired
	private QuarterDao quarterDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addQuarte(Quarter quarter) {
		quarterDao.addQuarte(quarter);
		
	}

	@Override
	public List<Quarter> listQuarter() {
		// TODO Auto-generated method stub
		return quarterDao.listQuarter();
	}

	@Override
	public Quarter getQuarter(int slNo) {
		// TODO Auto-generated method stub
		return quarterDao.getQuarter(slNo);
	}

	@Override
	public void deleteQuarter(Quarter quarter) {
		
		quarterDao.deleteQuarter(quarter);
		
	}

	@Override
	public Quarter getQuarterByDateRange(Date fromDate, Date toDate ) {
		
		return quarterDao.getQuarterByDateRange(fromDate, toDate);
		
	}
	
	@Override
	public List<FinanceYear> listFinanceYear() {
		
		return quarterDao.listFinanceYear();
		
	}

	@Override
	public FinanceYear getFinanceYear(int slNo) {
		// TODO Auto-generated method stub
		return quarterDao.getFinanceYear(slNo);

	}
	
	
	
}
