package com.demo.tecnico.supervielle.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.tecnico.supervielle.entity.Persona;
import com.demo.tecnico.supervielle.entity.PersonaKey;

public interface PersonaRepository extends CrudRepository<Persona, PersonaKey>{

}
