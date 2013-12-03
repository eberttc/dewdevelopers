package com.upc.condominio.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.modelo.Directivos;
import com.upc.condominio.modelo.Junta;
import com.upc.condominio.negocio.GestionCuota;
import com.upc.condominio.negocio.GestionJunta;
import com.upc.condominio.util.DateTimeUtil;
import com.upc.condominio.util.FormatoFecha;

/**
 * Servlet implementation class ListadoQuejas
 */
@WebServlet("/RegistrarJuntaServlet")
public class RegistrarJuntaServlet extends HttpServlet {
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
		
		
   		String strfecha=request.getParameter("txtfecha")==null?"":request.getParameter("txtfecha");
		String strHora=request.getParameter("txtHora")==null?"":request.getParameter("txtHora");
		String strTema=request.getParameter("txtTema")==null?"":request.getParameter("txtTema");
		String strAcuerdo=request.getParameter("txtAcuerdo")==null?"":request.getParameter("txtAcuerdo");
		String datos=request.getParameter("hidDirectivos")==null?"":request.getParameter("hidDirectivos");
		
		String opcion=request.getParameter("opcion")==null?"":request.getParameter("opcion");
				
		System.out.println("RegistrarJuntaServlet.processRequest()-->"+opcion);
		System.out.println("RegistrarJuntaServlet.processRequest()-->"+strfecha);
		System.out.println("RegistrarJuntaServlet.processRequest()-->"+datos);
		System.out.println("RegistrarJuntaServlet.processRequest()-->"+strTema);
		System.out.println("RegistrarJuntaServlet.processRequest()-->"+strAcuerdo);
		
		
		String page="";		
		List<Directivos> c=new ArrayList<Directivos>();
		GestionJunta negocioJunta=new GestionJunta();
		try{
			//trae todas las cuotas vencidas
			if(opcion.equals("1")){		
				
				c=(List<Directivos>) negocioJunta.listarDirectivos();
				page="/pages/BuscarDirigente.jsp";
				request.setAttribute("lista",c);
				
			}else if(opcion.equals("")){
				page="/pages/RegistrarJunta.jsp";
				
				String[] lstDirectivos;
				List<Directivos> listado=new ArrayList<Directivos>();
				
				lstDirectivos=datos.split("-/-");
				for (int i = 0; i < lstDirectivos.length; i++) {
					String[]  directivos = lstDirectivos[i].split(";");
					Directivos d=new Directivos(new Integer(directivos[0].toString()).intValue(),directivos[1].toString(),"",0,directivos[2].toString());					
					listado.add(d);						
				}
				
				Junta junta=negocioJunta.insertarJunta(strTema, strAcuerdo,FormatoFecha.stringToSqlDate(FormatoFecha.obtenerFechaInv2(strfecha)),strHora, listado);
				request.setAttribute("mensaje","1");													
				request.setAttribute("beanJunta",junta);													
				}
						
		}catch(DAOExcepcion e){
			request.setAttribute("mensaje",e.getMessage());		
		}
										
		request.getRequestDispatcher(page).forward(request, response);
				
	}
	

}
