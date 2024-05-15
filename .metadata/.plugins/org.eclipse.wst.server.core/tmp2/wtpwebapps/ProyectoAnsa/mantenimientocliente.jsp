<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/jpeg" href="imagenes/rodr-saav.jpeg">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

<sj:head jqueryui="true" jquerytheme="ui-darkness" />
<title>Mantenimiento Cliente</title>
</head>
<body>
<s:a href="cerrarSesionXML">Cerrar Sesion </s:a>

	<div align="center">
		<s:actionmessage cssStyle="color:blue; background-color:yellow;" />
		<s:actionerror cssStyle="color:red;" />

		<sj:a openDialog="ventanaIngreso" button="true"
			buttonIcon="uri-icon-newwin">Nuevo cliente</sj:a>
		<sj:dialog id="ventanaIngreso" autoOpen="false" modal="true"
			title="Ingreso cliente" height="300" width="600">
			<s:form action="ingresoClienteXML">

				<s:textfield label="Dni cliente" name="dni"></s:textfield>
				<s:textfield label="Nombres" name="nombre"></s:textfield>
				<s:textfield label="Apellidos" name="apellido"></s:textfield>
				<s:textfield label="Telefono" name="telefono"></s:textfield>

				<s:submit value="Enviar"></s:submit>
				<s:reset value="Borrar"></s:reset>
			</s:form>
		</sj:dialog>
		<hr>

	</div>

	<b>Buscar cliente</b>
	<s:form action="busquedaClienteNombreXML">
		<sj:textfield label="Buscar Nombre" name="nombre"></sj:textfield>
		<sj:submit value="Buscar"></sj:submit>

	</s:form>

	<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633">
		<p>Datos del cliente</p>
		<thead>
			<tr>
				<th>Dni:</th>
				<th>Nombres:</th>
				<th>Apellidos:</th>
				<th>Telefono:</th>
				<th>Actualizar:</th>
			</tr>
		</thead>
		<s:iterator value="listadoclienteAction">
			<tr>
				<td><s:property value="dnicliente"></s:property></td>
				<td><s:property value="nombre"></s:property></td>
				<td><s:property value="apellido"></s:property></td>
				<td><s:property value="telefono"></s:property></td>
				<td align="center"><s:url id="url1" action="buscaclienteObjXML">
						<s:param name="dni">
							<s:property value="dnicliente"></s:property>
						</s:param>
					</s:url> <sj:a href="%{url1}" openDialog="ventanaActualizacion">
						<img src="imagenes/update.png" />
					</sj:a></td>

			</tr>
		</s:iterator>
	</table>
	
<sj:dialog id="ventanaActualizacion" autoOpen="false" modal="true"
		title="Actualizacion Usuarios" height="400" width="600">
		
		<s:form action="actualizaclienteXML">
		<s:hidden label="Dni cliente" value="%{cliente.dnicliente}" name="dni"></s:hidden>
		
		<s:textfield label="Nombres" value="%{cliente.nombre}"
			name="nombre"></s:textfield>
		<s:textfield label="Usuario" value="%{cliente.apellido}"
			name="apellido"></s:textfield>
		<s:textfield label="telefono" value="%{cliente.telefono}" name="cla"></s:textfield>
		<s:submit value="Enviar"></s:submit>
		<s:reset value="Borrar"></s:reset>
	</s:form>
  </sj:dialog>
   <a href="menuUs.jsp"><input type=image
			src="imagenes/btnatras.gif" width="55" height="25"
			title="Volver al menu" align="center"></a>

</body>
</html>