<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="Bussines.dtNoticia" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Noticias</title>
</head>
<body>
	<h1>NOTICIAS</h1>
	<%List<dtNoticia> noticias = (List<dtNoticia>) request.getAttribute("noticias"); 
	for(dtNoticia dtn : noticias){
	%>
		<div>
		<a class="noticia">
                    <%=dtn.titulo%>  (<%=dtn.descripcion%>)
        </a><br>
        <a href="ListarPublicaciones?nid=<%=dtn.id%>">Ver publicaciones</a>   <a href="AgregarPublicacion?nid=<%=dtn.id%>">Agregar publicacion</a><br>
        </div>
	<%} %>
	<a href="index.jsp">Inicio</a>
</body>
</html>