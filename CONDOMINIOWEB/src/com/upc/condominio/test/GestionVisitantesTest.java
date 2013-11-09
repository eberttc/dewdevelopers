package com.upc.condominio.test;

import java.util.Collection;

import junit.framework.Assert;

import com.upc.condominio.dao.VisitanteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;
import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.negocio.GestionQueja;
import com.upc.condominio.negocio.GestionVisitantes;

public class GestionVisitantesTest {
	//@Test
		public void listarTest() {

			GestionVisitantes negocio = new GestionVisitantes();

			try {
				Collection<Visitante> listado = negocio.listar(2);

				System.out.println("-------------------------------------------------------------------------");
				System.out.println("CodQueja   Residente     Motivo-Queja                        Estado-Queja");
				System.out.println("-------------------------------------------------------------------------");
				
				for (Visitante visitante : listado) {
//					System.out.print(visitante.getintIdQueja()+"\t"+"\t");
//					System.out.print(visitante.getintIdResidente()+"\t");
//					System.out.print(visitante.getstrMotivoQueja()+"     \t"+"\t"+"\t");
//					System.out.print(visitante.getstrEstadoQueja()+"\t");
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
