<!doctype html>

<html>
  
  <head>
    <title>Registro de Quejas</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js" type="text/javascript"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/js/validar.js"></script>
  </head>
  
  <body>
  	<jsp:include page="/pages/header.jsp" />
  	<div class="jumbotron">
      <div class="container">
        <h3>REGISTO DE QUEJAS</h3>
        <p></p>
      </div>
    </div>
    <form method="post" action="../QuejaServlet">
      
      <div class="container">
        <table class="table">
          <tbody>
            <tr>
              <td>Fecha de Queja:</td>
              <td>
                <input class="form-control" type= "date" id="txtFecha" name="txtFecha" required autofocus onchange="validarFechaMenorActual(this.value);"/>
              	<dvi id="div_resultado"></dvi>
              </td>
            </tr>
            <tr>
              <td>Tipo de Queja:</td>
              <td>
                <select class="form-control" id="txtTipoQueja" name="txtTipoQueja">
                  <option value="Leve">Leve</option>
                  <option value="Grave">Grave</option>
                  <option value="Muy Grave">Muy Grave</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Motivo:</td>
              <td>
                <input class="form-control" type="text" id="txtMotivo" name="txtMotivo" required autofocus>
              </td>
            </tr>
            <tr>
              <td>Detalle de la Queja:</td>
              <td>
                <textarea class="form-control" id="txtDetalle" name="txtDetalle" required autofocus></textarea>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <div class="btn-group">
                  <input id="botonEnviar" type="submit" value="ENVIAR"></a>
                   <input id="botonCancela" type="button" value="CANCELAR"></a>
                </div>
                <div>
                <%
            String vt=null;
            String vf=null;
            
            String aux = request.getParameter("aux");
            if(aux != null && aux.equals("y")){%>
            		  <p></p>
			          <div class="alert alert-success">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>En hora buena,</b> Su Queja se registró con éxito.
			          </div>
            	
            <%}else if(aux != null && aux.equals("n")){%>
			          <p></p>
			          <div class="alert alert-danger">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <b>ERROR!</b> No se pudo insertar el registro.
			          </div>
            		
            	<%}%>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </form>
  </body>

</html>