<%@page import="java.util.*,com.upc.condominio.negocio.GestionQueja,
com.upc.condominio.modelo.Queja,com.upc.condominio.exceptions.DAOExcepcion"%>

<% 
String filtro = request.getParameter("filtro");

GestionQueja negocio = new GestionQueja();

		try {
			Collection<Queja> listado = negocio.listarQueja(filtro);
			
			for (Queja queja : listado) {%>
			<tr>
			<td><%=queja.getIntIdQueja()%></td>
          	<td><%=queja.getIntIdResidente()%></td>
          	<td><%=queja.getStrMotivoQueja()%></td>
          	<td><%=queja.getStrEstadoQueja()%></td>
          	</tr>	
			<%}

		} catch (DAOExcepcion e) {

			System.out.print("Fallo" + e.getMessage());

		}
	%>
	