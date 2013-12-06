<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>

<html>
    <head>
    <title>Resgistro de Mensajes</title>
    <meta name="viewport" content="width=device-width">
   	<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
 	 <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script> 	 
 	 <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script> 	  	 	    
     <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     <script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
  </head>
  
  <body>
  <jsp:include page="/pages/header.jsp" />
  <div class="jumbotron">
      <div class="container">
        <h3>REGISTRO DE MENSAJES</h3>
        <p></p>
      </div>
    </div>
    <div class="container">
      <form class="form-horizontal" role="form" Method="POST" action="<%=request.getContextPath()%>/MensajeServlet">
        <div class="form-group">
          <label for="inputAsunto" class="col-sm-2 control-label">Asunto</label>
          <div class="col-sm-4">
            <input type="text" class="form-control" name="fc_asunto" placeholder="Asunto" id="inputAsunto" required="required">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Mensaje</label>
          <div class="col-sm-8">
            <textarea class="form-control" name="fc_mensaje" placeholder="Redactar Mensaje" required="required"></textarea>
          </div>
        </div>
        <div class="form-group">
          <label for="inputfecha" class="col-sm-2 control-label">Fecha</label>
          <div class="col-sm-4">
            <input type="date" class="form-control" name="fc_fecha" placeholder="Asunto" id="inputfecha" required="required"
            onchange="validarFechaMenorActual(this.value);">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-8">
          	<input type="hidden" name="aux" value="in">
            <button type="submit" class="btn btn-default">Enviar</button>
          </div>
        </div>
        <div class="col-sm-offset-2 col-sm-6">
            <%
            String aux = request.getParameter("aux");
            if(aux != null && aux.equals("y")){%>
            		  <p></p>
			          <div class="alert alert-success">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>En hora buena,</b> El registro se insertó con éxito.
			          </div>
            	
            <%}else if(aux != null && aux.equals("n")){%>
			          <p></p>
			          <div class="alert alert-danger">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>ERROR!</b> No se pudo insertar el registro.
			          </div>
            		
            	<%}%>
           </div>
      </form>
    </div>
  </body>

</html>