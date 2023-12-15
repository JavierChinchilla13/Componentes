package com.cci.manage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class VacacionesService implements ICrud<Vacaciones>{

	public VacacionesService(){
		
	}
	
	

	@Override
	public Vacaciones buscarPK(EntityManager em, Object obj) {
		Vacaciones vacacionLocalizada = em.find(Vacaciones.class, obj);
		if (vacacionLocalizada != null) {
			return vacacionLocalizada;
		}
		return null;
	}
	
	public  List<Vacaciones>  findVacacion(EntityManager em, Empleados employeeId) throws Exception{
	    int totalVacationDays = 0;
	    
	    TypedQuery<Vacaciones> query = em.createNamedQuery("Vacaciones.find" , Vacaciones.class);
		String localizar = "%"+employeeId+"%";
		query.setParameter("employeeId", employeeId);

	        return query.getResultList();
	    
	}
	
	public static List<Vacaciones>  findPK1(EntityManager em, Empleados idLocalizador) throws Exception{
		TypedQuery<Vacaciones> query = em.createNamedQuery("Vacaciones.findPK" , Vacaciones.class);
		String localizar = "%"+idLocalizador+"%";
		query.setParameter("idParam", idLocalizador);
				
		return query.getResultList();
	}
	

	@Override
	public List<Vacaciones> listar(EntityManager em) {
		
		String jpql = "Select t From " + Vacaciones.class.getSimpleName() + " t";
		List<Vacaciones> lista = em.createQuery(jpql, Vacaciones.class).getResultList();
		
		return lista;
	}

	@Override
	public void insertar(EntityManager em, Object obj) {
		try {
			em.getTransaction().begin();

			em.persist(obj);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(EntityManager em, Object obj) {

		em.getTransaction().begin();

		em.merge(obj);

		em.getTransaction().commit();

		
	}

	@Override
	public void eliminar(EntityManager em, Object obj) {
		em.getTransaction().begin();

		em.remove(obj);

		em.getTransaction().commit();
		
	}
	
	public int calculateVacationDays(EntityManager em, int id) {
		
		
		Empleados localizado = em.find(Empleados.class, id);
		if(localizado != null) {
			System.out.println("Se localizo empleado: "+ localizado.getNombre());
			
		}
		else {
			System.out.println("No se encontro empleado");
                                             
		}
		
		LocalDate startLocalDate = localizado.getFechaIngreso().toLocalDate();
        LocalDate endLocalDate = LocalDate.now();
        // Calculate the number of days the employee has been employed
		long daysEmployed = 0;
        daysEmployed = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

        // Calculate the vacation days based on the rule (1 day for every 30 days of employment)
        int vacationDays = (int) (daysEmployed / 30);

        return Math.toIntExact(vacationDays);
    }


	

	   
	        
	

	
}
