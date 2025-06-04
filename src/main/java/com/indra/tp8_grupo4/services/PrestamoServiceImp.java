package com.indra.tp8_grupo4.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.tp8_grupo4.model.Copia;
import com.indra.tp8_grupo4.model.Copia.EstadoCopia;
import com.indra.tp8_grupo4.model.Lector;
import com.indra.tp8_grupo4.model.Prestamo;
import com.indra.tp8_grupo4.repository.PrestamoRepository;

@Service
public class PrestamoServiceImp implements PrestamoService {

	// aplico el Dependency Injection
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	LectorServiceImp lectorService;
	
	@Autowired
	CopiaServiceImp copiaService;

	// Todo/parte... la parte es injectada a traves del parametro del constructor

	// public PersonaServiceImp(PersonaRepository personaRepository){
	// this.personaRepository = personaRepository;
	// }

	@Override
	public Prestamo listarId(long id) {
		return prestamoRepository.findById(id);
	}

	@Override
	public List<Prestamo> listar() {
		return prestamoRepository.findAll();
	}

	@Override
	public Prestamo agregar(Prestamo p) {
		return prestamoRepository.save(p);
	}

	@Override
	public Prestamo modificar(Prestamo s) {
		Prestamo original = prestamoRepository.findById(s.getId().longValue());
		if (s.getFechaInicio() != null)
			original.setFechaInicio(s.getFechaInicio());

		if (s.getFechaFin() != null)
			original.setFechaFin(s.getFechaFin());

		return prestamoRepository.save(s);
	}

	@Override
	public void delete(long id) {
		prestamoRepository.deleteById(id);
	}
	
	// Prestamos la copia
	public void prestarCopia(long idCopia, long idLector) {
		Date fechaAct = new Date();
		
		// Lector por id
		Lector lector = lectorService.listarId(idLector);
		
		// Copia por id
		Copia copia = copiaService.listarId(idCopia);
		
		// Le prestamos al lector que nos ha llegado por id la copia id
		Prestamo prestamo = lector.prestar(idCopia, fechaAct);
		
		// Seteamos la copia y el lector
		prestamo.setCopia(copia);
		prestamo.setLector(lector);
		
		// Añadir el prestamo a la lista del lector
		List<Prestamo> listaPrestamos = lector.getPrestamos();
		listaPrestamos.add(prestamo);
		lector.setPrestamos(listaPrestamos);
		
		// Cambiamos el estado de la copia a PRESTADO
		copia.setEstado(EstadoCopia.PRESTADO);
		
		// Modificamos a la base de datos
		lectorService.modificar(lector);
		copiaService.modificar(copia);
		
	}

}
