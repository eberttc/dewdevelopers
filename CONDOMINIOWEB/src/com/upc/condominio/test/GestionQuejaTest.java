package com.upc.condominio.test;

import java.sql.Date;
import java.util.Collection;
//import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;
import com.upc.condominio.negocio.GestionQueja;

public class GestionQuejaTest {

	//@Test
	public void insertarTest() {

		GestionQueja negocio = new GestionQueja();
		Date fecha = new Date(System.currentTimeMillis());
		try {
			negocio.insertarQueja(2, "LEVE","VIGILANTE FUMANDO",fecha,"En Investigacion");
		} catch (DAOExcepcion e) {
			System.out.print("Fallo la inserción");	
			Assert.fail("Fallo la inserción" + e.getMessage());
				
		}
	}
	
	@Test
	public void listarTest() {

		GestionQueja negocio = new GestionQueja();

		try {
			Collection<Queja> listado = negocio.listarQueja();
			

			System.out.println("-------------------------------------------------------------------------");
			System.out.println("CodQueja   Residente     Motivo-Queja                        Estado-Queja");
			System.out.println("-------------------------------------------------------------------------");
			
			for (Queja queja : listado) {
				System.out.print("   "+String.format("%1$-10s",queja.getintIdQueja()));
				System.out.print(String.format("%1$-10s",queja.getintIdResidente()));
				System.out.print(String.format("%1$-40s",queja.getstrMotivoQueja()));
				System.out.print(String.format("%1$-100s",queja.getstrEstadoQueja()));
				System.out.println(" ");
			}
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Total Registros:" + listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Fallo" + e.getMessage());

		}

	}
}
