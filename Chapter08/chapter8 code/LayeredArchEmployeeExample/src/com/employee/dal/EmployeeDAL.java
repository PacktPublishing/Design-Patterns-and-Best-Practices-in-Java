package com.employee.dal;

import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;

/**
 * This class handle all the Employee Related Database operations.
 * 
 */
public class EmployeeDAL {
	
	/**
	 * This methods fetches employee list and returns to the caller.
	 * @return EmployeeList
	 */
	public List<Employee> getEmployeeList(){
		
		List<Employee> empList = new ArrayList<Employee>();
		// One will need to create a DB connection and fetch Employees 
		// Or we can use ORM like hibernate or frameworks like mybatis
		// For this example we are returning a dummy list
		Employee emp1 = new Employee();
		emp1.setId("1");
		emp1.setName("Dave");
		emp1.setDesignation("Manager");
		Employee emp2 = new Employee();
		emp2.setId("2");
		emp2.setName("John");
		emp2.setDesignation("Engineer");
		empList.add(emp1);
		empList.add(emp2);
		return empList;
		
		
	}

}
