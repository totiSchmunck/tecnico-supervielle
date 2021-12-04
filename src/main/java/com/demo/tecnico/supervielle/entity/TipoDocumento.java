package com.demo.tecnico.supervielle.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1819463108857165373L;
	
	private Long id;
	
	private String descrpcion;
	
	public TipoDocumento() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pk_tipo_documento", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "descripcion", nullable = false)
	public String getDescrpcion() {
		return descrpcion;
	}
	public void setDescrpcion(String descrpcion) {
		this.descrpcion = descrpcion;
	}
	
}
