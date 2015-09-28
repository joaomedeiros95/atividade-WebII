/**
 * 
 */
package com.joaoemedeiros.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.joaoemedeiros.entity.Entidade;

/**
 * @author joaomedeiros95
 *
 */
public abstract class AbstractDao<T extends Entidade> {
	
	protected static AbstractDao instance;
	private EntityManagerFactory factory;
	protected EntityManager manager;
	
	public void save(T objeto) {
		createManager();
		
		manager.getTransaction().begin();
		manager.persist(objeto);
		manager.getTransaction().commit();
		
		closeManager();
	}
	
	public void update(T objeto) {
		createManager();
		
		manager.getTransaction().begin();
		manager.merge(objeto);
		manager.getTransaction().commit();
		
		closeManager();
	}
	
	public void saveOrUpdate(T objeto) {
		if(objeto.getId() == null || objeto.getId() == 0) {
			save(objeto);
		} else {
			update(objeto);
		}
	}
	
	public void delete(T objeto) {
		createManager();
		
		manager.getTransaction().begin();
		manager.remove(manager.contains(objeto) ? objeto : manager.merge(objeto));
		manager.getTransaction().commit();
		
		closeManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> entidade) {
		createManager();
		try {
			return manager.createQuery("from " + entidade.getSimpleName()).getResultList();
		}
		finally {
			closeManager();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getById(Integer id, Class<T> entidade) {
		createManager();
		try {
			return (T) manager.createQuery("from " + entidade.getSimpleName() + " where id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} finally {
			closeManager();
		}
	}

	private void closeManager() {
		manager.close();
	}
	
	private void createManager() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("TarefaDoisPU");
		}
		manager = factory.createEntityManager();
	}
}
