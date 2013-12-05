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
	public void insertarMensajeTest() {

		GestionMensaje negocio = new GestionMensaje();
		Date fecha = new Date(System.currentTimeMillis());
		try {
			negocio.insertarMensaje("Reunion de residentes 1", "Lorem ipsum dolor kide ru soincp tur adipiscing elit",fecha);

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
			negocio.actualizarMensaje(7,"Reunion de Residenes 1","consectetur adipiscing elite",fecha);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la Actualización: "+e.getMessage());
		}
	}
	
	@Test
	public void eliminarMensajeTest(){
	
		GestionMensaje negocio = new GestionMensaje();
		try {
			negocio.eliminarMensaje(4);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la Eliminación: "+e.getMessage());
		}
	}
	
	//@Test
	public void ListarMensajesResidenteTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		try {
			Collection<Mensaje> listado = negocio.listarMensajeResidente(2);
			//System.out.println(listado.size());
			System.out.println("TITULO \t\t\t | MENSAJE \t\t\t\t\t\t| FECHA");
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			for (Mensaje m : listado) {
				
				System.out.print(m.getC_titulo()+" \t | ");
				System.out.print(m.getC_conten()+" \t\t\t| ");
				System.out.println(m.getD_fecPub()+" \t | ");
			}
			Assert.assertTrue(listado.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}

}
