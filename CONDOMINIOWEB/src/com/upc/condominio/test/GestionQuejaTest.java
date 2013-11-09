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
			negocio.insertarQueja(3, "Grave","Falta de Respeto Vigilante",fecha,"En Investigación");
//			negocio.insertarQueja(intIdResidente, strTipoQueja, strMotivoQueja, dFechaQueja, strEstadoQueja);

			//Categoria nuevo = negocio.obtener(3);
			//Assert.assertEquals("Categoria de Smartphones", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {
				Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	@Test
	public void listarTest() {

		GestionQueja negocio = new GestionQueja();

		try {
			Collection<Queja> listado = negocio.listarQueja();

			System.out.println(listado.size());
			

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Fallo" + e.getMessage());

		}

	}
}
