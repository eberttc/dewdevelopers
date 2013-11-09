package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.Collection;

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
	
	public Collection<Visitante> listar(int codigo) throws DAOExcepcion{
		
		VisitanteDAO visitanteDao=new  VisitanteDAO();	
		
		return visitanteDao.listar(2);
	}

}
