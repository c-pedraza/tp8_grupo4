package com.indra.tp8_grupo4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8_grupo4.model.Copia;

public interface CopiaRepository extends JpaRepository<Copia, Long> {

	// Dialogar hacia la BD directamente
	Copia findById(long id);

	List<Copia> findAll();

	Copia save(Copia t);

	void delete(Copia t);
}
