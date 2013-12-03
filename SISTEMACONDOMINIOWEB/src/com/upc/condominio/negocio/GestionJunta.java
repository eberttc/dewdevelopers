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
	

	  
		public Junta insertarJunta(String acuerdo,String tema,Date fecha,String strHora, List<Directivos> listaDirectivos)
				throws DAOExcepcion{
				
				
				
				//verifica que no exista reuniones en esa fecha y hora
				
				JuntaDAO juntaDao=new  JuntaDAO();	
				Collection<Junta> c = new ArrayList<Junta>();
				c=juntaDao.buscarPorFechaHora(fecha,strHora+":00");
				if(c.size()>0)
					throw new DAOExcepcion("Existe una Junta registrada en esa fecha");
				
				
				Junta junta=new Junta();
				junta.setdFechaJunta(fecha);
				junta.setStrAcuerdoJunta(acuerdo);
				junta.setStrTemaJunta(tema);
				junta.settHoraJunta(strHora);
				junta.setLstDirectivos(listaDirectivos);
				
				int idJunta=juntaDao.insertar(junta);
				junta.setIntCodigoJunta(idJunta);
				
				return junta;
		
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
		public Collection<Directivos> BuscarDirectivos(int codigo) throws DAOExcepcion{
			
			JuntaDAO juntaDao=new  JuntaDAO();						
			return juntaDao.BuscarDirectivos(codigo);
		
		}
		
		

}
