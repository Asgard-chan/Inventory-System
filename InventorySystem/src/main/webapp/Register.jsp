<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Register</h2>
<form action="RegisterController" method="POST">
<label for="email">Email:</label><br>
<input type="text" name="email"><br>
<label for="fname">First Name:</label><br>
<input type="text" name="firstname"><br>
<label for="lname">Last Name:</label><br>
<input type="text" name="lastname"><br>
<label for="password">Password:</label><br>
<input type="password" name="password"><br>
<br> <input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
<br>
<br>
<a href="login.jsp">Login</a>


</body>
</html>