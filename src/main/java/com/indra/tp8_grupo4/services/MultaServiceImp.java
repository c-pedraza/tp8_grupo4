package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Multa;
import com.indra.tp8_grupo4.repository.MultaRepository;

@Service
public class MultaServiceImp implements MultaService {
	// aplico el Dependency Injection
	@Autowired
	private MultaRepository multaRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Multa listarId(long id) {
		return multaRepository.findById(id);
	}

	@Override
	public List<Multa> listar() {
		return multaRepository.findAll();
	}

	@Override
	public Multa agregar(Multa p) {
		return multaRepository.save(p);
	}

	@Override
	public Multa modificar(Multa s) {
		Multa original = multaRepository.findById(s.getId().longValue());
		if (s.getFechaInicio() != null)
			original.setFechaInicio(s.getFechaInicio());

		if (s.getFechaFin() != null)
			original.setFechaFin(s.getFechaFin());

		return multaRepository.save(s);
	}

	@Override
	public void delete(long id) {
		multaRepository.deleteById(id);
	}
}
