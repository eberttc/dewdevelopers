package com.upc.condominio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.modelo.Residente;
import com.upc.condominio.modelo.Vivienda;
import com.upc.condominio.negocio.ViviendaCore;

import com.upc.condominio.exceptions.DAOExcepcion;

public class ViviendaTest {

	Vivienda vivienda = new Vivienda();
	Residente residente = new Residente();
	ViviendaCore viviendaCore = new ViviendaCore();
	
	
	//@Test
	public void insertarTest() throws ParseException {
		
		residente.setN_CodRes(1);
		
		vivienda.setResidente(residente);
		vivienda.setC_Ubicacion(1);
		vivienda.setC_Numero("654");
		vivienda.setN_Metraje(100.00);
		vivienda.setC_TipViv(1);
		vivienda.setC_EstReg(1);
				
		try {
			vivienda = viviendaCore.insertar(vivienda);
			Assert.assertNotNull(vivienda);
			System.out.println( "SE INSERTÓ LA VIVIENDA: " +vivienda.getN_IdVivi() + " " + vivienda.getC_Ubicacion());
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}

	//@Test
	public void obtenerTest() {
				
		try {
			vivienda = viviendaCore.obtener(1);
			Assert.assertNotNull(vivienda);
			System.out.print("Ubicacion: " + vivienda.getC_Ubicacion() + "; Tipo de vivienda:" + vivienda.getC_TipViv());
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() throws ParseException{
		
		residente.setN_CodRes(1);
		
		vivienda.setResidente(residente);
		vivienda.setC_Ubicacion(1);
		vivienda.setC_Numero("655");
		vivienda.setN_Metraje(90.50);
		vivienda.setC_TipViv(1);
		vivienda.setC_EstReg(1);
		
		try {
			vivienda = viviendaCore.actualizar(vivienda);
			Assert.assertNotNull(vivienda);
			System.out.println( "SE ACTUALIZÓ LOS DATOS DE LA VIVIENDA: " + vivienda.getN_IdVivi());
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
		
	@Test
	public void eliminarTest() {
		
		int nVivienda;
		nVivienda = 1; 
		
		String vReturn = "NO_OK";
		try {
			vReturn = viviendaCore.eliminar(nVivienda);
			Assert.assertEquals("OK", vReturn);
			System.out.println( "SE ELIMINÓ LA VIVIENDA: " + nVivienda + " CORRECTAMENTE.");
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
				
	}
		
}
