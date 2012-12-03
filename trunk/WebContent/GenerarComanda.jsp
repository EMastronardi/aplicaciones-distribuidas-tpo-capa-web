<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="beans.SucursalVO"%>
<%@page import="modelo.AdministradorRMI"%>
<%@page import="servlets.Controlador"%>
<%@page import="java.util.*"%>
<%@page import="beans.PlatoVO" %>
<%@page import="beans.VentaVO" %>

<%  
	List<PlatoVO> platos = AdministradorRMI.getInstancia().obtenerPlatos((String)request.getSession().getAttribute("sucursal")); 
	List<VentaVO> ventas = AdministradorRMI.getInstancia().obtenerVentas((String)request.getSession().getAttribute("sucursal"), (String)request.getSession().getAttribute("usuario"));
%> 			
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Comanda</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>
<script>
var cantElement=0;
function addElement(){
	var newTR = document.createElement("tr");
	newTR.innerHTML = document.getElementById("firstId").innerHTML;	
	newTR.cells[4].innerHTML="";		
	var tab = document.getElementById("tablaData");
	tab.appendChild(newTR);
}

</script>
<body>
<h1 id="MainTitle">Generar Comanda</h1>
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
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
	<!-- Fin Menu -->
	<hr width="500px" align="left">
	<form action="ControladorComanda?action=confirmarComanda">
	<table style="font-size:12px;">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td>
			<table border="0" id="tablaData">
				<tr>
					<td>Mesa</td>
					<td><Select name="mesa"><option>Seleccionar Mesa</option>
					<% for( VentaVO venta : ventas){
								out.println("<option value='"+venta.getIdVenta()+"'>"+venta.getNroMesa()+"</option>");
					} %>
					</Select></td>
					<td></td>
					<td></td>		
				<td></td>	
				</tr>
				<tr id="firstId">	
					<td>Producto</td>
					<td>
						<Select name="producto">
							<option>Seleccionar Producto</option>
							<% for( PlatoVO plato : platos){
								out.println("<option value='"+plato.getIdPlato()+"'>"+plato.getNombre()+"</option>");
							} %>
						</Select>
					</td>
					<td>Cantidad</td>
					<td>
						<select><% for(int i =1; i<=100; i++){%><option value="<%=i%>"><%=i%></option><%}%></select>
					</td>
					<td><input type="button" name="mas" value="+" onclick="addElement()"/></td>			
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
			<td>
		<tr>
	</table>
	</form>
	<hr width="500px" align="left"/>
<!-- Body -->
</body>
</html>