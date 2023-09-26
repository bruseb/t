package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Docente> docentes;

	public Universidad(String nombreUniversidad) {
		this.nombre = nombreUniversidad;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.ciclosLectivos = new ArrayList<CicloLectivo>();
		this.docentes = new ArrayList<Docente>();

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

	public Boolean agregarCicloLectivo(CicloLectivo cicloLectivo) {
		Boolean sePudoAgregar = false;

		if (buscarCicloLectivoPorId(cicloLectivo.getId()) == null
				&& validarFechas(cicloLectivo.getFechaDeInicio(), cicloLectivo.getFechaDeFin())) {
			ciclosLectivos.add(cicloLectivo);
			sePudoAgregar = true;
		}

		return sePudoAgregar;

	}

	private Boolean validarFechas(LocalDate fechaDeInicio, LocalDate fechaDeFin) {
		Boolean sePudoValidar = true;
		for (CicloLectivo cicloLectivo : ciclosLectivos) {
			if (fechaDeInicio.isAfter(cicloLectivo.getFechaDeInicio())
					&& fechaDeInicio.isBefore(cicloLectivo.getFechaDeFin())
					|| (fechaDeFin.isAfter(cicloLectivo.getFechaDeInicio())
							&& fechaDeFin.isBefore(cicloLectivo.getFechaDeFin()))) {
				sePudoValidar = false;
			}
		}
		return sePudoValidar;
	}

	private CicloLectivo buscarCicloLectivoPorId(Integer id) {
		for (CicloLectivo cicloLectivo : ciclosLectivos) {
			if (cicloLectivo.getId().equals(id)) {
				return cicloLectivo;
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

	public Boolean agregarCorrelativas(Integer idMateria1, Integer idMateria2) {
		Boolean sePudoAgregar = false;
		
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
		for (Comision i : this.comisiones) {
			if (i.getIdComision().equals(idComision)) {
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
		if (alumno != null & comision != null) {
			comision.agregarAlumno(alumno);
			return true;
		}

		return false;
	}

}
