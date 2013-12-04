package com.upc.condominio.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.negocio.GestionMensaje;



@WebServlet("/MensajeServlet")
public class MensajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MensajeServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod = Integer.parseInt(request.getParameter("CodUsuario"));
		GestionMensaje negocio = new GestionMensaje();
		try {
			Collection<Mensaje> listado = negocio.listar(cod);
			request.setAttribute("Mensajes", listado);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/ListarMensajes.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
