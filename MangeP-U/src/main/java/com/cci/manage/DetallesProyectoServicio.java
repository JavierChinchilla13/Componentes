package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public void insert(EntityManager em, int empleado, int proyecto,String rol) {

        try {
            em.getTransaction().begin();

            // Create a native SQL insert query
            String nativeInsertQuery = "INSERT INTO detallesproyecto (rol, fk_proyecto_Id, fk_empleado_id) VALUES (?, ?, ?)";
            Query query = em.createNativeQuery(nativeInsertQuery);

            // Set parameters
            query.setParameter(1, rol);
            query.setParameter(2, proyecto);
            query.setParameter(3, empleado);

            // Execute the query
            query.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

	
	

}
}
