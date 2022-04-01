<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> LogIn Page </h1>
	<form action ="validate">
		<label>Email</label><br>
		<input type="text" name="email"><br><br>
		<label>Password</label><br>
		<input type="password" name="password"><br><br>
		<input type="submit" value="submit">
	</form>
	<p>
  New user. <a href="signup.jsp">Sign in</a>
</body>
</html>