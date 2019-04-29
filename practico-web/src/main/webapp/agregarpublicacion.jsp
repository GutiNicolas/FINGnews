<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="Bussines.dtNoticia" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva publicacion</title>
</head>
<body>
	<h3>Nueva publicacion para la noticia: <%=request.getAttribute("titulo") %></h3>
	<h4>Complete el siguiente formulario:</h4>
	<form action="AgregarPublicacion" method="post">
  Url:<br>
  <input type="text" name="url" value="twitter.com/ejemplo">
  <br>
  Tipo:<br>
  <input type="text" name="tipo" value="Tweet">
  <br>
  ID Noticia:<br> <input type="text" name="idn" value="<%=request.getAttribute("idn") %>" readonly><br>
  <input type="submit" value="Enviar">
</form> 
</body>
</html>