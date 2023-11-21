package com.cci.manage;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DetallesProyectoId
 *
 */
@Entity

@IdClass(DetallesProyectoIdPK.class)
public class DetallesProyectoId implements Serializable {

	   
	@Id
	private Integer fk_proyecto;   
	@Id
	private Integer fk_empleado;
	private static final long serialVersionUID = 1L;

	public DetallesProyectoId() {
		super();
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
   
}
