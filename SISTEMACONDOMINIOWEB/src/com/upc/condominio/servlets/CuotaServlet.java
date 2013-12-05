package com.upc.condominio.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.modelo.Vivienda;
import com.upc.condominio.negocio.GestionCuota;
import com.upc.condominio.util.FormatoFecha;


/**
 * Servlet implementation class CuotaServlet
 */
@WebServlet("/CuotaServlet")
public class CuotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables del servlet
		System.out.println("<get> paramOpcion : UN INGRESO DE DOGET</h3>");
		String paramOpcion = request.getParameter("paramOpcion");
		String paramPeriodo = request.getParameter("paramPeriodo");
		String paramIdCuota = request.getParameter("paramIdCuota");
		
		String paginaDestino = "";
		
		
		System.out.println("<get> paramOpcion :"+paramOpcion+ "</h3>");
		System.out.println("<get> paramPeriodo :"+paramPeriodo + "</h3>");
		System.out.println("<get> paramIdCuota :"+paramIdCuota+ "</h3>");
		
		//Variables del negocio
		GestionCuota gestionCuota = new GestionCuota();
		Cuota cuota = new Cuota();
		try {
			if (paramOpcion.equals("eliminar")) {
				int idCuota = Integer.parseInt(paramIdCuota);
				cuota.setN_IdCuot(idCuota);
				gestionCuota.eliminar(cuota);
		        paginaDestino = "/pages/CuotaListar.jsp";
			
			}else if (paramOpcion.equals("editar")) {
				int idCuota = Integer.parseInt(paramIdCuota);
				cuota.setN_IdCuot(idCuota);
                cuota = gestionCuota.obtener(cuota);
                request.setAttribute("cuota", cuota);
                
                paginaDestino = "/pages/CuotaEditar.jsp";
			}else if (paramOpcion.equals("nuevo")) {
				
				Collection<Vivienda> listaVivienda = new ArrayList<Vivienda>();
				cuota.setC_Period(paramPeriodo);
				listaVivienda = gestionCuota.listarViviendaSinCuota(cuota);
				System.out.println("<get> listaVivienda COUNT :"+ String.format("", listaVivienda.size())) ; 
				for(Vivienda vivi: listaVivienda)
				{
					System.out.println("<get> paramOpcion :"+vivi.getC_Numero() + " - "+ vivi.getC_Ubicacion() + "</h3>");
				}
                request.setAttribute("prmlistaVivienda", listaVivienda);
                request.setAttribute("prmPeriodo", paramPeriodo);
                
                paginaDestino = "/pages/CuotaRegistrar.jsp";
			}else
				paginaDestino = "/pages/CuotaListar.jsp";
			
			
			RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
        	rd.forward(request, response);
			
		}catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
		}
		//processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("<get> paramOpcion : UN INGRESO DE DOPOST</h3>");
		// Variable periodo en formato AÑO-Mes . Ejemplo : 201301 (Año 2013, mes Enero)
				String paramPeriodo =(String) request.getAttribute("paramPeriodo");
				String paramOpcion = request.getParameter("paramOpcion");
				String vReturn = "";
				
				String strPeriodo = request.getParameter("txtperiodo")==null?"":request.getParameter("txtperiodo");
				String strperiodo=request.getParameter("periodo");
				String strVivienda=request.getParameter("slcvivienda");
				String strImporte =request.getParameter("importepago");
				String strfechaVcto = request.getParameter("fechaVcto");
				String paginaDestino = "";
				
				System.out.println("<Post> paramOpcion :"+paramOpcion + "</h3>");
				System.out.println("<Post> PERIODO :"+ strPeriodo + "</h3>");
				System.out.println("<Post> strperiodo :"+ strperiodo + "</h3>");
				System.out.println("<Post> VIVIENDA :"+ strVivienda + "</h3>");
				System.out.println("<Post> IMPORTE :"+ strImporte + "</h3>");
				System.out.println("<Post> FECHA VENCIMTO :"+ strfechaVcto + "</h3>");
				System.out.println("<Post> paramPeriodo :"+ paramPeriodo + "</h3>");
				
				GestionCuota gestionCuota = new GestionCuota();

				try {
					if (paramOpcion.equals("nuevo")) { //cargar los combos
							
						Collection<Vivienda> listaVivienda = new ArrayList<Vivienda>();
						Cuota cuota = new Cuota();
						cuota.setC_Period(strPeriodo); //paramPeriodo
						listaVivienda = gestionCuota.listarViviendaSinCuota(cuota);

						System.out.println("<post> listaVivienda COUNT :"+ String.format("", listaVivienda.size())) ; 
						for(Vivienda vivi: listaVivienda)
						{
							System.out.println("<post> paramOpcion : ID: "+vivi.getN_IdVivi()+" - " +vivi.getC_Numero() + " - "+ vivi.getC_Ubicacion() + "</h3>");
						}
						request.setAttribute("prmlistaVivienda", listaVivienda);
						request.setAttribute("paramPeriodo", strPeriodo);
						paginaDestino = "/pages/CuotaRegistrar.jsp";
					}else if (paramOpcion.equals("insertar")) {
						
						Cuota cuota = new Cuota();
						Date fechaVenc = FormatoFecha.stringToSqlDateYYYYMMDD(strfechaVcto);
						cuota.setC_Period(strperiodo);
						cuota.setN_IdVivi(Integer.parseInt(strVivienda));
						cuota.setN_ImpPag( Float.parseFloat(strImporte));
						cuota.setD_FecVen(fechaVenc);
						vReturn = gestionCuota.insertar(cuota);
						paginaDestino = "/pages/CuotaListar.jsp";
						
					}else if (paramOpcion.equals("buscar")) {
						
						Cuota cuota = new Cuota();
						cuota.setC_Period(strPeriodo);
						Collection<Cuota> listaCuota = gestionCuota.listar(cuota);
		                request.setAttribute("listaCuota", listaCuota);
		                                
		                paginaDestino = "/pages/CuotaListar.jsp";
		                
					}
					
					RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		        	rd.forward(request, response);
						
				}catch (DAOExcepcion e) {
		            System.out.println(e.getMessage());
		            RequestDispatcher rd = request.getRequestDispatcher("/pages/error.jsp");
		            rd.forward(request, response);
				//} catch (ParseException e) {
				// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
		
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Variable periodo en formato AÑO-Mes . Ejemplo : 201301 (Año 2013, mes Enero)
		String periodo = request.getParameter("periodo")==null?"":request.getParameter("periodo");
		String paramOpcion = request.getParameter("paramOpcion");
		String vReturn = "";
		
		int idVivienda = Integer.parseInt(request.getParameter("idvivienda"));
		float importe = Float.parseFloat(request.getParameter("importepago"));
		String strfechaPeriodo = request.getParameter("fechaVcto");
		String paginaDestino = "";
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h3> paramOpcion :"+paramOpcion+ "</h3>");
		pw.println("<h3> PERIODO :"+periodo + "</h3>");
		pw.println("<h3> VIVIENDA :"+idVivienda+ "</h3>");
		pw.println("<h3> IMPORTE :"+importe + "</h3>");
		pw.println("<h3> FECHA VENCIMTO :"+strfechaPeriodo + "</h3>");
		pw.println("</body></html>");
		
		GestionCuota gestionCuota = new GestionCuota();
		
		
		try {
			if (paramOpcion.equals("nuevo")) { //cargar los combos
						
				if(periodo.length()>0)
				{
					request.setAttribute("paramPeriodo", periodo);
					paginaDestino = "/pages/CuotaRegistrar.jsp";
				}
			}else if (paramOpcion.equals("insertar")) {
				Cuota cuota = new Cuota();
				Date fechaVenc = new Date(System.currentTimeMillis()); // Fecha Actauk del sistenma
				cuota.setC_Period(periodo);
				cuota.setN_IdVivi(idVivienda);
				cuota.setN_ImpPag(importe);
				cuota.setD_FecVen(fechaVenc);
				
				vReturn = gestionCuota.insertar(cuota);
				
				paginaDestino = "/pages/CuotaListar.jsp";
			}else if (paramOpcion.equals("buscar")) {
				Cuota cuota = new Cuota();
				Collection<Cuota> listaCuota = gestionCuota.listar(cuota);
                request.setAttribute("listaCuota", listaCuota);
                                
                paginaDestino = "/pages/CuotaListar.jsp";
                
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
        	rd.forward(request, response);
				
		}catch (DAOExcepcion e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/pages/error.jsp");
            rd.forward(request, response);
		//} catch (ParseException e) {
		// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
										
		//request.setAttribute("listaCuota",lstCuota);
		//request.getRequestDispatcher("CuotaListar.jsp").forward(request, response);
	}
}
