<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/jpeg" href="imagenes/rodr-saav.jpeg">


<link href="css/hoja2.css" rel="stylesheet" type="text/css" />

<sj:head jqueryui="true" jquerytheme="trontastic" />
<title>Sistema Ansa</title>

<s:a href="cerrarSesionXML">Cerrar Sesion </s:a>





</head>
<body>
	<center>
		<s:actionmessage cssStyle="color:black; background-color:white;" />
		<s:actionerror cssStyle="color:red;" />
	</center>
	<td><article>

		<hr>
		<b>Buscar cliente</b> <s:form action="busquedaClienteDniXML">
			<sj:textfield label="Dni" name="param"></sj:textfield>
			<sj:submit value="Buscar"></sj:submit>

		</s:form> <a href="cargaMantemientoClienteXML"><input
			value="Mostrar todos los clientes" type="submit"></a>
		<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
			<p>Datos del cliente</p>
			<thead>
				<tr>
					<th>Dni:</th>
					<th>Nombres:</th>
					<th>Apellidos:</th>
					<th>Telefono:</th>

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
		<br>

		</article></td>

	<abbr>

		<p align="center">Buscar producto</p> <s:form
			action="busquedaProductoXML">
			<sj:textfield label="Producto" name="parame"></sj:textfield>
			<sj:submit value="Buscar"></sj:submit>

		</s:form> <br> <a href="cargalistProductoXML"><input
			value="Mostrar todos los productos" type="submit"></a>
		<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
			<p>Datos del producto</p>
			<thead>
				<tr>
					<th>Id Producto</th>
					<th>categoria</th>
					<th>descripcion</th>
					<th>Precio</th>
					<th>Stock</th>

				</tr>
			</thead>
			<s:iterator value="listadoProductoAction">
				<tr>
					<td><s:property value="idProducto"></s:property></td>
					<td><s:property value="categoria.descripcion"></s:property></td>
					<td><s:property value="descripcion"></s:property></td>
					<td><s:property value="precio"></s:property></td>
					<td><s:property value="stock"></s:property></td>
				</tr>
			</s:iterator>
		</table>

	</abbr>

	<abbr>
		<p align="center">Registrar venta</p> <s:form action="ingresoventaXML"
			align="left">
			<s:textfield class="nrov" label="Nro Venta" name="id"></s:textfield>
			<s:textfield label="Fecha" name="fecv"></s:textfield>
			<s:textfield label="Dni Cliente" name="dc"></s:textfield>
			<s:textfield label="Dni Ususario" name="du"></s:textfield>
			<s:submit value="Enviar" align="left"></s:submit>


		</s:form> <br>
		<p align="center">Detalle</p> <s:form action="ingresodetalleventaXML"
			align="left">
			<s:textfield label="Nro Venta" name="nroventa"></s:textfield>

			<s:textfield label="Id producto" name="idpro"></s:textfield>
			<s:textfield label="Precio" name="pre"></s:textfield>
			<s:textfield label="Cantidad" name="can"></s:textfield>
			<s:submit value="Guardar" align="left"></s:submit>

		</s:form> <a href="menuUs.jsp"><input type=image
			src="imagenes/btnatras.gif" width="55" height="25"
			title="Volver al menu" align="center"></a>

	</abbr>

</body>

</html>