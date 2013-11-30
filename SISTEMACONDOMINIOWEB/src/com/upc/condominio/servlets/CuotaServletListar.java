package com.upc.condominio.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.negocio.GestionCuota;

/**
 * Servlet implementation class CuotaServletListar
 */
@WebServlet("/CuotaServletListar")
public class CuotaServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuotaServletListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Variable periodo en formato AÑO-Mes . Ejemplo : 201301 (Año 2013, mes Enero)
		String periodo=request.getParameter("periodo")==null?"":request.getParameter("periodo");
		
		GestionCuota gestionCuota = new GestionCuota();
		List<Cuota> lstCuota = new ArrayList<Cuota>();
		Cuota cuota = new Cuota();
		cuota.setC_Period(periodo);
		
		try{
			//trae todas las cuotas Generadas y por Generar del periodo ingresado
			lstCuota=(List<Cuota>) gestionCuota.listar(cuota);				 								
		
		}catch(Exception e){
		
			
		}
								
		request.setAttribute("listaCuota",lstCuota);
		request.getRequestDispatcher("/pages/CuotaListar.jsp").forward(request, response);
		
	}

}
