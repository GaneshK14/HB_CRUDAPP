<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignInPage</title>
</head>
<body style="background-color: gray;">
<form action="EmployeeController" method="get">
<input type="hidden" name="action" value="signin">
EmailId<input type="text" name="empemailid"><br>
Password<input type="password" name="emppassword"><br>
<input type="submit" value="SignIn">
</form>

</body>
</html>