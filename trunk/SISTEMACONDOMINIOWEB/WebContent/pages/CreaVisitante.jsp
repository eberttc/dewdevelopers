<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Registro de Visitantes</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  
<body>

  	<jsp:include page="/pages/header.jsp" />
    <form method="post" action="../VisitanteServlet">
      
      <div class="container">
        <table class="table">
          <tbody>
            <tr>
              <td>DNI Visitante:</td>
              <td>
                <input class="form-control" type="text" id="txtDNIVisitante" name="txtDNIVisitante" required autofocus>
              </td>
            </tr>
            <tr>
              <td>Nombre Visitante:</td>
              <td>
                <input class="form-control" type="text" id="txtNombreVisitante" name="txtNombreVisitante" required autofocus>
              </td>
            </tr>
            <tr>
              <td>Residente:</td>
              <td>
                <select class="form-control" id="txtResidente" name="txtResidente">
                  <option value="1">1 | Juan Lopez</option>
                  <option value="2">2 | Carlos Gomez</option>
                  <option value="3">3 | Karla Sifuentes</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Fecha de Visita:</td>
              <td>
                <input class="form-control" type= "date" id="txtFechaVisita" name="txtFechaVisita" required autofocus />
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <div class="btn-group">
                  <input id="botonEnviar" type="submit" value="ENVIAR">
                   <input id="botonCancela" type="button" value="CANCELAR">
                </div>
                <div>
                <% 
                
                String aux = request.getParameter("aux");
                if(aux !=null && aux.equals("y")){
                	
                	out.println("Se guardo con exito");
                }else{
                	out.println("No se pudo Guardar");
                }
                
                %>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </form>


</body>
</html>