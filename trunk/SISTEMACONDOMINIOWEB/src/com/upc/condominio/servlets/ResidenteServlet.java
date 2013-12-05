package com.upc.condominio.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.negocio.GestionResidente;

/**
 * Servlet implementation class ResidenteServlet
 */
@WebServlet("/ResidenteServlet")
public class ResidenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidenteServlet() {
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
				String idResidente = request.getParameter("id");
				String paginaDestino = "";

				
				//Variables del negocio
				GestionResidente residenteCore = new GestionResidente();
						
				try {
					if (param.equals("eliminar")) {
						
				        residenteCore.eliminar(Integer.parseInt(idResidente));
				        paginaDestino = "/pages/ResidenteBuscar.jsp";
					
					}else if (param.equals("editar")) {
						
		                Residente residente = residenteCore.obtener(Integer.parseInt(idResidente));
		                request.setAttribute("residente", residente);
		                
		                paginaDestino = "/pages/ResidenteEditar.jsp";
					}else
						paginaDestino = "/pages/ResidenteBuscar.jsp";
					
					
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
		
		//Variables del servlet
				String param = request.getParameter("Param");
				String nombre = request.getParameter("nombre");
				String paginaDestino = "";
				String vReturn = "";
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

				
				//Variables con datos de la página
				String idResidente = request.getParameter("txtID");
				String nombreResidente = request.getParameter("txtNombre");
				String tipoDocumento = request.getParameter("txtTipoDocumento");
				String fechaNacimiento = request.getParameter("txtFeNac");
				String correo = request.getParameter("txtCorreo");
				String numeroDocumento = request.getParameter("txtNuDocumento");
				//String clave = request.getParameter("clave");
				String mensaje="";
				//Variables del negocio
				GestionResidente residenteCore = new GestionResidente();
								
				try {
					if (param.equals("nuevo")) { //cargar los combos
						
				        //List<Local> listaLocal = localCore.listarLocal();
		                //request.setAttribute("locales", listaLocal);
		                
		                paginaDestino = "/pages/ResidenteNuevo.jsp";
						
					}else if (param.equals("insertar")) {

						
						
						Residente residente = new Residente();
						residente.setNombreResidente(nombreResidente);
						residente.setTipoDocumento(Integer.parseInt(tipoDocumento));
						residente.setFechaNacimiento(df.parse(fechaNacimiento));
						residente.setCorreo(correo);
						residente.setNumeroDocumento(numeroDocumento);
						//residente.setClave(clave);
										
						vReturn = residenteCore.insertar(residente);
						
						if(vReturn.equals("RESIDENTE GRABADO EXITOSAMENTE.")){
							paginaDestino = "/pages/Satisfactorio.jsp";
						}else{

							request.setAttribute("txtNombre",nombreResidente);
							request.setAttribute("txtTipoDocumento",tipoDocumento);
							request.setAttribute("txtFeNac",fechaNacimiento);
							request.setAttribute("txtCorreo",correo);
							request.setAttribute("txtNuDocumento",numeroDocumento);
							request.setAttribute("vreturn", vReturn);
							mensaje="1";
							paginaDestino = "/pages/ResidenteNuevo.jsp";
						}
						
					}else if (param.equals("buscar")) {
						
						List<Residente> listaResidente = residenteCore.buscarPorNombre(nombre);
		                request.setAttribute("residentes", listaResidente);
		                                
		                paginaDestino = "/pages/ResidenteBuscar.jsp";
		                
					}else if (param.equals("modificar")) {

						Residente residente = new Residente();
						residente.setIdResidente(Integer.parseInt(idResidente));
						residente.setNombreResidente(nombreResidente);
						residente.setTipoDocumento(Integer.parseInt(tipoDocumento));
						residente.setFechaNacimiento(df.parse(fechaNacimiento));
						residente.setCorreo(correo);
						residente.setNumeroDocumento(numeroDocumento);
						//residente.setClave(clave);
						
						vReturn = residenteCore.actualizar(residente);
						
						paginaDestino = "/pages/Satisfactorio.jsp";
					}else{
						
						paginaDestino = "/pages/ResidenteBuscar.jsp";
					}
					
					request.setAttribute("mensaje", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		        	rd.forward(request, response);
		        	
				}catch (DAOExcepcion e) {
		            System.out.println(e.getMessage());
		            RequestDispatcher rd = request.getRequestDispatcher("/pages/error.jsp");
		            rd.forward(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		
	}

}
