<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <!-- Bootstrap core CSS -->
  
 
 	<!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
 
 	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     
  
</head>



<script type="text/javascript">

$(document).ready(function() {

} );

</script>
	
  <body>
  
  <jsp:include page="/pages/header1.jsp" />
  <form id="frmMorosos" action="${pageContext.request.contextPath}/CuotasServlet">
  <input type="hidden" id="hidopcion"  name="opcion">  
    <div class="jumbotron">
      <div class="container">
        <h3>Mis Cuotas Vencidas</h3>

      </div>
    </div>
    <div class="container">
         
      <br>
      <table class="table table-bordered table-hover" id="jqueryDataTable">
        <thead>
          <tr class="success">
            <th>Periodo Cuota</th>
            <th>Nombre Residente</th>
            <th>Dni Residente</th>
            <th>Importe a pagar</th>
            <th>Fecha Vencimiento</th>
            <th>Id Vivienda</th>
            
          
          </tr>
        </thead>
        <tbody>
          <c:forEach var="bean" items="${requestScope.lista}" varStatus="i">
          <tr>
          	<td>${bean.c_Period}</td>
          	<td>${bean.o_Vivienda.residente.nombreResidente}</td>
          	<td>${bean.o_Vivienda.residente.numeroDocumento}</td>
          	<td>${bean.n_ImpPag}</td>
          	<td>${bean.d_FecVen}</td>
          	<td>${bean.o_Vivienda.n_IdVivi}</td>                    	          	          	          		           	       
          </tr>
          </c:forEach>
        </tbody>
      </table>  
      <footer></footer>
    </div>
  
    </form>
  </body>
	
</html>