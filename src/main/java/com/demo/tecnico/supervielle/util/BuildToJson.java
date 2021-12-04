package com.demo.tecnico.supervielle.util;

import com.demo.tecnico.supervielle.bean.resp.PersonaResp;
import com.demo.tecnico.supervielle.entity.PersonaPkIdentificador;

public class BuildToJson {
	
	public static PersonaResp personaEntityBuildToJson (PersonaPkIdentificador entity) {
		
		PersonaResp resp = new PersonaResp();
		resp.setId(entity.getIdentificador());
		resp.setNombre(entity.getPersona().getNombre());
		resp.setApellido(entity.getPersona().getApellido());
		resp.setSexo(entity.getPersona().getId().getSexo());
		resp.setNacionalidad(entity.getPersona().getId().getPais().getNombre());
		resp.setTipoDocumentoDescripcion(entity.getPersona().getId().getTipoDoc().getDescrpcion());
		resp.setDocumento(entity.getPersona().getId().getNumeroDoc());
		resp.setContacto(entity.getPersona().getContacto());
		resp.setFechaNacimiento(entity.getPersona().getFechaNacimiento());
		return resp;
	}
}
