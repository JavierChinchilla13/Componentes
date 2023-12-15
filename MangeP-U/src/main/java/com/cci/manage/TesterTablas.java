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
			
			
				
			
			Empleados p =  new Empleados();
			EmpleadoService m = new EmpleadoService();
			p.setId(new Integer("13"));
			p.setNombre("PRUEBA");
			
			
			//System.out.print(m.getUserByIdWithPlainQuery(em,"javi@mail.com", "12345678"));
			
			
			/*System.out.println("-----------------------");
			Vacaciones profe = findPK(p);
			System.out.println("Nombre localizado con JPQL por PK: : " + profe.getIdVacaciones());
				
			System.out.println("-----------------------");
			List<Vacaciones> lista = findPK1(p);
			for(Vacaciones pro: lista) {
				System.out.println("Nombre: " + pro.getIdVacaciones());
				Empleados localizado = em.find(Empleados.class, new Integer(13));
			if(localizado != null) {
				System.out.println("Se localizo el profesor: "+ localizado.getNombre());
				
			}
			else {
				System.out.println("No se encontro profesor");
                                                 
			}
			localizado.getFechaIngreso();
			
			Vacaciones localizado2 = em.find(Vacaciones.class, new Integer(14));
			if(localizado2 != null) {
				System.out.println("Se localizo el profesor: "+ localizado2.getIdVacaciones());
				
			}
			else {
				System.out.println("No se encontro profesor");
                                                 
			}
			for(Vacaciones pro: VacacionesService.findPK1(em, localizado)) {
				System.out.println("Nombre: " + pro.getIdVacaciones());
			}
				
			}*/
			int a;
			//Empleados x =  (int) a;
			
			VacacionesService v = new VacacionesService ();
			
			Empleados localizado = em.find(Empleados.class, 13);
			if(localizado != null) {
				System.out.println("Se localizo el profesor: "+ localizado.getNombre());
				
			}
			else {
				System.out.println("No se encontro profesor");
	                                             
			}
			
			int totalVacationDays = 0;
			
			List<Vacaciones> lista = v.findVacacion(em, localizado);
			for(Vacaciones pro: lista) {
				//System.out.println("Nombre: " + pro.getFech_Inicio());		
				 LocalDate startLocalDate = pro.getFech_Inicio().toLocalDate();
		            LocalDate endLocalDate = pro.getFech_Final().toLocalDate();
		            long days = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
		            System.out.println("+++++" + days);
		            totalVacationDays += days;
			}
			System.out.println(totalVacationDays);
			
			//System.out.println("------"+v.find(em, localizado));
			int nose = v.calculateVacationDays(em, 13);
			System.out.println(nose-totalVacationDays);
			//v.calculateVacationBalance(em, 13);
			//v.calculateVacationDays(em, 13);
			
			
			//System.out.println(v.calculateVaca(em, 6));
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			
			//System.out.println(m.findAllSQLWithParam(em, localizado2));
			
			//v.eliminar(em, localizado2);

			
			
			
			//v.insertar(em, m1);
			
			
				
			
				
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
