package com.indra.tp8_grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Libro;
import com.indra.tp8_grupo4.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Libro listarId(long id) {
		return libroRepository.findById(id);
	}

	@Override
	public List<Libro> listar() {
		return libroRepository.findAll();
	}

	@Override
	public Libro agregar(Libro p) {
		return libroRepository.save(p);
	}

	@Override
	public Libro modificar(Libro s) {
		Libro original = libroRepository.findById(s.getId().longValue());
		if (s.getTitulo() != null)
			original.setTitulo(s.getTitulo());

		if (s.getTipo() != null)
			original.setTipo(s.getTipo());

		if (s.getEditorial() != null)
			original.setEditorial(s.getEditorial());

		if (s.getAnyo() != original.getAnyo())
			original.setAnyo(s.getAnyo());

		return libroRepository.save(s);
	}

	@Override
	public void delete(long id) {
		libroRepository.deleteById(id);
	}
}
