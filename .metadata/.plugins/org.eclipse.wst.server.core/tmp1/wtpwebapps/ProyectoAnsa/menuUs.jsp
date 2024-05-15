<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />

<sj:head jqueryui="true" jquerytheme="trontastic" />
<title>Menu Usuario</title>
<meta charset="UTF-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description" content="Creative CSS3 Animation Menus" />

<meta name="keywords"
	content="menu, navigation, animation, transition, transform, rotate, css3, web design, component, icon, slide" />

<meta name="author" content="Codrops" />
<link rel="icon" type="image/jpeg" href="imagenes/rodr-saav.jpeg">

<link rel="stylesheet" type="text/css" href="css/demo.css" />

<link rel="stylesheet" type="text/css" href="css/style9.css" />

</head>
<body>
	<%
HttpSession sesi = request.getSession();
String usuari;
String tip;
if(sesi.getAttribute("user")!=null && sesi.getAttribute("idtipo")!=null){
	usuari=sesi.getAttribute("user").toString();
	tip = sesi.getAttribute("idtipo").toString();
	
	
	
}else{
	out.print("<script>location.replace(index.jsp);</script>");
}
%>
	<div class="container">

		<div class="header">

			<%usuari=sesi.getAttribute("user").toString();
			out.print("<a href='index.jsp?cerrar=true'><h5>cerrar session: &nbsp "+usuari+"</h5></a>");
		
			%>


			<div class="clr"></div>

		</div>

		<h1>
			Ansa Sac<span>Te sientes mejor? viste mejor... empresa ansa
				innovaciòn dia a dia</span>
		</h1>

		<div class="content">

			<div class="more">



				<ul>

					<%-- <li ><a href="index2.html"  > Acerca de</a></li> --%>
					<sj:a openDialog="Ingresar" button="true" effect=""
						buttonIcon="uri-icon-newwin">Acerca de:</sj:a>
					<sj:dialog id="Ingresar" autoOpen="false" modal="true"
						title="Sistema Ansa" height="250" width="650">

						<marquee direction="up" scrolldelay="250"> ... texto
							...xdxdxdxdxdllllllllllllllllllllllertgrcftgrftrgtrf trgvtrgtrg
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjk
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrggygyfytfgggggggggggggggggggggggggggggggg
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrgklllllllllllllllllllllllllll
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrgjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrgjjjiiiiiiiiiiiiiiiiiiiiiiiii
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft
							trgvtrgtrghjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft trgvtrgtrg
							thfjgjhhgkjhkggukghjfnjfgrjkfhgjrhhfyjft </marquee>
					</sj:dialog>

				</ul>

			</div>
			<ul class="ca-menu">

				<li><a href="cargaMantemientoClienteXML"> <span
						class="ca-icon">A</span>

						<div class="ca-content">

							<h2 class="ca-main">Ventas</h2>

							<h3 class="ca-sub">Registro de ventas</h3>

						</div>

				</a></li>

				<li><a href="cargaMantemientoclientesXML"> <span
						class="ca-icon">I</span>

						<div class="ca-content">

							<h2 class="ca-main">Cliente</h2>

							<h3 class="ca-sub">Mantenimiento cliente</h3>

						</div>

				</a></li>

				<li><a href="#"> <span class="ca-icon">C</span>

						<div class="ca-content">

							<h2 class="ca-main">Infographical Education</h2>

							<h3 class="ca-sub">Understanding visually</h3>

						</div>

				</a></li>

				<li><a href="#"> <span class="ca-icon">S</span>

						<div class="ca-content">

							<h2 class="ca-main">Sophisticated Team</h2>

							<h3 class="ca-sub">Professionals in action</h3>

						</div>

				</a></li>

			</ul>

		</div>
		<!-- content -->

	</div>


</body>
</html>