package com.upc.condominio.servlets;

import java.io.IOException;

import java.sql.Date;
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
		
		
   		String opcion=request.getParameter("opcion")==null?"":request.getParameter("opcion");
   		String strfecha=request.getParameter("txtfecha")==null?"":request.getParameter("txtfecha");
		String strHora=request.getParameter("txtHora")==null?"":request.getParameter("txtHora");
		String strTema=request.getParameter("txtTema")==null?"":request.getParameter("txtTema");
		String strAcuerdo=request.getParameter("txtAcuerdo")==null?"":request.getParameter("txtAcuerdo");
		String datos=request.getParameter("hidDirectivos")==null?"":request.getParameter("hidDirectivos");		
			
		List<Directivos> listado = null;
		String page="";		
		List<Directivos> c=new ArrayList<Directivos>();
		GestionJunta negocioJunta=new GestionJunta();
		Date fechaJunta = null;
		
		
		
		try{
			//trae todas las cuotas vencidas
			if(opcion.equals("1")){		
				page="/pages/BuscarDirigente.jsp";
				c=(List<Directivos>) negocioJunta.listarDirectivos();				
				request.setAttribute("lista",c);
								
			//registra juntas	
			}else if(opcion.equals("")){
				
				page="/pages/RegistrarJunta.jsp";
				
				String[] lstDirectivos;
				listado=new ArrayList<Directivos>();
				
				lstDirectivos=datos.split("-/-");
				for (int i = 0; i < lstDirectivos.length; i++) {
					String[]  directivos = lstDirectivos[i].split(";");
					Directivos d=new Directivos(new Integer(directivos[0].toString()).intValue(),directivos[1].toString(),"",0,directivos[2].toString());					
					listado.add(d);						
				}
				fechaJunta=FormatoFecha.stringToSqlDate(FormatoFecha.obtenerFechaInv2(strfecha));
				Junta junta=negocioJunta.insertarJunta(strTema, strAcuerdo,fechaJunta,strHora, listado);
				request.setAttribute("mensaje","1");													
				request.setAttribute("beanJunta",junta);	
				
				
			}else if(opcion.equals("3")){
				
				page="/pages/BuscarDirigente.jsp";
				String codigo=request.getParameter("codigo").trim().equals("")?"-1":request.getParameter("codigo").trim();								
				c=(List<Directivos>) negocioJunta.BuscarDirectivos(Integer.parseInt(codigo));				
				request.setAttribute("lista",c);
				
			}
						
		}catch(DAOExcepcion e){
			request.setAttribute("mensaje",e.getMessage());	
			Junta junta=new Junta(0, fechaJunta, strHora, strTema, strAcuerdo, listado);
			request.setAttribute("beanJunta",junta);
		}
										
		request.getRequestDispatcher(page).forward(request, response);
				
	}
	

}
