package ar.unlam.intraconsulta;

import java.time.LocalDate;


public class CicloLectivo {

	private Integer id;
	private Integer fechaDeInscripcion;
	private Integer fechaDeInicio;
	private Integer fechaDeFin;

	public CicloLectivo(Integer idCicloElectivo, Integer fechaDeInscripcion, Integer fechaDeInicio,
			Integer fechaDeFin) {
		this.id = idCicloElectivo;
		this.fechaDeInscripcion = fechaDeInscripcion;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
	}

	public CicloLectivo(Integer idCicloLectivo, LocalDate fechaDeInscripcion, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaFinalizacionCicloLectivo) {
		this.id = idCicloLectivo;
		this.fechaDeInscripcion = fechaDeInscripcion.getDayOfYear();
		this.fechaDeInicio = fechaInicioCicloLectivo.getDayOfYear();
		this.fechaDeFin = fechaFinalizacionCicloLectivo.getDayOfYear();

	}

	public Boolean lasFechasSeSuperponen(CicloLectivo cicloLectivoCopia) {

		if (this.fechaDeInicio<= cicloLectivoCopia.fechaDeFin
				&& this.fechaDeFin >= cicloLectivoCopia.fechaDeInicio) {
			return true;
		} else {
			return false;
		}

//		a <= c && b >= d  

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(Integer fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

	public Integer getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(Integer fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public Integer getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(Integer fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

}
