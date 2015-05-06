
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Place</title>
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
	<h1>Create Place for - A Perfect Holiday</h1>
	<form action="PlaceCreate" method="post">
		<p>
			<label for="place">Place</label> <input id="place" name="place"
				value="">
		</p>
		<p>
			Address <input id="address" name="address" value="" />
		</p>
		<p>
			ZipCode <input id="zipCode" name="zipCode" value="" />
		</p>
		<p>
			Description <br />
			<textarea rows="10" cols="60" id="description" name="description"> </textarea>
		</p>
		<p>
			<label for="photo">Photo</label> <input id="photo" name="photo"
				value="">
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