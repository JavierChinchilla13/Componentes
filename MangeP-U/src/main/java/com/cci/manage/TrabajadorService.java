package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class TrabajadorService extends Empleados implements ICrud<Trabajador>{

	public TrabajadorService() {
		super();
	}

	@Override
	public Trabajador buscarPK(EntityManager em, Object obj) {
		// TODO Auto-generated method stub
		Trabajador empleadoTrabajador = em.find(Trabajador.class, obj);
		if (empleadoTrabajador != null) {
			return empleadoTrabajador;
		}
		
		return null;
	}

	@Override
	public List<Trabajador> listar(EntityManager em) {
		// TODO Auto-generated method stub
		String jpql = "Select t From " + Trabajador.class.getSimpleName() + " t";
		List<Trabajador> listar = em.createQuery(jpql, Trabajador.class).getResultList();
		
		return listar;
	}

	@Override
	public void insertar(EntityManager em, Object obj) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		em.getTransaction().begin();

		em.merge(obj);

		em.getTransaction().commit();
		
	}

	@Override
	public void eliminar(EntityManager em, Object obj) {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();

		em.remove(obj);

		em.getTransaction().commit();
		
	}
	
	
	
	
}
