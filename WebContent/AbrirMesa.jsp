<!DOCTYPE html>
<%@page import="beans.SucursalVO"%>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="servlets.Controlador"%>

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
	<span class="user"><%="Usuario: "+ request.getSession().getAttribute("usuario")
					+ " - Sucursal: "+ request.getSession().getAttribute("sucursal")%></span>
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
		<form action="Controlador?action=confirmarAbrirMesa" method="post">
			<table>
				<tr>
					<td>
						<label>Mesas</label>
					</td>
					<td>
						<span style="font-size: 9px; font-family: Verdana, Arial, Sans-Serif"> nros (separados por coma): </span>
						<input name="nrosMesa" type="text" style="width: 153px; "/>
					</td>
				</tr>
				<tr>
					<td>
						<label>Cantidad Comenzales</label>
					</td>
					<td>
						<input name="cantComenzales" type="text" style="width: 154px; "/>
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