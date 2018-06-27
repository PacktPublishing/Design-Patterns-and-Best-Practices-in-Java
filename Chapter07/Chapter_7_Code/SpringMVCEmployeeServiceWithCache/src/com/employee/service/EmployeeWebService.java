package com.employee.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
/**
 * This class implements GET and POST methods for Employee Entity
 */
public class EmployeeWebService {

	/**
	 *  * This method fetches a particular employee data.  * @param id  * @return
	 *  * @throws ServletException  * @throws IOException  
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Employee EmployeeDataService(@PathVariable("id") String id) throws ServletException, IOException {

		/*
		 *  * Lets check of the data is available in cache.  * If not available, we will
		 * get the data from database and add to cache for future usage.    
		 */
		Employee emp = EmployeeCache.getData(id);
		if (emp == null) {
			System.out.println("Did not find in cache");
			EmployeeService employeeService = new EmployeeService();
			emp = employeeService.getEmployee(id);
			EmployeeCache.putData(id, emp);
		}
		return emp;
	}

}

/**
 * A simple cache class holding data for Employees
 *
 */
class EmployeeCache {

	static Map<String, Employee> cache = new HashMap<String, Employee>();

	/**
	 *  * get Employee from cache  * @param id  * @return Employee  
	 */
	public static Employee getData(String id) {
		return cache.get(id);
	}

	/**
	 *  * Set employee data to cache  * @param id  * @param employee  
	 */
	public static void putData(String id, Employee employee) {
		cache.put(id, employee);
	}
}

/**
 * This is an example service class
 *
 */
class EmployeeService {
	public Employee getEmployee(String id) {
		// This will actually fetch employee from DB and return
		Employee emp = new Employee();
		emp.setDesignation("Manager");
		emp.setId("1");
		emp.setName("Dave");
		return emp;
	}
}

class Employee {
	String name;
	String id;
	String designation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
