package com.upc.condominio.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.negocio.GestionVisitantes;
import com.upc.condominio.util.FormatoFecha;


@WebServlet("/VisitanteServlet")
public class VisitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//recbes variables de formulario
		//int idResidente = Integer.parseInt("idres");
		
		String dniVisitante = request.getParameter("txtDNIVisitante");
		String nombreVisitante = request.getParameter("txtNombreVisitante");
		int idResidente = Integer.parseInt(request.getParameter ("txtResidente")); 
		Date fechaVisita = FormatoFecha.stringToSqlDateYYYYMMDD(request.getParameter("txtFechaVisita"));
		
		try {
			//instancias Gestion queja -->NEGOCIO
			GestionVisitantes gv = new GestionVisitantes();
			//Llamasa a la funcion insertar
			//gv.insertarVisitante(dniVisitante, nombreVisitante, idResidente, fechaVisita); //--> DAO -->BAse de datos
			
			gv.insertarVisitante(dniVisitante, nombreVisitante, idResidente, fechaVisita);
			//redireccionas al archivo del fomrulario
			RequestDispatcher rd = request.getRequestDispatcher("/pages/CreaVisitante.jsp?aux=y");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/CreaVisitante.jsp?aux=n");
			rd.forward(request, response);
		
	}
	
	}

}
