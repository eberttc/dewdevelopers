<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Condominio - Registra Cuota</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.0.0.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
    <script>
       function validar(){
         var periodo = document.form1.periodo.value;        
         if(periodo.length!=6){
        	 alert('El formato del periodo es incorrecto (AÑOMES-YYYYMM)');
             return false;
         }
        	 
         return true;
       }
    </script>
    
  </head>

  <body>
    <jsp:include page="/pages/header.jsp" />    
	     
	 <div class="container"> 


<p><strong>Mantenimiento de Cuotas &gt; Nuevo</strong></p>
<form id="form1" name="form1" method="post" action="CuotaServlet?paramOpcion=insertar" onsubmit="validar()">
  <table width="100%" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td width="50%">Periodo a generar [YYYYMM]:</td>
      <td width="50%">
      	<label>
        <input  type="number" name="periodo" id="periodo"  required autofocus value="<%=request.getAttribute("paramPeriodo") %>">
      </label></td>
    </tr>
    <tr>
      <td>Importe de Pago:</td>
      <td><label>
        <input type="number" name="importepago" id="importepago" required autofocus />
      </label></td>
    </tr>
    <tr>
      <td>Id de Vivienda:</td>
      <td><label>
       
        <%@page import="java.util.*, com.upc.condominio.modelo.Vivienda" %>
	    <select name="slcvivienda" id="slcvivienda"  required autofocus>
      		<option></option>
        <%
        Collection<Vivienda> listavivienda = (ArrayList<Vivienda>)request.getAttribute("prmlistaVivienda");
		if(listavivienda!=null)			               
			for(Vivienda v:listavivienda){%> 
				<option value="<%=v.getN_IdVivi()%>"><%="ID: "+v.getN_IdVivi()+" - N°: " +v.getC_Numero() + " - Ubic.:"+ v.getC_Ubicacion()%>
				</option>
		<%} %>
        </select>
      </label></td>
    </tr>
    <tr>
      <td>Fecha de Vencimiento:</td>
      <td><label>
        <input id="fechaVcto" type="date" name="fechaVcto" value="2013-11-30"/>
      </label></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input id="btnGuardar" type="submit" value="Guardar"  class="btn btn-primary" />
      </td>
    </tr>
  </table> 
  <p>&nbsp;</p>
</form>


 <!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; Orlando Carril 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.0.0.js"></script>
  </body>
</html>