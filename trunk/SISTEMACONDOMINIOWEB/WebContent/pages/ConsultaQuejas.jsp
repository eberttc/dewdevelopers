<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Quejas</title>
  <!-- Bootstrap core CSS -->
  
 
 	<!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
  	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     
  
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
  <form id="frmMorosos" action="/SISTEMACONDOMINIOWEB/ConsultaQuejasServlet" method=post>
  <input type="hidden" id="hidopcion"  name="opcion">  
    <div class="jumbotron">
      <div class="container">
        <h3>Consulta de Quejas</h3>

      </div>
    </div>
    <div class="container">
      <hr>
      <div class="row">
        <div class="col-md-3" >
          <h4>Tipo de Queja</h4>
        </div>
        <div class="col-md-3">
          <input type="text" id="txtcodigo" name="codigo" class="form-control">
        </div>
        <div class="col-md-3">
          <div class="checkbox">
            <label>
              <input type="checkbox"  id="chktodos" name="todos">Todos</label>
          </div>
        </div>
        <div class="col-md-3">
             <input type="submit" class="btn btn-primary" value="Buscar" />
        </div>
      </div>
      <hr>
      <table class="table table-bordered table-hover" id="jqueryDataTable">
        <thead>
          <tr class="success">
            <th>ID Queja</th>
            <th>ID Residente</th>
            <th>Motivo Queja</th>
            <th>Estado</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="bean" items="${requestScope.lista}" varStatus="i">
          <tr>
          	<td>${bean.intIdQueja}</td>
          	<td>${bean.intIdResidente}</td>
          	<td>${bean.strMotivoQueja}</td>
          	<td>${bean.strEstadoQueja}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>  
      <footer></footer>
    </div>
  
    </form>
  </body>
	
</html>