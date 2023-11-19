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
	private Integer id;
	private Integer fk_proyecto;
	private Integer fk_empleado;
	private String Rol;
	@ManyToMany (mappedBy="detallesproyectoss")
	private Set<Empleados> DetalleProyecto;
	private static final long serialVersionUID = 1L;

	public DetallesProyecto() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getFk_proyecto() {
		return this.fk_proyecto;
	}

	public void setFk_proyecto(Integer fk_proyecto) {
		this.fk_proyecto = fk_proyecto;
	}   
	public Integer getFk_empleado() {
		return this.fk_empleado;
	}

	public void setFk_empleado(Integer fk_empleado) {
		this.fk_empleado = fk_empleado;
	}   
	public String getRol() {
		return this.Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}
   
}
