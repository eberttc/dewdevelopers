<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Cuotas generadas</title>
  <!-- Bootstrap core CSS -->
 	<!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="<%=request.getContextPath()%>/css/bootswatch.min.css" rel="stylesheet" media="screen">
    <link href="<%=request.getContextPath()%>/css/jquery.dataTables.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/DT_bootstrap.css" rel="stylesheet">
    
 	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
 	<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
  
</head>
<%
String listado=session.getAttribute("cuotas")==null?"":session.getAttribute("cuotas").toString();
%>


<script type="text/javascript">

$(document).ready(function() {

	 

} );

</script>
	
  <body>
  
  <jsp:include page="/pages/header.jsp" />
  <form id="frmMorosos" action="CuotasServlet">
  <input type="hidden" id="hidopcion"  name="opcion">  
    <div class="jumbotron">
      <div class="container">
        <h3>Cuotas Generadas</h3>

      </div>
    </div>
    <div class="container">
      <hr>
      <div class="row">
        <div class="col-md-3" >
          <h4>Periodo a buscar:</h4>
        </div>
        <div class="col-md-3">
          <input type="text" id="txtperiodo" name="periodo" class="form-control">
        </div>
        <div class="col-md-3">
             <input type="submit" class="btn btn-primary" value="Buscar" />
        </div>
      </div>
      <hr>
      <table class="table table-bordered table-hover" id="jqueryDataTable">
        <thead>
          <tr class="success">
            <th>Id Cuota</th>
            <th>Periodo</th>
            <th>Residente</th>
            <th>Importe Deudor</th>
            <th>Vivienda</th>
            <th>Dpto</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="cuota" items="${requestScope.cuotas}" varStatus="i">
          <tr>
          	<td>${cuota.n_IdCuot}</td>
          	<td>${cuota.c_Period}</td>
          	<td>${cuota.o_Vivienda.residente.nombreResidente}</td>
          	<td>${cuota.n_ImpPag}</td>
          	<td>${cuota.o_Vivienda.c_Ubicacion}</td>
          	<td>${cuota.o_Vivienda.c_Numero}</td>
          		           	        
          </tr>
          </c:forEach>
        </tbody>
      </table>  
      <footer></footer>
    </div>
  
    </form>
  </body>
	
</html>