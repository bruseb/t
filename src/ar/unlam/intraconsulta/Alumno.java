package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Alumno {

	private String nombreAlumno;
	private String apellidoAlumno;
	private Integer dniAlumno;
	private Integer fechaDeIngreso;

	public Alumno(String nombreAlumno, String apellidoAlumno, Integer dniAlumno, Integer fechaDeIngreso) {

		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.dniAlumno = dniAlumno;
		this.fechaDeIngreso = fechaDeIngreso;

	}

	public Alumno(String nombreAlumno2, String apellidoAlumno2, Integer dniAlumno2, LocalDate fechaDeIngreso2) {
		this.nombreAlumno = nombreAlumno2;
		this.apellidoAlumno = apellidoAlumno2;
		this.dniAlumno= dniAlumno2;
		this.fechaDeIngreso = fechaDeIngreso2.getDayOfYear();
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public Integer getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Integer fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
}
