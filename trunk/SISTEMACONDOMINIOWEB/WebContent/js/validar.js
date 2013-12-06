function validarFechaMenorActual(fecha){
	var x=new Date(fecha);
	x.setFullYear(x.getFullYear(),x.getMonth(),x.getUTCDate());
	var today = new Date();
	
	if (x<today){
		document.getElementById("div_resultado").innerHTML = 
		"<div class=\"alert alert-danger\"><button type=\"button\" class=\"close\"	data-dismiss=\"alert\">&times;</button><b>ERROR!</b> No puede Seleccionar una fecha inferior a la de hoy.</div>"
	}
}