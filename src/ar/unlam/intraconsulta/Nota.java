package ar.unlam.intraconsulta;

public class Nota {
	
	private Double valor;
	private TipoDeNota tipoDeNota;
	
	public Nota(Double valor, TipoDeNota tipoDeNota) {
		this.valor= valor;
		this.tipoDeNota= tipoDeNota;
	}

	public Nota(Double valorNota1) {
		if(valorNota1 >= 1 && valorNota1 <= 10) {
			this.valor = valorNota1;
		}
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoDeNota getTipoDeNota() {
		return tipoDeNota;
	}

	public void setTipoDeNota(TipoDeNota tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
	}
	
	

}
