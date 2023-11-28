package com.cci.manage;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

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
	private Integer Telefono;
	private Integer Vacaciones;
	private String CV;
	private String Direccion;
	private Integer Cedula;
	private String Correo;
	private String Password;
	private Date FechaIngreso;
	private Date FechaRetiro;
	private String estado;
	private String tipo;
	
	private static final long serialVersionUID = 1L;

	public Empleados() {
		
		// hola test test
		super();
	}   
	
	

	public Empleados(Integer id, String nombre, String apellido, Date cumpleaños, Integer telefono, Integer vacaciones,
			String cV, String direccion, Integer cedula, String correo, String password, Date fechaIngreso,
			Date fechaRetiro, String estado, String tipo) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		Cumpleaños = cumpleaños;
		Telefono = telefono;
		Vacaciones = vacaciones;
		CV = cV;
		Direccion = direccion;
		Cedula = cedula;
		Correo = correo;
		Password = password;
		FechaIngreso = fechaIngreso;
		FechaRetiro = fechaRetiro;
		this.estado = estado;
		this.tipo = tipo;
	}




	public Empleados(Integer id, String nombre, String apellido, Date cumpleaños, Integer telefono, String direccion,
			Integer cedula, String correo, String password, Date fechaIngreso, Date fechaRetiro, String estado,
			String tipo) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		Cumpleaños = cumpleaños;
		Telefono = telefono;
		Direccion = direccion;
		Cedula = cedula;
		Correo = correo;
		Password = password;
		FechaIngreso = fechaIngreso;
		FechaRetiro = fechaRetiro;
		this.estado = estado;
		this.tipo = tipo;
	}




	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public Integer getCedula() {
		return Cedula;
	}

	public void setCedula(Integer cedula) {
		Cedula = cedula;
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
	public Integer getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
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


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public Date getFechaIngreso() {
		return FechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}


	public Date getFechaRetiro() {
		return FechaRetiro;
	}


	public void setFechaRetiro(Date fechaRetiro) {
		FechaRetiro = fechaRetiro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
   
}
