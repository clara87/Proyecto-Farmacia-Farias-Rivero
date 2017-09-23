package ar.edu.unlam.tallerweb1.modelo;

public class Operaciones {
	private Integer operador1;
	private Integer operador2;
	private String operador;
	
	
	public Operaciones(Integer operador1, Integer operador2, String operador) {
		super();
		this.operador1 = operador1;
		this.operador2 = operador2;
		this.operador = operador;
	}
	public Integer getOperador1() {
		return operador1;
	}
	public void setOperador1(Integer operador1) {
		this.operador1 = operador1;
	}
	public Integer getOperador2() {
		return operador2;
	}
	public void setOperador2(Integer operador2) {
		this.operador2 = operador2;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	

}
