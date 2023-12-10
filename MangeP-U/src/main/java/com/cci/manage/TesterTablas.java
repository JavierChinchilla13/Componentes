package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;






public class TesterTablas {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		

		try {
			startEntityManagerFactory();
			
			em = entityManagerFactory.createEntityManager();
			
			/*Empleados empleados = new Empleados();
			EmpleadoService sp = new EmpleadoService();
			
			
			for(Empleados p: sp.listar(em)) {
				System.out.println("Nombre: "+p.getNombre());
			}*/
			
			/*Vacaciones vacaciones = new Vacaciones();
			VacacionesService sp2 = new VacacionesService();
				
				
				for(Vacaciones p: sp2.listar(em)) {
					System.out.println("Nombre: "+p.getEstado());
				}
			
				
				Empleados p =  new Empleados();
				p.setId(new Integer("11"));
				p.setNombre("CCI");
			
				
				Vacaciones u =  new Vacaciones();
				u.setIdVacaciones(new Integer("12"));
				u.setPersona(p);
				em.getTransaction().begin();
				em.persist(u);
				em.getTransaction().commit();*/
			
			
			
				
			
			Empleados p =  new Empleados();
			p.setId(new Integer("11"));
			p.setNombre("CCI");
			
			System.out.println("-----------------------");
			Vacaciones profe = findPK(p);
			System.out.println("Nombre localizado con JPQL por PK: : " + profe.getIdVacaciones());
				
				
				
				
			stopEntityManagerFactory();
			
			System.out.println("Done");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Vacaciones findPK(Empleados idLocalizador) throws Exception{
		Vacaciones vacaciones = (Vacaciones)em.createNamedQuery("Vacaciones.findPK").
				setParameter("idParam", idLocalizador)
				.getSingleResult();
		return vacaciones;
	}
	
	public static void startEntityManagerFactory() throws Exception {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("MangeP-U");
                em = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	public static void stopEntityManagerFactory() throws Exception {
        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            entityManagerFactory = null;
        }
    }

}
