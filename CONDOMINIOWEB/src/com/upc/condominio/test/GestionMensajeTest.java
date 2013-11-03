package com.upc.condominio.test;

import java.util.Collection;
import org.junit.Test;
import junit.framework.Assert;

import com.upc.condominio.negocio.GestionMensaje;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;

public class GestionMensajeTest {
	
	
	@Test
	public void ListarMensajeTest(){
		
		GestionMensaje negocio = new GestionMensaje();
		try {
			Collection<Mensaje> listado = negocio.listar();
			System.out.println(listado.size());
			for (Mensaje m : listado) {
				System.out.print(m.getN_idMens());
				System.out.print(m.getC_titulo());
				System.out.print(m.getC_conten());
				System.out.print(m.getD_fecPub());
			}
			Assert.assertTrue(listado.size()>0);
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}

}
