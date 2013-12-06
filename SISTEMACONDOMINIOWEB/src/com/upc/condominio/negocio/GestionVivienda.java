package com.upc.condominio.negocio;

import java.util.ArrayList;
import java.util.List;

import com.upc.condominio.dao.ResidenteDAO;
import com.upc.condominio.dao.ViviendaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.modelo.Vivienda;

public class GestionVivienda {

	public String insertar(Vivienda vivienda) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		ViviendaDAO dao = new ViviendaDAO();
		
		try{
			
			v_vReturn = getExisteVivienda(vivienda);
			
			if (v_vReturn.equals("OK")){
				vivienda = dao.insertar(vivienda);
				v_vReturn = "VIVIENDA GRABADA EXITOSAMENTE.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
	
	public String getExisteVivienda(Vivienda vivienda) throws DAOExcepcion {
	
		String v_vReturn = "ERROR - Consulte con Administrador";
		int v_nCantidad = 0; 

		try{
			ViviendaDAO dao = new ViviendaDAO();
			v_nCantidad = dao.getExisteVivienda(vivienda);
			
			if (v_nCantidad == 0){
				v_vReturn = "OK";
			}else if (v_nCantidad == 1){
				v_vReturn = "ERROR - Vivienda ya se encuentra registrado.";
			}else {
				v_vReturn = "ERROR - Muchos registros con los mismos datos.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
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
	public List<Vivienda> obtenerPorId(int idVivienda) throws DAOExcepcion {
		
	
			ViviendaDAO dao = new ViviendaDAO();
			 return  dao.listar(idVivienda);
		
       
				
	}
	
	public List<Vivienda> listar() throws DAOExcepcion {
		List<Vivienda> lista =null;
		try{
			ViviendaDAO dao = new ViviendaDAO();
		    lista = dao.listar();
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
		
	}

	public String actualizar(Vivienda vivienda) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		ViviendaDAO dao = new ViviendaDAO();
		
		try{
			Vivienda viviendaAux = new Vivienda();
			viviendaAux = obtener(vivienda.getN_IdVivi());	
			
			if ((vivienda.getC_Ubicacion().equals(viviendaAux.getC_Ubicacion()))&&(vivienda.getC_Numero().equals(viviendaAux.getC_Numero()))
				&&(vivienda.getC_TipViv().equals(viviendaAux.getC_TipViv()))){
				v_vReturn = "OK";
			}else{
				v_vReturn = getExisteVivienda(vivienda);
			} 
			
			if (v_vReturn.equals("OK")){
				vivienda = dao.actualizar(vivienda);
				v_vReturn = "VIVIENDA EDITADA EXITOSAMENTE.";
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
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
