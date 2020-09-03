package com.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @author yangzl 2019-11-06 
 * @version 1.00.00
 * @history:
 */
public abstract class BaseDao {
	
//	private final static Log _logger = LogFactory.getLog(BaseDao.class);
//
//	@Autowired
//	private EntityManager _entityManager;
//
//	@Autowired
//	protected JdbcTemplate _jdbcTemplate;
//
//
//	public void save(Object obj) {
//		_entityManager.persist(obj);
//	}
//
//	public <T> T merge(T entity) {
//		return _entityManager.merge(entity);
//	}
//
//	public <T> T findById(Class<T> clazz, Serializable id){
//		return (T) _entityManager.find(clazz, id);
//	}
//
//	public void update(Object obj) {
//		_entityManager.merge(obj);
//	}
//
//	public void deleteById(Class clazz,Serializable id) {
//		_entityManager.remove(_entityManager.find(clazz, id));
//	}
//
//	public Query createQuery(String sql) {
//		return _entityManager.createQuery(sql);
//	}
//
//	public Query createNativeQuery(String sql) {
//		return _entityManager.createNativeQuery(sql);
//	}
//
//	public List createNativeQuery(String sql, Object[] objs) {
//
//		Query q = createNativeQuery(sql);
//
//		if(objs != null && objs.length > 0) {
//
//			for(int i=0; i<objs.length; i++) {
//
//				q.setParameter(i+1, objs[i]);
//			}
//		}
//
//		return q.getResultList();
//	}
//
//	public JdbcTemplate getJdbcTemplate() {
//		return _jdbcTemplate;
//	}
//
//	public void clearList(List list){
//		list.clear();
//		list = null;
//	}
//
//	public void clearMap(Map map){
//		map.clear();
//		map = null;
//	}
}
