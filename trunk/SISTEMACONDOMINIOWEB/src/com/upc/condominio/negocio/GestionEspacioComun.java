package com.upc.condominio.negocio;

import java.util.Collection;

import com.upc.condominio.dao.EspacioComunDAO;
import com.upc.condominio.dao.MensajeDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.EspacioComun;

public class GestionEspacioComun {

	public Collection<EspacioComun> listarEspacios() throws DAOExcepcion{
		EspacioComunDAO Dao = new EspacioComunDAO();
		return Dao.listarEspacios();
	}
}
