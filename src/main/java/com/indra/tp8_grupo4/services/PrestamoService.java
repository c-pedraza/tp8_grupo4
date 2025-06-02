package com.indra.tp8_grupo4.services;

import java.util.List;

import com.indra.tp8_grupo4.model.Prestamo;

public interface PrestamoService {

	// CRUD o ABM
	Prestamo listarId(long id);

	List<Prestamo> listar();

	Prestamo agregar(Prestamo p);

	Prestamo modificar(Prestamo p);

	void delete(long id);
}
