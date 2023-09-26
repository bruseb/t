package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Docente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private LocalDate fechaDeIngreso;

	public Docente(String nombreDocente, String apellidoDocente, Integer dniDocente, LocalDate fechaDeIngreso) {
		this.nombre = nombreDocente;
		this.apellido = apellidoDocente;
		this.dni = dniDocente;
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
}
