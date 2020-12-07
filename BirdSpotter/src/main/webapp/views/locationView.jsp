<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="count" value="1" scope="page" />
	<h1>Overview of spotted birds in ${location.name}</h1>
	<table>
		<tr>
			<th>Index</th>
			<th>Specie</th>
			<th>Year of discovery</th>
			<th>Code index in the book of birds</th>
			<th>Spottings</th>
		</tr>
		<c:forEach items="${location.spottedBirds}" var="bird">
			<tr>
				<td>${count}</td>
				<td>${bird.birdSpecie.name}</td>
				<td>${bird.birdSpecie.yearOfDiscovery}</td>
				<td>${bird.birdSpecie.code}</td>
				<td>${bird.count}</td>
			</tr>
			<c:set var="count" value="${count + 1}" scope="page"/>
		</c:forEach>
	</table>
</body>
</html>