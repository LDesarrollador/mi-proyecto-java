<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>probando</title>
</head>
<body>
	<div>

		contenido de prueba
		<div class="encabezado">
			<img src="img-encabezado.png" alt="image" height="100px"
				width="1152px">
		</div>

		<div class="contenido">

			<div class="menu">
				<ul>
					<li><a href="ejercicio1.html" target="formularios">Ejercicio1</a></li>
				</ul>
				<ul>
					<li><a href="ejercicio2.html" target="formularios">Ejercicio1</a></li>
				</ul>
			</div>

			<div class="principal">
				<h2>Div de contenido, aqui se mostraran las paginas HTML</h2>
				<iframe src="principal.html" style="width: 90%; height: 80%"
					name="formularios"></iframe>
			</div>

		</div>
</body>
</html>