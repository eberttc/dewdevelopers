package com.upc.condominio.negocio;

import java.util.List;
import com.upc.condominio.dao.ResidenteDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;


public class ResidenteCore {
	
	public String insertar(Residente residente) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		ResidenteDAO dao = new ResidenteDAO();
		
		try{
			
			v_vReturn = getExisteDocumento(residente.getC_TipDoc(), residente.getC_NumDoc());
			
			if (v_vReturn.equals("OK")){

				v_vReturn = getExisteCorreo(residente.getC_Correo());
				
				if (v_vReturn.equals("OK")){
					residente = dao.insertar(residente);
					v_vReturn = "RESIDENTE GRABADO EXITOSAMENTE.";
				}
				
			}
						
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
        
	}
	
	public String getExisteDocumento(int p_nTi_Doc, String p_vNu_Doc) throws DAOExcepcion {

		String v_vReturn = "ERROR - Consulte con Administrador";
		int v_nCantidad = 0; 

		try{
			ResidenteDAO dao = new ResidenteDAO();
			v_nCantidad = dao.getExisteDocumento(p_nTi_Doc, p_vNu_Doc);
			
			if (v_nCantidad == 0){
				v_vReturn = "OK";
			}else if (v_nCantidad == 1){
				v_vReturn = "ERROR - Documento ya se encuentra registrado.";
			}else {
				v_vReturn = "ERROR - Muchos registros con el mismo documento.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
				
	}
	
	public String getExisteCorreo(String p_vCorreo) throws DAOExcepcion {

		String v_vReturn = "ERROR - Consulte con Administrador";
		int v_nCantidad = 0; 

		try{
			ResidenteDAO dao = new ResidenteDAO();
			v_nCantidad = dao.getExisteCorreo(p_vCorreo);
			
			if (v_nCantidad == 0){
				v_vReturn = "OK";
			}else if (v_nCantidad == 1){
				v_vReturn = "ERROR - Correo ya se encuentra registrado.";
			}else {
				v_vReturn = "ERROR - Muchos registros con el mismo correo.";
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
				
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
	
	public String actualizar(Residente residente) throws DAOExcepcion {
		
		String v_vReturn = "ERROR - Consulte con Administrador";
		ResidenteDAO dao = new ResidenteDAO();
		
		try{
			Residente residenteAux = new Residente();
			residenteAux = obtener(residente.getN_CodRes());	
			
			if ((residente.getC_TipDoc()==residenteAux.getC_TipDoc()) && (residente.getC_NumDoc().equals(residenteAux.getC_NumDoc()))){
				v_vReturn = "OK";
			}else{
				v_vReturn = getExisteDocumento(residente.getC_TipDoc(), residente.getC_NumDoc());
			} 
			
			if (v_vReturn.equals("OK")){
				if (residente.getC_Correo().equals(residenteAux.getC_Correo())){
					v_vReturn = "OK";
				}else{
					v_vReturn = getExisteCorreo(residente.getC_Correo());	
				}
			}
			
			if (v_vReturn.equals("OK")){
				residente = dao.actualizar(residente);
				v_vReturn = "RESIDENTE EDITADO EXITOSAMENTE.";
			}
				
						
		}
		catch (Exception e) {
            e.printStackTrace();
        }
        return v_vReturn;
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
