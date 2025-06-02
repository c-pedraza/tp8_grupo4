package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Lector;

public interface LectorService {

	// CRUD o ABM
	Lector listarId(long id);

	List<Lector> listar();

	Lector agregar(Lector p);

	Lector modificar(Lector p);

	void delete(long id);
}
