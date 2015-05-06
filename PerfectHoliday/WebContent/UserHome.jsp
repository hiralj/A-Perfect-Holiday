<%@ page import="holiday.model.Enumerations"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body bgcolor="#F2F5A9">
	<div>
		<img alt="Perfect Holiday"
			src="https://i.vimeocdn.com/video/346260911_640.jpg"
			style="width: 100%; height: 200px;">
	</div>
	<div align="right">
		<a href="About.jsp">About us</a> &nbsp;&nbsp; <a href="ContactUs.jsp">Contact
			us</a>&nbsp;&nbsp; <a href="HomePage">Log out</a>
	</div>
	<div>
		<h1>
			<font size="14" color="#0B0B61">Welcome,
				${user.getFirstName()} </font>
		</h1>
		<a href="UserUpdate"> Update Profile</a> &nbsp; <a
			href="DestinationSearch"> Search Destination</a> &nbsp; <a
			href="ReviewCreate"> Add Review</a>
	</div>

</body>
</html>