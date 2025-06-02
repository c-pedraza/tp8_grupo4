package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Prestamo;
import com.indra.tp8_grupo4.repository.PrestamoRepository;

@Service
public class PrestamoServiceImp implements PrestamoService {

	// aplico el Dependency Injection
	@Autowired
	private PrestamoRepository prestamoRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Prestamo listarId(long id) {
		return prestamoRepository.findById(id);
	}

	@Override
	public List<Prestamo> listar() {
		return prestamoRepository.findAll();
	}

	@Override
	public Prestamo agregar(Prestamo p) {
		return prestamoRepository.save(p);
	}

	@Override
	public Prestamo modificar(Prestamo s) {
		Prestamo original = prestamoRepository.findById(s.getId().longValue());
		if (s.getFechaInicio() != null)
			original.setFechaInicio(s.getFechaInicio());

		if (s.getFechaFin() != null)
			original.setFechaFin(s.getFechaFin());

		return prestamoRepository.save(s);
	}

	@Override
	public void delete(long id) {
		prestamoRepository.deleteById(id);
	}

}
