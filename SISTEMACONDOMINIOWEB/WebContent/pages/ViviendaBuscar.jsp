<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
 	<!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
 
 	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     
  
    
	<title>Condominio</title>
 
<body>

	<jsp:include page="/pages/header.jsp" />
	
	<div>
	
	<fieldset class="form-horizontal well">
	  <p>Mantenimiento de Viviendas </p>
	</fieldset>
		
	<fieldset class="form-horizontal well">
	 	<form id="form1" name="form1" method="post" action="<%=request.getContextPath()%>/ViviendaServlet?Param=buscar">
		  <p>Buscar vivienda de un Residente: 
		    <label>
		    <input type="text" name="id" placeholder="Dejar en blanco si desea listar todos..." />
		    </label>
		    <label>
		    <button id="button" type="submit" class="btn btn-primary">Buscar</button>		
		    </label>
		  </p>
		</form>
	</fieldset>
	
	<fieldset class="form-horizontal well">
		<form id="form2" name="form2" method="post" action=ViviendaServlet?Param=nuevo>
		    <button id="button" type="submit" class="btn btn-primary">Nuevo</button>		
		</form>
	</fieldset>
	<fieldset class="form-horizontal well">
		
		<table class="table table-striped table-bordered">
		  <tr>
		    <th width="49"  scope="col">Id Viv.</th>
		    <th width="49"  scope="col">Nro. Edi.</th>
		    <th width="192" scope="col">Nro. Dpto.</th>
		    <th width="55"  scope="col">Metraje</th>
		    <th width="55"  scope="col">Tipo Vivienda</th>
		    <th width="150" scope="col">Residente</th>
		    <th width="192" scope="col">Acciones</th>  
		    
		  </tr>
		
		<%@page import="java.util.*, com.upc.condominio.modelo.*" %>
		
		<%
		List<Vivienda> listaVivienda = (ArrayList<Vivienda>)request.getAttribute("viviendas");
		if(listaVivienda != null) { 
		int i = 1;
		for(Vivienda x : listaVivienda) {
		%>  
		  <tr>
		    <td><% out.print(x.getN_IdVivi()); %></td>
		    <td><% out.print(x.getC_Ubicacion()); %></td>
		    <td><% out.print(x.getC_Numero()); %></td>
		    <td><% out.print(x.getN_Metraje()); %></td>
		    <td><%
		    		if(x.getC_TipViv().equals("1")){
		    			out.print("CASA");
		    		}else{
		    			out.print("DEPARTAMENTO");
		    		}; 
		    %></td>
		    <td><% out.print(x.getResidente().getNombreResidente()); %></td>
		    
		    <td><a href="<%=request.getContextPath()%>/ViviendaServlet?Param=editar&id=<%=x.getN_IdVivi()%>">Editar</a> - <a href="<%=request.getContextPath()%>/ViviendaServlet?Param=eliminar&id=<%=x.getN_IdVivi()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></td>
		  </tr>
		<% }  
		  } %>
		  
		</table>
	</fieldset>
  </div>
</body>
