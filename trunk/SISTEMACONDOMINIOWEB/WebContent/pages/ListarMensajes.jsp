
    <%@page import="java.util.ArrayList"%>
<%@page import="com.upc.condominio.negocio.GestionMensaje,com.upc.condominio.modelo.Mensaje,
    com.upc.condominio.exceptions.DAOExcepcion,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
<jsp:include page="/pages/header1.jsp" />
<h3>BANDEJA DE ENTRADA</h3></h3>
        <p></p>
        <table class="table" >
  <thead>
    <tr>
      <th>#</th>
      <th>Asunto</th>
      <th>Mensaje</th>		
      <th>Fecha</th>
    </tr>
  </thead>
  <tbody>	
<%

	Collection<Mensaje> listado = (ArrayList<Mensaje>)request.getAttribute("Mensajes");
	int x=1;
	for (Mensaje m : listado) {%>
	<tr>	
	<td><%=x++ %></td>
      <td><%=m.getC_titulo() %></td>
      <td><%=m.getC_conten() %></td>
      <td><%=m.getD_fecPub() %></td>
    </tr>
	<%}
%>
</body>
</html>