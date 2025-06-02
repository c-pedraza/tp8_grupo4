package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Copia;

public interface CopiaService {

	// CRUD o ABM
	Copia listarId(long id);

	List<Copia> listar();

	Copia agregar(Copia p);

	Copia modificar(Copia p);

	void delete(long id);
}
