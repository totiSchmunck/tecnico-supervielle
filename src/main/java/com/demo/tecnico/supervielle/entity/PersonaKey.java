package com.demo.tecnico.supervielle.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonaKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5969831127119632835L;
	
	@ManyToOne
	@JoinColumn(name="fk_tipo_documento")
	private TipoDocumento tipoDoc;
	
	@Column(name = "documento", nullable = false)
	private String numeroDoc;
	
	@ManyToOne
	@JoinColumn(name="fk_pais")
	private Pais pais;
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	public PersonaKey() {}

	public PersonaKey(TipoDocumento tipoDoc, String numeroDoc, Pais pais, String sexo) {
		super();
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.pais = pais;
		this.sexo = sexo;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDoc == null) ? 0 : numeroDoc.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaKey other = (PersonaKey) obj;
		if (numeroDoc == null) {
			if (other.numeroDoc != null)
				return false;
		} else if (!numeroDoc.equals(other.numeroDoc))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipoDoc == null) {
			if (other.tipoDoc != null)
				return false;
		} else if (!tipoDoc.equals(other.tipoDoc))
			return false;
		return true;
	}
}
