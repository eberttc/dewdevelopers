<%@page import="com.upc.condominio.negocio.GestionReserva,com.upc.condominio.modelo.Horario,
com.upc.condominio.exceptions.DAOExcepcion,java.util.*,java.text.*,com.upc.condominio.util.*"%>
<%


java.sql.Date fecha = FormatoFecha.stringToSqlDateYYYYMMDD(request.getParameter("fecha"));
int cod = Integer.parseInt(request.getParameter("ec"));
GestionReserva negocio = new GestionReserva();
try {
	Collection<Horario> listado = negocio.listarHorariosDisponibles(fecha,cod);
	
	for (Horario h : listado) {
		String estado = null;
		String css = null;
		if(h.getDisponibilidad()==1){estado="disabled";css="color:#ccc";}
	%>
		
		<tr>
		<td width="10"><input id="fc_horario" type="radio" name="fc_horario" value="<%=h.getIdHorario()%>" <%=estado %> required="required"></td>
        <td style=<%=css %>><%=h.getRango() %></td>
        </tr>
	<%}
} catch (DAOExcepcion e) {
	
	out.println("Falló el Listado: "+e.getMessage());
}
%>
