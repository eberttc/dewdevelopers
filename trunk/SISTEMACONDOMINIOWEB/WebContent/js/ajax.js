/*
*Esta libreria es una libreria AJAX creada por Javier Mellado con la inestimable
*colaboracion de Beatriz Gonzalez.
*y descargada del portal AJAX Hispano oAjax://www.ajaxhispano.com
*contacto javiermellado@gmail.com
*
*Puede ser utilizada, pasada, modificada pero no olvides mantener
*el espiritu del software libre y respeta GNU-GPL
*/ 

function creaAjax() {
var req;
try {
	req = new XMLHttpRequest();
} catch(err1) {
	try {
		req = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (err2) {
		try {
			req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (err3) {
				req = false;
			}
		}
	}
	return req;
}

oAjax = creaAjax();
function validarFechaMenorActual(fecha){
	var x=new Date(fecha);
	x.setFullYear(x.getFullYear(),x.getMonth(),x.getUTCDate());
	var today = new Date();
	
	if (x<today){
		document.getElementById("div_resultado").innerHTML = 
		"<div class=\"alert alert-warning\"><button type=\"button\" class=\"close\"	data-dismiss=\"alert\">&times;</button><b>ERROR!</b> No puede Seleccionar una fecha inferior a la de hoy.</div>"
		document.getElementById("fc_espacioComun").selectedIndex = 0;
		document.getElementById("fc_espacioComun").disabled = true;
	}else{
		document.getElementById("fc_espacioComun").disabled = false;
		listarHorarioDisponible('listarHorarios.jsp','&fecha='+document.getElementById('fc_fechaReserva').value,'&ec='+document.getElementById('fc_espacioComun').value,'div_resultado')
	}
}
function listarHorarioDisponible(archivo,ec,fecha,divid){
	
	//	alert(ec+fecha);
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + ec+fecha	; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = listarHorarioDisponibleRespuesta;
	oAjax.send(null);
}

function listarHorarioDisponibleRespuesta() {
	if (oAjax.readyState == 4) {	
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<div class=\"alert alert-warning\">Esperando...</div>";
	}

}

function fAjax(archivo,vars,divid){
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + vars; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = rAjax;
	oAjax.send(null);
}

function rAjax() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}
}
/**----------------------*/
function ver_articulo(archivo,vars,divid){
	//alert('hola');
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + vars; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = articulo_respuesta;
	oAjax.send(null);
}

function articulo_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}
/**----------------------*/

/**----------------------*/
function captura_np(archivo,vars,NC,divid){
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + vars+NC; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = captura_np_respuesta;
	oAjax.send(null);
}

function captura_np_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/**----------------------*/
function sumartot(archivo,vars,np,divid){
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + vars+np; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = sumartot_respuesta;
	oAjax.send(null);
}

function sumartot_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/**----------------------*/
function actualiza_cant(archivo,cad,cant,divid){
	//alert(cant+cad);
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + cad+cant; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = actualiza_cant_respuesta;
	oAjax.send(null);
}

function actualiza_cant_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/****************************************************/
function actualiza_cant_pro(archivo,cad,cant,divid){
	//alert(cant+cad);
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + cad+cant; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = actualiza_cant_pro_respuesta;
	oAjax.send(null);
}

function actualiza_cant_pro_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/**************Busca Cotizacion por cliente para OT**************/

function buscar_cot_ot(archivo,cad,divid){
	//alert(cad);
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + cad; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = buscar_cot_ot_respuesta;
	oAjax.send(null);
}

function buscar_cot_ot_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/**************Busca OT por cliente para FACTURA**************/


function buscar_ot_factura(archivo,cad,divid){
	//alert(cad);
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + cad; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = buscar_ot_factura_respuesta;
	oAjax.send(null);
}

function buscar_ot_factura_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

/**********ENVIA MENSAJE RANGO PRECIO TOTAL PROYECTO*************/

function mensaje(archivo,cad,divid){
	alert(cad);
	/*myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + cad; 
	oAjax.open("GET", modurl, true);
	mydiv = divid;
	oAjax.onreadystatechange = mensaje_respuesta;
	oAjax.send(null);*/
}

function mensaje_respuesta() {
	if (oAjax.readyState == 4) {
		if(oAjax.status == 200) {
			var miTexto = oAjax.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	}else{
		document.getElementById(mydiv).innerHTML = "<img src='carga_barra.gif'>";
	}
}

