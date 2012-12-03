<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="beans.SucursalVO"%>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="servlets.Controlador"%>
<%@page import="java.util.*"%>
<%@page import="beans.PlatoVO" %>
<%@page import="beans.ComandaVO" %>

<%  
	List<ComandaVO> comandas = AdministradorRMI.getInstancia().obtenerComandasAbiertas((String)request.getSession().getAttribute("sucursal"));
%> 			
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Confirmar Comanda</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>

<body>
<h1 id="MainTitle">Confirmar Comanda</h1>
	<span class="user"><%= "Usuario: "+request.getSession().getAttribute("usuario") + " - Sucursal: " + request.getSession().getAttribute("sucursal") %></span>	
	<!-- Menu -->
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
	<hr width="500px" align="left">
	<form action="ControladorComanda?action=confirmarComandaRealizada">
	<table style="font-size:12px;">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td>
			<table border="0" id="tablaData">
				<tr>
					<td>Comanda</td>
					<td><Select name="comanda"><option>Seleccionar Comanda</option>
					<% for( ComandaVO comanda : comandas){
								out.println("<option value='"+comanda.getIdComanda()+"'>"+comanda.getIdComanda()+"</option>");
					} %>
					</Select></td>
					</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
			<hr width="500px" align="left"/>
				<!-- Botones -->
				<table align="center" border="0">
				<tr>
					<td><input type="submit" name="confirmar" value="Confirmar"></td>
					<td></td>
					<td><input type="reset" name="cancelar" value="Cancelar"></td>
				</tr>
				</table>
			</td>
		</tr>
	</table>
	</form>
	<hr width="500px" align="left"/>
<!-- Body -->
</body>
</html>