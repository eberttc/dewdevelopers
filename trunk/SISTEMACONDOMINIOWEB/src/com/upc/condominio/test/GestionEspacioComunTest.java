package com.upc.condominio.test;

import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.EspacioComun;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.negocio.GestionEspacioComun;

public class GestionEspacioComunTest {

	@Test
		public void ListarEspacioComunTest(){
			
			GestionEspacioComun negocio = new GestionEspacioComun();
			try {
				Collection<EspacioComun> listado = negocio.listarEspacios();
				
				for (EspacioComun m : listado) {
					
					System.out.println(m.getIdespacio());
					System.out.println(m.getNombreEspacio());
				}
				Assert.assertTrue(listado.size()>0);
			} catch (DAOExcepcion e) {
				
				Assert.fail("Falló el Listado: "+e.getMessage());
			}
		}
}
