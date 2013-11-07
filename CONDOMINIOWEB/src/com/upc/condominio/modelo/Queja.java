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
	
	public int getintIdQueja() {
		return intIdQueja;
	}
	public void setintIdQueja(int intIdQueja) {
		this.intIdQueja = intIdQueja;
	}
	public int getintIdResidente() {
		return intIdResidente;
	}
	public void setintIdResidente(int intIdResidente) {
		this.intIdResidente = intIdResidente;
	}
	
	public String getstrTipoQueja() {
		return strTipoQueja;
	}
	public void setstrTipoQueja(String strTipoQueja) {
		this.strTipoQueja = strTipoQueja;
	}

	public String getstrMotivoQueja() {
		return strMotivoQueja;
	}
	public void setstrMotivoQueja(String strMotivoQueja) {
		this.strMotivoQueja = strMotivoQueja;
	}

	public Date getdFechaQueja() {
		return dFechaQueja;
	}
	public void setdFechaQueja(Date dFechaQueja) {
		this.dFechaQueja = dFechaQueja;
	}

	public String getstrEstadoQueja() {
		return strEstadoQueja;
	}
	public void setstrEstadoQueja(String strEstadoQueja) {
		this.strEstadoQueja = strEstadoQueja;
	}
	
}
