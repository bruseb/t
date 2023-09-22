package ar.unlam.intraconsulta;

public class Docente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer fechaDeIngreso;

	public Docente(String nombreDocente, String apellidoDocente, Integer dniDocente, Integer fechaDeIngreso) {
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

	public Integer getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Integer fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
}
