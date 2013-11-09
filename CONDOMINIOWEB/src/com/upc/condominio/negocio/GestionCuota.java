package com.upc.condominio.negocio;

import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.dao.CuotaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;

public class GestionCuota {

	public String insertar(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		CuotaDAO cuotaDAO = new CuotaDAO();
		
		try{
			
			v_vReturn = buscar(cuota);
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.insertar(cuota);
				v_vReturn = "Cuota Grabada exitosamente.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
	
	public String buscar(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		Cuota cuotaBuscada = null; 

		try{
			CuotaDAO cuotaDAO = new CuotaDAO();
			cuotaBuscada = cuotaDAO.buscar(cuota);
			
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
	
	public Cuota obtener(int idCuota) throws DAOExcepcion {
		Cuota cuota = null;
		try{
			CuotaDAO cuotaDao = new CuotaDAO();
			cuota = cuotaDao.obtener(idCuota);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return cuota;
	}
	
	public String actualizar(Cuota cuota) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		CuotaDAO cuotaDAO = new CuotaDAO();
		
		try{
			Cuota cuotaAux = new Cuota ();
			cuotaAux = obtener(cuota.getN_IdCuot());	
			
			if ((cuota.getC_Period()==cuotaAux.getC_Period())
					&&(cuota.getN_IdVivi()==cuotaAux.getN_IdVivi())){
				v_vReturn = "OK";
			}else{
				v_vReturn = buscar(cuota);
			} 
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.actualizar(cuota);
				v_vReturn = "Cuota editada exitosamente.";
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}

	public String eliminar(int idCuota) throws DAOExcepcion {
		
		String vReturn = "NO_OK";
		try{
			CuotaDAO cuotaDao = new CuotaDAO();
			vReturn = cuotaDao.eliminar(idCuota);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vReturn;
		
	}

	public Collection<Cuota> listar() throws DAOExcepcion {
		Collection<Cuota> listaCuota = new ArrayList<Cuota>();
		try {
			CuotaDAO cuotaDAO = new CuotaDAO();
			listaCuota = cuotaDAO.listar();

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
			cuotaAux = obtener(cuota.getN_IdCuot());	
			
			if ((cuota.getC_Period()==cuotaAux.getC_Period())
					&&(cuota.getN_IdVivi()==cuotaAux.getN_IdVivi())){
				v_vReturn = "OK";
			}else{
				v_vReturn = buscar(cuota);
			} 
			
			if (v_vReturn.equals("OK")){
				cuota = cuotaDAO.realizarPago(cuota);
				v_vReturn = "Cuota pagada exitosamente.";
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
			
		
}
