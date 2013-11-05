package com.upc.condominio.modelo;

import java.sql.Date;

public class Reserva {

	private int n_idRese;
	private Date d_fecReg;
	private int n_idEspa;
	private int n_idRes;
	private int n_idRanHor;
	
	
	public Reserva() {
		
	}


	public int getN_idRese() {
		return n_idRese;
	}


	public void setN_idRese(int n_idRese) {
		this.n_idRese = n_idRese;
	}


	public Date getD_fecReg() {
		return d_fecReg;
	}


	public void setD_fecReg(Date d_fecReg) {
		this.d_fecReg = d_fecReg;
	}


	public int getN_idEspa() {
		return n_idEspa;
	}


	public void setN_idEspa(int n_idEspa) {
		this.n_idEspa = n_idEspa;
	}


	public int getN_idRes() {
		return n_idRes;
	}


	public void setN_idRes(int n_idRes) {
		this.n_idRes = n_idRes;
	}


	public int getN_idRanHor() {
		return n_idRanHor;
	}


	public void setN_idRanHor(int n_idRanHor) {
		this.n_idRanHor = n_idRanHor;
	}
	
	
	
}
