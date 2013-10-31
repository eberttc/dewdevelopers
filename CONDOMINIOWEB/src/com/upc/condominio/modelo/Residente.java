package com.upc.condominio.modelo;

import java.util.Date;

public class Residente {

	private int N_CodRes;
	private String C_NomRes;
	private int C_TipDoc;
	private Date D_FecNac;
	private String C_Correo;
	private String C_NumDoc;
	private String C_Clave;
	private int C_EstReg;
	
	public Residente() {
	}

	public Residente(int n_CodRes, String c_NomRes, int c_TipDoc,
			Date d_FecNac, String c_Correo, String c_NumDoc, String c_Clave,
			int c_EstReg) {
		super();
		N_CodRes = n_CodRes;
		C_NomRes = c_NomRes;
		C_TipDoc = c_TipDoc;
		D_FecNac = d_FecNac;
		C_Correo = c_Correo;
		C_NumDoc = c_NumDoc;
		C_Clave = c_Clave;
		C_EstReg = c_EstReg;
	}

	public int getN_CodRes() {
		return N_CodRes;
	}

	public void setN_CodRes(int n_CodRes) {
		N_CodRes = n_CodRes;
	}

	public String getC_NomRes() {
		return C_NomRes;
	}

	public void setC_NomRes(String c_NomRes) {
		C_NomRes = c_NomRes;
	}

	public int getC_TipDoc() {
		return C_TipDoc;
	}

	public void setC_TipDoc(int c_TipDoc) {
		C_TipDoc = c_TipDoc;
	}

	public Date getD_FecNac() {
		return D_FecNac;
	}

	public void setD_FecNac(Date d_FecNac) {
		D_FecNac = d_FecNac;
	}

	public String getC_Correo() {
		return C_Correo;
	}

	public void setC_Correo(String c_Correo) {
		C_Correo = c_Correo;
	}

	public String getC_NumDoc() {
		return C_NumDoc;
	}

	public void setC_NumDoc(String c_NumDoc) {
		C_NumDoc = c_NumDoc;
	}

	public String getC_Clave() {
		return C_Clave;
	}

	public void setC_Clave(String c_Clave) {
		C_Clave = c_Clave;
	}

	public int getC_EstReg() {
		return C_EstReg;
	}

	public void setC_EstReg(int c_EstReg) {
		C_EstReg = c_EstReg;
	}

	
	
	
}
