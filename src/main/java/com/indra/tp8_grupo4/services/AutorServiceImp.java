package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Autor;
import com.indra.tp8_grupo4.repository.AutorRepository;

@Service
public class AutorServiceImp implements AutorService {
	// aplico el Dependency Injection
	@Autowired
	private AutorRepository autorRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Autor listarId(long id) {
		return autorRepository.findById(id);
	}

	@Override
	public List<Autor> listar() {
		return autorRepository.findAll();
	}

	@Override
	public Autor agregar(Autor p) {
		return autorRepository.save(p);
	}

	@Override
	public Autor modificar(Autor s) {
		Autor original = autorRepository.findById(s.getId().longValue());
		if (s.getNombre() != null)
			original.setNombre(s.getNombre());

		if (s.getNacionalidad() != null)
			original.setNacionalidad(s.getNacionalidad());

		if (s.getFechaNacimiento() != null)
			original.setFechaNacimiento(s.getFechaNacimiento());

		return autorRepository.save(s);
	}

	@Override
	public void delete(long id) {
		autorRepository.deleteById(id);
	}

}
