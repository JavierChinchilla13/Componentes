package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public class DetallesProyectoServicio implements ICrud<DetallesProyecto> {
	
	public DetallesProyectoServicio() {
		
	}

	@Override
	public DetallesProyecto buscarPK(EntityManager em, Object obj) {
		
		DetallesProyecto DetalleproyectoLocalizado = em.find(DetallesProyecto.class, obj);
		
		if (DetalleproyectoLocalizado != null) {
			return DetalleproyectoLocalizado;
		}

		return null;
	}

	@Override
	public List<DetallesProyecto> listar(EntityManager em) {
		
		String jpql = "Select t From " + DetallesProyecto.class.getSimpleName() + " t";
		List<DetallesProyecto> lista = em.createQuery(jpql, DetallesProyecto.class).getResultList();

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
