package com.upc.condominio.negocio;

import java.sql.Date;
import java.util.Collection;

import com.upc.condominio.dao.MensajeDAO;
import com.upc.condominio.dao.ReservaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Horario;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.modelo.Reserva;

public class GestionReserva {
	
	public Reserva insertar(Date fecReg, int idEspacio, int idResidente,int idHorario) throws DAOExcepcion{
		
		ReservaDAO dao = new ReservaDAO();
		Reserva r = new Reserva();
		r.setFecReg(fecReg);
		r.setIdEspacio(idEspacio);
		r.setIdResidente(idResidente);
		r.setIdHorario(idHorario);
		
		return dao.insertar(r);
	}

	public Collection<Horario> listarHorariosDisponibles(Date fecha, int idEspacio) throws DAOExcepcion{
		ReservaDAO dao = new ReservaDAO();
		return dao.listarHorariosDisponibles(fecha,idEspacio);
	}
	
}
