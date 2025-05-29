package com.indra.tp8.model;

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
public class Libro {
	
	public enum TipoLibro {
		NOVELA, TEATRO, POESIA, ENSAYO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	@Enumerated(EnumType.STRING)
	private TipoLibro tipo;

	private String editorial;

	private int anyo;

	//Muchos libros de UN solo autor
	@ManyToOne
	private Autor autor;
	
	//UN libro puede tener MUCHAS copias
	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
	private List<Copia> copias;
	
	//Estado del libro equivalente al enum del estado de las copias
	private String estado;

}
