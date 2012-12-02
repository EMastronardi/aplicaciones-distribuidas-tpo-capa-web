<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />
</head>
<body>
<h1 id="MainTitle">Cerrar Mesa</h1>
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
<!-- Body -->
</body>
</html>