<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BirdSpotting Locations</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Overview of bird spotting locations:</h1>
	<p>Please select your location to add a spotting:</p>
	<table>
		<tr>
			<th>Location</th>
			<th>Birds spotted</th>
		</tr>
		<c:forEach items="${locations}" var="location">
			<tr>
				<td>${location.name}</td>
				<td>${location.spottedBirds}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action='logout?logout' method='post'>
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
	</form>
</body>
</html>