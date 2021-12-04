package com.demo.tecnico.supervielle.bean.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePersonaReq {
	
	@JsonProperty
	private Long idTipodoc;
	
	@JsonProperty
	private String numeroDoc;
	
	@JsonProperty
	private Long idPais;
	
	@JsonProperty
	private String sexo;
	
	@JsonProperty
	private String contacto;
	
	@JsonProperty
	private String nombre;
	
	@JsonProperty
	private String apellido;
	
	@JsonProperty
	private String fechaNacimiento;

	public Long getIdTipodoc() {
		return idTipodoc;
	}

	public void setIdTipodoc(Long idTipodoc) {
		this.idTipodoc = idTipodoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
