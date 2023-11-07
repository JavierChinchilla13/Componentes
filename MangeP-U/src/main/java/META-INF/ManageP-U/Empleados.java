

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Empleados
 *
 */
@Entity

public class Empleados implements Serializable {

	   
	@Id
	private Integer id;
	private String Nombre;
	private String Apellido;
	private Date Cumpleaños;
	private Integer Telefonos;
	private Integer Vacaciones;
	private String CV;
	private String Direccion;
	private Integer Cedula;
	private static final long serialVersionUID = 1L;

	public Empleados() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}   
	public Date getCumpleaños() {
		return this.Cumpleaños;
	}

	public void setCumpleaños(Date Cumpleaños) {
		this.Cumpleaños = Cumpleaños;
	}   
	public Integer getTelefonos() {
		return this.Telefonos;
	}

	public void setTelefonos(Integer Telefonos) {
		this.Telefonos = Telefonos;
	}   
	public Integer getVacaciones() {
		return this.Vacaciones;
	}

	public void setVacaciones(Integer Vacaciones) {
		this.Vacaciones = Vacaciones;
	}   
	public String getCV() {
		return this.CV;
	}

	public void setCV(String CV) {
		this.CV = CV;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}   
	public Integer getCedula() {
		return this.Cedula;
	}

	public void setCedula(Integer Cedula) {
		this.Cedula = Cedula;
	}
   
}
