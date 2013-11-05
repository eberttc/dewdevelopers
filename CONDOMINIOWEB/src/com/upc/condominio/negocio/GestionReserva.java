package com.upc.condominio.negocio;

import java.sql.Date;

import com.upc.condominio.dao.ReservaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Reserva;

public class GestionReserva {
	
	public Reserva insertar(Date fecReg, int idEsp, int idRes,int idRanHor) throws DAOExcepcion{
		
		ReservaDAO dao = new ReservaDAO();
		Reserva r = new Reserva();
		r.setD_fecReg(fecReg);
		r.setN_idEspa(idEsp);;
		r.setN_idRes(idRes);
		r.setN_idRanHor(idRanHor);
		return dao.insertar(r);
	}

	
}
