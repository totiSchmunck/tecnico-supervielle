package com.demo.tecnico.supervielle.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.tecnico.supervielle.bean.resp.EstadisticaResp;
import com.demo.tecnico.supervielle.entity.PersonaPkIdentificador;

public class Utilidad {
	
	public static int calcularEdad (String fechaNacimiento) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, dtf);
		LocalDate ahora = LocalDate.now();
		
		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
	}
	
	public static EstadisticaResp calcularEstadistica (List<PersonaPkIdentificador> personas) {
		
		Long cantidadMujeres = (long)0, cantidadHombres = (long)0, porcentajeArgentinos = (long)0, cantidadArgentinos=(long)0;
		
		if (!personas.isEmpty()) {
			
			EstadisticaResp estadistica = new EstadisticaResp();
			
			for (PersonaPkIdentificador p : personas) {
				
				if (p.getPersona().getId().getSexo().equalsIgnoreCase("M"))
					cantidadHombres+=1;
				else
					cantidadMujeres+=1;
				
				if (p.getPersona().getId().getPais().getId()==1)
					cantidadArgentinos+=1;
			}
			
			porcentajeArgentinos = (cantidadArgentinos*100)/personas.size();
			
			estadistica.setCantidad_mujeres(cantidadMujeres.toString());
			estadistica.setCantidad_hombres(cantidadHombres.toString());
			estadistica.setPorcentaje_argentinos(porcentajeArgentinos.toString());
			
			return estadistica;
		}
		
		return null;
	}
	
	public static String buscarRelacionId1Toid2 (PersonaPkIdentificador p1, PersonaPkIdentificador p2) {
		
		for (PersonaPkIdentificador h : p1.getHermanos()) {
			if (h.getIdentificador() == p2.getIdentificador())
				return p1.getPersona().getNombre() + " es hermano de " + p2.getPersona().getNombre();
		}
		
		for (PersonaPkIdentificador t : p1.getTios()) {
			if (t.getIdentificador() == p2.getIdentificador())
				return p1.getPersona().getNombre() + " es sobrino de " + p2.getPersona().getNombre();
		}
		
		for (PersonaPkIdentificador p : p1.getPrimos()) {
			if (p.getIdentificador() == p2.getIdentificador())
				return p1.getPersona().getNombre() + " es primo " + p2.getPersona().getNombre();
		}
		
		return "No existe parentesco";
	}
}
