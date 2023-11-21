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
@IdClass(DetallesProyectoId.class)
public class DetallesProyecto implements Serializable {

	   

    @Id
    private Integer fk_proyecto;

    @Id
    private Integer fk_empleado;

    private String Rol;

    @ManyToMany
    @JoinTable(
        name = "DetallesProyecto_Empleado",
        joinColumns = @JoinColumn(name = "fk_detallesproyecto"),
        inverseJoinColumns = @JoinColumn(name = "fk_empleado")
    )
    private Set<Empleados> empleados;

    @ManyToMany
    @JoinTable(
        name = "DetallesProyecto_Proyecto",
        joinColumns = @JoinColumn(name = "fk_detallesproyecto"),
        inverseJoinColumns = @JoinColumn(name = "fk_proyecto")
    )
    private Set<Proyecto> proyectos;

    private static final long serialVersionUID = 1L;

	public DetallesProyecto() {
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
	public String getRol() {
		return this.Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}
	public Set<Empleados> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleados> empleados) {
		this.empleados = empleados;
	}
	public Set<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
   
}
