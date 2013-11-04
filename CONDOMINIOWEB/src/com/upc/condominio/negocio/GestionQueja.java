package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import com.upc.condominio.dao.QuejaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;
import com.upc.condominio.util.FormatoFecha;

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
	
}
