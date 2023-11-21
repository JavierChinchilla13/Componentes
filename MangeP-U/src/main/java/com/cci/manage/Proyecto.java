package com.cci.manage;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Proyecto
 *
 */
@Entity

public class Proyecto implements Serializable {

	   
	@Id
	private Integer Id;
	private String nombreProyecto;
	private String Descripcion;
	private  Date FechaInicio;
	private  Date FechaFin;
	@ManyToMany(mappedBy = "proyectos")
    private Set<DetallesProyecto> detallesProyectos;
	private static final long serialVersionUID = 1L;

	public Proyecto() {
		super();
	} 
	
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getNombreProyecto() {
		return this.nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
   
}
