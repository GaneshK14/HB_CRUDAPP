package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService empServiceImpl = new EmployeeServiceImpl();

	String INDEX_PAGE = "/index.jsp";
	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String EDIT_PAGE = "/edit.jsp";
	String LISTEMPL_PAGE = "/listEmployee.jsp";

	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redirect = "";

		String empName = request.getParameter("empname");

		String action = request.getParameter("action");

		if (empName != null && action.equals("signup")) {

			long empContactNo = Long.valueOf(request.getParameter("empcontactno"));
			Date empDob = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				empDob = sdf.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee();

			employee.setEmpName(empName);
			employee.setEmpContactNo(empContactNo);
			employee.setEmpDob(empDob);
			employee.setEmpEmailId(empEmailId);
			employee.setEmpPassword(empPassword);

			empServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {
			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			if (empServiceImpl.signIn(empEmailId, empPassword)) {
				redirect = LISTEMPL_PAGE;
			} else {
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("editform")) {
			redirect = EDIT_PAGE;

		} else if (action.equals("edit")) {
			int empId = Integer.parseInt(request.getParameter("empid"));
			long empContactNo = Long.valueOf(request.getParameter("empcontactno"));
			
			Date empDob = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				empDob = sdf.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee();

			employee.setEmpName(empName);
			employee.setEmpContactNo(empContactNo);
			employee.setEmpDob(empDob);
			employee.setEmpEmailId(empEmailId);
			employee.setEmpPassword(empPassword);

			empServiceImpl.updateEmpData(empId, employee);

			redirect = LISTEMPL_PAGE;

		} else if (action.equals("delete")) {

			int empId = Integer.parseInt(request.getParameter("empid"));

			empServiceImpl.deleteEmpData(empId);

			redirect = LISTEMPL_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
