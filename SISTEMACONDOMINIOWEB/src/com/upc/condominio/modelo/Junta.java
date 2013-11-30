package com.upc.condominio.modelo;

import java.sql.Date;
import java.util.List;

public class Junta {

	private int  intCodigoJunta;
	private Date dFechaJunta;
	private String tHoraJunta;
	private String strTemaJunta;
	private String strAcuerdoJunta;
	private List<Directivos> lstDirectivos;
	
	
	public Junta() {		

	
	}
	
	
	public Junta(int intCodigoJunta, Date dFechaJunta, String tHoraJunta,
			String strTemaJunta, String strAcuerdoJunta,
			List<Directivos> lstDirectivos) {
		
		this.intCodigoJunta = intCodigoJunta;
		this.dFechaJunta = dFechaJunta;
		this.tHoraJunta = tHoraJunta;
		this.strTemaJunta = strTemaJunta;
		this.strAcuerdoJunta = strAcuerdoJunta;
		this.setLstDirectivos(lstDirectivos);
	}


	public int getIntCodigoJunta() {
		return intCodigoJunta;
	}
	public void setIntCodigoJunta(int intCodigoJunta) {
		this.intCodigoJunta = intCodigoJunta;
	}
	public Date getdFechaJunta() {
		return dFechaJunta;
	}
	public void setdFechaJunta(Date dFechaJunta) {
		this.dFechaJunta = dFechaJunta;
	}
	public String gettHoraJunta() {
		return tHoraJunta;
	}
	public void settHoraJunta(String tHoraJunta) {
		this.tHoraJunta = tHoraJunta;
	}
	public String getStrTemaJunta() {
		return strTemaJunta;
	}
	public void setStrTemaJunta(String strTemaJunta) {
		this.strTemaJunta = strTemaJunta;
	}
	public String getStrAcuerdoJunta() {
		return strAcuerdoJunta;
	}
	public void setStrAcuerdoJunta(String strAcuerdoJunta) {
		this.strAcuerdoJunta = strAcuerdoJunta;
	}


	public List<Directivos> getLstDirectivos() {
		return lstDirectivos;
	}


	public void setLstDirectivos(List<Directivos> lstDirectivos) {
		this.lstDirectivos = lstDirectivos;
	}
	
	
	
}
