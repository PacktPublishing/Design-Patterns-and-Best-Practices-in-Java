package com.employee.service;

import java.util.List;

import com.employee.dal.EmployeeDAL;
import com.employee.model.Employee;

/**
 * 
 * This service handles all the Employee relation functionality and servers 
 * calling methods. 
 */
public class EmployeeService {

	/**
	 * This methods returns list of Employees
	 * @return EmployeeList
	 */
	public List<Employee> getEmployeeList(){
		
		// This method calls EmployeeDAL and gets employee List
		EmployeeDAL empDAL = new EmployeeDAL();
		return empDAL.getEmployeeList();
	}
}
