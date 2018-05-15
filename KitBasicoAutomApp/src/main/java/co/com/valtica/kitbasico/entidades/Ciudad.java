package co.com.valtica.kitbasico.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ciudad")
public class Ciudad {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCiudad;
	private String nombre;
	
	public Ciudad() {
		super();
	}
	public Ciudad(Long idCiudad, String nombre) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
