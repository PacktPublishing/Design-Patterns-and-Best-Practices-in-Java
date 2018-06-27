package com.employee.service;

// import statements
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 * 
 * This class is responsible for handling Employee Entity related requests.
 * 
 */
public class EmployeeWebService extends HttpServlet {

	public void init() throws ServletException {
		// Do required initialization
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();
		/*
		 * This is a dummy example where we are simply returning static employee
		 * details. This is just to give an idea how simple request response works. In
		 * real world you might want to     * fetch the data from data base and return
		 * employee list or an employee object based on employee id sent by request.
		 * Well in real world you migth not want to use servlet at all.
		 */
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("EmployeeName", "Dave");
		jsonObject.put("EmployeeId", "1234");
		out.print(jsonObject);
		out.flush();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Similar to doGet, you might want to implement do post. where we will read
		// Employee values and add to database.
	}

	public void destroy() {
		// Handle any object cleanup or connection closures here.
	}
}
