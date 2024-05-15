<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/jpeg" href="imagenes/rodr-saav.jpeg">


<link href="css/estilos2.css" rel="stylesheet" type="text/css" />

<sj:head jqueryui="true" jquerytheme="trontastic" />
<title>Detalle de venta</title>
</head>
<body>

<center>
		<s:actionmessage cssStyle="color:black; background-color:white;" />
		<s:actionerror cssStyle="color:red;" />
	</center>
	<s:a href="cerrarSesionXML">Cerrar Sesion</s:a>
	<hr>
	<br>
	<h2>Detalles De Ventas Registradas</h2>
	<hr>
	
	<article>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
		<thead>
			<tr>
				<th>Nro Venta</th>
				<th>Producto</th>
				<th>Precio del producto</th>
				<th>Cantidad</th>
				<th>Fecha de venta</th>
				<th>Cliente</th>
				<th>Usuario</th>
			</tr>
		</thead>
		<s:iterator value="listadoDetalleVentaAction">
			<tr>
				<td><s:property value="venta.idventa"></s:property></td>
				<td><s:property value="producto.descripcion"></s:property></td>
				<td><s:property value="precio"></s:property></td>
				<td><s:property value="cantidad"></s:property></td>
				<td><s:property value="venta.fechaventa"></s:property></td>
				<td><s:property value="venta.dnicliente"></s:property></td>
				<td><s:property value="venta.dniusuario"></s:property></td>
			
			</tr>
		</s:iterator>
	</table></article>
	<abbr><b>Busqueda de Clientes</b>
	<s:form action="busquedaclienteIddXML">
		<s:textfield label="Id Busqueda" name="param"></s:textfield>
		<s:submit value="Buscar"></s:submit>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
		<thead>
			<tr>
				<th>dni cliente</th>
				<th>Nombres</th>
				<th>Apellidos</th>
				<th>Telefono</th>
				
			</tr>
		</thead>
		<s:iterator value="listadoclienteAction">
			<tr>
				<td><s:property value="dnicliente"></s:property></td>
				<td><s:property value="nombre"></s:property></td>
				<td><s:property value="apellido"></s:property></td>
				<td><s:property value="telefono"></s:property></td>
			
			</tr>
		</s:iterator>
	</table>
	</s:form>
	</abbr>
	<b>&nbsp; &nbsp;Busqueda de Usuarios</b>
	<abbr><s:form action="busquedausuarioIddXML">
		<s:textfield label="Id Busqueda" name="param"></s:textfield>
		<s:submit value="Buscar"></s:submit>

	</s:form>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
		<thead>
			<tr>
				<th>Dni usuario</th>
				<th>Tipo</th>
				<th>Usuario </th>
				<th>Contraseña</th>
				<th>Estado</th>
				<th>Nombre</th>
				
			</tr>
		</thead>
		<s:iterator value="listadoUsuarioAction">
			<tr>
				<td><s:property value="dniusuario"></s:property></td>
				<td><s:property value="tipo.idtipo"></s:property></td>
				<td><s:property value="usuario"></s:property></td>
				<td><s:property value="contraseña"></s:property></td>
				<td><s:property value="estado"></s:property></td>
				<td><s:property value="nombre"></s:property></td>
				
			
			</tr>
		</s:iterator>
	</table>
	</abbr>


</body>
</html>