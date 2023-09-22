package ar.unlam.intraconsulta;

public class CicloElectivo {

	private Integer id;
	private Integer fechaDeInscripcion;
	private Integer fechaDeInicio;
	private Integer fechaDeFin;

	public CicloElectivo(Integer idCicloElectivo, Integer fechaDeInscripcion, Integer fechaDeInicio,Integer fechaDeFin) {
		this.id = idCicloElectivo;
		this.fechaDeInscripcion = fechaDeInscripcion;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
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
