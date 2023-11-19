package com.cci.manage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesterTablas {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		
		//Aquí se escriben las sentencias :v

	}
	
	public static void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("MangeP-U");
				em = entityManagerFactory.createEntityManager();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void stopEntityManagerFactory() {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
	}

}
