package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.Collection;


import com.upc.condominio.dao.MensajeDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;

public class GestionMensaje {

	public Mensaje insertarMensaje(String titulo, String contenido, Date fec_pub)throws DAOExcepcion {
		
		MensajeDAO dao = new MensajeDAO();

		Mensaje m = new Mensaje();
		m.setC_titulo(titulo);
		m.setC_conten(contenido);
		m.setD_fecPub(fec_pub);
		
		return dao.insertarMensaje(m);
	}
	
	public Mensaje actualizarMensaje(int id, String titulo, String contenido, Date fec_pub)throws DAOExcepcion {
		
		MensajeDAO dao = new MensajeDAO();

		Mensaje m = new Mensaje();
		m.setN_idMens(id);
		m.setC_titulo(titulo);
		m.setC_conten(contenido);
		m.setD_fecPub(fec_pub);
		
		return dao.actualizarMensaje(m);
	}

	public void eliminarMensaje(int id_mensaje) throws DAOExcepcion {
	
		MensajeDAO dao = new MensajeDAO();
		dao.eliminarMensaje(id_mensaje);
	
}
	
	public Collection<Mensaje> listarMensajeResidente(int x) throws DAOExcepcion{
		MensajeDAO mensajeDao = new MensajeDAO();
		return mensajeDao.listarMensajeResidente(x);
	}
}
