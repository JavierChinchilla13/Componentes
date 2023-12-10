package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

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

	@Override
	public List<Vacaciones> listar(EntityManager em) {
		
		String jpql = "Select t From " + Vacaciones.class.getSimpleName() + " t";
		List<Vacaciones> lista = em.createQuery(jpql, Vacaciones.class).getResultList();
		
		return null;
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

	
}
