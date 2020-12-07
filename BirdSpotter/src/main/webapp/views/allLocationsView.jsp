<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BirdSpotting Locations</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<spring:url value="/birdspotting/" var="listOfSpots"/>

	<h1>Overview of bird spotting locations:</h1>
	<p>Please select your location to add a spotting:</p>
	<table>
		<tr>
			<th>Location</th>
			<th>Birds spotted</th>
		</tr>
		<c:forEach items="${locations}" var="location">
			<tr>
				<td>
					<a href="${listOfSpots}${location.name}">${location.name}</a>
				</td>
				<td>${location.spottedBirds}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action='login?logout' method='post'>
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
	</form>
</body>
</html>