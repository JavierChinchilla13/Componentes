package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class ProyectoServicio implements ICrud<Projecto> {
	
	public ProyectoServicio(){
		
		
	}

	@Override
	public Projecto buscarPK(EntityManager em, Object obj) {
		
		Projecto proyectoLocalizado = em.find(Projecto.class, obj);
		if (proyectoLocalizado != null) {
			return proyectoLocalizado;
		}

		return null;
	}

	@Override
	public List<Projecto> listar(EntityManager em) {
		
		String jpql = "Select t From " + Projecto.class.getSimpleName() + " t";
		List<Projecto> lista = em.createQuery(jpql, Projecto.class).getResultList();

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
	

}
