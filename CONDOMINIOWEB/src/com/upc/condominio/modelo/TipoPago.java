package com.upc.condominio.modelo;

public class TipoPago {
	
	private int N_TipoPago;
	private String C_Descri;
	private String C_EstReg;
	
	public TipoPago() {
		// TODO Auto-generated constructor stub
	}
	
	public TipoPago(int nTipoPago, String cDescri, String cEstReg) {
		super();
		N_TipoPago= nTipoPago;
		C_Descri  = cDescri;
		C_EstReg  = cEstReg;
	}
	
	public int getnTipoPago() {
		return N_TipoPago;
	}

	public void setnTipoPago(int n_TipoPago) {
		this.N_TipoPago = n_TipoPago;
	}

	public String getcDescri() {
		return C_Descri;
	}

	public void setcDescri(String c_Descri) {
		this.C_Descri = c_Descri;
	}

	public String getcEstReg() {
		return C_EstReg;
	}

	public void setcEstReg(String c_EstReg) {
		this.C_EstReg = c_EstReg;
	}

}
