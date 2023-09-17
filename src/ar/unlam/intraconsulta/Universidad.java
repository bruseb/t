package ar.unlam.intraconsulta;

import java.util.ArrayList;


public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;

	public Universidad(String nombreUniversidad) {
		this.nombre = nombreUniversidad;
		this.alumnos = new ArrayList<Alumno>(); 
		this.materias = new ArrayList<Materia>(); 
	}
	public Boolean registrarMateria(Materia materia1) {
		Boolean sePudoAgregar = false;
		if(buscarMateriaPorId(materia1.getId())== null) {
			materias.add(materia1);
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	private Materia buscarMateriaPorId(Integer id) {
		for (Materia materia : materias) {
			if(materia.getId().equals(id)) {
				return materia;
			}
		}
		return null;
	}
	public Boolean registrar(Alumno alumno) {
		Boolean sePudoAgregar = false;
		if(buscarAlumnoPorDni(alumno.getDniAlumno())== null){
			alumnos.add(alumno);
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	private Alumno buscarAlumnoPorDni(Integer dniAlumno) {
		for (Alumno alumno : alumnos) {
			if(alumno.getDniAlumno().equals(dniAlumno)){
				return alumno;
			}
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
