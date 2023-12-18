package com.cci.manage;

import com.cci.manage.Empleados;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity(name="Administrador")

public class Admin extends Empleados implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
		
	}
   
}
