package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class ProyectoServicio implements ICrud<Proyecto> {
	
	public ProyectoServicio(){
		
		
	}

	@Override
	public Proyecto buscarPK(EntityManager em, Object obj) {
		
		Proyecto proyectoLocalizado = em.find(Proyecto.class, obj);
		if (proyectoLocalizado != null) {
			return proyectoLocalizado;
		}

		return null;
	}

	@Override
	public List<Proyecto> listar(EntityManager em) {
		
		String jpql = "Select t From " + Proyecto.class.getSimpleName() + " t";
		List<Proyecto> lista = em.createQuery(jpql, Proyecto.class).getResultList();

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
