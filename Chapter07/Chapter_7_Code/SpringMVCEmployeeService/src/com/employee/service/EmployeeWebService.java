package com.employee.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	EmployeeDAO empDAO = new EmployeeDAO();
	/**
	 * This method returns List of all the employees in the system.
	 *
	 * @return Employee List
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> EmployeeListService() throws ServletException, IOException {
		// fetch employee list and return
		List<Employee> empList = empDAO.getEmployeeList();
		return empList;
	}

	/**
	 * This method returns details of a specific Employee.
	 *
	 * @return Employee
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Employee EmployeeDataService(@PathVariable("id") String id) throws ServletException, IOException {
		// fetch employee details and return
		Employee emp = empDAO.getEmployee(id);
		return emp;
	}

	/**
	 * This method returns Adds an Employee to the system
	 *
	 * @return Employee List
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String EmployeeAddService(@RequestBody Employee emp) throws ServletException, IOException {
		// add employee and return id
		String empId= empDAO.addEmployee(emp);
		return empId;
	}

}

class EmployeeDAO{
	
	public List<Employee> getEmployeeList(){
		List<Employee> empList = new ArrayList<Employee>();
		/*
		 * Ideally you will call business or data layer to fetch the Employee List. For
		 * keeping this example simple returning a dummy list.
		 */
		// First Employee
		Employee emp1 = new Employee();
		emp1.setId("1");
		emp1.setName("Dave");
		emp1.setDesignation("Manager");
		empList.add(emp1);
		// Second Employee
		Employee emp2 = new Employee();
		emp2.setId("2");
		emp2.setName("Tom");
		emp2.setDesignation("Engineer");
		empList.add(emp2);
		// Return Employee List
		return empList;
	}
	
	public Employee getEmployee(String id) {
		/*
		 * Again, to keep it simple, returning a dummy record.
		 */
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName("Alex");
		emp.setDesignation("Manager");
		return emp;
	}
	
	public String addEmployee(Employee emp) {
		/*
		 * A new employee will be created and id will be returned. 
		 * For sake of this example returning dummy id
		 */
		return "1";
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
