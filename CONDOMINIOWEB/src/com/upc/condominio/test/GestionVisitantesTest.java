package com.upc.condominio.test;

import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;

import com.upc.condominio.dao.VisitanteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;
import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.negocio.GestionQueja;
import com.upc.condominio.negocio.GestionVisitantes;

public class GestionVisitantesTest {
	@Test
		public void listarTest() {

			GestionVisitantes negocio = new GestionVisitantes();

			try {
				Collection<Visitante> listado = negocio.listar(2);

				System.out.println("-------------------------------------------------------------------------");
				System.out.println("CodVisitante   NomVisitante     CodResidente        Fecha/Hora");
				System.out.println("-------------------------------------------------------------------------");
				
				/*
				this.intCorrelativo = intCorrelativo;
				this.strDNIVisitante = strDNIVisitante;
				this.strNombreVisitante = strNombreVisitante;
				this.intCodigoResidente = intCodigoResidente;
				this.dHoraFechaVisitante = dHoraFechaVisitante;
				*/
				
				for (Visitante visitante : listado) {
					System.out.print(visitante.getintCorrelativo()+"\t"+"\t");
					System.out.print(visitante.getstrNombreVisitante()+"\t"+"\t"+"\t");
					System.out.print(visitante.getstrNombreResidente()+"     \t"+"\t"+"\t");
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
