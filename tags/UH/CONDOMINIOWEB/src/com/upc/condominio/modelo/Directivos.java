package com.upc.condominio.modelo;

public class Directivos {

	private int intCodigoDirectivo;
	private String strNombreDirectivo;
	private String strCargo;
	private String strPresideJunta;
	


	public Directivos(int intCodigoDirectivo, String strNombreDirectivo,
			String strCargo, int intCodigoResidente,String strPresideJunta) {
		
		this.intCodigoDirectivo = intCodigoDirectivo;
		this.strNombreDirectivo = strNombreDirectivo;
		this.strCargo = strCargo;
		this.intCodigoResidente = intCodigoResidente;
		this.strPresideJunta=strPresideJunta;
	}

	
	public Directivos(int intCodigoDirectivo, String strPresideJunta) {
		
		this.intCodigoDirectivo = intCodigoDirectivo;
		this.strPresideJunta = strPresideJunta;
	}


	public int getIntCodigoDirectivo() {
		return intCodigoDirectivo;
	}

	public void setIntCodigoDirectivo(int intCodigoDirectivo) {
		this.intCodigoDirectivo = intCodigoDirectivo;
	}


	public String getStrNombreDirectivo() {
		return strNombreDirectivo;
	}


	public void setStrNombreDirectivo(String strNombreDirectivo) {
		this.strNombreDirectivo = strNombreDirectivo;
	}


	public String getStrCargo() {
		return strCargo;
	}


	public void setStrCargo(String strCargo) {
		this.strCargo = strCargo;
	}


	public int getIntCodigoResidente() {
		return intCodigoResidente;
	}


	public void setIntCodigoResidente(int intCodigoResidente) {
		this.intCodigoResidente = intCodigoResidente;
	}


	private int intCodigoResidente;
	
	
	public Directivos() {
		// TODO Auto-generated constructor stub
	
	}

	public String getStrPresideJunta() {
		return strPresideJunta;
	}

	public void setStrPresideJunta(String strPresideJunta) {
		this.strPresideJunta = strPresideJunta;
	}

}
