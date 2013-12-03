package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import com.upc.condominio.dao.QuejaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;


public class GestionQueja {

	  
		public void insertarQueja(int intIdResidente,String strTipoQueja, String strMotivoQueja, Date dFechaQueja, String strEstadoQueja)

				throws DAOExcepcion{
				
		
				Queja queja=new Queja();
				queja.setIntIdResidente(intIdResidente);
				queja.setStrTipoQueja(strTipoQueja);
				queja.setStrMotivoQueja(strMotivoQueja);
				queja.setdFechaQueja(dFechaQueja);
				queja.setStrEstadoQueja(strEstadoQueja);
				
				
				QuejaDAO quejaDao=new  QuejaDAO();	
				
				quejaDao.insertar(queja);
		
		}
		
		public Queja obtenerQueja(int codigo) throws DAOExcepcion{
			
			QuejaDAO quejaDao=new  QuejaDAO();	
			Queja queja=new Queja();
			queja=quejaDao.obtener(5);
			
			return queja;
		}

		public Collection<Queja> listarQueja() throws DAOExcepcion{
			
			QuejaDAO quejaDao=new  QuejaDAO();	
			Collection<Queja> c = new ArrayList<Queja>();
			
			return quejaDao.listar();
		
		}
/*		public Collection<Queja> listarQuejaPorTipo() throws DAOExcepcion{
			
			QuejaDAO quejaDao=new  QuejaDAO();	
			Collection<Queja> c = new ArrayList<Queja>();
			
			return quejaDao.listarQuejaPorTipo();
		
		} */
}
