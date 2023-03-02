<%@page import="com.daniel.cajero.entitybeans.Movimiento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos</title>
</head>
<body>
	<h2>Cuenta: ${idCuenta }</h2>
	<h2>Saldo: ${saldo }</h2>
	
	<%List<Movimiento> movimientos = (List<Movimiento>)request.getAttribute("movimientos");%>
	<table border="1">
		<tr>
			<th>Cantidad</th>
			<th>Fecha</th>
			<th>Tipo</th>
		</tr>
		<% for (Movimiento ele: movimientos){%>
			<tr>
				<td><%= ele.getCantidad() %></td>
				<td><%= ele.getFecha() %></td>
				<td><%= ele.getOperacion() %></td>
			</tr>
		<%} %>
	</table>
	<br/>
	<div><a href="/cajero">Volver</a></div>
</body>
</html>