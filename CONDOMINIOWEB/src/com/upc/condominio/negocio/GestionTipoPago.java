package com.upc.condominio.negocio;

import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.dao.TipoPagoDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.TipoPago;

public class GestionTipoPago {
	
	public Collection<TipoPago> listar(String estadoTipoPago) throws DAOExcepcion {
		
		Collection<TipoPago> lstTipoPago = new ArrayList<TipoPago>();
		try {
			TipoPagoDAO tipoPagoDAO = new TipoPagoDAO();
			lstTipoPago = tipoPagoDAO.listar(estadoTipoPago);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstTipoPago;
	}
}
