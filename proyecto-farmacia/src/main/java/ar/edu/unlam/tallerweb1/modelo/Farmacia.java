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
public class Farmacia {	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Farmacia")
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Direccion", nullable = true)
	private Direccion direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Punto", nullable = true)
	private Punto geoLocalizacion;
			
	// Constructor Con Parametros
	
	public Farmacia() {
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}

	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

}
