<%@page import="com.daniel.cajero.entitybeans.Cuenta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cajero</title>
</head>
<body>
	<form action="/inicio" method="post" style="text-align:center">
		<label style="display:block">Introduce cuenta <input type="text" name="idCuenta"></label>
		<br/>
		<input type="submit" value="Entrar">
		<p>${mensaje }</p>
	</form>
</body>
</html>