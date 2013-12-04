package com.upc.condominio.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.modelo.Usuario;
import com.upc.condominio.negocio.GestionCuota;

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
		HttpSession session=request.getSession();
		Usuario usuario=(Usuario) session.getAttribute("USUARIO_ACTUAL");
		
		String page="/pages/principal.jsp";
		List<Cuota> c=new ArrayList<Cuota>();
		GestionCuota cuota=new GestionCuota();
		try{
			//trae todas las cuotas vencidas de todos las viviendas
			if(usuario.getTipoUsuario().equals("R")){			
				page="/pages/ConsultaMisCuotasVencidas.jsp";
				c=(List<Cuota>) cuota.listarCuotasVencidasPorResidente(usuario.getIdUsuario());
			}
			else if(opcion.equals("1"))		{				
				page="/pages/ConsultaMorosos.jsp";
				c=(List<Cuota>) cuota.listarCuotasVencidas();
			}
			else if(!txtcodigo.equals("")){//busca cuotas vencidas por codigo de vivienda
				page="/pages/ConsultaMorosos.jsp";
				c=(List<Cuota>) cuota.listarCuotasVencidasPorVivienda(new Integer(txtcodigo).intValue());
			}
		
		}catch(Exception e){
		
			
		}
								
		request.setAttribute("lista",c);
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}
	

}
