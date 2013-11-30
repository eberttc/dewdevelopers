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
String listado=session.getAttribute("listaCuota")==null?"":session.getAttribute("listaCuota").toString();
%>

<script type="text/javascript">

$(document).ready(function() {

} );

</script>
	
  <body>
  
  <jsp:include page="/pages/header.jsp" />
  <form id="frmCuota" action="CuotaServletListar">
  
    <div class="jumbotron">
      <div class="container">
        <h3>Cuotas Generadas</h3>
      </div>
    </div>
    <div class="container">
      <hr>
      <div class="row">
        <div class="col-md-3" >
          <h4>Periodo a buscar [YYYYMM]:</h4>
        </div>
        <div class="col-md-3">
          <input type="text" id="txtperiodo" name="periodo" class="form-control">
        </div>
        <div class="col-md-3">
        <table>
        <tr>
        <td><input type="submit" class="btn btn-primary" value="Buscar" /></td>
        <td><input type="button" class="btn" value="Nuevo" onclick="window.location='CuotaRegistrar.jsp' "/></td>
        </tr>
        </table>
             
        </div>
       <!--  <div class="col-md-3">
             
        </div> -->
      </div>
      <hr>
      
      
<!--       <div class="container"> 


<p><strong>Mantenimiento de Roles &gt; Buscar</strong></p>

<form id="form1" name="form1" method="post" action="RolBuscarServlet">

</form> -->
<table width="550" height="65" border="1" cellpadding="0" cellspacing="0"  class="table table-bordered table-hover">
  <tr>
  	<th width="40" scope="col">Item</th>
    <th width="49" scope="col">Nro.Cuota</th>
    <th width="70" scope="col">Periodo</th>
     <th width="60" scope="col">N° Vivienda</th>
    <th width="180" scope="col">Residente</th>
     <th width="90" scope="col">Cuota</th>
     <th width="90" scope="col">Fecha Vencto</th>
     <th width="90" scope="col">Tipo Pago</th>
     <th width="90" scope="col">Fecha Pago</th>
  	<th width="192" scope="col">Acciones</th> 
  </tr>

<%@page import="java.util.*, com.upc.condominio.modelo.Cuota" %>
<%
Collection<Cuota> arreglo = (ArrayList<Cuota>)request.getAttribute("listaCuota");
if(arreglo != null) { 
int i = 1;
for(Cuota x : arreglo) {
%>  
  <tr>
    <td><%=i++ %></td>
    <td><% out.print(x.getN_IdCuot()); %></td>
    <td><% out.print(x.getC_Period()); %></td>
    <td><% out.print(x.getO_Vivienda().getC_Numero()); %></td>
    <td><% out.print(x.getO_Vivienda().getResidente().getNombreResidente()); %></td>
     <td><% out.print(x.getN_ImpPag()); %></td>
     <td><% out.print(x.getD_FecVen()); %></td>
     <td><% out.print(x.getO_TipPag().getcDescri()); %></td>
     <td><% out.print(x.getD_FecPag()); %></td>
    <td><a href="<%=request.getContextPath() %>/CuotaServletEditar?id=<%=x.getN_IdCuot() %>">Editar</a> - <a href="<%=request.getContextPath()%>
/RolCuotaServletEliminar?id=<%=x.getN_IdCuot()%>" onclick="return confirm('¿Está seguro que desea eliminar Cuota');">Eliminar</a></td>
  </tr>
<% }  
  } %>
  
</table>

 <!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; OCarril 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
      
      
      <!-- <table class="table table-bordered table-hover" id="jqueryDataTable">
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
          <c:forEach var="cuotas" items="${requestScope.listaCuota}" varStatus="i">
          <tr>
          	<td>${cuotas.n_IdCuot}</td>
          	<td>${cuotas.c_Period}</td>
          	<td>${cuotas.o_Vivienda.residente.nombreResidente}</td>
          	<td>${cuotas.n_ImpPag}</td>
          	<td>${cuotas.o_Vivienda.c_Ubicacion}</td>
          	<td>${cuotas.o_Vivienda.c_Numero}</td>
          		           	        
          </tr>
          </c:forEach>
        </tbody>
      </table>  
      <footer></footer>
    </div>-->
  
    </form>
  </body>
	
</html>