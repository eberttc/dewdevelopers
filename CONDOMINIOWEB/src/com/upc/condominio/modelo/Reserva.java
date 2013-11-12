package com.upc.condominio.modelo;

import java.sql.Date;

public class Reserva {

	private int idReserva;
	private Date fecReg;
	private int idEspacio;
	private int idResidente;
	private int idHorario;
	
	
	public Reserva() {
		
	}


	public int getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	public Date getFecReg() {
		return fecReg;
	}


	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}


	public int getIdEspacio() {
		return idEspacio;
	}


	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}


	public int getIdResidente() {
		return idResidente;
	}


	public void setIdResidente(int idResidente) {
		this.idResidente = idResidente;
	}


	public int getIdHorario() {
		return idHorario;
	}


	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	
}