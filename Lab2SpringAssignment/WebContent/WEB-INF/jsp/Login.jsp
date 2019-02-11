<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Login Page opened on : ${compNameObj } Server</h2>
		<hr size="3" color="red"/>
						<form:form action="ValidateUser.obj" modelAttribute="log">
								User Name: <form:input path="username" />
								<form:errors path="username"/>
								<br/>
								Password: <form:password path="password"/>
								<form:errors path="password"/>
								<br/><br/>
								<input type="submit" name="Submit" value="LOGIN">
					</form:form>	
</body>
</html>