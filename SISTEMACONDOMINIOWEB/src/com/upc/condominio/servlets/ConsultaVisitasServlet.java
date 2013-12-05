package com.upc.condominio.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.negocio.GestionVisitantes;

/**
 * Servlet implementation class ConsultaVisitasServlet
 */
@WebServlet("/ConsultaVisitasServlet")
public class ConsultaVisitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaVisitasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
	List<Visitante> v=new ArrayList<Visitante>();
	GestionVisitantes visit=new GestionVisitantes();
	try{
		//trae todas las Visitas
		v=(List<Visitante>) visit.listarVisitante();				 								
	}catch(Exception e){
	
		
	}
							
	request.setAttribute("lista",v);
	request.getRequestDispatcher("/pages/ConsultaVisitantes.jsp").forward(request, response);
	
	}		


}
