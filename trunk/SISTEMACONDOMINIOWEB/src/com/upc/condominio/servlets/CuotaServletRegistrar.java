package com.upc.condominio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.negocio.GestionCuota;

/**
 * Servlet implementation class CuotaServletRegistrar
 */
@WebServlet("/CuotaServletRegistrar")
public class CuotaServletRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuotaServletRegistrar() {
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
		Cuota cuota = new Cuota();
		
		/*procedAlmacenado.setString(1, cuota.getC_Period());
		procedAlmacenado.setInt(2, cuota.getN_IdVivi());
		procedAlmacenado.setDouble(3, cuota.getN_ImpPag());
		procedAlmacenado.setTimestamp(4, dt);*/

		PrintWriter pw = response.getWriter();
		
		String periodo = request.getParameter("periodo");
		int idVivienda = Integer.parseInt(request.getParameter("idvivienda"));
		float importe = Float.parseFloat(request.getParameter("importepago"));
		String strfechaPeriodo = request.getParameter("fechaVcto");
	
		pw.println("<html><body>");
		pw.println("<h3> PERIODO :"+periodo + "</h3>");
		pw.println("<h3> VIVIENDA :"+idVivienda+ "</h3>");
		pw.println("<h3> IMPORTE :"+importe + "</h3>");
		pw.println("<h3> FECHA VENCIMTO :"+strfechaPeriodo + "</h3>");
		
		pw.println("</body></html>");
		
		Date fechaVenc = new Date(System.currentTimeMillis()); // Fecha Actauk del sistenma
		pw.println("<h3> FECHA VENCIMTO 2:"+fechaVenc + "</h3>");
		
		cuota.setC_Period(periodo);
		cuota.setN_IdVivi(idVivienda);
		cuota.setN_ImpPag(importe);
		cuota.setD_FecPag(fechaVenc);
		
		GestionCuota gestionCuota = new GestionCuota();
		try {
			gestionCuota.insertar(cuota);
    		response.sendRedirect(request.getContextPath()	+ "/CuotaServletListar");
		} catch (Exception e ) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
