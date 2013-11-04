package com.upc.condominio.negocio;

import java.util.List;
import com.upc.condominio.dao.ResidenteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;


public class ResidenteCore {
	
	public Residente insertar(Residente residente) throws DAOExcepcion {
		
		try{
			ResidenteDAO dao = new ResidenteDAO();
			residente = dao.insertar(residente);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return residente;
        
	}

	public List<Residente> buscarPorNombre(String nombre) throws DAOExcepcion {
	    
		List<Residente> list = null;
		try{
			ResidenteDAO dao = new ResidenteDAO();
		    list = dao.buscarPorNombre(nombre);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return list;
		
	}
	
	public Residente obtener(int idResidente) throws DAOExcepcion {
		Residente residente = null;
		try{
			ResidenteDAO dao = new ResidenteDAO();
			residente = dao.obtener(idResidente);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return residente;
				
	}
	
	public Residente actualizar(Residente residente) throws DAOExcepcion {
		
		try{
			ResidenteDAO dao = new ResidenteDAO();
			residente = dao.actualizar(residente);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return residente;
        
	}
	
	public String eliminar(int idResidente) throws DAOExcepcion {
		
		String vReturn = "NO_OK";
		try{
			ResidenteDAO dao = new ResidenteDAO();
			vReturn = dao.eliminar(idResidente);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vReturn;
		
	}
}
