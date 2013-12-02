package com.upc.condominio.modelo;

import java.sql.Date;

public class Queja {

	private int intIdQueja;
	private int intIdResidente;
	private String strTipoQueja;
	private String strMotivoQueja;
	private Date dFechaQueja;
	private String strEstadoQueja;

	public Queja() {
		
	}
	
	public Queja(int intIdQueja, int intIdResidente, String strTipoQueja,
			String strMotivoQueja, Date dFechaQueja, String strEstadoQueja) {
		
		this.intIdQueja = intIdQueja;
		this.intIdResidente = intIdResidente;
		this.strTipoQueja = strTipoQueja;
		this.strMotivoQueja = strMotivoQueja;
		this.dFechaQueja = dFechaQueja;
		this.strEstadoQueja = strEstadoQueja;
	}

	public int getIntIdQueja() {
		return intIdQueja;
	}

	public void setIntIdQueja(int intIdQueja) {
		this.intIdQueja = intIdQueja;
	}

	public int getIntIdResidente() {
		return intIdResidente;
	}

	public void setIntIdResidente(int intIdResidente) {
		this.intIdResidente = intIdResidente;
	}

	public String getStrTipoQueja() {
		return strTipoQueja;
	}

	public void setStrTipoQueja(String strTipoQueja) {
		this.strTipoQueja = strTipoQueja;
	}

	public String getStrMotivoQueja() {
		return strMotivoQueja;
	}

	public void setStrMotivoQueja(String strMotivoQueja) {
		this.strMotivoQueja = strMotivoQueja;
	}

	public Date getdFechaQueja() {
		return dFechaQueja;
	}

	public void setdFechaQueja(Date dFechaQueja) {
		this.dFechaQueja = dFechaQueja;
	}

	public String getStrEstadoQueja() {
		return strEstadoQueja;
	}

	public void setStrEstadoQueja(String strEstadoQueja) {
		this.strEstadoQueja = strEstadoQueja;
	}
	
	
	
}
