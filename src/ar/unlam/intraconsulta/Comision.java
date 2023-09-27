package ar.unlam.intraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Comision {

	private Integer idComision;
	private Integer idCicloLectivo;
	private Materia materia;
	private Turno turno;
	private ArrayList<Docente> docentes;
	private ArrayList<Alumno> alumnos;
	private Aula aula;
	private ArrayList<RegistroDeNotaDeExamen> registroNota;

	public Comision() {
		this.registroNota = new ArrayList<RegistroDeNotaDeExamen>();
	}

	public Comision(Integer idComision, Materia materia1, Turno turno) {

		this.idComision = idComision;
		this.materia = materia1;
		this.turno = turno;
		this.docentes = new ArrayList<Docente>();
		this.alumnos = new ArrayList<Alumno>();
		this.registroNota = new ArrayList<RegistroDeNotaDeExamen>();
	}

	public void agregarDocente(Docente docente) {
		docentes.add(docente);
	}

	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}

	@Override
	public int hashCode() {
		return Objects.hash(materia, turno);
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
		return Objects.equals(materia, other.materia) && turno == other.turno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
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

	public Integer getIdCicloLectivo() {
		return idCicloLectivo;
	}

	public void setIdCicloLectivo(Integer idCicloLectivo) {
		this.idCicloLectivo = idCicloLectivo;
	}

	public Boolean agregarRegistroDeNotaDeExamen(RegistroDeNotaDeExamen registroExamen) {
		TipoDeNota tipoDeNotaAAlmacenar = registroExamen.getNota().getTipoDeNota();
		for (int i = 0; i < this.registroNota.size(); i++) {
			if (this.registroNota.get(i).getNota().getTipoDeNota().equals(tipoDeNotaAAlmacenar)) {
				return false;
			}
		}
		return this.registroNota.add(registroExamen);
	}

	private Boolean puedeRecuperar(Integer dni) {
		Double notaPrimerParcial = 0.0;
		Double notaSegundoParcial = 0.0;
		TipoDeNota tipoPrimerParcial = null;
		TipoDeNota tipoSegundoParcial = null;
		for (RegistroDeNotaDeExamen i : this.registroNota) {
			if (i.getAlumno().getDniAlumno().equals(dni)) {
				if (i.getNota().getTipoDeNota().equals(TipoDeNota.Primer_parcial) && i.getNota().getValor() >= 4){ 
					notaPrimerParcial = i.getNota().getValor();
				}
				if (i.getNota().getTipoDeNota().equals(TipoDeNota.Segundo_parcial) && i.getNota().getValor() >= 4) {
					notaSegundoParcial = i.getNota().getValor();
				}
			}
		
		}
		if(!notaPrimerParcial.equals(null) && !notaSegundoParcial.equals(null)){
			return true;
		}
		return false;

	}
	
	

	
				



	public Boolean rendirRecuperatorio(Integer dniAlumno, TipoDeNota recuperatorio, Double valorNota) {
		Nota nota = null;
		Alumno alumno = null;
		if(puedeRecuperar(dniAlumno)){
			for (RegistroDeNotaDeExamen i : this.registroNota) {
				if(i.getAlumno().getDniAlumno().equals(dniAlumno) && i.getNota().getTipoDeNota().equals(recuperatorio)) {
					alumno = i.getAlumno();
					if(i.getNota().getTipoDeNota().equals(TipoDeNota.Primer_parcial)) {
						nota = new Nota(valorNota, TipoDeNota.Rec_primer_parcial);
						i = new RegistroDeNotaDeExamen(alumno,nota);
						return true;
					}
					if(i.getNota().getTipoDeNota().equals(TipoDeNota.Segundo_parcial)) {
						nota = new Nota(valorNota, TipoDeNota.Rec_segundo_parcial);
						i = new RegistroDeNotaDeExamen(alumno,nota);
						return true;
					}
				}
			}
		}
		return false;
		
	}

}
