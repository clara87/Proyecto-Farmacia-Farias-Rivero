package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Direccion")
	private Long id;
	private String calle;
	private String numero;
	
	// n a 1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Barrio", nullable = true)
	private Barrio barrio;
		
	// Constructor Con Parametros


	public Direccion() {
		super();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Barrio getBarrio() {
		return barrio;
	}


	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	
}
