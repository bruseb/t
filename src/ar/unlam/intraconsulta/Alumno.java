package ar.unlam.intraconsulta;

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
