package com.upc.condominio.negocio;

import java.sql.Date;

import com.upc.condominio.dao.ReservaDAO;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Reserva;

public class GestionReserva {
	
	public void insertar(Date fecReg, int idEsp, int idRes,int idRanHor) throws DAOExcepcion{
		
		ReservaDAO dao = new ReservaDAO();
		Reserva r = new Reserva();
		r.setD_fecReg(fecReg);
		r.setN_idEspa(idEsp);;
		r.setN_idRes(idRes);
		r.setN_idRanHor(idRanHor);
		int aux = dao.verificarhorario(fecReg,idEsp,idRanHor);

		if(aux!=1){
			dao.insertar(r);
		}else{
			System.out.println("El espacio "+idEsp+ " de no esta disponible en este horario");
		}
	}

	
}
