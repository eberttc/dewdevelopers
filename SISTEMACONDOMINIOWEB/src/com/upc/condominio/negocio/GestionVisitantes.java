package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.dao.VisitanteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Visitante;

public class GestionVisitantes {

	public void insertarVisitante(String strDNIVisitante, String strNombreVisitante, int intIdResidente, Date dHoraFechaVisitante)

			throws DAOExcepcion{
			
	
			Visitante visitante=new Visitante();
			visitante.setStrDNIVisitante(strDNIVisitante);
			visitante.setStrNombreVisitante(strNombreVisitante);
			visitante.setIntCodigoResidente(intIdResidente);
			visitante.setdHoraFechaVisitante(dHoraFechaVisitante);
			
			
			VisitanteDAO visitanteDao=new  VisitanteDAO();	
			
			visitanteDao.insertar(visitante);
	
	}
	
	public Collection<Visitante> listarVisitante() throws DAOExcepcion{
		
		VisitanteDAO visitanteDao=new  VisitanteDAO();	
		Collection<Visitante> c = new ArrayList<Visitante>();
		
		return visitanteDao.listarVisitante();
	}
	
	
}
