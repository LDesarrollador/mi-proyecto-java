<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body>
	<s:actionmessage />
	<s:actionerror />
	<s:form action="actualizaclienteXML">
		<s:hidden label="Dni" value="%{clientes.dnicliente}" name="dni"></s:hidden>

		<s:textfield label="Nombres" value="%{clientes.nombres}" name="nombre"></s:textfield>
		<s:textfield label="Apellidos" value="%{clientes.apellidos}"
			name="apellido"></s:textfield>
		<s:textfield label="Telefono" value="%{clientes.telefono}"
			name="telefono"></s:textfield>
		<s:submit value="Enviar"></s:submit>
		<s:reset value="Borrar"></s:reset>
	</s:form>
</body>
</html>