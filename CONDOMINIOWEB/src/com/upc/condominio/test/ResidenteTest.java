package com.upc.condominio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.upc.condominio.core.ResidenteCore;
import com.upc.condominio.modelo.Residente;

import com.upc.condominio.exceptions.DAOExcepcion;

public class ResidenteTest {

	Residente residente = new Residente();
	ResidenteCore residenteCore = new ResidenteCore();
	
	
	//@Test
	public void insertarTest() throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		residente.setC_NomRes("JUAN PEREZ RAMIREZ");
		residente.setC_TipDoc(1);
		residente.setC_NumDoc("12345678");
		residente.setD_FecNac(df.parse("01/01/1980"));
		residente.setC_Correo("JPEREZ@GMAIL.COM");
		residente.setC_Clave("ADMIN");
		residente.setC_EstReg(1);
				
		try {
			residente = residenteCore.insertar(residente);
			Assert.assertNotNull(residente);
			System.out.println( "SE INSERTÓ EL RESIDENTE: " +residente.getN_CodRes() + " " + residente.getC_NomRes());
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorNombreTest (){
		
		try {
			List<Residente> residenteList = new ArrayList<Residente>();
	        residenteList = residenteCore.buscarPorNombre("PEREZ");
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
			residente = residenteCore.obtener(1);
			Assert.assertNotNull(residente);
			System.out.print("Nombre: " + residente.getC_NomRes() + "; Correo:" + residente.getC_Correo());
		} 
		catch (DAOExcepcion e) {	
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
	
	@Test
	public void actualizarTest() throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

		residente.setN_CodRes(2);
		residente.setD_FecNac(df.parse("02/02/1979"));
		residente.setC_NomRes("JUAN RAMIREZ ROJAS");
		residente.setC_TipDoc(1);
		residente.setC_NumDoc("12345679");
		residente.setC_Correo("JPEREZ@GMAIL.COM");
		
		try {
			residente = residenteCore.actualizar(residente);
			Assert.assertNotNull(residente);
			System.out.println( "SE ACTUALIZÓ LOS DATOS DEL RESIDENTE: " + residente.getN_CodRes() + " " + residente.getC_NomRes());
		} 
		catch (DAOExcepcion e) {
			Assert.fail("ERROR: " + e.getMessage());
		}
	}
		

		
}
