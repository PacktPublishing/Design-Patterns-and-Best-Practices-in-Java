package com.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dal.EmployeeDAL;
import com.employee.model.Employee;

@Controller
@RequestMapping("/employees")
/**
 * This class implements controller for Employee Entity
 */
public class EmployeeController {
	/**
	 * This method returns view to display all the employees in the system.
	 *
	 * @return Employee List
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView getEmployeeList(ModelAndView modelView) throws ServletException, IOException {
		List<Employee> empList = new ArrayList<Employee>();
		
		EmployeeDAL empDAL = new EmployeeDAL();
		
		empList = empDAL.getEmployeeList();
		modelView.addObject("employeeList", empList);
		modelView.setViewName("employees");
		return modelView;
	}
}