package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Multa;

public interface MultaService {

	// CRUD o ABM
	Multa listarId(long id);

	List<Multa> listar();

	Multa agregar(Multa p);

	Multa modificar(Multa p);

	void delete(long id);
}
