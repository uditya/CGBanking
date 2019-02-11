<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Booking</title>
</head>
<body>
		<div align="center">
			<h3>Book a Hotel</h3>
			<form:form action="bookingDetails.obj" method="post" modelAttribute="hd">
				Customer Id:<form:input path="id"/><br>
									<form:errors path="id"/><br>
				Customer Name:<form:input path="customerName"/><br>
									<form:errors path="customerName"/><br>
				Hotel Id:	<form:input path="hotelId"/><br>
									<form:errors path="hotelId"/><br>
				To Date: <form:input path="toDate"/><br>
										<form:errors path="toDate"/><br>
				From Date: <form:input path="fromDate"/><br>
										<form:errors path="fromDate"/><br>	
				Number of Rooms: <form:input path="noOfRooms"/><br>
										<form:errors path="noOfRooms"/><br>					
				<input type="submit" name="btnHot" value="Book Hotel"/>
				<input type="reset" name="btnRest" value="Reset"/>
		</form:form>
		</div>
</body>
</html>