package com.upc.condominio.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {

	private int idUsuario;
	private String clave;
	private String nombres;
	private String correo;
	private String tipoUsuario;
    public Usuario(){
		
	}

	public Usuario(int idUsuario, String clave, String nombres, String correo,String tipoUsuario) {
		
		this.idUsuario = idUsuario;
		this.clave = clave;
		this.nombres = nombres;
		this.correo = correo;
		this.tipoUsuario=tipoUsuario;
	}




	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getTipoUsuario() {
		return tipoUsuario;
	}




	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



}
