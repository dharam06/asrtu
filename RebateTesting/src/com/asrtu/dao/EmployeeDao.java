package com.asrtu.dao;

import java.util.List;

import com.asrtu.model.Employee;

/**
 * @author ##
 *
 */
public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
