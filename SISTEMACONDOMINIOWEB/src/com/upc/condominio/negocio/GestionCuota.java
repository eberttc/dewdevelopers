package com.upc.condominio.negocio;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sun.org.apache.bcel.internal.generic.IDIV;
import com.upc.condominio.dao.CuotaDAO;
import com.upc.condominio.dao.ViviendaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.modelo.Vivienda;

public class GestionCuota {

	public String insertar(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		CuotaDAO cuotaDAO = new CuotaDAO();
		
		try{
			
			v_vReturn = obtenerPeriodoVivienda(cuota);
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.insertarPA(cuota);
				v_vReturn = "Cuota Grabada exitosamente.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
	
	public String obtenerPeriodoVivienda(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		Cuota cuotaBuscada = null; 

		try{
			CuotaDAO cuotaDAO = new CuotaDAO();
			cuotaBuscada = cuotaDAO.obtenerPeriodoViviendaPA(cuota);
			
			if (cuotaBuscada == null){
				v_vReturn = "OK";
			}else if (cuotaBuscada != null){
				v_vReturn = "ERROR - Cuota ya se encuentra registrado para Periodo y Vivienda.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
	}
	
	public Cuota obtener(Cuota cuota) throws DAOExcepcion {
		Cuota cuotaBuscada = null;
		try{
			CuotaDAO cuotaDao = new CuotaDAO();
			cuotaBuscada = cuotaDao.obtenerPA(cuota);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return cuotaBuscada;
	}
	
	public String actualizar(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		CuotaDAO cuotaDAO = new CuotaDAO();
		
		try{
			Cuota cuotaAux = new Cuota ();
			cuotaAux = obtener(cuota);	
			if (cuotaAux.getN_TipPag()==0
			 || cuotaAux.getD_FecPag()==null){
				v_vReturn = "OK";
			}else{
				v_vReturn = obtenerPeriodoVivienda(cuota);
			} 
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.actualizarPA(cuota);
				v_vReturn = "Cuota editada exitosamente.";
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}

	public String eliminar(Cuota cuota) throws DAOExcepcion {
		
		String vReturn = "NO_OK";
		try{
			CuotaDAO cuotaDao = new CuotaDAO();
			vReturn = cuotaDao.eliminarPA(cuota);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vReturn;
		
	}

	public Collection<Cuota> listar(Cuota pcuota) throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarPA(pcuota);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}
	
	public Collection<Cuota> listarPorResidente(String pLoginResidente) throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarPorResidentePA(pLoginResidente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}

	public Collection<Vivienda> listarViviendaSinCuota(Cuota pcuota) throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		Collection<Vivienda> listaVivienda = new ArrayList<Vivienda>();
		Collection<Vivienda> listaViviendaNueva = new ArrayList<Vivienda>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			ViviendaDAO viviendaDAO = new ViviendaDAO();
			listaCuota = cuotaDAO.listarPA(pcuota);
			listaVivienda= viviendaDAO.listar();
			int idvivienda = 0;
			for(Cuota cuota : listaCuota)
			{
				if(cuota.getN_ImpPag()==0)
				{
					idvivienda = cuota.getN_IdVivi();
					for(Vivienda vivienda : listaVivienda)
						if(vivienda.getN_IdVivi()==idvivienda)
							listaViviendaNueva.add(vivienda);
				}
					
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaViviendaNueva;
	}
	
	public Collection<Cuota> listarCuotasNoPagadas() throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarCuotasNoPagadas();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}

	public Collection<Cuota> listarCuotasVencidas() throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarCuotasVencidas();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}

	public Collection<Cuota> listarCuotasVencidasPorVivienda(int idVivienda) throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarCuotasVencidasXvivienda(idVivienda);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}
	
	public Collection<Cuota> listarCuotasVencidasPorResidente(int idResidente) throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listarCuotasVencidasXResidente(idResidente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuota;
	}

	public String realizarPago(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		CuotaDAO cuotaDAO = new CuotaDAO();
		
		try{
			Cuota cuotaAux = new Cuota ();
			cuotaAux = obtener(cuota);	
			
			if ((cuota.getC_Period().equals(cuotaAux.getC_Period()) )
					&&(cuota.getN_IdVivi()==cuotaAux.getN_IdVivi())){
				v_vReturn = "OK";
			}else{
				v_vReturn = obtenerPeriodoVivienda(cuota);
			} 
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.realizarPagoPA(cuota);
				v_vReturn = "Cuota pagada exitosamente.";
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
			
		
}
