package com.demo.tecnico.supervielle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.tecnico.supervielle.bean.req.CreatePersonaReq;
import com.demo.tecnico.supervielle.bean.req.UpdatePersonaReq;
import com.demo.tecnico.supervielle.bean.resp.EstadisticaResp;
import com.demo.tecnico.supervielle.bean.resp.PersonaResp;
import com.demo.tecnico.supervielle.entity.Pais;
import com.demo.tecnico.supervielle.entity.Persona;
import com.demo.tecnico.supervielle.entity.PersonaKey;
import com.demo.tecnico.supervielle.entity.PersonaPkIdentificador;
import com.demo.tecnico.supervielle.entity.TipoDocumento;
import com.demo.tecnico.supervielle.repository.PaisRepository;
import com.demo.tecnico.supervielle.repository.PersonaIdentificadorRepository;
import com.demo.tecnico.supervielle.repository.PersonaRepository;
import com.demo.tecnico.supervielle.repository.TipoDocRepository;
import com.demo.tecnico.supervielle.util.Utilidad;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private TipoDocRepository tipoDocRepo;
	
	@Autowired
	private PaisRepository paisrepo;
	
	@Autowired
	private PersonaIdentificadorRepository identificadorRepo;
	
	@Transactional
	public String createPersona (CreatePersonaReq persona) {
			
			if (Utilidad.calcularEdad(persona.getFechaNacimiento()) < 18)
				return "La persona que se quiere dar de alta debe ser mayor a 18 años";
		
			if (persona.getContacto() == null || persona.getContacto().isEmpty())
				return "La persona que se quiere dar de alta debe contener el dato contacto";
		
			Optional<TipoDocumento> tipoDoc = tipoDocRepo.findById(persona.getIdTipodoc());
			
			Optional<Pais> pais = paisrepo.findById(persona.getIdPais());
			
			Optional<Persona> personaEntity = personaRepo.findById(new PersonaKey(tipoDoc.get(), persona.getNumeroDoc(), pais.get(), persona.getSexo()));
			
			if (!personaEntity.isPresent()) {
			
				identificadorRepo.save(new PersonaPkIdentificador(personaRepo.save(new Persona(new PersonaKey(tipoDoc.get(), persona.getNumeroDoc(), pais.get(), persona.getSexo()), persona.getContacto(), persona.getNombre(), persona.getApellido(), persona.getFechaNacimiento(), new PersonaPkIdentificador()))));
					
				return "La persona se guardo en BD exitosamente";
					
			} else {
					
				return "La persona ya existe en la BD";
			}
	}
	
	public List<PersonaResp> listarTodo (){
		
		List<PersonaPkIdentificador> personas = IteratorUtils.toList(identificadorRepo.findAll().iterator());
		
		List<PersonaResp> respList = new ArrayList<>();
		
		if (!personas.isEmpty()) {
			
			for (PersonaPkIdentificador p : personas) {
				respList.add(com.demo.tecnico.supervielle.util.BuildToJson.personaEntityBuildToJson(p));
			}
		}
		return respList;
	}
	
	@Transactional
	public String personaBorrar (Long id) {
		
		Optional<PersonaPkIdentificador> identificador = identificadorRepo.findById(id);
		
		if (identificador.isPresent()) {
			
			Persona persona = identificador.get().getPersona();
			
			identificadorRepo.delete(identificador.get());
			
			personaRepo.delete(persona);
			
			return "La persona se borro de forma exitosa";
		} else {
			return "No existe el id de la persona que se quiere borrar";
		}
	}
	
	@Transactional
	public String personaUpdate (Long id, UpdatePersonaReq update) {
		
		Optional<PersonaPkIdentificador> identificador = identificadorRepo.findById(id);
		
		if (identificador.isPresent()) {
			
			Persona persona = identificador.get().getPersona();
			
			persona.setApellido(update.getApellido());
			persona.setNombre(update.getNombre());
			persona.setContacto(update.getContacto());
			personaRepo.save(persona);
			
			return "La persona se actualizó de forma exitosa";
		} else {
			return "No existe el id de la persona que se quiere actualizar";
		}
	}
	
	public EstadisticaResp getEstadistica () {
		
		List<PersonaPkIdentificador> personas = IteratorUtils.toList(identificadorRepo.findAll().iterator());
		
		EstadisticaResp estadistica = null;
		
		if (!personas.isEmpty()) {
			
			estadistica = Utilidad.calcularEstadistica(personas);
		}
		
		return estadistica;
	}
	
	public String getRelacion (Long id1, Long id2) {
		
		Optional<PersonaPkIdentificador> per1 = identificadorRepo.findById(id1);
		
		Optional<PersonaPkIdentificador> per2 = identificadorRepo.findById(id2);
		
		if (per1.isPresent() && per2.isPresent()) {
			
			return Utilidad.buscarRelacionId1Toid2(per1.get(), per2.get());
		} else
			return "No existe id en la BD";
	}
	
	@Transactional
	public String setRelacion (Long id1, String tipoRelacion, Long id2) {
		
		Optional<PersonaPkIdentificador> per1 = identificadorRepo.findById(id1);
		
		Optional<PersonaPkIdentificador> per2 = identificadorRepo.findById(id2);
		
		if (per1.isPresent() && per2.isPresent()) {
			
			if (tipoRelacion.equalsIgnoreCase("HERMANO")) {
				List<PersonaPkIdentificador> hermanos = new ArrayList<>();
				hermanos.add(per2.get());
				per1.get().setHermanos(hermanos);
				identificadorRepo.save(per1.get());
				return per2.get().getPersona().getNombre() + " Es hermana/o de " + per1.get().getPersona().getNombre();
			} else if (tipoRelacion.equalsIgnoreCase("PRIMO")) {
				List<PersonaPkIdentificador> primos = new ArrayList<>();
				primos.add(per2.get());
				per1.get().setPrimos(primos);
				identificadorRepo.save(per1.get());
				return per2.get().getPersona().getNombre() + " Es prima/o de " + per1.get().getPersona().getNombre();
			} else if (tipoRelacion.equalsIgnoreCase("TIO")) {
				List<PersonaPkIdentificador> tios = new ArrayList<>();
				tios.add(per2.get());
				per1.get().setTios(tios);
				identificadorRepo.save(per1.get());
				return per2.get().getPersona().getNombre() + " Es tia/o de " + per1.get().getPersona().getNombre();
			} else {
				return "No se permite el tipo relacion " + tipoRelacion;
			}
		} else
			return "No existe id en la BD";
	}
}