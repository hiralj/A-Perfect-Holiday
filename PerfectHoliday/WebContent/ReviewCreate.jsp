
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
<title>Add Review</title>
<script type="text/javascript">
	function removeSuggestions() {
		document.getElementById("suggestion").innerHTML = "";
	}
	function showSuggestions(str) {
		var xmlhttp;
		if (str == "") {
			document.getElementById("suggestion").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("suggestion").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "CitySuggestions?cityName=" + str, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<jsp:include page="/UserHome.jsp"></jsp:include>
	<h1>Add a review</h1>
	<form action="ReviewCreate" method="post">
		<p>
			City : <input type="text" id="cityName" name="cityName"
				onkeyup="showSuggestions(this.value)" onblur="removeSuggestions()" />
		</p>
		<div id="suggestion"></div>
		<p>
			Interest Rating:
			<c:forEach items="${interests}" var="interest">
				<c:out value="${interest}">
				</c:out>
				<select id="${interest}" name="${interest}">
					<option selected="selected">Select</option>
					<c:forEach begin="1" end="5" var="rating">
						<option>
							<c:out value="${rating}">
							</c:out>
						</option>
					</c:forEach>
				</select>
			&nbsp;
		</c:forEach>
		</p>

		<p>
			Companion Rating:
			<c:forEach items="${companions}" var="companion">
				<c:out value="${companion}">
				</c:out>
				<select id="${companion}" name="${companion}">
					<option selected="selected">Select</option>
					<c:forEach begin="1" end="5" var="rating">
						<option>
							<c:out value="${rating}">
							</c:out>
						</option>
					</c:forEach>
				</select>
			&nbsp;
		</c:forEach>
		</p>

		<p>
			Review : <br />
			<textarea rows="10" cols="60" id="review" name="review"> </textarea>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>
	<p>${success}</p>
</body>
</html>