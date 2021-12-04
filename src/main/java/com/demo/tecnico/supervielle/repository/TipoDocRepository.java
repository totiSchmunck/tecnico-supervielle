package com.demo.tecnico.supervielle.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.tecnico.supervielle.entity.TipoDocumento;

public interface TipoDocRepository extends CrudRepository<TipoDocumento, Long> {

}
