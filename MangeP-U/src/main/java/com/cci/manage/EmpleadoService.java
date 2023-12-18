package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



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
	
	public Empleados getUserByIdWithPlainQuery(EntityManager em, String correo, String password) {
	    Query jpqlQuery = em.createQuery("SELECT u FROM Empleados u WHERE u.correo=:correo");
	    jpqlQuery.setParameter("coreo", correo);
	    return (Empleados) jpqlQuery.getSingleResult();
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
	
	public static Empleados findAllSQLWithParam(EntityManager em, Object obj) throws Exception {
		Empleados query = (Empleados) em.createNamedQuery("Empleados.find", Empleados.class)
		.setParameter("nombreParam", obj).getSingleResult();
		return query;
		
	}

	public String Credenciales(EntityManager em, String correo, String clave) {
        TypedQuery<String> query = em.createQuery("SELECT e.tipo FROM Empleados e WHERE e.Correo = :Correo AND e.Password = :Password", String.class);
        query.setParameter("Correo", correo);
        query.setParameter("Password", clave);

        try {
            String tipoEmpleado = query.getSingleResult();
            if (tipoEmpleado != null) {
                return tipoEmpleado;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
}
