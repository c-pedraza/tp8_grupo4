package com.indra.tp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

	// Dialogar hacia la BD directamente
	Prestamo findById(long id);

	List<Prestamo> findAll();

	Prestamo save(Prestamo t);

	void delete(Prestamo t);
}
