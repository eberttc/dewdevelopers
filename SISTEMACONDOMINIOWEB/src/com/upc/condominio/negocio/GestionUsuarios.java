package com.upc.condominio.negocio;

import java.util.List;

import com.upc.condominio.dao.UsuarioDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.exceptions.LoginExcepcion;
import com.upc.condominio.modelo.Usuario;


public class GestionUsuarios {

	public Usuario validarUsuario(String usuario, String clave, String tipoUsuraio)
			throws DAOExcepcion, LoginExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario,clave,tipoUsuraio);
	}
	
	public List obtienePermisos(Usuario usu) 	throws DAOExcepcion{
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.obtienePermisos(usu);				
	}

}
