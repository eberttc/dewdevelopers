package com.upc.condominio.negocio;

import java.util.Collection;

import com.upc.condominio.dao.MensajeDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;

public class GestionMensaje {

	public Collection<Mensaje> listar() throws DAOExcepcion{
		MensajeDAO mensajeDao = new MensajeDAO();
		return mensajeDao.listar();
	}
}
