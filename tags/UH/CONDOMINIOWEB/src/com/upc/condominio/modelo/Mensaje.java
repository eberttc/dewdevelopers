package com.upc.condominio.modelo;

import java.sql.Date;

public class Mensaje {

	private int n_idMens;
	private String c_titulo;
	private String c_conten;
	private Date d_fecPub;
	
	public Mensaje() {
		
	}

	public int getN_idMens() {
		return n_idMens;
	}

	public void setN_idMens(int n_idMens) {
		this.n_idMens = n_idMens;
	}

	public String getC_titulo() {
		return c_titulo;
	}

	public void setC_titulo(String c_titulo) {
		this.c_titulo = c_titulo;
	}

	public String getC_conten() {
		return c_conten;
	}

	public void setC_conten(String c_conten) {
		this.c_conten = c_conten;
	}

	public Date getD_fecPub() {
		return d_fecPub;
	}

	public void setD_fecPub(Date d_fecPub) {
		this.d_fecPub = d_fecPub;
	}

	
}
