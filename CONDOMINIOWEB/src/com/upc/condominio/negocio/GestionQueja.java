package com.upc.condominio.negocio;

import java.sql.Date;
import com.upc.condominio.dao.QuejaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;


public class GestionQueja {

	  
		public void insertarQueja(int intIdResidente,String strTipoQueja, String strMotivoQueja, Date dFechaQueja, String strEstadoQueja)

				throws DAOExcepcion{
				
		
				Queja queja=new Queja();
				queja.setintIdResidente(intIdResidente);
				queja.setstrTipoQueja(strTipoQueja);
				queja.setstrMotivoQueja(strMotivoQueja);
				queja.setdFechaQueja(dFechaQueja);
				queja.setstrEstadoQueja(strEstadoQueja);
				
				
				QuejaDAO quejaDao=new  QuejaDAO();	
				
				quejaDao.insertar(queja);
		
		}
		
		public Queja obtenerQueja(int codigo) throws DAOExcepcion{
			
			QuejaDAO quejaDao=new  QuejaDAO();	
			Queja queja=new Queja();
			queja=quejaDao.obtener(5);
			
			return queja;
		}

	
}
