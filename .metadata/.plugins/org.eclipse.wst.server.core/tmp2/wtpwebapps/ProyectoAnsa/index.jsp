<%@page import="javax.swing.JOptionPane"%>
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

<script type="text/javascript">

/******************************************
* Snow Effect Script- By Altan d.o.o. (http://www.altan.hr/snow/index.html)
* Visit Dynamic Drive DHTML code library (http://www.dynamicdrive.com/) for full source code
* Last updated Nov 9th, 05' by DD. This notice must stay intact for use
******************************************/
  function openwindow(){
window.open("autumn_effect.htm","","width=350,height=500")

}

  //Configure below to change URL path to the snow image
  var snowsrc="snow.gif"
  // Configure below to change number of snow to render
  var no = 20;
  // Configure whether snow should disappear after x seconds (0=never):
  var hidesnowtime = 0;
  // Configure how much snow should drop down before fading ("windowheight" or "pageheight")
  var snowdistance = "pageheight";

///////////Stop Config//////////////////////////////////

  var ie4up = (document.all) ? 1 : 0;
  var ns6up = (document.getElementById&&!document.all) ? 1 : 0;

	function iecompattest(){
	return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
	}

  var dx, xp, yp;    // coordinate and position variables
  var am, stx, sty;  // amplitude and step variables
  var i, doc_width = 800, doc_height = 600; 
  
  if (ns6up) {
    doc_width = self.innerWidth;
    doc_height = self.innerHeight;
  } else if (ie4up) {
    doc_width = iecompattest().clientWidth;
    doc_height = iecompattest().clientHeight;
  }

  dx = new Array();
  xp = new Array();
  yp = new Array();
  am = new Array();
  stx = new Array();
  sty = new Array();
  snowsrc=(snowsrc.indexOf("")!=-1)? "snow.gif" : snowsrc
  for (i = 0; i < no; ++ i) {  
    dx[i] = 0;                        // set coordinate variables
    xp[i] = Math.random()*(doc_width-50);  // set position variables
    yp[i] = Math.random()*doc_height;
    am[i] = Math.random()*50;         // set amplitude variables
    stx[i] = 0.02 + Math.random()/50; // set step variables
    sty[i] = 0.7 + Math.random();     // set step variables
		if (ie4up||ns6up) {
      if (i == 0) {
        document.write("<div id=\"dot"+ i +"\" style=\"POSITION: absolute; Z-INDEX: "+ i +"; VISIBILITY: visible; TOP: 15px; LEFT: 15px;\"><a href=\"http://dynamicdrive.com\"><img src='"+snowsrc+"' border=\"0\"><\/a><\/div>");
      } else {
        document.write("<div id=\"dot"+ i +"\" style=\"POSITION: absolute; Z-INDEX: "+ i +"; VISIBILITY: visible; TOP: 15px; LEFT: 15px;\"><img src='"+snowsrc+"' border=\"0\"><\/div>");
      }
    }
  }

  function snowIE_NS6() {  // IE and NS6 main animation function
    doc_width = ns6up?window.innerWidth-10 : iecompattest().clientWidth-20;
		doc_height=(window.innerHeight && snowdistance=="windowheight")? window.innerHeight : (ie4up && snowdistance=="windowheight")?  iecompattest().clientHeight : (ie4up && !window.opera && snowdistance=="pageheight")? iecompattest().scrollHeight : iecompattest().offsetHeight;
	if (snowdistance=="windowheight"){
		doc_height = window.innerHeight || iecompattest().clientHeight
	}
	else{
		doc_height = iecompattest().scrollHeight
	}
    for (i = 0; i < no; ++ i) {  // iterate for every dot
      yp[i] += sty[i];
      if (yp[i] > doc_height-50) {
        xp[i] = Math.random()*(doc_width-am[i]-30);
        yp[i] = 0;
        stx[i] = 0.02 + Math.random()/20;
        sty[i] = 0.7 + Math.random();
      }
      dx[i] += stx[i];
      document.getElementById("dot"+i).style.top=yp[i]+"px";
      document.getElementById("dot"+i).style.left=xp[i] + am[i]*Math.sin(dx[i])+"px";  
    }
    snowtimer=setTimeout("snowIE_NS6()", 10);
  }

	function hidesnow(){
		if (window.snowtimer) clearTimeout(snowtimer)
		for (i=0; i<no; i++) document.getElementById("dot"+i).style.visibility="hidden"
	}
		

if (ie4up||ns6up){
    snowIE_NS6();
		if (hidesnowtime>0)
		setTimeout("hidesnow()", hidesnowtime*1000)
		}

</script>
<style>
/* valores genericos para los copos */
.copo {
	background-color: #00f;
	color: #fff;
	position: relative;
	z-index: 0;
}
/* definimos los 4 tipos de copos */
.copo1 {
	height: 1px;
	width: 1px;
}

.copo2 {
	height: 2px;
	width: 2px;
}

.copo3 {
	height: 3px;
	width: 3px;
	border-radius: 2px;
}

.copo4 {
	height: 4px;
	width: 4px;
	border-radius: 3px;
}
</style>
<script>
        var anchuraMax=0;
        var alturaMax=0;
        var copos=new Array;
 
        /**
         * Funcion inicial
         * Tiene que recibir:
         *  numeroCopos a mostrar
         *  anchura y altura por donde aparecen los copos
         *  velocidad de movimiento de los mismos
         */
        function inicializar(numeroCopos, anchura, altura, velocidad)
        {
            var i, x, y;
            copos = new Array(numeroCopos);
            for (i = 0; i<numeroCopos; i++)
            {
                x = parseInt(Math.random()*anchura);
                y = parseInt(Math.random()*altura);
                dibujaCopo(i,x,y);
                copos[i] = document.getElementById("c"+i);
            }
            alturaMax = altura;
            anchuraMax = anchura;
            setInterval(nevar, velocidad);
        }
 
        // Funci�n inicial que dibuja los copos en la pantalla
        function dibujaCopo(numeroCopo, x, y)
        {
            var tamano = Math.floor(Math.random()*4)+1;
            document.write('<div id="c'+numeroCopo+'" class="copo copo'+tamano+'" style="left:'+x+'px; top:'+y+'px;"></div>');
        }
 
        // Funci�n que controla el movimiento de los copos por la pantalla
        function nevar()
        {
            var i, x, y;
            for (i = 0; i < copos.length; i++)
            {
                // cogemos las posiciones de cada elemento
                y = parseInt(copos[i].style.top);
                x = parseInt(copos[i].style.left);
 
                y+=Math.floor(Math.random()*4)+1;
                copos[i].style.top = y;
 
                // si ha llegado al final de la pantalla
                if(y>document.body.scrollTop+alturaMax)
                {
                    // posicionamos nuevamente en la parte superior
                    copos[i].style.top = document.body.scrollTop-(Math.round(Math.random()*10)+1);
                    // cogemos una posicion horizontal aleatoria
                    copos[i].style.left=parseInt((Math.random()*anchuraMax)+1);
                }
            }
        }
    </script>

<sj:head jqueryui="true" jquerytheme="trontastic" />

<title>Bienvenido Al Sistema Ansa</title>
</head>
<body background="imagenes/f.jpg"
	style="background-repeat: no-repeat; background-position: center"
	bgproperties="fixed">
	<center>
		<header>

		<div class="image">

			<img src="imagenes/mision.jpg" alt="Ansa SAC">

		</div>
		</header>
	</center>
	<p align="center">
		<u><EM><font size="10">Empresa Textil: Ansa </font></em></u>
	</p>
	<br>
	<br>
	<p align="center">
		<TT>
			<font size="4"> Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum
				sociis natoque penatibus et magnis dis parturient montes, nascetur
				ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
				pretium quis, sem. Nulla consequat massa quis enim. Donec pede
				justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim
				justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam
				dictum felis eu pede mollis pretium. Integer tincidunt. Cras
				dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend
				tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
				ac, enim. </font>
		</tt>
	</p>
	<br>
	<br>
	<br>
	<center>

		<sj:a openDialog="Ingresar" button="true" effect=""
			buttonIcon="uri-icon-newwin">Intranet</sj:a>
		<sj:dialog id="Ingresar" autoOpen="false" modal="true"
			title="Bienvenido Al Sistema Ansa" height="350" width="700">
			<br>
			<center>
				<s:form action="validaUsuarioXML">
					<s:textfield label="Usuario" name="usu"></s:textfield>
					<s:password label="Contrase�a" name="contra"></s:password>
					<label>TIpo Usuario: </label> &nbsp; &nbsp;  &nbsp;  &nbsp;
            <select name="tipou">
						<OPTION VALUE="usuario">Usuario</OPTION>
						<OPTION VALUE="administrador">Administrador</OPTION>
					</select>
					<br>
					<br>
					<sj:submit value="Enviar" button="true"></sj:submit>

				</s:form>
			</center>
			<br>
			<br>
			<br>
			<MARQUEE BEHAVIOR=alternate> Ingrese su usuario y
				contrase�a </MARQUEE>
		</sj:dialog>
	</center>
	<sj:dialog id="ventanaActualizacion" autoOpen="true" modal="false"
		title="Sistema Ansa" height="200" width="400">
		<marquee direction="up" scrolldelay="250">
			<hr>
			Bienvenido Al Sistema Ansa
			<hr>
		</marquee>
	</sj:dialog>

	<s:actionerror cssStyle="color:red;" />


	<script>
inicializar(40, 1300, 50, 300, 300, 800);
</script>


</body>
</html>