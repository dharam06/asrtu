package com.asrtu.dao;

import java.util.Date;
import java.util.List;

import com.asrtu.model.Employee;
import com.asrtu.model.FinanceYear;
import com.asrtu.model.Quarter;

public interface QuarterDao {
	
	public void addQuarte(Quarter quarter);

	public List<Quarter> listQuarter();
	
	public Quarter getQuarter(int slNo);
	
	public void deleteQuarter(Quarter quarter);

	Quarter getQuarterByDateRange(Date fromDate, Date toDate);

	List<FinanceYear> listFinanceYear();

	FinanceYear getFinanceYear(int slNo);
	
	

}
