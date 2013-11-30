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
	
	@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		Date fechaPago = new Date(System.currentTimeMillis());
		
		cuota.setN_IdVivi(1);
		cuota.setD_FecPag(fechaPago);
		cuota.setC_Period("201305");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(135);
				
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
				Cuota cuotaBuscar = new Cuota();
				cuotaBuscar.setN_IdCuot(3);
				cuota = gestionCuota.obtener(cuotaBuscar);
				Assert.assertNotNull(cuota);
				System.out.print("Periodo: " + cuota.getC_Period() + "; Importe de Pago:" + cuota.getN_ImpPag());
			} 
			catch (DAOExcepcion e) {	
				Assert.fail("ERROR: " + e.getMessage());
			}
	}
	
	//@Test
	public void obtenerPeriodoViviendaTest() {
					
		try {
			Cuota cuotaBuscar = new Cuota();
			String buscado = "NO_OK";
			cuotaBuscar.setC_Period("201301");
			cuotaBuscar.setN_IdVivi(4);
			buscado = gestionCuota.obtenerPeriodoVivienda(cuotaBuscar);
			//Assert.assertEquals("ERROR", buscado.contains("ERROR"));
			System.out.print("Periodo: " + buscado);
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";
		Date fechaVenc = new Date(System.currentTimeMillis());
		
		cuota.setN_IdCuot(2);
		cuota.setN_IdVivi(3);
		cuota.setC_Period("201301");
		cuota.setD_FecVen(fechaVenc);
		cuota.setN_ImpPag(150);
				
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
			
			Cuota cuota = new Cuota();
			cuota.setN_IdCuot(2); 
			
			String vReturn = "NO_OK";
			try {
				vReturn = gestionCuota.eliminar(cuota);
				Assert.assertEquals("OK", vReturn);
				System.out.println( "Se eliminó la cuota: " + cuota.getN_IdCuot() + " correctamente.");
			} 
			catch (DAOExcepcion e) {
				Assert.fail("ERROR: " + e.getMessage());
			}
					
	}
	
	//@Test
	public void ListarTest(){
		Cuota pcuota = new Cuota();
		pcuota.setC_Period("201301");
		
		GestionCuota gestionCuota = new GestionCuota();
		try {
			Collection<Cuota> lstCuota = gestionCuota.listar(pcuota);
			System.out.println(lstCuota.size());
			for (Cuota m : lstCuota) {
				System.out.println(m.getN_IdCuot()+" | " + m.getC_Period()+" | "+m.getO_Vivienda().getResidente().getNombreResidente()+" | "+m.getN_TipPag()+" | "+m.getN_ImpPag()+" | "+m.getO_TipPag().getcDescri()+" | ");
			}
			Assert.assertTrue(lstCuota.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}
		
	//@Test
	public void ListarCuotasNoPagadasTest(){
		
		GestionCuota gestionCuota = new GestionCuota();
		try {
			Collection<Cuota> lstCuota = gestionCuota.listarCuotasNoPagadas();
			System.out.println("Cuotas no pagadas:");
			for (Cuota m : lstCuota) {
				System.out.println( "Id Cuota        ==> "+m.getN_IdCuot()+"\n"+
						"Nombre Residente==> "+m.getO_Vivienda().getResidente().getNombreResidente()+"\n"+
						"Documento Residente==> "+m.getO_Vivienda().getResidente().getNumeroDocumento()+"\n"+
			            "Importe Vencido ==> "+m.getN_ImpPag()+"\n"+
						"Id Vivienda     ==> "+ m.getO_Vivienda().getN_IdVivi()+"\n"+
						"Nro Edificio    ==> "+ m.getO_Vivienda().getC_Ubicacion()+"\n"+
						"Nro Dpto        ==> "+ m.getO_Vivienda().getC_Numero()+"\n\n");
			}
			Assert.assertTrue(lstCuota.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}
	
	//@Test
	public void ListarCuotasVencidasTest(){
		
		GestionCuota gestionCuota = new GestionCuota();
		try {
			Collection<Cuota> lstCuota = gestionCuota.listarCuotasVencidas();
			System.out.println(lstCuota.size());
			for (Cuota m : lstCuota) {
				System.out.println( "Id Cuota        ==> "+m.getN_IdCuot()+"\n"+
						"Nombre Residente==> "+m.getO_Vivienda().getResidente().getNombreResidente()+"\n"+
						"Documento Residente==> "+m.getO_Vivienda().getResidente().getNumeroDocumento()+"\n"+
			            "Importe Vencido ==> "+m.getN_ImpPag()+"\n"+
						"Id Vivienda     ==> "+ m.getO_Vivienda().getN_IdVivi()+"\n"+
						"Nro Edificio    ==> "+ m.getO_Vivienda().getC_Ubicacion()+"\n"+
						"Nro Dpto        ==> "+ m.getO_Vivienda().getC_Numero()+"\n\n");
			}
			Assert.assertTrue(lstCuota.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}
	//@Test
	public void ListarCuotasVencidasXviviendaTest(){
		
		GestionCuota gestionCuota = new GestionCuota();
		try {
			Collection<Cuota> lstCuota = gestionCuota.listarCuotasVencidasPorVivienda(1);
			System.out.println("Cuotas Vencidas por vivienda");
			for (Cuota m : lstCuota) {
				System.out.println( "Id Cuota        ==> "+m.getN_IdCuot()+"\n"+
									"Nombre Residente==> "+m.getO_Vivienda().getResidente().getNombreResidente()+"\n"+
									"Documento Residente==> "+m.getO_Vivienda().getResidente().getNumeroDocumento()+"\n"+
						            "Importe Vencido ==> "+m.getN_ImpPag()+"\n"+
									"Id Vivienda     ==> "+ m.getO_Vivienda().getN_IdVivi()+"\n"+
									"Nro Edificio    ==> "+ m.getO_Vivienda().getC_Ubicacion()+"\n"+
									"Nro Dpto        ==> "+ m.getO_Vivienda().getC_Numero()+"\n\n");
			}
			Assert.assertTrue(lstCuota.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}
	
	//@Test
	public void realizarPagoTest() throws ParseException {
			
			String v_vReturn = "NO_OK";
			Date fechaPago = new Date(System.currentTimeMillis());
			
			cuota.setN_IdCuot(3);
			cuota.setN_IdVivi(4);
			cuota.setN_IdCuot(9);
			cuota.setD_FecPag(fechaPago);
			cuota.setN_TipPag(1);
					
			try {
				v_vReturn = gestionCuota.realizarPago(cuota);
				System.out.println(v_vReturn);
				Assert.assertEquals("Cuota pagada exitosamente.",v_vReturn);
			} 
			catch (DAOExcepcion e) {
				Assert.fail("ERROR: " + e.getMessage());
			}
		}

}
