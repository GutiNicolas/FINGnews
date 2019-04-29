<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FING NEWS</title>
</head>
<body>
	<h1>FING NEWS</h1>
	<a href="ListarNoticias">Listar Noticias</a>
	<a href="AgregarNoticia">Crear Noticias</a>
	<% if (request.getParameter("msg")!=null){
		if(request.getParameter("msg").equals("ok")){%>
		<h4>Publicacion creada con exito</h4>
	<%} else if (request.getParameter("msg").equals("oknoticia")) { %>
		<h4>Noticia creada con exito</h4>
	<%}else{ %>
		<h4>Error: Imposible de crear</h4>
	<%}} %>	
	
</body>
</html>