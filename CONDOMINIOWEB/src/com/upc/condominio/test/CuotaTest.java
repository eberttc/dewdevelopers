package com.upc.condominio.test;

import java.sql.Date;
import java.sql.NClob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.negocio.CuotaCore;
import com.upc.condominio.exceptions.DAOExcepcion;

public class CuotaTest {

	Cuota cuota = new Cuota();
	CuotaCore cuotaCore = new CuotaCore();
	
	@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		Date fechaPago = new Date(System.currentTimeMillis());
		
		cuota.setN_IdVivi(1);
		cuota.setD_FecPag(fechaPago);
		cuota.setC_Period("201301");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(120);
		cuota.setN_TipPag(1);
				
		try {
			v_vReturn = cuotaCore.insertar(cuota);
			System.out.println(v_vReturn);
			Assert.assertEquals("Cuota grabada exitosamente.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	@Test
	public void obtenerTest() {
					
			try {
				cuota = cuotaCore.obtener(1);
				Assert.assertNotNull(cuota);
				System.out.print("Periodo: " + cuota.getC_Period() + "; Importe de Pago:" + cuota.getN_ImpPag());
			} 
			catch (DAOExcepcion e) {	
				Assert.fail("ERROR: " + e.getMessage());
			}
	}
	
	@Test
	public void actualizarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		Date fechaPago = new Date(System.currentTimeMillis());
		
		cuota.setN_IdCuot(1);
		cuota.setN_IdVivi(1);
		cuota.setD_FecPag(fechaPago);
		cuota.setC_Period("201301");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(120);
		cuota.setN_TipPag(1);
				
		try {
			v_vReturn = cuotaCore.actualizar(cuota);
			System.out.println(v_vReturn);
			Assert.assertEquals("Cuota ctualizada exitosamente.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	@Test
		public void eliminarTest() {
			
			int nIdCuota;
			nIdCuota = 1; 
			
			String vReturn = "NO_OK";
			try {
				vReturn = cuotaCore.eliminar(nIdCuota);
				Assert.assertEquals("OK", vReturn);
				System.out.println( "Se eliminó la cuota: " + nIdCuota + " correctamente.");
			} 
			catch (DAOExcepcion e) {
				Assert.fail("ERROR: " + e.getMessage());
			}
					
		}
}
