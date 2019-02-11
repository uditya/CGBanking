<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Detail Page</title>
</head>
<body>
	<div align="center">
			<h2>Hotel Details</h2>
			<table border="1">
									<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Rating</th>
									<th>Rate</th>
									<th>Available Rooms</th>
									</tr>
									<c:forEach var="hotel" items="${hotelListObj}">
									<tr>
									<td>${hotel.hotelId }</td>
									<td><a href="bookingController1.obj">${hotel.hotelName }</a></td>
									<td>${hotel.hotelRating}</td>
									<td>${hotel.hotelRate}</td>
									<td>${hotel.availableRooms}</td>		
									</tr>
									</c:forEach>
			</table>
			<b>Click a Hotel name to start Booking</b>
	</div>
</body>
</html>