<%@page import="com.upc.condominio.negocio.GestionReserva,com.upc.condominio.modelo.Horario,
com.upc.condominio.exceptions.DAOExcepcion,java.util.*,java.text.*"%>
<%
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date fecha = df.parse(request.getParameter("fecha"));
int cod = Integer.parseInt(request.getParameter("ec"));
GestionReserva negocio = new GestionReserva();
/*try {
	Collection<Horario> listado = negocio.listarHorariosDisponibles(fecha,3);
	
	System.out.println("HORARIOS DISPONIBLES");
	System.out.println("---------------------------------------------------------------------------------------------------");
	
	for (Horario h : listado) {
		System.out.println(h.getIdHorario());
		System.out.println(h.getRango());
	}
} catch (DAOExcepcion e) {
	
	out.println("Falló el Listado: "+e.getMessage());
}*/
%>