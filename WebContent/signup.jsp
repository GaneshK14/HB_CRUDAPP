<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUpPage</title>
</head>
<body style="background-color: silver;">
<form action="EmployeeController" method="get">
<input type="hidden" name="action" value="signup" >
Name<input type="text" name="empname"><br>
ContactNo<input type="text" name="empcontactno"><br>
DOB<input type="text" name="empdob"><br>
EmailId<input type="text" name="empemailid"><br>
Password<input type="password" name="emppassword"><br>
<input type="submit" value="SignUp">
</form>

</body>
</html>