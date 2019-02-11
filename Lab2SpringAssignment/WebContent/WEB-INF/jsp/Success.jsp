<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Trainee Management System</h1>
		<table>
					<tr><th>Pick your Operation</th></tr>
					<tr><td><a href="AddTraineePage.obj">add a trainee</a></td></tr>
					<tr><td><a href=" deleteTraineePage.obj">delete a trainee</a></td></tr>
					<tr><td><a href="updateTraineePage.obj">modify a trainee</a></td></tr>
					<tr><td><a href="searchTraineePage.obj">retrieve a trainee</a></td></tr>
					<tr><td><a href="ListAllTraineePage.obj">retrieve all trainee</a></td></tr>
		</table>
		${msg}
</body>
</html>