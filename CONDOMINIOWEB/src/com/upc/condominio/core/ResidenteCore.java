package com.upc.condominio.core;

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

	
}
