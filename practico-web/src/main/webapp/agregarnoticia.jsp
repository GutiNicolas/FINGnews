<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Noticia</title>
</head>
<body>
	<h3>Nueva Noticia</h3>
	<h4>Complete el siguiente formulario:</h4>
	<form action="AgregarNoticia" method="post">
  Titulo:<br>
  <input type="text" name="titulo" style="width: 250px">
  <br>
  Descripcion:<br>
  <input type="text" name="descripcion" style="width: 450px">
  <br>
  <input type="submit" value="Enviar">
</form> 
</body>
</html>