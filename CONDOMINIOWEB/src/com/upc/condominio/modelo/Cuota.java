package com.upc.condominio.modelo;

import java.util.Date;


public class Cuota {

	private int N_IdCuot;
	private String C_Period;
	private int N_IdVivi;
	private int N_TipPag;
	private float N_ImpPag;
	private Date D_FecVen;
	
	private TipoPago O_TipPag;
	
	public Cuota() {
		// TODO Auto-generated constructor stub
	}

	public Cuota(int n_IdCuot, String c_Period, int n_IdVivi,int n_TipPag,float n_ImpPag, Date d_FecVen)
	{
		// TODO Auto-generated constructor stub
		N_IdCuot=n_IdCuot;
		C_Period=c_Period;
		N_IdVivi= n_IdVivi;
		N_TipPag= n_TipPag;
		N_ImpPag= n_ImpPag;
		D_FecVen= d_FecVen;
		D_FecVen= d_FecVen;
	}
	
	public int getN_IdCuot() {
		return N_IdCuot;
	}

	public void setN_IdCuot(int n_IdCuot) {
		N_IdCuot = n_IdCuot;
	}

	public String getC_Period() {
		return C_Period;
	}

	public void setC_Period(String c_Period) {
		C_Period = c_Period;
	}

	public int getN_IdVivi() {
		return N_IdVivi;
	}

	public void setN_IdVivi(int n_IdVivi) {
		N_IdVivi = n_IdVivi;
	}

	public int getN_TipPag() {
		return N_TipPag;
	}

	public void setN_TipPag(int n_TipPag) {
		N_TipPag = n_TipPag;
	}

	public float getN_ImpPag() {
		return N_ImpPag;
	}

	public void setN_ImpPag(float n_ImpPag) {
		N_ImpPag = n_ImpPag;
	}

	public Date getD_FecVen() {
		return D_FecVen;
	}

	public void setD_FecVen(Date d_FecVen) {
		D_FecVen = d_FecVen;
	}

	public TipoPago getO_TipPag() {
		return O_TipPag;
	}

	public void setO_TipPag(TipoPago o_TipPag) {
		O_TipPag = o_TipPag;
	}

}
