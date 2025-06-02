package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Lector;
import com.indra.tp8_grupo4.repository.LectorRepository;

@Service
public class LectorServiceImp implements LectorService {
	// aplico el Dependency Injection
	@Autowired
	private LectorRepository lectorRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Lector listarId(long id) {
		return lectorRepository.findById(id);
	}

	@Override
	public List<Lector> listar() {
		return lectorRepository.findAll();
	}

	@Override
	public Lector agregar(Lector p) {
		return lectorRepository.save(p);
	}

	@Override
	public Lector modificar(Lector s) {
		Lector original = lectorRepository.findById(s.getNSocio().longValue());

		if (s.getNombre() != null)
			original.setNombre(s.getNombre());

		if (s.getTelefono() != null)
			original.setTelefono(s.getTelefono());

		if (s.getDireccion() != null)
			original.setDireccion(s.getDireccion());

		return lectorRepository.save(s);
	}

	@Override
	public void delete(long id) {
		lectorRepository.deleteById(id);
	}

}
