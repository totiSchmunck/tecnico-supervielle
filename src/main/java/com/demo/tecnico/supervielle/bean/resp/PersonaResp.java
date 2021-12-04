package com.demo.tecnico.supervielle.bean.resp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaResp {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nombre;
	
	@JsonProperty
	private String apellido;
	
	@JsonProperty
	private String sexo;
	
	@JsonProperty
	private String nacionalidad;
	
	@JsonProperty
	private String tipoDocumentoDescripcion;
	
	@JsonProperty
	private String documento;
	
	@JsonProperty
	private String contacto;
	
	@JsonProperty
	private String fechaNacimiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTipoDocumentoDescripcion() {
		return tipoDocumentoDescripcion;
	}

	public void setTipoDocumentoDescripcion(String tipoDocumentoDescripcion) {
		this.tipoDocumentoDescripcion = tipoDocumentoDescripcion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
