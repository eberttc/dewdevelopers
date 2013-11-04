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
			negocio.insertar("Reunion de residentes 2", "Lorem ipsum dolor sit amet consectetur adipiscing elit",fecha);

			//Categoria nuevo = negocio.obtener(3);
			//Assert.assertEquals("Categoria de Smartphones", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {
				Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
	}

	@Test
	public void actualizarMensajeTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		Date fecha = new Date(System.currentTimeMillis());
		
		try {
			negocio.actualizar(5,"Reunion de Residenes 3","Lorem ipsum dolor sit amet consectetur adipiscing elit",fecha);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la Actualizaci�n: "+e.getMessage());
		}
	}
	
	//@Test
	public void eliminarMensajeTest(){
	
		GestionMensaje negocio = new GestionMensaje();
		try {
			negocio.eliminar(6);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la Eliminaci�n: "+e.getMessage());
		}
	}
	
	//@Test
	public void ListarMensajeTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		try {
			Collection<Mensaje> listado = negocio.listar();
			System.out.println(listado.size());
			for (Mensaje m : listado) {
				System.out.print(m.getN_idMens()+" | ");
				System.out.print(m.getC_titulo()+" | ");
				System.out.print(m.getC_conten()+" | ");
				System.out.print(m.getD_fecPub()+" | ");
			}
			Assert.assertTrue(listado.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Fall� el Listado: "+e.getMessage());
		}
	}

}
