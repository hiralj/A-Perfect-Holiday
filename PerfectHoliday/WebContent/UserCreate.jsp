
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.regex.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function validEmail() {
		var regexEmail = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
		var email = document.getElementById("email");

		if (!regexEmail.test(email.value)) {
			alert("Email Not valid");
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a User</title>
</head>
<body bgcolor="#F2F5A9">
	<div>
		<img alt="Perfect Holiday"
			src="https://i.vimeocdn.com/video/346260911_640.jpg"
			style="width: 100%; height: 200px;">
	</div>
	<h1>Create User for - A Perfect Holiday</h1>
	<form action="UserCreate" method="post">
		<p>
			<label for="username">UserName</label> <input id="username"
				name="username" value="">
		</p>
		<p>
			Password <input id="password" name="password" type="password"
				value="" />
		</p>
		<p>
			<label for="firstname">FirstName</label> <input id="firstname"
				name="firstname" value="">
		</p>
		<p>
			<label for="lastname">LastName</label> <input id="lastname"
				name="lastname" value="">
		</p>
		<p>
			Email <input type="text" id="email" name="email" value=""
				onblur="validEmail()" />
		</p>
		<p>
			Phone <input type="text" id="phone" name="phone" value="" />
		</p>
		<p>
			<label for="dob">DoB (yyyy-mm-dd)</label> <input id="dob" name="dob"
				value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br />
	<br />
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>