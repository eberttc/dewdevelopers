package com.upc.condominio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.modelo.Residente;
import com.upc.condominio.negocio.GestionResidente;

import com.upc.condominio.exceptions.DAOExcepcion;

public class ResidenteTest {

	Residente residente = new Residente();
	GestionResidente gestionResidente = new GestionResidente();
	
	
	@Test
	public void insertarTest() throws ParseException {
		
		String v_vReturn = "NO_OK";

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		residente.setNombreResidente("TAMARA VALDIVIESO");
		residente.setTipoDocumento(1);
		residente.setNumeroDocumento("69696969");
		residente.setFechaNacimiento(df.parse("08/11/1984"));
		residente.setCorreo("TVALDIVIESO@GMAIL.COM");
		residente.setClave("ADMIN");
		residente.setEstadoRegistro(1);
				
		try {
			v_vReturn = gestionResidente.insertar(residente);
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
	        residenteList = gestionResidente.buscarPorNombre("ADNA");
	        Assert.assertNotNull(residenteList);
	        
	        for (Residente residente : residenteList){
	        	System.out.println(residente.getIdResidente() + " " + residente.getNombreResidente() + " " + residente.getCorreo() );
	        }
		}
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	
	
	//@Test
	public void obtenerTest() {
				
		try {
			residente = gestionResidente.obtener(8);
			Assert.assertNotNull(residente);
			System.out.print("Nombre: " + residente.getNombreResidente() + "; Correo:" + residente.getCorreo());
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() throws ParseException{
		
		String v_vReturn = "NO_OK";

		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

		residente.setIdResidente(8);
		residente.setNombreResidente("ARIADNA VALDIVIESO");
		residente.setTipoDocumento(1);
		residente.setNumeroDocumento("69696969");
		residente.setFechaNacimiento(df.parse("08/11/1984"));
		residente.setCorreo("AVALDIVIESO@GMAIL.COM");
		
		try {
			v_vReturn = gestionResidente.actualizar(residente);
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
			vReturn = gestionResidente.eliminar(nResidente);
			Assert.assertEquals("OK", vReturn);
			System.out.println( "SE ELIMIN� EL RESIDENTE: " + nResidente + " CORRECTAMENTE.");
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
				
	}
		
}
