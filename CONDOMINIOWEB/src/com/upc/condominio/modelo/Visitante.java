package com.upc.condominio.modelo;

import java.util.Date;

public class Visitante {
		private int intCorrelativo;
		private String strDNIVisitante;
		private String strNombreVisitante;
		private int intCodigoResidente;
		private Date dHoraFechaVisitante;

		public Visitante() {
			
		}
		
		public Visitante(int intCorrelativo, String strDNIVisitante, String strNombreVisitante,
				int intCodigoResidente, Date dHoraFechaVisitante) {
			
			this.intCorrelativo = intCorrelativo;
			this.strDNIVisitante = strDNIVisitante;
			this.strNombreVisitante = strNombreVisitante;
			this.intCodigoResidente = intCodigoResidente;
			this.dHoraFechaVisitante = dHoraFechaVisitante;
		}
		
		public int getintCorrelativo() {
			return intCorrelativo;
		}
		public void setintCorrelativo(int getintCorrelativo) {
			this.intCorrelativo = getintCorrelativo;
		}
		public String getstrDNIVisitante() {
			return strDNIVisitante;
		}
		public void setstrDNIVisitante(String strDNIVisitante) {
			this.strDNIVisitante = strDNIVisitante;
		}
		
		public String getstrNombreVisitante() {
			return strNombreVisitante;
		}
		public void setstrNombreVisitante(String strNombreVisitante) {
			this.strNombreVisitante = strNombreVisitante;
		}

		public int getintCodigoResidente() {
			return intCodigoResidente;
		}
		public void setintCodigoResidente(int intCodigoResidente) {
			this.intCodigoResidente = intCodigoResidente;
		}

		public Date getdHoraFechaVisitante() {
			return dHoraFechaVisitante;
		}
		public void setdHoraFechaVisitante(Date dHoraFechaVisitante) {
			this.dHoraFechaVisitante = dHoraFechaVisitante;
		}


	
}
