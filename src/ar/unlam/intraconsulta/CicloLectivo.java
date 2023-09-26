package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class CicloLectivo {

	private Integer id;
	private LocalDate fechaDeInscripcion;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFin;
	private ArrayList<Comision> comisiones;

	public CicloLectivo(Integer idCicloElectivo, LocalDate fechaDeInscripcion, LocalDate fechaDeInicio,
			LocalDate fechaDeFin) {
		this.id = idCicloElectivo;
		this.fechaDeInscripcion = fechaDeInscripcion;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
		this.comisiones = new ArrayList<Comision>();
	}

//	public CicloLectivo(Integer idCicloLectivo, LocalDate fechaDeInscripcion, LocalDate fechaInicioCicloLectivo,
//			LocalDate fechaFinalizacionCicloLectivo) {
//		this.id = idCicloLectivo;
//		this.fechaDeInscripcion = fechaDeInscripcion.getDayOfYear();
//		this.fechaDeInicio = fechaInicioCicloLectivo.getDayOfYear();
//		this.fechaDeFin = fechaFinalizacionCicloLectivo.getDayOfYear();
//
//	}
//
//	public Boolean lasFechasSeSuperponen(CicloLectivo cicloLectivoCopia) {
//
//		if (this.fechaDeInicio<= cicloLectivoCopia.fechaDeFin
//				&& this.fechaDeFin >= cicloLectivoCopia.fechaDeInicio) {
//			return true;
//		} else {
//			return false;
//		}

//		a <= c && b >= d  

//	}

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
	
	public Comision buscarComisionPorId(Integer idComision) {
		for (Comision i : this.comisiones) {
			if (i.getIdComision().equals(idComision)) {
				return i;
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(LocalDate fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	public Boolean asignarDocenteAComision(Integer idComision, Docente docente1) {
		Boolean sePudoAgregar = false;
		for (Comision comision : comisiones) {
			if (comision.getIdComision().equals(idComision) && !comision.getDocentes().contains(docente1)) {
				comision.agregarDocente(docente1);
				sePudoAgregar = true;
			}

		}
		return sePudoAgregar;
	}
}
