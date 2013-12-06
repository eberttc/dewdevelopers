<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">

</head>
<body>
<!-- Static navbar -->
	  <div class="navbar navbar-default navbar-static-top">
	    <div class="container">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="principal.jsp">Condominio</a>
	      </div>
	      <div class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	          <li class="active"><a href="principal.jsp">Inicio</a></li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimientos <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="#">Vivienda</a></li>	              
	              <li><a href="<%=request.getContextPath()%>/ResidenteServlet?Param=" target="_top">Residente</a></li>	              	             	             
	            </ul>
	          </li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cuotas <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	               <li><a href="CuotaListar.jsp">Colocacion de Cuotas</a></li>	                        
	              <li><a href="#">Pago cuotas</a></li>	              	             	             
	              <li><a href="#">Consulta Morosas</a></li>	              	             	             
	              <li><a href="<%=request.getContextPath()%>/CuotasServlet?opcion=1" target="_top">Consulta de Cuotas Vencidas</a></li>	              	             	             
	              <li><a href="<%=request.getContextPath()%>/CuotasServlet?" target="_top">Mis Cuotas Vencidas</a></li>	              	             	             
	            </ul>
	          </li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Quejas <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="<%=request.getContextPath()%>/pages/CreaQueja.jsp">Registro de Quejas</a></li>	              
	              <li><a href="<%=request.getContextPath()%>/ConsultaQuejasServlet?opcion=1">Listado de Quejas</a></li>	                                         	             	                       	             	             
	            </ul>
	          </li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Visitas <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="<%=request.getContextPath()%>/pages/CreaVisitante.jsp">Registro de visitas</a></li>	              
	              <li><a href="<%=request.getContextPath()%>/ConsultaVisitasServlet?opcion=1">Listado de visitas</a></li>	                        	             	             
	            </ul>
	          </li>
	          
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Juntas <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="<%=request.getContextPath()%>/pages/RegistrarJunta.jsp" target="_top">Registro Juntas</a></li>	              
	                           	             	             
	            </ul>
	          </li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reservas <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="pages/ingresarReserva.jsp?idResidente=${sessionScope.USUARIO_ACTUAL.idUsuario}">Espacio comun</a></li>	              
	                           	             	             
	            </ul>
	          </li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mensajeria <b class="caret"></b></a>
	            <ul class="dropdown-menu">	             
	              <li><a href="#">Registrar Mensajes</a></li>	              
	              <li><a href="MensajeServlet?CodUsuario=${sessionScope.USUARIO_ACTUAL.idUsuario}">Ver Mensajes</a></li>	              
	                           	             	             
	            </ul>
	          </li>
	          
	         
        
	          <li><a href="<%=request.getContextPath()%>/LogoutServlet" target="_top">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
</body>
</html>