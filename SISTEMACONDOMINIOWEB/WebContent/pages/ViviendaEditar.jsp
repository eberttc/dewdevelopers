<%@page import="com.upc.condominio.modelo.Residente"%>
<%@page import="com.upc.condominio.modelo.Vivienda"%>
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
     <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script>
  
<%
	String mensaje=request.getAttribute("mensaje")==null?"":request.getAttribute("mensaje").toString();
	String vreturn=request.getAttribute("vreturn")==null?"":request.getAttribute("vreturn").toString();
	String tipViv=request.getAttribute("txtTipViv")==null?"":request.getAttribute("txtTipViv").toString();
	String idResidente=request.getAttribute("listaResidente")==null?"":request.getAttribute("listaResidente").toString();

%>
	<title>Condominio</title>
</head>
<body>
	
	<jsp:include page="../pages/header.jsp" />
	
	
	
	<div>	
	<br>
	<br>
	<br>
	
	<fieldset class="form-horizontal well">
	
	<form id="form1" name="form1" method="post" action="ViviendaServlet?Param=modificar" onsubmit="return validar();">	
		
		<%@page import="java.util.*, com.upc.condominio.modelo.*" %>
				
		<%
		Vivienda vivienda = (Vivienda)request.getAttribute("vivienda");
		%>
		
		<h3>Editar Vivienda</h3>
				
  		<TABLE WIDTH=300>
			
			<TR>
				<TD WIDTH=100>	
					ID:	
				</TD>
				
				<TD WIDTH=100>
					<input id="txtID" name="txtID" type="text" value="<%=vivienda.getN_IdVivi()%>" readonly="readonly" />
				</TD>
			</TR>
			
			<TR>
				<TD WIDTH=100>	
					Residente:
				</TD>
				
				<TD WIDTH=100>
					<%
					List<Residente> listaResidentes = (ArrayList<Residente>)request.getAttribute("residentes");
					if(listaResidentes != null) { 
					int i = 1;
					%>
					<select name="listaResidente" id="listaResidente" style=" width : 149px;">
						<%for(Residente x : listaResidentes) {%>  
						  <option value=<%out.print(x.getIdResidente());%>   <%if(idResidente.equals(x.getIdResidente()+"")){%>selected<%}%>  ><%out.print(x.getNombreResidente());%></option>
						<% } %> 
					</select>
					<% } %>
				</TD>
			</TR>
			
			<TR>
				<TD WIDTH=100>	
					Tipo: 
				</TD>
				
				<TD WIDTH=100>			
					<select id="txtTipViv" name="txtTipViv" >
					  <option value="1" <%if(tipViv.equals("1")){%>selected<%}%>>CASA</option>
					  <option value="2" <%if(tipViv.equals("2")){%>selected<%}%>>DEPARTAMENTO</option>			  
					</select>
				</TD>
			</TR>
			
			<TR>
				<TD WIDTH=100>	
					Nro. Edificio:
				</TD>
				
				<TD WIDTH=100>
					<input id="txtNroEdi" name="txtNroEdi" type="text" value="<%=vivienda.getC_Ubicacion() %>" maxlength="2" required autofocus/>
				</TD>
			</TR>
			
			<TR>
				<TD WIDTH=100>	
					Nro. Departamento: 
				</TD>
				
				<TD WIDTH=100>
					<input id="txtNroDpto" name="txtNroDpto" type="text" value="<%=vivienda.getC_Numero() %>" maxlength="250" required autofocus/>
				</TD>
			</TR>

			<TR>
				<TD WIDTH=100>	
					Metraje:
				</TD>
				
				<TD WIDTH=100>
					 <input id="txtMetraje" name="txtMetraje" value="<%=vivienda.getN_Metraje()%>" type="text" required autofocus/>
				</TD>
			</TR>
			
			<TR>
				<TD WIDTH=100>	
					
				</TD>
				
				<TD WIDTH=100>
					<button id="botonEnviar" type="submit" class="btn btn-primary">Actualizar</button>
				</TD>
			</TR>		
		
		</TABLE>
		
		<p/>&nbsp;	
		
	</form>
			
	</fieldset>
	</div>
	

	<script>
		
		if("<%=mensaje%>"=='1'){
			bootbox.alert("<%=vreturn%>");
			  
		}
		function validar(){
			
			
			var f=document.forms[0];
			
			  if (!/^([0-9])*[.]?[0-9]*$/.test(f.txtMetraje.value)){
				  bootbox.alert("El formato de Metraje no es valido");
				  f.txtMetraje.focus();
				  return false;
			  }
		}

	</script>
</body>
</html>