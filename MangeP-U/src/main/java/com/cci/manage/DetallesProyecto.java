package com.cci.manage;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DetallesProyecto
 *
 */
@Entity
public class DetallesProyecto implements Serializable {

	   

	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Projecto fk_proyecto;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Empleados fk_empleado;

    private String Rol;
   

    private static final long serialVersionUID = 1L;

	public DetallesProyecto() {
		super();
	}   
	 
	public String getRol() {
		return this.Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}

	public Projecto getFk_proyecto() {
		return fk_proyecto;
	}

	public void setFk_proyecto(Projecto fk_proyecto) {
		this.fk_proyecto = fk_proyecto;
	}

	public Empleados getFk_empleado() {
		return fk_empleado;
	}

	public void setFk_empleado(Empleados fk_empleado) {
		this.fk_empleado = fk_empleado;
	}
	
	
	
   
}
