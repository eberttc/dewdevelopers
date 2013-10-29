package com.upc.condominio.modelo;

public class Vivienda {

	private int N_IdVivi;
	private String C_NroUbi;
	private Double N_NumMet;
	private String C_TipViv;
	private Residente residente;
	
	public Vivienda() {
	}

	public Vivienda(int n_IdVivi, String c_NroUbi, Double n_NumMet,
			String c_TipViv, Residente residente) {
		super();
		N_IdVivi = n_IdVivi;
		C_NroUbi = c_NroUbi;
		N_NumMet = n_NumMet;
		C_TipViv = c_TipViv;
		this.residente = residente;
	}

	public int getN_IdVivi() {
		return N_IdVivi;
	}

	public void setN_IdVivi(int n_IdVivi) {
		N_IdVivi = n_IdVivi;
	}

	public String getC_NroUbi() {
		return C_NroUbi;
	}

	public void setC_NroUbi(String c_NroUbi) {
		C_NroUbi = c_NroUbi;
	}

	public Double getN_NumMet() {
		return N_NumMet;
	}

	public void setN_NumMet(Double n_NumMet) {
		N_NumMet = n_NumMet;
	}

	public String getC_TipViv() {
		return C_TipViv;
	}

	public void setC_TipViv(String c_TipViv) {
		C_TipViv = c_TipViv;
	}

	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}
	
	
	
	
}
