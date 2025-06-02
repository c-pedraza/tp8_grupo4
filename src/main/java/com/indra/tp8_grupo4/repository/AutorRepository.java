package com.indra.tp8_grupo4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.tp8_grupo4.model.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long>{

	//Dialogar hacia la BD directamente
	Autor findById(long id);
	List<Autor> findAll();
	Autor save(Autor t);
	void delete(Autor t);
}
