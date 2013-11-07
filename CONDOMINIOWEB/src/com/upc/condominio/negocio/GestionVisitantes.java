package com.upc.condominio.negocio;

import java.sql.Date;
import com.upc.condominio.dao.VisitanteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Visitante;

public class GestionVisitantes {

	public void insertarVisitante(int intCorrelativo,String strDNIVisitante, String strNombreVisitante, int intCodigoResidente, Date dHoraFechaVisitante)

			throws DAOExcepcion{
			
	
			Visitante visitante=new Visitante();
			visitante.setintCorrelativo(intCorrelativo);
			visitante.setstrDNIVisitante(strDNIVisitante);
			visitante.setstrNombreVisitante(strNombreVisitante);
			visitante.setintCodigoResidente(intCodigoResidente);
			visitante.setdHoraFechaVisitante(dHoraFechaVisitante);
			
			
			VisitanteDAO visitanteDao=new  VisitanteDAO();	
			
			visitanteDao.insertar(visitante);
	
	}
	
	public Visitante obtenerVisitante(int codigo) throws DAOExcepcion{
		
		VisitanteDAO visitanteDao=new  VisitanteDAO();	
		Visitante visitante=new Visitante();
		visitante=visitanteDao.obtener(2);
		
		return visitante;
	}

}
