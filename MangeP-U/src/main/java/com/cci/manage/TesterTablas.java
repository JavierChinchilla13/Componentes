package com.cci.manage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
			
		
			
			
			EmpleadoService m = new EmpleadoService();
			
			
			
			
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
