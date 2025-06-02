package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Copia;
import com.indra.tp8_grupo4.repository.CopiaRepository;

@Service
public class CopiaServiceImp implements CopiaService {
	// aplico el Dependency Injection
	@Autowired
	private CopiaRepository copiaRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Copia listarId(long id) {
		return copiaRepository.findById(id);
	}

	@Override
	public List<Copia> listar() {
		return copiaRepository.findAll();
	}

	@Override
	public Copia agregar(Copia p) {
		return copiaRepository.save(p);
	}

	@Override
	public Copia modificar(Copia s) {
		Copia original = copiaRepository.findById(s.getId().longValue());

		if (s.getEstado() != null)
			original.setEstado(s.getEstado());

		return copiaRepository.save(s);
	}

	@Override
	public void delete(long id) {
		copiaRepository.deleteById(id);
	}

}
