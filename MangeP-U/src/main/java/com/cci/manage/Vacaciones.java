package com.cci.manage;


import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vacaciones
 *
 */
@Entity

public class Vacaciones implements Serializable {
	
	
	private Integer idVacaciones;
	private Integer dias;
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
   
}
