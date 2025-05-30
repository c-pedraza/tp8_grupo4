package com.indra.tp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8.model.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {

	// Dialogar hacia la BD directamente
	Lector findById(long id);

	List<Lector> findAll();

	Lector save(Lector t);

	void delete(Lector t);
}
