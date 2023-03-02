<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operar</title>
</head>
<body>
	<form action="/ingresar" method="post" style="text-align:center">
		<label style="display:block">Introduce cantidad <input type="number" name="saldo" min=1></label>
		<br/>
		<input type="submit" value="Ingresar">
	</form>
</body>
</html>