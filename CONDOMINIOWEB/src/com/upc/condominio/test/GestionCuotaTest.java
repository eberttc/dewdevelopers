package com.upc.condominio.test;

import java.sql.Date;
import java.text.ParseException;
import java.util.Collection;

import junit.framework.Assert;
import org.junit.Test;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.negocio.GestionCuota;

public class GestionCuotaTest {

	Cuota cuota = new Cuota();
	GestionCuota gestionCuota = new GestionCuota();
	
	//@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		Date fechaPago = new Date(System.currentTimeMillis());
		
		cuota.setN_IdVivi(5);
		cuota.setD_FecPag(fechaPago);
		cuota.setC_Period("201301");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(120);
		cuota.setN_TipPag(1);
				
		try {
			v_vReturn = gestionCuota.insertar(cuota);
			System.out.println(v_vReturn);
			Assert.assertEquals("Cuota Grabada exitosamente.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void obtenerTest() {
					
			try {
				cuota = gestionCuota.obtener(1);
				Assert.assertNotNull(cuota);
				System.out.print("Periodo: " + cuota.getC_Period() + "; Importe de Pago:" + cuota.getN_ImpPag());
			} 
			catch (DAOExcepcion e) {	
				Assert.fail("ERROR: " + e.getMessage());
			}
	}
	
	//@Test
	public void actualizarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		Date fechaPago = new Date(System.currentTimeMillis());
		
		cuota.setN_IdCuot(1);
		cuota.setN_IdVivi(2);
		cuota.setD_FecPag(fechaPago);
		cuota.setC_Period("201311");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(150);
		cuota.setN_TipPag(1);
				
		try {
			v_vReturn = gestionCuota.actualizar(cuota);
			System.out.println(v_vReturn);
			Assert.assertEquals("Cuota editada exitosamente.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void eliminarTest() {
			
			int nIdCuota;
			nIdCuota = 1; 
			
			String vReturn = "NO_OK";
			try {
				vReturn = gestionCuota.eliminar(nIdCuota);
				Assert.assertEquals("OK", vReturn);
				System.out.println( "Se eliminó la cuota: " + nIdCuota + " correctamente.");
			} 
			catch (DAOExcepcion e) {
				Assert.fail("ERROR: " + e.getMessage());
			}
					
	}
	
	@Test
		public void ListarTest(){
			
			GestionCuota gestionCuota = new GestionCuota();
			try {
				Collection<Cuota> lstCuota = gestionCuota.listar();
				System.out.println(lstCuota.size());
				for (Cuota m : lstCuota) {
					System.out.print(m.getN_IdCuot()+" | ");
					System.out.print(m.getC_Period()+" | ");
					System.out.print(m.getN_TipPag()+" | ");
					System.out.print(m.getN_ImpPag()+" | ");
				}
				Assert.assertTrue(lstCuota.size()>0);
			} catch (DAOExcepcion e) {
				
				Assert.fail("Falló el Listado: "+e.getMessage());
			}
		}
}
