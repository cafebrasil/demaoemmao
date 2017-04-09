package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class Service<T> {

	@Inject
	EntityManager em;

	/***
	 *
	 * @param entity
	 * @return T
	 */
	public T create(final T entity) {
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	/**
	 *
	 * @param entityClass
	 * @param primaryKey
	 * @return T
	 */
	public T find(final Class<T> entityClass, final Object primaryKey) {
		return em.find(entityClass, primaryKey);
	}

	/***
	 *
	 * @param name
	 * @param entityClass
	 * @return List<T>
	 */
	public List<T> findAll(final String name,final Class<T> entityClass) {
		return em.createNamedQuery(name,entityClass).getResultList();
	}

	/**
	 *
	 * @param entityClass
	 * @param primaryKey
	 */
	public void delete(final Class<?> entityClass, final Object primaryKey) {
		em.remove(em.getReference(entityClass, primaryKey));
	}

	/***
	 *
	 * @param entity
	 * @return T
	 */
	public T update(final T entity) {
		return em.merge(entity);
	}

}
