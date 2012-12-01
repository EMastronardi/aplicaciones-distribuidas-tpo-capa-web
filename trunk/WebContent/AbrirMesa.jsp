<!DOCTYPE html>
<%@page import="beans.SucursalVO"%>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="servlets.Controlador"%>
<%@page import="java.util.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
<script type="text/javascript">

</script>
</head>
<body>
	<h1 id="MainTitle">Abrir Mesa</h1>
	<span><%=request.getSession().getAttribute("usuario") + " - " + request.getSession().getAttribute("sucursal")%></span>
	<!-- Menu -->
	<ul id="menu">
		<li><a href="Controlador?action=home">Inicio</a></li>
		<li><a class="selected">Mesa</a>
			<ul>
				<li><a href="Controlador?action=abrirMesa">Abrir Mesa</a></li>
				<li><a href="Controlador?action=cerrarMesa">Cerrar Mesa</a></li>
				<li><a href="Controlador?action=crearMesa">Crear Mesa</a></li>
			</ul></li>
		<li><a href="Controlador?action=generarComanda">Generar Comanda</a></li>
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
	<!-- Fin Menu -->
	<%
		//List<SucursalEntity> lista = AdministradorSucursales.getInstancia().obtenerSucursales();
			//SucursalEntity suc;
			//String cadena = AdministradorSucursales.getInstancia().obtenerCadena();
	%>
	
	
	<br>
	<div class="content">
		<form action="Controlador?action=abrirMesaServer" method="post">
			<table>
				<tr>
					<td>
						<label>Mesas</label>
					</td>
					<td>
						<span> nros (separados por coma): </span>
						<input id="nrosMesa" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<label>Cantidad Comenzales</label>
					</td>
					<td>
						<input id="cantComenzales" type="text" />
					</td>
				</tr>
			</table>
			<div style="clear: both;"></div>
			<input type="submit" value="Abrir" />
		</form>
	</div>
	<!-- Body -->
</body>
</html>