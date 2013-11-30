<%@page import="com.upc.condominio.negocio.GestionReserva,com.upc.condominio.modelo.Horario,
com.upc.condominio.exceptions.DAOExcepcion,java.util.*,java.text.*,com.upc.condominio.util.*"%>
<%


String fecha_s = request.getParameter("fecha");
java.sql.Date fecha = FormatoFecha.stringToSqlDateYYYYMMDD(fecha_s);
int cod = Integer.parseInt(request.getParameter("ec"));
GestionReserva negocio = new GestionReserva();
try {
	Collection<Horario> listado = negocio.listarHorariosDisponibles(fecha,cod);
	
	for (Horario h : listado) {%>	
		<tr>
		<td width="10"><input type="checkbox" value="true" name="horario" value="<%=h.getIdHorario()%>"></td>
        <td><%=h.getRango() %></td>
        </tr>
	<%}
} catch (DAOExcepcion e) {
	
	out.println("Falló el Listado: "+e.getMessage());
}
%>
