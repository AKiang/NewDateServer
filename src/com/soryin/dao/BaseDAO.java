package com.soryin.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DAO基类 <br>
 * 2012-12-16 <br>
 * @author 八二年的矿泉水
 * */
public interface BaseDAO<T> {
	/**
	 * 
	 * @param entity
	 * */
	public void save(T entity);

	/**
	 * 
	 * @param entity
	 * */
	public void update(T entity);

	/**
	 * 
	 * @param id
	 * */
	public void delete(Serializable id);

	public T findById(Serializable id);

	public List<?> findByHQL(String hql, Object... params);

	public boolean updateByHQL(String hql, Object... params);
	
	public List<?> findListForPage(final String condition, final int offset,
		    final int length);
	
	public List<?> findListForPage_customHql(String hql, int offset, int length);
}
