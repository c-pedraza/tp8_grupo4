package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Libro;

public interface LibroService {

	// CRUD o ABM
	Libro listarId(long id);

	List<Libro> listar();

	Libro agregar(Libro p);

	Libro modificar(Libro p);

	void delete(long id);
}
