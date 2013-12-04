package com.upc.condominio.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import sun.misc.Perf.GetPerfAction;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.negocio.GestionReserva;
import com.upc.condominio.util.FormatoFecha;


@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReservaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath()+"/pages/ingresarReserva.jsp?aux=0");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date fecha = FormatoFecha.stringToSqlDateYYYYMMDD(request.getParameter("fc_fechaReserva"));
		int idEspacio = Integer.parseInt(request.getParameter("fc_espacioComun"));
		int idResidente = Integer.parseInt(request.getParameter("idResidente"));
		int idHorario = Integer.parseInt(request.getParameter("fc_horario"));
		//System.out.print("valors  12125"+idEspacio+"---"+idHorario+"**"+fecha);
		try {
			GestionReserva gr = new GestionReserva();
			gr.insertar(fecha, idEspacio, idResidente, idHorario);
			response.sendRedirect(request.getContextPath()+"/pages/ingresarReserva.jsp?aux=y");
		} catch (DAOExcepcion e) {
			System.out.println("ERROR: "+e.getMessage());
			response.sendRedirect(request.getContextPath()+"/pages/ingresarReserva.jsp?aux=n");
		}
		
		
		
	}

}
