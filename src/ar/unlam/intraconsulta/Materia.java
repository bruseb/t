package ar.unlam.intraconsulta;

public class Materia {
	
	private Integer id;
	private String nombre;

	public Materia(Integer idMateria, String nombreMateria) {
		this.id = idMateria;
		this.nombre = nombreMateria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
