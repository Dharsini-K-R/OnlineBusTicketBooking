<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="user"> 
		<label>Name</label><br>
		<input type="text" name="name" placeholder="full name.."> <br><br> 
		<label>DOB</label><br>
		<input type="date" name="dob"  placeholder="DOB.."><br><br>  
		<label>Address</label> <br>
		<input type="text" name="address"  placeholder="Address.."><br><br> 
		<label>Phone Number</label><br>
		<input type="number" name="phone"  placeholder="Phone Number.."><br><br> 
		<label>Email</label>  <br>
		<input type="text" name="email"  placeholder="Email Id.."><br><br> 
		<label>Password</label> <br>
		<input type="password" name="password"  placeholder="Password.."><br><br>
		<input type="submit" value="Register"/>  
	</form>  
</body>
</html>