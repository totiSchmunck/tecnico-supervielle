package com.demo.tecnico.supervielle.bean.resp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadisticaResp {
	
	@JsonProperty
	private String cantidad_mujeres;
	
	@JsonProperty
	private String cantidad_hombres;
	
	@JsonProperty
	private String porcentaje_argentinos;

	public String getCantidad_mujeres() {
		return cantidad_mujeres;
	}

	public void setCantidad_mujeres(String cantidad_mujeres) {
		this.cantidad_mujeres = cantidad_mujeres;
	}

	public String getCantidad_hombres() {
		return cantidad_hombres;
	}

	public void setCantidad_hombres(String cantidad_hombres) {
		this.cantidad_hombres = cantidad_hombres;
	}

	public String getPorcentaje_argentinos() {
		return porcentaje_argentinos;
	}

	public void setPorcentaje_argentinos(String porcentaje_argentinos) {
		this.porcentaje_argentinos = porcentaje_argentinos;
	}
	
}
