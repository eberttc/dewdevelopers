package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.upc.condominio.dao.JuntaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Directivos;
import com.upc.condominio.modelo.Junta;
import com.upc.condominio.util.FormatoFecha;


public class GestionJunta {
	

	  
		public void insertarJunta(String acuerdo,String tema,Date fecha,List<Directivos> listaDirectivos)
				throws DAOExcepcion{
				
		
				Junta junta=new Junta();
				junta.setdFechaJunta(fecha);
				junta.setStrAcuerdoJunta(acuerdo);
				junta.setStrTemaJunta(tema);
				junta.settHoraJunta(FormatoFecha.obtenerHora());
				junta.setLstDirectivos(listaDirectivos);
				
				
				JuntaDAO juntaDao=new  JuntaDAO();	
				
				juntaDao.insertar(junta);
		
		}
		
		public Junta obtenerJunta(int codigo) throws DAOExcepcion{
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			Junta junta=new Junta();
			junta=juntaDao.obtener(5);
			
			return junta;
		}
		
		public void eliminarJunta(int codigo)throws DAOExcepcion{

			JuntaDAO juntaDao=new  JuntaDAO();	
			
			
			juntaDao.eliminar(codigo);
				
		
		}
	 
		public void actualizarJunta(int codigo,String acuerdo,String tema) throws DAOExcepcion{
			JuntaDAO juntaDao=new  JuntaDAO();	
			
			Junta j=new Junta(); 
				
						j.setIntCodigoJunta(codigo);
						j.setStrAcuerdoJunta(acuerdo);
						j.setStrTemaJunta(tema);
						juntaDao.actualizar(j);
			
			
		}
		
		public Collection<Junta> listarJunta() throws DAOExcepcion{
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			Collection<Junta> c = new ArrayList<Junta>();
			
			return juntaDao.listar();
		
		}
		public Collection<Directivos> listarDirectivos() throws DAOExcepcion{
			
			JuntaDAO juntaDao=new  JuntaDAO();						
			return juntaDao.listarDirectivos();
		
		}

}
