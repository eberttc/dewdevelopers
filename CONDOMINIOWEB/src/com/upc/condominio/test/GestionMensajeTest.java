package com.upc.condominio.test;

import java.sql.Date;
import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;

import com.upc.condominio.negocio.GestionMensaje;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;

public class GestionMensajeTest {
	
	
	//@Test
	public void insertarTest() {

		GestionMensaje negocio = new GestionMensaje();
		Date fecha = new Date(System.currentTimeMillis());
		try {
			negocio.insertar("Reunion de residentes 2", "Lorem ipsum dolor kide ru soincp tur adipiscing elit",fecha);

			//Categoria nuevo = negocio.obtener(3);
			//Assert.assertEquals("Categoria de Smartphones", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {
				Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarMensajeTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		Date fecha = new Date(System.currentTimeMillis());
		
		try {
			negocio.actualizar(1,"Reunion de Residenes 1","Lorem ipsum dolor sit amet consectetur adipiscing elite df",fecha);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la Actualización: "+e.getMessage());
		}
	}
	
	//@Test
	public void eliminarMensajeTest(){
	
		GestionMensaje negocio = new GestionMensaje();
		try {
			negocio.eliminar(2);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la Eliminación: "+e.getMessage());
		}
	}
	
	@Test
	public void ListarMensajeTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		try {
			Collection<Mensaje> listado = negocio.listar(5);
			//System.out.println(listado.size());
			System.out.println("TITULO 		  	| MENSAJE 						   | FECHA");
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			for (Mensaje m : listado) {
				
				System.out.print(m.getC_titulo()+" | ");
				System.out.print(m.getC_conten()+" | ");
				System.out.println(m.getD_fecPub()+" | ");
			}
			Assert.assertTrue(listado.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}

}
