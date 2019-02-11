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
		<h3>Add a Trainee</h3>
		<form:form action="addTrainee.obj" method="post" modelAttribute="reg">
				TraineeID:<form:input path="traineeId"/><br>
									<form:errors path="traineeId"/><br>
				TraineeName:<form:input path="traineeName"/><br>
									<form:errors path="traineeId"/><br>
				TraineeLocation<form:radiobutton path="traineeLocation" value="C" label="Chennai"/>
							<form:radiobutton path="traineeLocation" value="B" label="Bangalore"/>
							<form:radiobutton path="traineeLocation" value="P" label="Pune"/>
							<form:radiobutton path="traineeLocation" value="M" label="Mumbai"/><br>
				TraineeDomain: <form:select path="traineeDomain">
						<form:option value="Select trainee domain"/>
						<form:option value="Java"/>
						<form:option value=".Net"/>
						<form:option value="Oracle"/>
				</form:select><br>
				<input type="submit" name="btnReg" value="Add Trainee"/>
		</form:form>

</body>
</html>