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
  </head>

  <body>
    <jsp:include page="/pages/header.jsp" />    
	     
	 <div class="container"> 


<p><strong>Mantenimiento de Cuotas &gt; Nuevo</strong></p>
<form id="form1" name="form1" method="post" action="CuotaServletRegistrar">
  <table width="300" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td width="300">Periodo a generar [YYYYMM]:</td>
      <td><label>
        <input type="text" name="periodo" id="periodo" />
      </label></td>
    </tr>
    <tr>
      <td>Importe de Pago:</td>
      <td><label>
        <input type="text" name="importepago" id="importepago" />
      </label></td>
    </tr>
    <tr>
      <td>Id de Vivienda:</td>
      <td><label>
        <input type="text" name="idvivienda" id="idvivienda" />
      </label></td>
    </tr>
    <tr>
      <td>Fecha de Vencimiento:</td>
      <td><label>
        <input id="fechaVcto" type="date" name="fechaVcto" value="2013-11-30"/>
      </label></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Guardar"  class="btn btn-primary" />
        <input type="button" value="Regresar" onclick="window.location='CuotaListar.jsp' " />
      </td>
    </tr>
  </table> 
  <p>&nbsp;</p>
</form>


 <!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; Ocarril 2014 </p>
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