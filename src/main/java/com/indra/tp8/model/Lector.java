package com.indra.tp8.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// REVISAR ESTO CUIDAO AAA
	private Long nSocio;

	private String nombre;
	private String telefono;
	private String direccion;

	// Un lector tiene MUCHOS prestamos
	@OneToMany(mappedBy = "lector", cascade = CascadeType.ALL)
	private List<Prestamo> prestamos;

	// Cada persona tiene una sola multa
	@OneToOne(cascade = CascadeType.ALL)
	private Multa multa;

	// FALTA HACER LOS MÉTODOS
	public void devolver(Long idPrestamo, Date fechaAct) {

		// Obtenemos el prestamo con su id
		Optional<Prestamo> prestamo = prestamos.stream().filter(p -> p.getId().equals(idPrestamo)).findFirst();

		if (prestamo.isPresent()) {
			// Máximo 30 días prestado Si hay días de retraso multa(dias)
			if (fechaAct.compareTo(prestamo.get().getFechaFin()) < 0) {
				int dias = fechaAct.getDate() - prestamo.get().getFechaFin().getDate();
				multar(dias);
			}

			// Prestado - 1
			prestamos.remove(prestamo.get());
		}

	}

	public boolean prestar(Long id, Date fechaAct) {

		// Se ha acabado la multa
		if (multa != null) {
			if (fechaAct.compareTo(multa.getFechaFin()) < 0) {
				// Se puede pedir prestado un libro
				return false;
			}
		}

		// Tiene más de 3 prestados
		if (prestamos.size() > 3) {
			return false;
		}

		// Creamos el prestamo
		Date hoy = new Date();
		int mes = this.multa.getFechaFin().getDate() + 30;
		Date finFecha = this.multa.getFechaFin();

		finFecha.setDate(mes);

		Prestamo prestamo = new Prestamo();
		prestamo.setFechaInicio(hoy);
		prestamo.setFechaFin(finFecha);
		prestamos.add(prestamo);

		return true;
	}

	public void multar(int dias) {
		// Cada día de retraso se impone una multa de 2 días
		// Si hay multa

		if (this.multa == null) {
			this.multa = new Multa();
			Date hoy = new Date();

			this.multa.setFechaInicio(hoy);
			this.multa.setFechaFin(hoy);

		}

		int diasFecha = this.multa.getFechaFin().getDate() + dias * 2;
		Date finMulta = this.multa.getFechaFin();

		finMulta.setDate(diasFecha);
		this.multa.setFechaFin(finMulta);

	}

}
