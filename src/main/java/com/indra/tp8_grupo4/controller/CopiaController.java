package com.indra.tp8_grupo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.tp8_grupo4.model.Copia;
import com.indra.tp8_grupo4.services.CopiaServiceImp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/copia") 
public class CopiaController {
	
	@Autowired
	CopiaServiceImp servicio;
	
	@GetMapping("/listado") // http:://localhost::8080/Copia/listado
	public List<Copia> listar() {
		return servicio.listar();
	}

	@GetMapping("/id/{id1}") // http:://localhost::8080/Copia/id/2 (2 por ejemplo, el valor cambia)
	public Copia listarId(@PathVariable long id1) {
		return servicio.listarId(id1);
	}

	@PostMapping("/addLibro") // altas
	public Copia agregar(@RequestBody Copia p) {
		return servicio.agregar(p);
	}

	@PutMapping(path = "/{id1}") // modificaciones o actualizaciones http://localhost:8080/Copia/2
	public Copia editar(@PathVariable long id1, @RequestBody Copia p) {
		p.setId(id1);
		return servicio.modificar(p);
	}

	@DeleteMapping(path = "/delete/{id1}") // http://localhost:8080/Copia/delete/2
	public void delete(@PathVariable long id1) {
		servicio.delete(id1);
	}

}
