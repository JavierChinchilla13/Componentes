package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class AdminService extends Empleados implements ICrud<Admin>{
	
	public AdminService() {
		super();
	}

	@Override
	public Admin buscarPK(EntityManager em, Object obj) {
		Admin empleadoAdmin = em.find(Admin.class, obj);
		if (empleadoAdmin != null) {
			return empleadoAdmin;
		}
		
		return null;
	}

	@Override
	public List<Admin> listar(EntityManager em) {
		String jpql = "Select t From " + Admin.class.getSimpleName() + " t";
		List<Admin> listar = em.createQuery(jpql, Admin.class).getResultList();
		
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
