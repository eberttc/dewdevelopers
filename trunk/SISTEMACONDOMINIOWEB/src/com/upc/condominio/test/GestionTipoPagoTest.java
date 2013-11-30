package com.upc.condominio.test;

import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.TipoPago;
import com.upc.condominio.negocio.GestionTipoPago;

public class GestionTipoPagoTest {

	@Test
	public void ListarTest(){
		GestionTipoPago gestionTipoPago = new GestionTipoPago();
		try {
			Collection<TipoPago> lstTipoPago = gestionTipoPago.listar("S");
			System.out.println(lstTipoPago.size());
			for (TipoPago m : lstTipoPago) {
				System.out.print(m.getnTipoPago()+" | ");
				System.out.print(m.getcDescri()+" | ");
				System.out.print(m.getcEstReg()+" | ");
				}
				Assert.assertTrue(lstTipoPago.size()>0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Listado: "+e.getMessage());
		}
	}
}
