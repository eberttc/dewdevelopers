<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

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
	        
	      </div>
	      <div class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	          <li class="active"><a href="<%=request.getContextPath()%>/pages/principal.jsp" target="_top">Inicio</a></li>
	      
	          
				<c:forEach items="${sessionScope.MENU}" var="cab" varStatus="cabecera">
				
						<c:if test="${cab.codigoPadre==-1}">
							<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">${cab.nombre} <b class="caret"></b></a>
									 <ul class="dropdown-menu">
									 
									 <c:forEach items="${sessionScope.MENU}" var="det" varStatus="detalle">
									 	<c:if test="${cab.codigoMenu==det.codigoPadre}">
										
											<li><a href="${det.accion}" target="_top" >${det.nombre}</a></li>	                        
						              	
						              	</c:if>
									</c:forEach>
									 
									 
									</ul>
							</li>
						
						</c:if>
				</c:forEach>
					          
	           <li><a href="<%=request.getContextPath()%>/LogoutServlet" target="_top">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
</body>
</html>