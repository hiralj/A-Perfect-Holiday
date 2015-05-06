<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
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
			<font size="14" color="#0B0B61"> Welcome,
				${admin.getFirstName()}</font>
		</h1>
		<a href="AdminCreate?"><font></font>Create Admin</a> &nbsp; <a
			href="UserSearch?">Search User</a> &nbsp; <a href="CityCreate?">
			Add City</a> &nbsp; <a href="PlaceCreate?"> Add Place</a> &nbsp; <a
			href="HotelCreate?"> Add Hotel</a>
	</div>
</body>
</html>