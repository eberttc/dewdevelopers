package com.upc.condominio.test;

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
	
	
	@Test
	public void insertarTest() {
		
		//Cambiar datos para agregar nuevo residente
		residente.setC_NomRes("JUAN PEREZ RAMIREZ");
		residente.setC_TipDoc(1);
		residente.setC_NumDoc("12345678");
		residente.setD_FecNac("01/01/1980");
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

	

}
