
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Hotel</title>
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
	<jsp:include page="/AdminHome.jsp"></jsp:include>
	<h1>Create Hotel for - A Perfect Holiday</h1>
	<form action="HotelCreate" method="post">
		<p>
			<label for="hotel">Hotel</label> <input id="hotel" name="hotel"
				value="">
		</p>
		<p>
			Address <input id="address" name="address" value="" />
		</p>
		<p>
			ZipCode <input id="zipCode" name="zipCode" value="" />
		</p>
		<p>
			Phone <input id="phone" name="phone" value="" />
		</p>
		<p>
			Website <input id="website" name="website" value="" />
		</p>
		<p>
			City <input id="city" name="city" value=""
				onkeyup="showSuggestions(this.value)" onblur="removeSuggestions()" />
		</p>
		<div id="suggestion"></div>
		<p>
			<input type="submit">
		</p>
	</form>

	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>