package com.indra.tp8_grupo4.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Copia {

	public enum EstadoCopia {
		PRESTADO, RETRASO, BIBLIOTECA, REPARACION
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ???????????????????????????????
	private Long idenfiticacion;

	@Enumerated(EnumType.STRING)
	private EstadoCopia estado;

	// Muchas copias para un solo libro
	@ManyToOne
	private Libro libro;

	// UNA copia para MUCHOS prestamos
	// IGUAL ES MANYTOONE AAAAAAAA
	@OneToMany(mappedBy = "copia", cascade = CascadeType.ALL)
	private List<Prestamo> prestamos;
}
