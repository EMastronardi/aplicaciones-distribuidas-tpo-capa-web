<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>
<body>
	<h1 id="MainTitle">Crear Mesa</h1>
	<span class="user"><%="Usuario: "
					+ request.getSession().getAttribute("usuario")
					+ " - Sucursal: "
					+ request.getSession().getAttribute("sucursal")%></span>
	<!-- Menu -->
	<ul id="menu">
		<li><a href="Home.jsp">Inicio</a></li>
		<li><a class="selected">Mesa</a>
			<ul>
				<li><a href="AbrirMesa.jsp">Abrir Mesa</a></li>
				<li><a href="CerrarMesa.jsp">Cerrar Mesa</a></li>
				<li><a href="CrearMesa.jsp">Crear Mesa</a></li>
			</ul></li>
		<li><a href="GenerarComanda.jsp">Generar Comanda</a></li>
		<li><a href="Controlador?action=salir">Salir</a></li>
	</ul>
	<!-- Fin Menu -->
	<!-- Body -->
</body>
</html>