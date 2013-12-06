<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta charset="utf-8">
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
	  <p>Mantenimiento de Residentes </p>
	</fieldset>
		
	<fieldset class="form-horizontal well">
	 	<form id="form1" name="form1" method="post" action="<%=request.getContextPath()%>/ResidenteServlet?Param=buscar" target="form1">
		  <p>Buscar Residente: 
		    <label>
		    <input type="text" name="nombre" id="nombre" placeholder="Dejar en blanco si desea listar todos..." />
		    </label>
		    <label>
		    <button id="button" type="submit" class="btn btn-primary">Buscar</button>		
		    </label>
		  </p>
		</form>
	</fieldset>
	
	<fieldset class="form-horizontal well">
		<form id="form2" name="form2" method="post" action=ResidenteServlet?Param=nuevo>
		    <button id="button" type="submit" class="btn btn-primary">Nuevo</button>		
		</form>
	</fieldset>
	<fieldset class="form-horizontal well">
		
		<table class="table table-striped table-bordered">
		  <tr>
		    <th width="49"  scope="col">Item</th>
		    <th width="192" scope="col">Nombre</th>
		    <th width="55"  scope="col">Tipo Doc.</th>
		    <th width="55"  scope="col">Num. Doc.</th>
		    <th width="55" scope="col">Fecha Nac.</th>
		    <th width="150" scope="col">Correo</th>
		    <th width="192" scope="col">Acciones</th>
		    
		  </tr>
		
		<%@page import="java.util.*, com.upc.condominio.modelo.*" %>
		<%@page import="java.text.SimpleDateFormat"%>
		
		<%
		List<Residente> listaResidente = (ArrayList<Residente>)request.getAttribute("residentes");
		if(listaResidente != null) { 
		int i = 1;
		for(Residente x : listaResidente) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getNombreResidente()); %></td>
		    <td><%
		    		if(x.getTipoDocumento()==1){
		    			out.print("DNI");
		    		}else{
		    			out.print("CARNET EXTRANJERIA");
		    		}; 
		    %></td>
		    <td><% out.print(x.getNumeroDocumento()); %></td>
		    <td><% 
			   		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		    		out.print(sdf.format(x.getFechaNacimiento()));    
		    %></td>
		    
		    
		    <td><% out.print(x.getCorreo()); %></td>
		    <td><a href="<%=request.getContextPath()%>/ResidenteServlet?Param=editar&id=<%=x.getIdResidente()%>">Editar</a> - <a href="<%=request.getContextPath()%>/ResidenteServlet?Param=eliminar&id=<%=x.getIdResidente()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></td>
		  </tr>
		<% }  
		  } %>
		  
		</table>
	</fieldset>
  </div>
</body>
