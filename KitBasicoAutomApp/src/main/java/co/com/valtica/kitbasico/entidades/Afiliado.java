package co.com.valtica.kitbasico.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="afiliados")
public class Afiliado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAfiliado;
	private String numeroIdentificacion;
	private String nombre;
	private String apellido;
	private String telefono;
	private int edad;
	private double salario;
	@ManyToOne
	@JoinColumn(name = "ID_CIUDAD")
	private Ciudad ciudad;
	
	public Afiliado() {
		super();
	}
	
	public Afiliado(String numeroIdentificacion, String nombre, String apellido, String telefono, int edad, double salario, Ciudad ciudad) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.edad = edad;
		this.salario = salario;
		this.ciudad = ciudad;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public boolean validar() {
		return validarEdad() && validarSalario() && validarCiudad();
	}
	
	private boolean validarEdad() {
		return this.edad >= 18;
	}
	
	private boolean validarSalario() {
		return this.salario >= 100000;
	}
	
	private boolean validarCiudad() {
		return this.ciudad.getIdCiudad() == 1;
	}
	

}
