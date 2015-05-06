<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	function cursorOnUsername() {
		document.getElementById("username").focus();
	}
</script>

<title>A Perfect Holiday - Login</title>
</head>
<body bgcolor="#F2F5A9" onload="cursorOnUsername()">
	<div>
		<img alt="Perfect Holiday"
			src="https://i.vimeocdn.com/video/346260911_640.jpg"
			style="width: 100%; height: 200px;">
	</div>
	<div align="center">

		<h1>Login</h1>
		<form action="HomePage" method="post">
			<p>
				UserName : <input id="username" name="username" value="">
			</p>
			<p>
				Password : <input id="password" name="password" type="password"
					value="" />
			</p>
			<p>
				<input type="submit" />
			</p>
			<p>
				Not a user? <a href="UserCreate"> SignUp </a>
			</p>
		</form>

		<p style="color: red">${failure}</p>
	</div>
</body>
</html>