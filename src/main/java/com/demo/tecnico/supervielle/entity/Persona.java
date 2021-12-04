package com.demo.tecnico.supervielle.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -475305704558004419L;
	
	@EmbeddedId
	private PersonaKey id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private String fechaNacimiento;

	@Column(name = "contacto", nullable = false)
	private String contacto;
	
	private PersonaPkIdentificador identificador;

	public Persona () {}
	
	
	public Persona(PersonaKey id, String contacto, String nombre, String apellido, String fechaNacimiento, PersonaPkIdentificador identificador) {
		super();
		this.id = id;
		this.contacto = contacto;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.identificador = identificador;
	}


	public PersonaKey getId() {
		return id;
	}

	public void setId(PersonaKey id) {
		this.id = id;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	@OneToOne(mappedBy="identificador")
	public PersonaPkIdentificador getIdPersona() {
		return identificador;
	}


	public void setIdPersona(PersonaPkIdentificador identificador) {
		this.identificador = identificador;
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
