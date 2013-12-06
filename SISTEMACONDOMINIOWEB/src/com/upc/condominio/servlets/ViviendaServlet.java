package com.upc.condominio.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.modelo.Vivienda;
import com.upc.condominio.negocio.GestionResidente;
import com.upc.condominio.negocio.GestionVivienda;

/**
 * Servlet implementation class ViviendaServlet
 */
@WebServlet("/ViviendaServlet")
public class ViviendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViviendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Variables del servlet
		String param = request.getParameter("Param");
		String idVivienda = request.getParameter("id")==null?"0":request.getParameter("id");
		String paginaDestino = "";

		
		//Variables del negocio
		GestionVivienda viviendaCore = new GestionVivienda();
		GestionResidente residenteCore = new GestionResidente();

				
		try {
			if (param.equals("eliminar")) {
				
		        viviendaCore.eliminar(Integer.parseInt(idVivienda));
		        paginaDestino = "/pages/ViviendaBuscar.jsp";
			
			}else if (param.equals("editar")) {
				
				List<Residente> listaResidente= residenteCore.buscarPorNombre("");
                request.setAttribute("residentes", listaResidente);
                
                Vivienda vivienda = viviendaCore.obtener(Integer.parseInt(idVivienda));
                request.setAttribute("vivienda", vivienda);
            	request.setAttribute("txtTipViv",vivienda.getC_TipViv());
                request.setAttribute("listaResidente",vivienda.getResidente().getIdResidente());
                paginaDestino = "/pages/ViviendaEditar.jsp";
			}else
				paginaDestino = "/pages/ViviendaBuscar.jsp";			
			
			RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
        	rd.forward(request, response);
        	
		}catch (DAOExcepcion e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Variables del servlet
		String param = request.getParameter("Param");
		String id =request.getParameter("id")==null?"0":request.getParameter("id");
		if(id==null||id.equals(""))
			id="0";
		
		System.out.println("codigo de vivienda-->"+id);
		String paginaDestino = "";
		String vReturn = "";
		
		//Variables con datos de la página
		String N_IdVivi = request.getParameter("txtID");
		String C_Ubicacion = request.getParameter("txtNroEdi");
		String C_Numero = request.getParameter("txtNroDpto");
		String N_Metraje = request.getParameter("txtMetraje");
		String C_TipViv = request.getParameter("txtTipViv");
		String N_IdRes = request.getParameter("listaResidente");
		
		//Variables del negocio
		GestionVivienda viviendaCore = new GestionVivienda();
		GestionResidente residenteCore = new GestionResidente();
			String mensaje="";			
		try {
			if (param.equals("nuevo")) { //cargar los combos
						                        
                paginaDestino = "/pages/ViviendaNuevo.jsp";
				
			}else if (param.equals("insertar")) {
				
				Residente residente = new Residente();
				residente.setIdResidente(Integer.parseInt(N_IdRes));
				
				Vivienda vivienda = new Vivienda();
				vivienda.setC_Ubicacion(C_Ubicacion);
				vivienda.setC_Numero(C_Numero);
				vivienda.setN_Metraje(Double.parseDouble(N_Metraje));
				vivienda.setC_TipViv(C_TipViv);
				vivienda.setResidente(residente);
				
				vReturn = viviendaCore.insertar(vivienda);
				
				if(vReturn.equals("VIVIENDA GRABADA EXITOSAMENTE.")){
					paginaDestino = "/pages/Satisfactorio.jsp";
				}else{
					mensaje="1";
					paginaDestino = "/pages/ViviendaNuevo.jsp";
				}
				
			}else if (param.equals("buscar")) {
				
				@SuppressWarnings("unchecked")
				List<Vivienda> listaVivienda =viviendaCore.obtenerPorId(Integer.parseInt(id));
                request.setAttribute("viviendas", listaVivienda);
                                
                paginaDestino = "/pages/ViviendaBuscar.jsp";
                
			}else if (param.equals("modificar")) {
				
				Residente residente = new Residente();
				residente.setIdResidente(Integer.parseInt(N_IdRes));
				
				Vivienda vivienda = new Vivienda();
				vivienda.setN_IdVivi(Integer.parseInt(N_IdVivi));
				vivienda.setC_Ubicacion(C_Ubicacion);
				vivienda.setC_Numero(C_Numero);
				vivienda.setN_Metraje(Double.parseDouble(N_Metraje));
				vivienda.setC_TipViv(C_TipViv);
				vivienda.setResidente(residente);
				
				vReturn = viviendaCore.actualizar(vivienda);
				
				if(vReturn.equals("VIVIENDA EDITADA EXITOSAMENTE.")){
					paginaDestino = "/pages/Satisfactorio.jsp";
				}else{
					mensaje="1";
					paginaDestino = "/pages/ViviendaEditar.jsp";
				}
				
                request.setAttribute("vivienda", vivienda);
				
			}else
				paginaDestino = "/pages/ViviendaBuscar.jsp";
			
			

				request.setAttribute("txtNroEdi",C_Ubicacion);
				request.setAttribute("txtNroDpto",C_Numero);
				request.setAttribute("txtMetraje",N_Metraje);
				request.setAttribute("txtTipViv",C_TipViv);
				request.setAttribute("listaResidente",N_IdRes);
				request.setAttribute("vreturn", vReturn);
				
				
			
			
			List<Residente> listaResidente = residenteCore.buscarPorNombre("");
            request.setAttribute("residentes", listaResidente);
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
        	rd.forward(request, response);
        	
		}catch (DAOExcepcion e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/pages/error.jsp");
            rd.forward(request, response);
		}
		

	}

}
