<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Condominio - Pagar Cuota Emitida</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.0.0.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
    <script>
       function validar(){
         var periodo = document.form1.txtPeriodo.value;        
         if(periodo.length!=6){
        	 alert('El formato del periodo es incorrecto (AÑOMES-YYYYMM)');
             return false;
         }
      
        return true;	 
       }
       
    function ConfirmarPago() {

        	 if(confirm("¿Estas seguro de confirmar pago de la cuota?")) {
        	 	document.location.href= 'http://SISTEMACONDOMINIOWEB/CuotaServlet?paramOpcion=pagos';

   	 }
       
    </script>
    
  </head>

  <body>
    <jsp:include page="/pages/header.jsp" />    
	     
	 <div class="container"> 


<p><strong>PAGO de Cuota - Cancelar</strong></p>
<form id="form1" name="form1" method="post" action="CuotaServlet?paramOpcion=pagar" onsubmit="validar()">
  <table width="100%" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td width="50%">Periodo a PAGAR [YYYYMM]:</td>
      <td width="50%">
      	<label>
        <input  type="number" name="txtPeriodo" id="txtPeriodo"   size="100px" required autofocus  disabled="disabled" value="<%=request.getAttribute("txtPeriodo") %>">
        <input  type="hidden" name="txtIdVivienda" id="txtIdVivienda" value="<%=request.getAttribute("txtIdVivienda") %>">
        <input  type="hidden" name="txtIdCuota" id="txtIdCuota" value="<%=request.getAttribute("txtIdCuota") %>">
      </label></td>
    </tr>
    <tr>
      <td>Importe de Pago:</td>
      <td><label>
        <input type="text" name="txtImportePago" id="txtImportePago" disabled="disabled" value="<%=request.getAttribute("txtImportePago") %>"/>
      </label></td>
    </tr>
   
    <tr>
       <td>Tipo de Pago:</td>
      <td><label>
       
        <%@page import="java.util.*, com.upc.condominio.modelo.TipoPago" %>
	    <select name="slcTipoPago" id="slcTipoPago"  required autofocus>
      		<option></option>
        <%
        Collection<TipoPago> listaTipoPago = (ArrayList<TipoPago>)request.getAttribute("prmlistaTipoPago");
		if(listaTipoPago!=null)			               
			for(TipoPago tp:listaTipoPago){%> 
				<option value="<%=tp.getnTipoPago()%>"><%=tp.getcDescri()%>
				</option>
		<%} %>
        </select>
      </label></td>
    </tr>
     <tr>
      <td>Residente:</td>
      <td><label>
       	<input id="txtResidente" type="text" name="txtResidente"  size="100px"  disabled="disabled" value="<%=request.getAttribute("txtResidente") %>"/>
        
      </label></td>
    </tr>
    <tr>
      <td>Vivienda:</td>
      <td><label>
       	<input id="txtVivienda" type="text" name="txtVivienda" size="100px" disabled="disabled" value="<%=request.getAttribute("txtVivienda") %>"/>
        
      </label></td>
    </tr>
    <tr>
      <td>Fecha de Vencimiento:</td>
      <td><label>
        <input id="txtfechaVcto" type="date" name="txtfechaVcto"  size="100px"   disabled="disabled" value="<%=request.getAttribute("txtfechaVcto") %>"/>
      </label></td>
    </tr>
    <tr>
      <td>Fecha de Pago:</td>
      <td><label>
        <input id="txtfechaPago" type="text" name="txtfechaPago"  size="100px"  disabled="disabled" value="<%=request.getAttribute("txtfechaPago") %>"/>
      </label></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input id="btnPagar" type="submit" value="Pagar"   class="btn btn-primary" onclick="ConfirmarPago();"/>
      </td>
    </tr>
  </table> 
  <p>&nbsp;</p>
  <div>
                <%
            String vt=null;
            String vf=null;
            
            String aux = request.getParameter("aux");
            if(aux != null && aux.equals("y")){%>
            		  <p></p>
			          <div class="alert alert-success">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>En hora buena,</b> Su Cuota se pago con éxito.
			          </div>
            	
            <%}else if(aux != null && aux.equals("n")){%>
			          <p></p>
			          <div class="alert alert-danger">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>ERROR!</b> No se pudo pagar el registro de la Cuota.
			          </div>
            	<%}%>
                </div>
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