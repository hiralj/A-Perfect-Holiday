<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/UserHome.jsp"></jsp:include>
	<p>Thankyou for choosing ${cityName} to visit.</p>
	<p>Please let us know the travel date.</p>

	<form action="UserTravel" method="post">
		<p>
			<label for="travelDate">Travel Date (yyyy-mm-dd)</label> <input
				id="travelDate" name="travelDate" value="">
		</p>

		<input type="hidden" id="cityName" name="cityName" value="${cityName}" />
		<p>
			<input type="submit" />
		</p>
	</form>
	<p>${success}
</body>
</html>