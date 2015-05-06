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
<title>Search Destination</title>
</head>
<body>
	<jsp:include page="/UserHome.jsp"></jsp:include>
	<h1>Provide your trip preferences</h1>

	<form action="DestinationSearch" method="post">
		<p>
			Region <select id="region" name="region">
				<c:forEach items="${regions}" var="region">
					<option
						<c:if test="${selectedRegion == region.toString()}"> selected="selected" </c:if>>
						<c:out value="${region}">
						</c:out>
					</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Interest <select id="interest" name="interest">
				<c:forEach items="${interests}" var="interest">
					<option
						<c:if test="${selectedInterest == interest.toString()}"> selected="selected" </c:if>>
						<c:out value="${interest}">
						</c:out>
					</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Companion <select id="companion" name="companion">
				<c:forEach items="${companions}" var="companion">
					<option
						<c:if test="${selectedCompanion == companion.toString()}"> selected="selected" </c:if>>
						<c:out value="${companion}">
						</c:out>
					</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>

	<c:forEach items="${cities}" var="city">
		<label style="font-size: 25px; font-weight: bold"> <c:out
				value="${city.getCityName()}" />
		</label>
		&nbsp; &nbsp; &nbsp; 
		${selectedInterest} : ${city.getInterestRating()}
		&nbsp; &nbsp; &nbsp; 
		${selectedCompanion} : ${city.getCompanionRating()}
		<br />

		<img alt="City photo" src="${city.getPhoto()}" width="300px"
			height="200px" />
		<br />
		<c:out value="${city.getDescription()}" />
		<br />
		<a href="CityPlaces?cityname=<c:out value="${city.getCityName()}"/>">Places</a>
		&nbsp; &nbsp; &nbsp; 
		<a href="CityHotels?cityname=<c:out value="${city.getCityName()}"/>">Hotels</a>
		&nbsp; &nbsp; &nbsp; 
		<a href="CityReview?cityname=<c:out value="${city.getCityName()}"/>">Reviews</a>
		&nbsp; &nbsp; &nbsp; 
		<a href="UserTravel?cityname=<c:out value="${city.getCityName()}"/>">Visit</a>
		<br />
		<br />
	</c:forEach>

</body>
</html>