package com.upc.condominio.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.modelo.DataTableObject;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.negocio.GestionCuota;
import com.upc.condominio.util.ConexionBD;

/**
 * Servlet implementation class ListadoQuejas
 */
@WebServlet("/CuotasServlet")
public class CuotasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String opcion=request.getParameter("opcion")==null?"":request.getParameter("opcion");
		String txtcodigo=request.getParameter("codigo")==null?"":request.getParameter("codigo");
		
		List<Cuota> c=new ArrayList<Cuota>();
		GestionCuota cuota=new GestionCuota();
		try{
			//trae todas las cuotas vencidas
			if(opcion.equals("1"))								
				c=(List<Cuota>) cuota.listarCuotasVencidas();				 								
			else								
				if(!txtcodigo.equals(""))//busca cuotas vencidas por codigo de vivienda
					c=(List<Cuota>) cuota.listarCuotasVencidasPorVivienda(new Integer(txtcodigo).intValue());
				
		
		}catch(Exception e){
		
			
		}
								
		request.setAttribute("lista",c);
		request.getRequestDispatcher("/pages/ConsultaMorosos.jsp").forward(request, response);
		
		
	}
	

}
