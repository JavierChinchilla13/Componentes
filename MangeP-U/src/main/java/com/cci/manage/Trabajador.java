package com.cci.manage;

import com.cci.manage.Empleados;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Trabajador extends Empleados implements Serializable {

	
	@Temporal (TemporalType.TIMESTAMP)
	private Date Cumpleaños;
	private String Direccion;
	private static final long serialVersionUID = 1L;

	public Trabajador() {
		super();
	}   
	public Date getCumpleaños() {
		return this.Cumpleaños;
	}

	public void setCumpleaños(Date Cumpleaños) {
		this.Cumpleaños = Cumpleaños;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
   
}
