package com.upc.condominio.modelo;

import java.util.Date;

public class Residente {

	private int idResidente;
	private String nombreResidente;
	private int tipoDocumento;
	private Date fechaNacimiento;
	private String correo;
	private String numeroDocumento;
	private String clave;
	private String estadoRegistro;
	
	public Residente() {
	}

		
	public Residente(int idResidente, String nombreResidente,
			int tipoDocumento, Date fechaNacimiento, String correo,
			String numeroDocumento, String clave, String estadoRegistro) {
		super();
		this.idResidente = idResidente;
		this.nombreResidente = nombreResidente;
		this.tipoDocumento = tipoDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.numeroDocumento = numeroDocumento;
		this.clave = clave;
		this.estadoRegistro = estadoRegistro;
	}



	public int getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(int idResidente) {
		this.idResidente = idResidente;
	}

	public String getNombreResidente() {
		return nombreResidente;
	}

	public void setNombreResidente(String nombreResidente) {
		this.nombreResidente = nombreResidente;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}


	
	
	
}
