package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Autor;


public interface AutorService {

	// CRUD o ABM
	Autor listarId(long id);

	List<Autor> listar();

	Autor agregar(Autor p);

	Autor modificar(Autor p);

	void delete(long id);
}
