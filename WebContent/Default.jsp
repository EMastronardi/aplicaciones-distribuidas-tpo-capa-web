<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Inicio</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
<link rel="stylesheet" type="text/css" href="styles/jquery.msgbox.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.msgbox.min.js"></script>
</head>
<body>
<h1 id="MainTitle">Inicio</h1>
	<span class="user"><%= "Usuario: "+request.getSession().getAttribute("usuario") + " - Sucursal: " + request.getSession().getAttribute("sucursal") %></span>	<!-- Menu -->
	<ul id="menu">
		<li><a href="Controlador?action=home">Inicio</a></li>
		<li><a class="selected">Mesa</a>
			<ul>
				<li><a href="Controlador?action=abrirMesa">Abrir Mesa</a></li>
				<li><a href="Controlador?action=cerrarMesa">Cerrar Mesa</a></li>
				<li><a href="Controlador?action=crearMesa">Crear Mesa</a></li>
			</ul></li>
		<li><a href="ControladorComanda?action=generarComanda">Generar Comanda</a></li>
		<li><a href="ControladorComanda?action=confirmarComandaRealizada">Confirmar Comanda</a></li>
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
	<!-- Fin Menu -->
	<% 
	String mensaje = request.getParameter("mensaje");
	if(mensaje != null && !mensaje.equals("")){
		%><script type="text/javascript">
		$(document).ready(function() {
			
		$.msgbox('<%= mensaje %>', {type: "info"});
		});
		</script> 
	<%}  %>
		
<!-- Body -->
</body>
</html>