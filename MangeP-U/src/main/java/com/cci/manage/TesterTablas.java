package com.cci.manage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class TesterTablas {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		

		try {
			startEntityManagerFactory();
			
			em = entityManagerFactory.createEntityManager();
			
			Empleados empleados = new Empleados();
			EmpleadoService sp = new EmpleadoService();
			
			
			for(Empleados p: sp.listar(em)) {
				System.out.println("Nombre: "+p.getNombre());
			}
			
			stopEntityManagerFactory();
			
			System.out.println("Done");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

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
