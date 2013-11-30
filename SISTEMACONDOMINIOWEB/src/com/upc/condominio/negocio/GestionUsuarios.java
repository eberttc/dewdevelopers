package com.upc.condominio.negocio;

import com.upc.condominio.dao.UsuarioDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.exceptions.LoginExcepcion;
import com.upc.condominio.modelo.Usuario;


public class GestionUsuarios {

	public Usuario validarUsuario(String idUsuario, String clave, String tipoUsuraio)
			throws DAOExcepcion, LoginExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(idUsuario, clave,tipoUsuraio);
	}

}
