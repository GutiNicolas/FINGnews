<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="Bussines.dtNoticia" %>
    <%@page import="Bussines.dtPublicacion" %>
<!DOCTYPE html>
<html>
<head>
	<%dtNoticia noticia = (dtNoticia) request.getAttribute("noticia"); %>
<meta charset="UTF-8">
<title><%= noticia.titulo %></title>
</head>
<body>
	<h2><%= noticia.titulo %></h2>
	<h4><%= noticia.descripcion %></h4><br>
	<a>----------------------------------------------</a><br>
	<h4>Publicaciones:</h4><br>
	<%List<dtPublicacion> publicaciones = (List<dtPublicacion>) request.getAttribute("publicaciones");
	for (dtPublicacion dtp : publicaciones) {%>
		<div>
			<a href="<%=dtp.url%>">[<%= dtp.tipo %>] <%=dtp.url %></a>
		</div>
	<%} %>
	<a href="index.jsp">Inicio</a>
</body>
</html>