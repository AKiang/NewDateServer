package com.soryin.dao.implement;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soryin.dao.BaseDAO;

@SuppressWarnings("unchecked")
public class BaseDAOImpl<T> implements BaseDAO<T> {

	private Class<T> clazz;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BaseDAOImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("DAO" + this.clazz.getName());
	}

	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		this.getSession().beginTransaction();
		this.getSession().save(entity);
		this.getSession().getTransaction().commit();
	}

	public void update(T entity) {
		this.getSession().beginTransaction();
		this.getSession().update(entity);
		this.getSession().getTransaction().commit();
	}

	public void delete(Serializable id) {
		this.getSession().beginTransaction();
		this.getSession().delete(this.findById(id));
		this.getSession().getTransaction().commit();
	}

	public T findById(Serializable id) {
		this.getSession().beginTransaction();
		Object t = this.getSession().get(this.clazz, id);
		this.getSession().getTransaction().commit();
		return (T) t;

	}

	public List<T> findByHQL(String hql, Object... params) {
		this.getSession().beginTransaction();
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> list = query.list();
		this.getSession().getTransaction().commit();
		return list;
	}

	public List<T> findListForPage(String condition, int offset, int length) {
		String hql="from "+clazz.getSimpleName() ;
		if(condition!=null&&condition.trim().length()>0){
			hql=hql+"where "+condition;
		}
		System.out.println(hql);
		this.getSession().beginTransaction();
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<T> list = query.list();
		this.getSession().getTransaction().commit();
		return list;
	}
	
	public List<T> findListForPage_customHql(String hql, int offset, int length) {
		this.getSession().beginTransaction();
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<T> list = query.list();
		this.getSession().getTransaction().commit();
		return list;
	}
}
