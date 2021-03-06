<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Bird Spotting</title>
<spring:url value="/css/style.css" var= "urlCss"/>
<link href="${urlCss}" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Create new bird specie:</h1>
	<form:form method="POST" action="/birdspotting/${location.name}/create-new-spotting" modelAttribute="birdSpecie">
		<p>${globalError}</p>
		<p>
		<form:label path="name">Specie:</form:label>
		<form:input path="name"/>
		<form:errors path="name" cssClass="error"/>
		</p>
		<p>
		<form:label path="yearOfDiscovery">Year of discovery:</form:label>
		<form:input path="yearOfDiscovery"/>
		<form:errors path="yearOfDiscovery" cssClass="error"/>
		</p>
		<p>
		<form:label path="code">Book of birds code:</form:label>
		<form:input path="code"/>
		<form:errors path="code" cssClass="error"/>
		</p>
		<input type="submit" value="Spot new bird"/>
	</form:form>
</body>
</html>