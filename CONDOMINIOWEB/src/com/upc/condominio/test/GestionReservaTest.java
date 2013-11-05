package com.upc.condominio.test;

import java.sql.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.negocio.GestionReserva;

public class GestionReservaTest {

	@Test
	public void insertarReservaTest(){
		
		GestionReserva negocio = new GestionReserva();
		Date fecha = new Date(System.currentTimeMillis());
		try {
			negocio.insertar(fecha,1,1,1);
			
		} catch (DAOExcepcion e) {
			Assert.fail("No se pudo insertar el registro: "+e.getMessage());
		}
		
	}
}
