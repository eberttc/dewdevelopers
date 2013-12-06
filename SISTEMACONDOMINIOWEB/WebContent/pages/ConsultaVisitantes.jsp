<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Visitantes</title>
  <!-- Bootstrap core CSS -->
  
 
 	<!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
  	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
    <script src="<%=request.getContextPath()%>/js/ajax.js"></script>
     
  
</head>
<%
String listado=session.getAttribute("listado")==null?"":session.getAttribute("listado").toString();

%>


<script type="text/javascript">

$(document).ready(function() {

	
	 
	 $("#chktodos").click(function(){
		 
		 verificaCheck();
     		
	 });
	 
	 var verificaCheck=function(){
		 
		 
		 if($("#chktodos").is(':checked')){
			
			 $("#txtcodigo").val("");
			 $("#hidopcion").val("1");			 
			 $("#txtcodigo").attr("disabled", true);
			 
		 }
     	else{
			$("#hidopcion").val("2");			 
     		$("#txtcodigo").attr("disabled", false);
     	}
		 
	 };
	
	 
	

	 verificaCheck();

} );

</script>
	
  <body>
  
  <jsp:include page="/pages/header.jsp" />
  <form id="frmMorosos" action="/SISTEMACONDOMINIOWEB/ConsultaVisitasServlet" method=post>
  <input type="hidden" id="hidopcion"  name="opcion">  
    <div class="jumbotron">
      <div class="container">
        <h3>Consulta de Visitantes</h3>

      </div>
    </div>
    <div class="container">
      <hr>
      <div class="row">
        <div class="col-md-3" >
          <h4>Residente</h4>
        </div>
        <div class="col-md-3">
          <input type="text" id="txtcodigo" name="codigo" class="form-control" 
          onKeyUp="filtrarQueja('filtroQuejas.jsp','&filtro='+this.value,'div_resultado')">
        </div>
        <div class="col-md-3">
          <div class="checkbox">
            <label>
              <input type="checkbox"  id="chktodos" name="todos">Todos</label>
          </div>
        </div>
        <div class="col-md-3">
             <input type="button" class="btn btn-primary" value="Buscar"
              onclick="filtrarQueja('filtroQuejas.jsp','&filtro= ','div_resultado')"/>
        </div>
      </div>
      <hr>
      <table class="table table-bordered table-hover" id="jqueryDataTable">
        <thead>
          <tr class="success">
            <th>DNI Visitante</th>
            <th>Nombre Visitante</th>
            <th>Residente</th>
            <th>Fecha Visita</th>
          </tr>
        </thead>
        <tbody id="div_resultado">
          <c:forEach var="bean" items="${requestScope.lista}" varStatus="i">
          <tr>
          	<td>${bean.strDNIVisitante}</td>
          	<td>${bean.strNombreVisitante}</td>
          	<td>${bean.strNombreResidente}</td>
          	<td>${bean.dHoraFechaVisitante}</td>
          </tr>
          </c:forEach>
          <div ></div>
        </tbody>
      </table>  
      <footer></footer>
    </div>
  
    </form>
  </body>
	
</html>