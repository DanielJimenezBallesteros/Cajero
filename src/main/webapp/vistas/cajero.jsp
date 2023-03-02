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
	<% Cuenta cuentaIniciada = (Cuenta)request.getAttribute("cuentaIniciada");%>
	<ul style="text-align:center">
		<li style="list-style:none"><a href="/ingresar">Ingresar</a></li>
		<li style="list-style:none"><a href="/extraer">Extraer</a></li>
		<li style="list-style:none"><a href="/movimientos">Ver movimientos</a></li>
		<li style="list-style:none"><a href="/transferencia">Transferecia</a></li>
		<br/>
		<li style="list-style:none"><a href="/cerrarSesion">Cerrar sesión</a></li>
	</ul>
</body>
</html>