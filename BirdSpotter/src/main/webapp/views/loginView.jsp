<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body onload='document.loginForm.username.focus();'>
<h1>Bird Spotting Login</h1>
<h2>Login with Username and Password</h2>

<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>

<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>

<form action='login' method='POST'>
	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' value=''></td>
		</tr>
	</table>
	<input name="submit" type="submit"value="Log in" />
	<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
	
</form>

</body>
</html>