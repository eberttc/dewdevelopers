package com.upc.condominio.modelo;

import java.util.Date;

public class Visitante {
		private int intCorrelativo;
		private String strDNIVisitante;
		private String strNombreVisitante;
		private int intCodigoResidente;
		private String strNombreResidente;
		private Date dHoraFechaVisitante;
		

		public Visitante() {
			
		}
		
		public Visitante(int intCorrelativo, String strDNIVisitante, String strNombreVisitante,
				String strNombreResidente, int intCodigoResidente, Date dHoraFechaVisitante) {
			
			this.intCorrelativo = intCorrelativo;
			this.strDNIVisitante = strDNIVisitante;
			this.strNombreVisitante = strNombreVisitante;
			this.intCodigoResidente = intCodigoResidente;
			this.strNombreResidente = strNombreResidente;
			this.dHoraFechaVisitante = dHoraFechaVisitante;
		}

		public int getIntCorrelativo() {
			return intCorrelativo;
		}

		public void setIntCorrelativo(int intCorrelativo) {
			this.intCorrelativo = intCorrelativo;
		}

		public String getStrDNIVisitante() {
			return strDNIVisitante;
		}

		public void setStrDNIVisitante(String strDNIVisitante) {
			this.strDNIVisitante = strDNIVisitante;
		}

		public String getStrNombreVisitante() {
			return strNombreVisitante;
		}

		public void setStrNombreVisitante(String strNombreVisitante) {
			this.strNombreVisitante = strNombreVisitante;
		}

		public int getIntCodigoResidente() {
			return intCodigoResidente;
		}

		public void setIntCodigoResidente(int intCodigoResidente) {
			this.intCodigoResidente = intCodigoResidente;
		}

		public String getStrNombreResidente() {
			return strNombreResidente;
		}

		public void setStrNombreResidente(String strNombreResidente) {
			this.strNombreResidente = strNombreResidente;
		}

		public Date getdHoraFechaVisitante() {
			return dHoraFechaVisitante;
		}

		public void setdHoraFechaVisitante(Date dHoraFechaVisitante) {
			this.dHoraFechaVisitante = dHoraFechaVisitante;
		}
		
	
	
}
