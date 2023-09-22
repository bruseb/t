package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {
	
	private Integer id;
	private String nombre;
	private ArrayList <Materia> correlativas;

	public Materia(Integer idMateria, String nombreMateria) {
		this.id = idMateria;
		this.nombre = nombreMateria;
		this.correlativas = new ArrayList <Materia>(); 
	}
	
	public void agregarMateriaCorrelativa(Materia materia) {
		correlativas.add(materia);
	}
	
	public void eliminarCorrelativa(Materia materia) {
		correlativas.remove(materia);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}
}
