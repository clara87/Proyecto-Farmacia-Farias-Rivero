package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Comuna")
	private Long id;
	private String nombre;
	
	//  1 - n // Acceder 
	@OneToMany(mappedBy="comuna" )
	private List<Barrio> listaBarrios;
	
	// Constructor Con Parametros

	public List<Barrio> getListaBarrios() {
		return listaBarrios;
	}

	public void setListaBarrios(List<Barrio> listaBarrios) {
		this.listaBarrios = listaBarrios;
	}

	public Comuna() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
