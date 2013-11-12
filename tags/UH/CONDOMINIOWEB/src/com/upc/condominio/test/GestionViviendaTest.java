package com.upc.condominio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.modelo.Residente;
import com.upc.condominio.modelo.Vivienda;
import com.upc.condominio.negocio.GestionVivienda;
import com.upc.condominio.negocio.GestionVivienda;
import com.upc.condominio.exceptions.DAOExcepcion;

public class GestionViviendaTest {

	Vivienda vivienda = new Vivienda();
	Residente residente = new Residente();
	GestionVivienda GestionVivienda = new GestionVivienda();
	
	
	@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		
		residente.setIdResidente(4);
		vivienda.setResidente(residente);
		vivienda.setC_Ubicacion(1);
		vivienda.setC_Numero("124");
		vivienda.setN_Metraje(121.00);
		vivienda.setC_TipViv(2);
				
		try {
			v_vReturn = GestionVivienda.insertar(vivienda);
			System.out.println(v_vReturn);
			//Assert.assertEquals("VIVIENDA GRABADA EXITOSAMENTE.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}

	//@Test
	public void obtenerTest() {
				
		try {
			vivienda = GestionVivienda.obtener(3);
			Assert.assertNotNull(vivienda);
			System.out.print("Ubicacion: " + vivienda.getC_Ubicacion() + "; Tipo de vivienda:" + vivienda.getC_TipViv());
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() throws ParseException{
		
		String v_vReturn = "NO_OK";
		
		vivienda.setN_IdVivi(3);
		vivienda.setC_Ubicacion(1);
		vivienda.setC_Numero("124");
		vivienda.setN_Metraje(122.50);
		vivienda.setC_TipViv(2);
		residente.setIdResidente(8);
		vivienda.setResidente(residente);
		
		try {
			v_vReturn = GestionVivienda.actualizar(vivienda);
			System.out.println(v_vReturn);
			Assert.assertEquals("VIVIENDA EDITADA EXITOSAMENTE.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
		
	//@Test
	public void eliminarTest() {
		
		int nVivienda;
		nVivienda = 3; 
		
		String vReturn = "NO_OK";
		try {
			vReturn = GestionVivienda.eliminar(nVivienda);
			Assert.assertEquals("OK", vReturn);
			System.out.println( "SE ELIMINÓ LA VIVIENDA: " + nVivienda + " CORRECTAMENTE.");
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
				
	}
		
}
