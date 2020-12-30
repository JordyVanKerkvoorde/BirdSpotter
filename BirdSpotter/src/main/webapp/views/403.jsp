<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access denied</title>
</head>
<body>
<h1>HTTP Status 403 - Access is denied</h1>
<form action='login?logout' method='post'>
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
</form>
</body>
</html>