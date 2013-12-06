package com.upc.condominio.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.modelo.Queja;
import com.upc.condominio.negocio.GestionQueja;

/**
 * Servlet implementation class ConsultaQuejas
 */
@WebServlet("/ConsultaQuejasServlet")
public class ConsultaQuejasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaQuejasServlet() {
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

		
//		String opcion=request.getParameter("opcion")==null?"":request.getParameter("opcion");
//		String txtcodigo=request.getParameter("codigo")==null?"":request.getParameter("codigo");
		
		List<Queja> q=new ArrayList<Queja>();
		GestionQueja queja=new GestionQueja();
		try{
			//trae todas las quejas
			q=(List<Queja>) queja.listarQuejaTipo("%");				 								
		}catch(Exception e){
		
			
		}
								
		request.setAttribute("lista",q);
		request.getRequestDispatcher("/pages/ConsultaQuejas.jsp").forward(request, response);
		
		}		

		
	}

