<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<h1>${review.getCityName().getCityName()}Reviews</h1>
	<table border="1">
		<tr>
			<th>Review</th>
			<th>Traveler</th>
		</tr>
		<c:forEach items="${reviews}" var="review">
			<tr>
				<td><c:out value="${review.getReview()}" /></td>
				<td><c:out
						value="${review.getUserName().getFirstName()} ${review.getUserName().getLastName()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>