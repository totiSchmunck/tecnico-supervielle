package com.demo.tecnico.supervielle.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="identificador_persona")
public class PersonaPkIdentificador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7838529780098860721L;
	
	private Long identificador;
	
	private Persona persona;
	
	private List<PersonaPkIdentificador> hermanos;
	
	private List<PersonaPkIdentificador> primos;
	
	private List<PersonaPkIdentificador> tios;
	
	public PersonaPkIdentificador() {}

	public PersonaPkIdentificador(Persona persona) {
		super();
		this.persona = persona;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pk_persona", unique = true, nullable = false)
	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	
	@OneToOne
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	@ManyToMany
	@JoinTable(name="hermanos", 
		joinColumns=@JoinColumn(name="identificador"),
		inverseJoinColumns=@JoinColumn(name="hermano_id")
	)
	public List<PersonaPkIdentificador> getHermanos() {
		return hermanos;
	}

	public void setHermanos(List<PersonaPkIdentificador> hermanos) {
		this.hermanos = hermanos;
	}
	
	@ManyToMany
	@JoinTable(name="primos", 
		joinColumns=@JoinColumn(name="identificador"),
		inverseJoinColumns=@JoinColumn(name="primo_id")
	)
	public List<PersonaPkIdentificador> getPrimos() {
		return primos;
	}

	public void setPrimos(List<PersonaPkIdentificador> primos) {
		this.primos = primos;
	}

	@ManyToMany
	@JoinTable(name="tios", 
		joinColumns=@JoinColumn(name="identificador"),
		inverseJoinColumns=@JoinColumn(name="tio_id")
	)
	public List<PersonaPkIdentificador> getTios() {
		return tios;
	}

	public void setTios(List<PersonaPkIdentificador> tios) {
		this.tios = tios;
	}
}
