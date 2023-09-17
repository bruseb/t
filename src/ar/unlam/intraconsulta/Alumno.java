package ar.unlam.intraconsulta;

public class Alumno {

	private String nombreAlumno;
	private String apellidoAlumno;
	private Integer dniAlumno;

	public Alumno(String nombreAlumno, String apellidoAlumno, Integer dniAlumno) {

		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.dniAlumno = dniAlumno;

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
}
