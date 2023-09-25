package ar.unlam.intraconsulta;

import java.util.ArrayList;

import ar.unlam.intraconsulta.*;

public class Universidad {

	private String nombre;
	private ArrayList<Comision> comisiones;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosElectivos;
	private ArrayList<Docente> docentes;

	public Universidad(String nombreUniversidad) {
		this.nombre = nombreUniversidad;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.ciclosElectivos = new ArrayList<CicloLectivo>();
		this.docentes = new ArrayList<Docente>();
		this.comisiones = new ArrayList<Comision>();
	}

	public Boolean registrarMateria(Materia materia1) {
		Boolean sePudoAgregar = false;
		if (buscarMateriaPorId(materia1.getId()) == null) {
			materias.add(materia1);
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	private Materia buscarMateriaPorId(Integer id) {
		for (Materia materia : materias) {
			if (materia.getId().equals(id)) {
				return materia;
			}
		}
		return null;
	}

	public Boolean registrar(Alumno alumno) {
		Boolean sePudoAgregar = false;
		if (buscarAlumnoPorDni(alumno.getDniAlumno()) == null) {
			alumnos.add(alumno);
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	private Alumno buscarAlumnoPorDni(Integer dniAlumno) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDniAlumno().equals(dniAlumno)) {
				return alumno;
			}
		}
		return null;
	}

	public Boolean agregarCicloElectivo(CicloLectivo cicloElectivo1) {
		if (this.ciclosElectivos.size() != 0) {
			for (int i = 0; i < this.ciclosElectivos.size(); i++) {
				if (this.ciclosElectivos.get(i).equals(cicloElectivo1)) {
					return false;
				}
				if (this.ciclosElectivos.get(i).lasFechasSeSuperponen(cicloElectivo1)) {
					return false;
				}
			}
		}
		return this.ciclosElectivos.add(cicloElectivo1);
	}

	

	private CicloLectivo buscarCicloElectivoPorId(Integer id) {
		for (CicloLectivo cicloElectivo : ciclosElectivos) {
			if (cicloElectivo.getId().equals(id)) {
				return cicloElectivo;
			}
		}
		return null;
	}

	public Boolean registrarDocente(Docente docente) {
		Boolean sePudoRegistrar = false;
		if (buscarDocentePorDni(docente.getDni()) == null) {
			docentes.add(docente);
			sePudoRegistrar = true;
		}

		return sePudoRegistrar;
	}

	private Docente buscarDocentePorDni(Integer dni) {
		for (Docente docente : docentes) {
			if (docente.getDni().equals(dni)) {
				return docente;
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

	public Boolean agregarComision(Comision comision) {
		Boolean sePudoAgregar = false;
		if (validarComision(comision)) {
			sePudoAgregar = true;
			comisiones.add(comision);
		}
		return sePudoAgregar;
	}

	private boolean validarComision(Comision comision) {
		for (Comision comision2 : comisiones) {
			if (comision2.equals(comision)) {
				return false;
			}
		}
		return true;
	}

	public Boolean asignarDocente(Integer idComision, Docente docente1) {
		Boolean sePudoAgregar = false;
		for (Comision comision : comisiones) {
			if (comision.getIdComision().equals(idComision)&& !comision.getDocentes().contains(docente1) ) {
				comision.agregarDocente(docente1);
				sePudoAgregar = true;
				return sePudoAgregar;
			}

		}
		return sePudoAgregar;
	}

	public Boolean agregarCorrelativas(Integer idMateria1, Integer idMateria2) {
		Boolean sePudoAgregar = false;
		for (Materia materia : materias) {
			if (materia.getId().equals(idMateria1)) {
				materia.agregarMateriaCorrelativa(this.buscarMateriaPorId(idMateria2));
				sePudoAgregar = true;
			}

		}

		return sePudoAgregar;
	}

	public Boolean eliminarCorrelativa(Integer idMateria1, Integer idMateria2) {
		Boolean sePudoEliminar = false;
		for (Materia materia : materias) {
			if (materia.getId().equals(idMateria1)) {
				materia.eliminarCorrelativa(this.buscarMateriaPorId(idMateria2));
				sePudoEliminar = true;
			}
		}
		return sePudoEliminar;
	}
	
	private Comision buscarComisionPorId(Integer idComision) {
		for(Comision i: this.comisiones) {
			if(i.getIdComision().equals(idComision)) {
				return i;
			}
		}
		return null;
	}

	public Boolean inscribirAlumnoAComision(Integer dniAlumno, Integer idComision) {
		Alumno alumno = null;
		Comision comision = null;
		alumno = buscarAlumnoPorDni(dniAlumno);
		comision = buscarComisionPorId(idComision);
		if(alumno != null & comision !=null) {
			comision.agregarAlumno(alumno);
			return true;
		}

		return false;
	}

}
