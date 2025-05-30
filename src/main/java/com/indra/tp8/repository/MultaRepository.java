package com.indra.tp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long> {

	// Dialogar hacia la BD directamente
	Multa findById(long id);

	List<Multa> findAll();

	Multa save(Multa t);

	void delete(Multa t);
}
