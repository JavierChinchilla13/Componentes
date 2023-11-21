package com.cci.manage;

import java.io.Serializable;
import java.lang.Integer;

/**
 * ID class for entity: DetallesProyectoId
 *
 */ 
public class DetallesProyectoIdPK  implements Serializable {   
   
	         
	private Integer fk_proyecto;         
	private Integer fk_empleado;
	private static final long serialVersionUID = 1L;

	public DetallesProyectoIdPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof DetallesProyectoIdPK)) {
			return false;
		}
		DetallesProyectoIdPK other = (DetallesProyectoIdPK) o;
		return true
			&& (getFk_proyecto() == null ? other.getFk_proyecto() == null : getFk_proyecto().equals(other.getFk_proyecto()))
			&& (getFk_empleado() == null ? other.getFk_empleado() == null : getFk_empleado().equals(other.getFk_empleado()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getFk_proyecto() == null ? 0 : getFk_proyecto().hashCode());
		result = prime * result + (getFk_empleado() == null ? 0 : getFk_empleado().hashCode());
		return result;
	}
   
   
}
