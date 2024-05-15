<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Producto</title>
</head>
<body>
	<s:actionmessage cssStyle="color:blue; background-color:white;" />
	<s:actionerror cssStyle="color:red;" />


	<hr>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
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
	<hr>
	<b>Ingreso de nuevo producto</b>
	<s:form action="ingresoProductoXML">
		<s:select label="Categoria" name="idcat" list="listadoCategoriaAction"
			listKey="idCategoria" listValue="descripcion"></s:select>
		<s:textfield label="descripcion" name="des"></s:textfield>
		<s:textfield label="precio" name="pre"></s:textfield>
		<s:textfield label="stock" name="stock"></s:textfield>
		<s:submit value="Enviar"></s:submit>
		<s:reset value="Borrar"></s:reset>
	</s:form>
	<hr>
	<b>Busqueda de productos</b>
	<s:form action="busquedaProductoNombresXML">
		<s:textfield label="busqueda" name="param"></s:textfield>
		<s:submit value="Buscar"></s:submit>
		<s:reset value="Borrar"></s:reset>
	</s:form>
	<hr>
</body>
</html>