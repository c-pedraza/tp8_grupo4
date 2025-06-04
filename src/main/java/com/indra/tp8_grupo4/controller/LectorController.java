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

import com.indra.tp8_grupo4.model.Lector;
import com.indra.tp8_grupo4.services.LectorServiceImp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lector") // http:://localhost::8080/lector
public class LectorController {
	
	@Autowired
	LectorServiceImp servicio;
	
	@GetMapping("/listado") // http:://localhost::8080/lector/listado
	public List<Lector> listar() {
		return servicio.listar();
	}

	@GetMapping("/id/{id1}") // http:://localhost::8080/lector/id/2 (2 por ejemplo, el valor cambia)
	public Lector listarId(@PathVariable long id1) {
		return servicio.listarId(id1);
	}

	@PostMapping("/addLibro") // altas
	public Lector agregar(@RequestBody Lector p) {
		return servicio.agregar(p);
	}

	@PutMapping(path = "/{id1}") // modificaciones o actualizaciones http://localhost:8080/lector/2
	public Lector editar(@PathVariable long id1, @RequestBody Lector p) {
		p.setNSocio(id1);
		return servicio.modificar(p);
	}

	@DeleteMapping(path = "/delete/{id1}") // http://localhost:8080/lector/delete/2
	public void delete(@PathVariable long id1) {
		servicio.delete(id1);
	}

}
