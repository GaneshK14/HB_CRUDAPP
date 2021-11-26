<%@page import="com.csi.service.EmployeeServiceImpl"%>
<%@page import="com.csi.service.EmployeeService"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csi.model.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%
	Employee employee = new Employee();
%>
<%
	EmployeeService empServiceImpl=new EmployeeServiceImpl();
%>
<form method="GET" action='EmployeeController' name="frmEditEmployee"><input
	type="hidden" name="action" value="edit" /> <%
 	String uid = request.getParameter("empid");
 	if (!((uid) == null)) {
 		int empId = Integer.parseInt(uid);
 		employee = empServiceImpl.getEmpDataById(empId);
 		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String empDOB = sdf.format(employee.getEmpDob());
 %>
<table>
	<tr>
		<td>Employee ID</td>
		<td><input type="text" name="empid" readonly="readonly"
			value="<%=employee.getEmpId()%>"></td>
	</tr>
	<tr>
		<td>Employee Name</td>
		<td><input type="text" name="empname" value="<%=employee.getEmpName()%>"/></td>
	</tr>
	<tr>
		<td>Employee Contact Number</td>
		<td><input type="text" name="empcontactno" value="<%=employee.getEmpContactNo()%>"/></td>
	</tr>
	
	<tr>
		<td>Employee DOB</td>
		<td><input type="text" name="empdob" value="<%=empDOB%>"/></td>
	</tr>
	<tr>
		<td>Employee Email Id</td>
		<td><input type="text" name="empemailid" value="<%=employee.getEmpEmailId()%>"/></td>
	</tr>
	<tr>
		<td>Employee Password</td>
		<td><input type="text" name="emppassword" value="<%=employee.getEmpPassword()%>"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("ID Not Found");
%>
</form>
</body>
</html>