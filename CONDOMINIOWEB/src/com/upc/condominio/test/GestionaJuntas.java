package com.upc.condominio.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.upc.condominio.dao.JuntaDAO;
import com.upc.condominio.modelo.DirectivosDTO;
import com.upc.condominio.modelo.JuntaDTO;
import com.upc.condominio.util.ConexionBD;
import com.upc.condominio.util.FormatoFecha;

public class GestionaJuntas {

	
   @Test
	public void insertarJunta(){
			
		try{
			Date fecha=new Date(System.currentTimeMillis());
			List<DirectivosDTO> lstDirectivos=new ArrayList<DirectivosDTO>();
			DirectivosDTO dir1=new  DirectivosDTO(1,"S");
			DirectivosDTO dir2=new  DirectivosDTO(2,"N");
			lstDirectivos.add(dir1);	
			lstDirectivos.add(dir2);	
			
			
			JuntaDTO junta=new JuntaDTO();
			junta.setdFechaJunta(fecha);
			junta.setStrAcuerdoJunta("Se compraran 2 equipos de seguridad");
			junta.setStrTemaJunta("Compra de Equipos");
			junta.settHoraJunta(FormatoFecha.obtenerHora());
			junta.setLstDirectivos(lstDirectivos);
			
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			
			juntaDao.insertar(junta);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	
	//@Test
	public void obtenerJunta(){
			
		try{
			
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			JuntaDTO junta=new JuntaDTO();
			junta=juntaDao.obtener(5);
			
			System.out.print("tema de junta=>"+junta.getStrTemaJunta());
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	
	//@Test
	public void eliminarJunta(){
			
		try{
			
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			
			juntaDao.eliminar(5);
			
			System.out.print("Se elimino junta");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
   //@Test
	public void actualizarJunta(){
			
		try{
			
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			
			JuntaDTO j=new JuntaDTO(); 
					j.setIntCodigoJunta(6);
					j.setStrAcuerdoJunta("No se comprara nada");
					j.setStrTemaJunta("Se comprara 10 equipos");
			juntaDao.actualizar(j);
			
			System.out.print("Se actualizo junta");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	//@Test
	public void listarJunta(){
			
		try{
			
			
			JuntaDAO juntaDao=new  JuntaDAO();	
			Collection<JuntaDTO> c = new ArrayList<JuntaDTO>();
			
			c=juntaDao.listar();
			
			
			
			System.out.print("cantidad de juntas="+c.size());
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

}
