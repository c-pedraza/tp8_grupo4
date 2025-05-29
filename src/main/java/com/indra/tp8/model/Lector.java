package com.indra.tp8.model;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;

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
	
	//REVISAR ESTO CUIDAO AAA
	private Identifier nSocio;
	
	private String nombre;
	private String telefono;
	private String direccion;
	
	//Un lector tiene MUCHOS prestamos
	@OneToMany(mappedBy = "lector", cascade = CascadeType.ALL)
	private List<Prestamo> prestamos;
	
	
	//Cada persona tiene una sola multa
	@OneToOne(cascade = CascadeType.ALL)
	private Multa multa;
	
	//FALTA HACER LOS MÉTODOS
}
