package com.demo.tecnico.supervielle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tecnico.supervielle.bean.req.CreatePersonaReq;
import com.demo.tecnico.supervielle.bean.req.UpdatePersonaReq;
import com.demo.tecnico.supervielle.bean.resp.EstadisticaResp;
import com.demo.tecnico.supervielle.bean.resp.PersonaResp;
import com.demo.tecnico.supervielle.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	@RequestMapping(value="/personas/crear", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String crearPersona (@RequestBody CreatePersonaReq request) {
		
		return service.createPersona(request);
	}
	
	@RequestMapping(value="/personas/listar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PersonaResp> listarPersonas () {
		
		return service.listarTodo();
	}
	
	@RequestMapping(value="/personas/borrar/{idPersona}", method=RequestMethod.DELETE)
	public String listarPersonas (@PathVariable Long idPersona) {
		
		return service.personaBorrar(idPersona);
	}
	
	@RequestMapping(value="/personas/actualizar/{idPersona}", method=RequestMethod.PUT)
	public String updatePersona (@PathVariable Long idPersona, @RequestBody UpdatePersonaReq update) {
		
		return service.personaUpdate(idPersona, update);
	}
	
	@RequestMapping(value="/personas/estadistica", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public EstadisticaResp getEstadistica () {
		
		return service.getEstadistica();
	}
	
	@RequestMapping(value="/personas/relaciones/{id1}/{id2}", method=RequestMethod.GET)
	public String getRealcion (@PathVariable Long id1, @PathVariable Long id2) {
		
		return service.getRelacion(id1, id2);
	}
	
	@RequestMapping(value="/personas/relacionar/{id1}/{relacion}/{id2}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public String setRealcion (@PathVariable Long id1, @PathVariable String relacion, @PathVariable Long id2) {
		
		return service.setRelacion(id2, relacion, id1);
	}
}
