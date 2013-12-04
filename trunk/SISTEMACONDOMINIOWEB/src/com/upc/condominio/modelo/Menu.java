package com.upc.condominio.modelo;

public class Menu {

		private int    codigoMenu;
		private String nombre;
		private int codigoPadre;
		private String accion;
		
		
		public int getCodigoMenu() {
			return codigoMenu;
		}
		public void setCodigoMenu(int codigoMenu) {
			this.codigoMenu = codigoMenu;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getCodigoPadre() {
			return codigoPadre;
		}
		public void setCodigoPadre(int codigoPadre) {
			this.codigoPadre = codigoPadre;
		}
		public String getAccion() {
			return accion;
		}
		public void setAccion(String accion) {
			this.accion = accion;
		}
		
		
		
}
