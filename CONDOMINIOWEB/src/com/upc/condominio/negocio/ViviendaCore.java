package com.upc.condominio.negocio;

import java.util.List;

import com.upc.condominio.dao.ViviendaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Vivienda;

public class ViviendaCore {

	public Vivienda insertar(Vivienda vivienda) throws DAOExcepcion {
		
		try{
			ViviendaDAO dao = new ViviendaDAO();
			vivienda = dao.insertar(vivienda);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vivienda;
        
	}
	
	public Vivienda obtener(int idVivienda) throws DAOExcepcion {
		Vivienda vivienda = null;
		try{
			ViviendaDAO dao = new ViviendaDAO();
			vivienda = dao.obtener(idVivienda);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vivienda;
				
	}
	
	public Vivienda actualizar(Vivienda vivienda) throws DAOExcepcion {
		
		try{
			ViviendaDAO dao = new ViviendaDAO();
			vivienda = dao.actualizar(vivienda);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vivienda;
        
	}
	
	public String eliminar(int idVivienda) throws DAOExcepcion {
		
		String vReturn = "NO_OK";
		try{
			ViviendaDAO dao = new ViviendaDAO();
			vReturn = dao.eliminar(idVivienda);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return vReturn;
		
	}
}
