package com.cci.manage;


import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Vacaciones
 *
 */
@Entity

public class Vacaciones implements Serializable {
	
	
	private Integer idVacaciones;
	private Integer dias;
	private Date fech_Inicio;
	private Date fech_Final;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Empleados persona;
	private String estado;
	
	private static final long serialVersionUID = 1L;

	public Vacaciones() {
		super();
	}   
	public Integer getIdVacaciones() {
		return this.idVacaciones;
	}
	public void setIdVacaciones(Integer idVacaciones) {
		this.idVacaciones = idVacaciones;
	}   
	public Integer getDias() {
		return this.dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public Date getFech_Inicio() {
		return fech_Inicio;
	}
	public void setFech_Inicio(Date fech_Inicio) {
		this.fech_Inicio = fech_Inicio;
	}
	public Date getFech_Final() {
		return fech_Final;
	}
	public void setFech_Final(Date fech_Final) {
		this.fech_Final = fech_Final;
	}
	public Empleados getPersona() {
		return persona;
	}
	public void setPersona(Empleados persona) {
		this.persona = persona;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
   
}
