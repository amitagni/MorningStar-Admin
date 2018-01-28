/*******************************************************************************
* Copyright (c) 2016 PWC Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the PWC License v1.0
*
* Contributors:
* PWC - initial API and implementation
*******************************************************************************/
package com.ms.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import com.ms.entity.BaseEntity;
import com.ms.util.MSException;



public class GenericDao<K, E extends BaseEntity<?>> implements Serializable {

	private static final long serialVersionUID = 5614427191507003407L;
	private EntityManagerFactory entityManagerFactory;

	/**
	 * @param entityManagerFactory
	 */
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * @return the entityManagerFactory
	 */
	/**
	 * @return
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * @return
	 */
	public EntityManager getEntityManager() {

		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory);

		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	/**
	 * @param query
	 * @return
	 */
	public int executeUpdateNative(String query) {
		return executeUpdateNative(query, null);
	}

	/**
	 * @param query
	 * @param params
	 * @return
	 */
	public int executeUpdateNative(String query, List<Object> params) {
		Query jpaQuery = getEntityManager().createNativeQuery(query);
		for (int i = 0; i < params.size(); i++) {
			jpaQuery.setParameter(i + 1, params.get(i));
		}
		return jpaQuery.executeUpdate();
	}

	/**
	 * @param id
	 * @param klass
	 * @return
	 */
	public E findById(K id, Class<E> klass) {
		return getEntityManager().find(klass, id); // class is keyword
	}

	/**
	 * @param pcId
	 * @param userId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedBy(Integer pcId, Integer userId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.pcId = :pcId");
		query.setParameter("pcId", pcId);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param clientId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByClientIdAndCreadedBy(Integer clientId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.clientId = :clientId");
		query.setParameter("clientId", clientId);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param id
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByID(Integer id, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.id = :id ");
		query.setParameter("id", id);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param pcId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedBy(Integer pcId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x");
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param pcId
	 * @param userId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndUserId(Integer pcId, Integer userId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x where x.pcId = :pcId");

		query.setParameter("pcId", pcId);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;

	}

	/**
	 * @param pcId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByPCId(Integer pcId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x where x.pcId = :pcId");
		query.setParameter("pcId", pcId);
		return query.getResultList();

	}

	/**
	 * @param pcId
	 * @param userId
	 * @param reportType
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedBy(Integer pcId, Integer userId, byte reportType, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.pcId = :pcId and x.reportType = :reportType");
		query.setParameter("pcId", pcId);
		query.setParameter("reportType", reportType);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param pcId
	 * @param userId
	 * @param reportType
	 * @param matrixType
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedByAndMatrixType(Integer pcId, Integer userId, byte reportType, byte matrixType, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.pcId = :pcId and x.reportType = :reportType and x.matrixType = :matrixType");

		query.setParameter("pcId", pcId);
		query.setParameter("reportType", reportType);
		query.setParameter("matrixType", matrixType);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param pcId
	 * @param userId
	 * @param reportType
	 * @param matrixType
	 * @param reportIndex
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedByAndMatrixTypeAndReportIndex(Integer pcId, Integer userId, byte reportType, byte matrixType, byte reportIndex, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.pcId = :pcId and x.reportType = :reportType and x.matrixType = :matrixType and x.reportIndex = :reportIndex");

		query.setParameter("pcId", pcId);
		query.setParameter("reportType", reportType);
		query.setParameter("matrixType", matrixType);
		query.setParameter("reportIndex", reportIndex);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findAll(Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x");
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param pcId
	 * @param userId
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findInvestmentValuationByPCIdAndUserId(Integer pcId, Integer userId, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x where x.pcId = :pcId order by x.instrumentType, x.financialYearCode");

		query.setParameter("pcId", pcId);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;

	}

	/**
	 * @param pcId
	 * @param userId
	 * @param financialYear
	 * @param klass
	 * @return
	 * @throws MSException
	 */
	public List<E> findByPCIdAndCreadedByAndFinancialYear(Integer pcId, Integer userId, String financialYear, Class<E> klass) throws MSException {
		String fullClassName = klass.getName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		EntityManager em = getEntityManager();
		Query query = em.createQuery("Select x from " + simpleClassName + " x    where x.pcId = :pcId");
		query.setParameter("pcId", pcId);
		query.setParameter("financialYear", financialYear);
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<E> list = query.getResultList();
		return list;
	}

	/**
	 * @param id
	 * @param klass
	 * @return
	 */
	public E findById(String id, Class<E> klass) {
		return getEntityManager().find(klass, id);
	}

	/**
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name) {
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	/**
	 * @param name
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params) {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	public Object findNumberByNamedQuery(String name, Map<String, Object> params) {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return (Long) query.getSingleResult();
	}

	/**
	 * @param name
	 * @param params
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param param
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value) {
		Query query = null;
		try {
			query = getEntityManager().createNamedQuery(name);
			query.setParameter(param, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	/**
	 * @param name
	 * @param param
	 * @param value
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	/**
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name) {
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	/**
	 * @param name
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params) {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param params
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	/**
	 * @param name
	 * @param param
	 * @param value
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value) {
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);
		return query.getResultList();
	}

	/**
	 * @param name
	 * @param param
	 * @param value
	 * @param first
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value, int first, int pageSize) {
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	/**
	 * @param qry
	 * @return
	 */
	public List<? extends Object> findByNativeQuery(String qry) {
		return findByNativeQuery(qry, null);
	}

	/**
	 * @param qry
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Object> findByNativeQuery(String qry, List<Object> params) {
		Query query = getEntityManager().createNativeQuery(qry);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i + 1, params.get(i));
			}
		}
		return query.getResultList();
	}

	/**
	 * 
	 */
	public void flush() {
		getEntityManager().flush();
	}

	/**
	 * @param entity
	 * @return
	 */
	public E merge(E entity) {
		return getEntityManager().merge(entity);
	}

	/**
	 * @param entity
	 */
	public void persist(E entity) {
		getEntityManager().persist(entity);
	}

	/**
	 * @param entityList
	 */
	public void persist(List<E> entityList) {
		for (E e : entityList) {
			persist(e);
		}
	}

	/**
	 * @param entities
	 * @return
	 */
	public Collection<E> bulkSave(Collection<E> entities) {
		final List<E> savedEntities = new ArrayList<E>(entities.size());
		int i = 0;
		for (E e : entities) {
			persistOrMerge(e);
			i++;
			if (i % 30 == 0) {
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		return savedEntities;
	}

	/**
	 * @param e
	 * @return
	 */
	public <Entity> E persistOrMerge(E e) {
		if (e.getId() == null) {
			persist(e);
			return e;
		} else {
			return merge(e);
		}
	}

	/**
	 * @param entity
	 */
	public void refresh(E entity) {
		getEntityManager().refresh(entity);
	}

	/**
	 * @param entity
	 */
	public void remove(E entity) {
		getEntityManager().remove(entity);
	}

	/**
	 * @param name
	 * @return
	 */
	public Object findSingleResult(String name) {
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		return ((Object) jpaQuery.getSingleResult());
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	public Object findSingleResult(String name, Map<String, Object> params) {
		Query query = getEntityManager().createNamedQuery(name);
		for (Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		return (Object) query.getSingleResult();
	}

	/**
	 * @param query
	 * @param params
	 * @return
	 */
	public int executeUpdate(String query, Map<String, Object> params) {
		Query jpaQuery = getEntityManager().createQuery(query);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return jpaQuery.executeUpdate();

	}

	/**
	 * @param query
	 * @return
	 */
	public int executeUpdate(String query) {
		return executeUpdate(query, null);
	}

	/**
	 * @param name
	 * @return
	 */
	public int executeUpdateByNamedQuery(String name) {
		Query query = getEntityManager().createNamedQuery(name);
		return query.executeUpdate();
	}

	/**
	 * @param name
	 * @param params
	 * @return
	 */
	public int executeUpdateByNamedQuery(String name, Map<String, Object> params) {
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
			return jpaQuery.executeUpdate();
		}
		return executeUpdateByNamedQuery(name);
	}

	/**
	 * @param countQuery
	 * @param params
	 * @return
	 */
	public Long findTotalPagesByFilters(StringBuilder countQuery, Map<String, Object> params) {
		Query jpaCountQuery = getEntityManager().createQuery(countQuery.toString());
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet()) {
				jpaCountQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return (Long) jpaCountQuery.getSingleResult();
	}

}