package com.upc.condominio.test;

import java.sql.Date;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.negocio.GestionMensaje;
import com.upc.condominio.negocio.GestionReserva;

public class GestionReservaTest {

	@Test
	public void insertarReservaTest(){
		
		GestionReserva negocio = new GestionReserva();
		Date fecha = new Date(System.currentTimeMillis());
		try {
			negocio.insertar(fecha,4,4,11);
			
		} catch (DAOExcepcion e) {
			Assert.fail("No se pudo insertar el registro: "+e.getMessage());
		}
		
	}

	@Test
	public void ListarFechasDisponibles(){
		
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
