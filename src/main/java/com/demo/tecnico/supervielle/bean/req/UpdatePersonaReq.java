package com.demo.tecnico.supervielle.bean.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePersonaReq {
	
	@JsonProperty
	private String contacto;
	
	@JsonProperty
	private String nombre;
	
	@JsonProperty
	private String apellido;

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
}
