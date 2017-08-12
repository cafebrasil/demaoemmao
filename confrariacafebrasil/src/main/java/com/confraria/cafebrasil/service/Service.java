package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	 * @param entityClass
	 * @param namedQuery
	 * @param params
	 * @return T
	 */
	public T find(final Class<T> entityClass, final String namedQuery, final Object... params){
		try {
			final TypedQuery<T> createNamedQuery = em.createNamedQuery(namedQuery, entityClass);
			Integer position = 0;
			for (final Object param : params) {
				createNamedQuery.setParameter(++position, param);
			}
			return createNamedQuery.getSingleResult();
		} catch (final NoResultException e) {
			return null;
		}
	}


	/****
	 *
	 * @param entityClass
	 * @param namedQuery
	 * @param params
	 * @return List<T>
	 */
	public List<T> findAllByParams(final Class<T> entityClass, final String namedQuery, final Object... params){
		try {
			final TypedQuery<T> createNamedQuery = em.createNamedQuery(namedQuery, entityClass);
			Integer position = 0;
			for (final Object param : params) {
				createNamedQuery.setParameter(++position, param);
			}
			return createNamedQuery.getResultList();
		} catch (final NoResultException e) {
			return null;
		}
	}
	/***
	 *
	 * @param name
	 * @param entityClass
	 * @return List<T>
	 */
	public List<T> findAll(final String name, final Class<T> entityClass) {
		return em.createNamedQuery(name, entityClass).getResultList();
	}

	/***
	 *
	 * @param descricao
	 * @param name
	 * @param entityClass
	 * @return List<T>
	 */
	public List<T> find(final String descricao, final String name, final Class<T> entityClass) {
		final TypedQuery<T> createNamedQuery = em.createNamedQuery(name, entityClass);
		createNamedQuery.setParameter(1, descricao);
		return createNamedQuery.getResultList();
	}

	/***
	 *
	 * @param name
	 * @param entityClass
	 */
	public void delete(final String name, final Class<T> entityClass) {
		em.createNamedQuery(name, entityClass).executeUpdate();
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
