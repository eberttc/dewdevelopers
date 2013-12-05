package com.upc.condominio.test;

import java.util.Collection;
import org.junit.Test;
import junit.framework.Assert;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.negocio.GestionVisitantes;

public class GestionVisitantesTest {
	@Test
		public void listarTest() {

			GestionVisitantes negocio = new GestionVisitantes();

			try {
				Collection<Visitante> listado = negocio.listarVisitante();

				System.out.println("-------------------------------------------------------------------------");
				System.out.println("CodVisitante   NomVisitante     NomResidente        Fecha/Hora");
				System.out.println("-------------------------------------------------------------------------");
			
				for (Visitante visitante : listado) {
					System.out.print(visitante.getIntCorrelativo()+"\t"+"\t");
					System.out.print(visitante.getStrNombreVisitante()+"\t"+"\t"+"\t");
					System.out.print(visitante.getStrNombreResidente()+"     \t"+"\t");
					System.out.print(visitante.getdHoraFechaVisitante()+"\t");
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
