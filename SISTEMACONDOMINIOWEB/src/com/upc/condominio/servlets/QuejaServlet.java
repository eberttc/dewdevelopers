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
import com.upc.condominio.negocio.GestionQueja;
import com.upc.condominio.util.FormatoFecha;


@WebServlet("/QuejaServlet")
public class QuejaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QuejaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recbes variables de formulario
		//int idResidente = Integer.parseInt("idres");
		Date fecha = FormatoFecha.stringToSqlDateYYYYMMDD(request.getParameter("txtFecha"));
		String tipoQueja = request.getParameter("txtTipoQueja");
		String motivo = request.getParameter("txtMotivo");
		String detalle = request.getParameter("txtDetalle");
		
		try {
			//instancias Gestion queja -->NEGOCIO
			GestionQueja gq = new GestionQueja();
			//Llamasa a la funcion insertar
			gq.insertarQueja(1, tipoQueja, motivo, fecha, "En Proceso");//--> DAO -->BAse de datos
			//redireccionas al archivo del fomrulario
			RequestDispatcher rd = request.getRequestDispatcher("/pages/CreaQueja.jsp?aux=y");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/CreaQueja.jsp?aux=n");
			rd.forward(request, response);
		
	}
	}

}
