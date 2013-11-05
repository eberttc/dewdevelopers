package com.upc.condominio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.modelo.Residente;
import com.upc.condominio.negocio.ResidenteCore;

import com.upc.condominio.exceptions.DAOExcepcion;

public class ResidenteTest {

	Residente residente = new Residente();
	ResidenteCore residenteCore = new ResidenteCore();
	
	
	@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		residente.setC_NomRes("TAMARA VALDIVIESO");
		residente.setC_TipDoc(1);
		residente.setC_NumDoc("69696969");
		residente.setD_FecNac(df.parse("08/11/1984"));
		residente.setC_Correo("TVALDIVIESO@GMAIL.COM");
		residente.setC_Clave("ADMIN");
		residente.setC_EstReg(1);
				
		try {
			v_vReturn = residenteCore.insertar(residente);
			System.out.println(v_vReturn);
			Assert.assertEquals("RESIDENTE GRABADO EXITOSAMENTE.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorNombreTest (){
		
		try {
			List<Residente> residenteList = new ArrayList<Residente>();
	        residenteList = residenteCore.buscarPorNombre("ADNA");
	        Assert.assertNotNull(residenteList);
	        
	        for (Residente residente : residenteList){
	        	System.out.println(residente.getN_CodRes() + " " + residente.getC_NomRes() + " " + residente.getC_Correo() );
	        }
		}
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	
	
	//@Test
	public void obtenerTest() {
				
		try {
			residente = residenteCore.obtener(8);
			Assert.assertNotNull(residente);
			System.out.print("Nombre: " + residente.getC_NomRes() + "; Correo:" + residente.getC_Correo());
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() throws ParseException{
		
		String v_vReturn = "NO_OK";

		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

		residente.setN_CodRes(8);
		residente.setC_NomRes("ARIADNA VALDIVIESO");
		residente.setC_TipDoc(1);
		residente.setC_NumDoc("69696969");
		residente.setD_FecNac(df.parse("08/11/1984"));
		residente.setC_Correo("AVALDIVIESO@GMAIL.COM");
		
		try {
			v_vReturn = residenteCore.actualizar(residente);
			System.out.println(v_vReturn);
			Assert.assertEquals("RESIDENTE EDITADO EXITOSAMENTE.",v_vReturn);
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
				
	}
		
	//@Test
	public void eliminarTest() {
		
		int nResidente;
		nResidente = 8; 
		
		String vReturn = "NO_OK";
		try {
			vReturn = residenteCore.eliminar(nResidente);
			Assert.assertEquals("OK", vReturn);
			System.out.println( "SE ELIMINÓ EL RESIDENTE: " + nResidente + " CORRECTAMENTE.");
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
				
	}
		
}
