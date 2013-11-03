package com.upc.condominio.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Directivos;
import com.upc.condominio.modelo.Junta;
import com.upc.condominio.negocio.GestionJunta;

public class GestionaJuntasTest {

	
   //@Test
	public void insertarJunta(){
		
	   try{
		Date fecha=new Date(System.currentTimeMillis());
		List<Directivos> lstDirectivos=new ArrayList<Directivos>();
		Directivos dir1=new  Directivos(1,"S");
		Directivos dir2=new  Directivos(2,"N");
		lstDirectivos.add(dir1);	
		lstDirectivos.add(dir2);	
		
		GestionJunta negocio=new  GestionJunta();	
		
		negocio.insertarJunta("Se compraran 2 equipos de seguridad",
							  "Compra de Equipos", 
							   fecha, 
							   lstDirectivos);
	   }catch(DAOExcepcion e){
			Assert.fail("Fallo la inserción: " + e.getMessage());			
	   }
	
   }
	
	//@Test
	public void obtenerJunta(){
			
		try{
			
			GestionJunta negocio=new  GestionJunta();	
			
			Junta junta=negocio.obtenerJunta(5);
			
			System.out.print("tema de junta=>"+junta.getStrTemaJunta());
			
		}catch(DAOExcepcion e){
			
			Assert.fail("Fallo la inserción: " + e.getMessage());			
				
		}
	}
	
	//@Test
	public void eliminarJunta(){
			
		try{
			
			
			GestionJunta negocio=new  GestionJunta();	
			
			negocio.eliminarJunta(5);
			
			System.out.print("Se elimino junta");
			
		}catch(DAOExcepcion e){
			
			Assert.fail("Fallo la inserción: " + e.getMessage());			
				
		}
	}
   //@Test
	public void actualizarJunta(){
			
		try{
			
			GestionJunta negocio=new  GestionJunta();	
				
		    negocio.actualizarJunta(6, "No se comprara nada", "Se comprara 10 equipos");
			
			System.out.print("Se actualizo junta");
			
		}catch(DAOExcepcion e){
			
			Assert.fail("Fallo la inserción: " + e.getMessage());			
					
		}
	}
	@Test
	public void listarJunta(){
			
		try{
			
			GestionJunta negocio=new  GestionJunta();	
			Collection<Junta> c = new ArrayList<Junta>();
			
			c=negocio.listarJunta();

			System.out.print("cantidad de juntas="+c.size());
			
		}catch(DAOExcepcion e){
			
			Assert.fail("Fallo la inserción: " + e.getMessage());			
				
		}
	}

}
