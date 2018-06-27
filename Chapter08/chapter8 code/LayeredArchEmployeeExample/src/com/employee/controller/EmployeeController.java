package com.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
/**
 * This class implements GET and POST methods for Employee Entity
 */
public class EmployeeController {
	/**
	 * This method returns List of all the employees in the system.
	 *
	 * @return Employee List
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Employee> EmployeeListService() throws ServletException, IOException {
		List<Employee> empList = new ArrayList<Employee>();
		
		// Lets call Employee service which will return employee list
		EmployeeService empService = new EmployeeService();
		empList = empService.getEmployeeList();
		return empList;
	}
}