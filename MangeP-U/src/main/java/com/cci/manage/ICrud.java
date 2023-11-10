package com.cci.manage;

import java.util.List;

import javax.persistence.EntityManager;

public interface ICrud <E>{
	
	public E buscarPK (EntityManager em, Object obj);
	public List<E>listar(EntityManager em);
	public void insertar(EntityManager em, Object obj);
	public void modificar(EntityManager em, Object obj);
	public void eliminar(EntityManager em, Object obj);

}
