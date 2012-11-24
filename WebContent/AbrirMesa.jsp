<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante - Mesa</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css" />

</head>
<body>
	<h1 id="MainTitle">Abrir Mesa</h1>
	<!-- Menu -->
	<ul id="menu">
		<li><a href="Home.html">Inicio</a></li>
		<li><a class="selected">Mesa</a>
			<ul>
				<li><a href="AbrirMesa.html">Abrir Mesa</a></li>
				<li><a href="CerrarMesa.html">Cerrar Mesa</a></li>
				<li><a href="CrearMesa.html">Crear Mesa</a></li>
			</ul></li>
		<li><a href="GenerarComanda.html">Generar Comanda</a></li>
		<li><a href="#">Salir</a></li>
	</ul>
	<!-- Fin Menu -->
	<br>
	<div class="content">
		<form action="Controlador?action=abrirMesa" method="post">
			<div style="float: left;">
				<p>
					<label>Sucursal</label>
				</p>
				<p>
					<label>Mesas</label>
				</p>
				<p>
					<label>Mozo</label>
				</p>
				<p>
					<label>Personas</label>
				</p>
			</div>
			<div style="float: left">
				<p>
					<SELECT name="Sucursal">
						<OPTION VALUE="Belgrano">Belgrano</OPTION>
						<OPTION VALUE="Caballito">Caballito</OPTION>
						<OPTION VALUE="Puerto Madero">Puerto Madero</OPTION>
					</SELECT>
				</p>
				<p>
					<SELECT name="mesa">
						<OPTION VALUE="1">1</OPTION>
						<OPTION VALUE="2">2</OPTION>
						<OPTION VALUE="3">3</OPTION>
					</SELECT>
				</p>
				<p>
					<SELECT name="mozo">
						<OPTION VALUE="Jose">Jose</OPTION>
						<OPTION VALUE="Juan">Juan</OPTION>
						<OPTION VALUE="Carlos">Carlos</OPTION>
					</SELECT>
				</p>
				<p>
					<input type="text" />
				</p>
			</div>
			<div style="clear: both;"></div>
			<input type="submit" value="Abrir" />
		</form>
	</div>
	<!-- Body -->
</body>
</html>