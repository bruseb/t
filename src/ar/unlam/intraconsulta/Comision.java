package ar.unlam.intraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Comision {

	private Integer idComision;
	private Materia materia;
	private CicloLectivo cicloElectivo;
	private Turno turno;
	private ArrayList <Docente> docentes;
	private ArrayList <Alumno> alumnos;
	private Aula aula;

	public Comision(Integer idComision, Materia materia1, CicloLectivo cicloElectivo, Turno turno) {
		
		this.idComision = idComision;
		this.materia = materia1;
		this.cicloElectivo = cicloElectivo;
		this.turno = turno;
		this.docentes = new ArrayList<Docente>();
		this.alumnos = new ArrayList<Alumno>();

	}
	
	public void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cicloElectivo, materia, turno);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(cicloElectivo, other.cicloElectivo) && Objects.equals(materia, other.materia)
				&& Objects.equals(turno, other.turno);
	}


	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloElectivo() {
		return cicloElectivo;
	}

	public void setCicloElectivo(CicloLectivo cicloElectivo) {
		this.cicloElectivo = cicloElectivo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	
	
}
