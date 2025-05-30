package com.indra.tp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	// Dialogar hacia la BD directamente
	Libro findById(long id);

	List<Libro> findAll();

	Libro save(Libro t);

	void delete(Libro t);
}
