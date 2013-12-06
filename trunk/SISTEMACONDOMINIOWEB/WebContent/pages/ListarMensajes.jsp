
<%@page import="java.util.ArrayList"%>
<%@page import="com.upc.condominio.negocio.GestionMensaje,com.upc.condominio.modelo.Mensaje,
    com.upc.condominio.exceptions.DAOExcepcion,java.util.*" %>
<!doctype html>
<html>
  <head>
    <title>New Page</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootswatch/3.0.0/cosmo/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <jsp:include page="/pages/header1.jsp" />
    <div class="jumbotron">
      <div class="container">
        <h3>BANDEJA DE ENTRADA</h3>
        <p></p>
      </div>
    </div>
    <table class="table">
  <thead>
    <tr>
      <th>#</th>
      <th>Asunto</th>
      <th>Mensaje</th>
      <th>Fecha</th>
    </tr>
  </thead>
  <tbody>
   <%
	Collection<Mensaje> listado = (ArrayList<Mensaje>)request.getAttribute("Mensajes");
	int x=1;
	for (Mensaje m : listado) {%>
	<tr>	
	<td><%=x++ %></td>
      <td><%=m.getC_titulo() %></td>
      <td><%=m.getC_conten() %></td>
      <td><%=m.getD_fecPub() %></td>
    </tr>
	<%}
%>
  </tbody>
</table>
      
    </div>
  </body>

</html>