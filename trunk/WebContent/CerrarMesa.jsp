<!DOCTYPE html>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="beans.VentaVO" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>

<%  
	List<VentaVO> ventas = AdministradorRMI.getInstancia().obtenerVentas((String)request.getSession().getAttribute("sucursal"), (String)request.getSession().getAttribute("usuario"));
%> 	

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
		<li><a href="ControladorComanda?action=ConfirmarComanda">Confirmar Comanda</a></li>
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
	<br>
	<div class="content">
		<form action="Controlador?action=confirmarCerrarMesa" method="post">
			<table>
				<tr>
					<td>Mesa</td>
					<td><Select name="mesa">
							<option>Seleccionar Mesa</option>
							<% for( VentaVO venta : ventas){
								out.println("<option value='"+venta.getIdVenta()+"'>"+venta.getNroMesa()+"</option>");
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