package com.upc.condominio.modelo;

public class Vivienda {

	private int N_IdVivi;
	private int C_Ubicacion;
	private String C_Numero;
	private Double N_Metraje;
	private int C_TipViv;
	private int N_CodRes;
	private int C_EstReg;
	private Residente residente;
	
	public Vivienda() {
	}

	public Vivienda(int n_IdVivi, int c_Ubicacion, String c_Numero,
			Double n_Metraje, int c_TipViv, int n_CodRes, int c_EstReg,
			Residente residente) {
		super();
		N_IdVivi = n_IdVivi;
		C_Ubicacion = c_Ubicacion;
		C_Numero = c_Numero;
		N_Metraje = n_Metraje;
		C_TipViv = c_TipViv;
		N_CodRes = n_CodRes;
		C_EstReg = c_EstReg;
		this.residente = residente;
	}

	public int getN_IdVivi() {
		return N_IdVivi;
	}

	public void setN_IdVivi(int n_IdVivi) {
		N_IdVivi = n_IdVivi;
	}

	public int getC_Ubicacion() {
		return C_Ubicacion;
	}

	public void setC_Ubicacion(int c_Ubicacion) {
		C_Ubicacion = c_Ubicacion;
	}

	public String getC_Numero() {
		return C_Numero;
	}

	public void setC_Numero(String c_Numero) {
		C_Numero = c_Numero;
	}

	public Double getN_Metraje() {
		return N_Metraje;
	}

	public void setN_Metraje(Double n_Metraje) {
		N_Metraje = n_Metraje;
	}

	public int getC_TipViv() {
		return C_TipViv;
	}

	public void setC_TipViv(int c_TipViv) {
		C_TipViv = c_TipViv;
	}

	public int getN_CodRes() {
		return N_CodRes;
	}

	public void setN_CodRes(int n_CodRes) {
		N_CodRes = n_CodRes;
	}

	public int getC_EstReg() {
		return C_EstReg;
	}

	public void setC_EstReg(int c_EstReg) {
		C_EstReg = c_EstReg;
	}

	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	
	
}
