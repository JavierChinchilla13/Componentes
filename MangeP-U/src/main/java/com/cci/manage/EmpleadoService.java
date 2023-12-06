package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class EmpleadoService implements ICrud<Empleados> {

	public EmpleadoService() {

	}

	@Override
	public Empleados buscarPK(EntityManager em, Object obj) {

		Empleados empleadoLocalizado = em.find(Empleados.class, obj);
		if (empleadoLocalizado != null) {
			return empleadoLocalizado;
		}

		return null;
	}

	@Override
	public List<Empleados> listar(EntityManager em) {

		String jpql = "Select t From " + Empleados.class.getSimpleName() + " t";
		List<Empleados> lista = em.createQuery(jpql, Empleados.class).getResultList();

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
