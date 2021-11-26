
<%@page import="com.csi.service.EmployeeServiceImpl"%>
<%@page import="com.csi.service.EmployeeService"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csi.model.Employee"%>

<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User</title>
</head>
<body>
<%
	//UserBean user = new UserBean();
	EmployeeService empServiceImpl=new EmployeeServiceImpl();
	List<Employee> employeeList = empServiceImpl.getEmpAllData();
	//Iterator<UserBean> itr = userList.iterator();
%>
<table border="1">
	<tr>
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Employee Contact Number</th>
		<th>Employee DOB</th>
		<th>Employee Email</th>
		<th>Employee Password</th>
	</tr>
	<tr>
		<%
			/*while(itr.hasNext())
			 {
			 System.out.println(user.getId());*/
			for (Employee employee : employeeList) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String empDOB = sdf.format(employee.getEmpDob());
				
		%>
		<td><%=employee.getEmpId()%></td>
		<td><%=employee.getEmpName()%></td>
		<td><%=employee.getEmpContactNo()%></td>
		
		<td><%=empDOB%></td>
		<td><%=employee.getEmpEmailId()%></td>
		<td><%=employee.getEmpPassword()%></td>
		<td><a
			href="EmployeeController?action=editform&empid=<%=employee.getEmpId()%>">Update</a></td>
		<td><a
			href="EmployeeController?action=delete&empid=<%=employee.getEmpId()%>">Delete</a></td>

	</tr>
	<%
		}
		//}
	%>
</table>
<p><a href="EmployeeController?action=insert">Add Employee</a></p>
</body>
</html>