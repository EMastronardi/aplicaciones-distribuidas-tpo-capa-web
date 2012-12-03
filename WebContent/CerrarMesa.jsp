<!DOCTYPE html>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="beans.MesaVO" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>
<body>
	<h1 id="MainTitle">Abrir Mesa</h1>
	<span class="user"><%="Usuario: "+ request.getSession().getAttribute("usuario")+ " - Sucursal: "+ request.getSession().getAttribute("sucursal")%></span>
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
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
<% List<MesaVO> mesas = AdministradorRMI.getInstancia().obtenerMesasOcupadas((String)request.getSession().getAttribute("sucursal"));%>
	<br>
	<div class="content">
		<form action="Controlador?action=confirmarCerrarMesa" method="post">
			<table>
				<tr>
					<td>Mesa</td>
					<td><Select name="mesa">
							<option>Seleccionar Mesa</option>
							<% for( MesaVO mesa : mesas){
								out.println("<option value='"+mesa.getIdMesa()+"'>"+mesa.getNumero()+"</option>");
							} %>
					</Select></td>
				</tr>
			</table>
			<hr width="500px" align="left"/>
		</form>
	</div>
	<!-- Body -->
</body>
</html>