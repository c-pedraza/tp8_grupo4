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

import com.indra.tp8_grupo4.model.Prestamo;
import com.indra.tp8_grupo4.services.PrestamoServiceImp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/prestamos") // http:://localhost::8080/prestamos
public class PrestamoController {

	// Dependency injection
	@Autowired
	PrestamoServiceImp servicio;

	@GetMapping("/listado") // http:://localhost::8080/prestamos/listado
	public List<Prestamo> listar() {
		return servicio.listar();
	}

	@GetMapping("/id/{id1}") // http:://localhost::8080/prestamos/id/2 (2 por ejemplo, el valor cambia)
	public Prestamo listarId(@PathVariable long id1) {
		return servicio.listarId(id1);
	}

	@PostMapping // altas
	public Prestamo agregar(@RequestBody Prestamo p) {
		return servicio.agregar(p);
	}

	@PutMapping(path = "/{id1}") // modificaciones o actualizaciones http://localhost:8080/prestamos/2
	public Prestamo editar(@PathVariable long id1, @RequestBody Prestamo p) {
		p.setId(id1);
		return servicio.modificar(p);
	}

	@DeleteMapping(path = "/delete/{id1}") // http://localhost:8080/prestamos/delete/2
	public void delete(@PathVariable long id1) {
		servicio.delete(id1);
	}
}
