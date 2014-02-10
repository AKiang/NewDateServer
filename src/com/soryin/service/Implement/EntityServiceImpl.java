package com.soryin.service.Implement;

import com.soryin.dao.EntityDao;
import com.soryin.entity.Entity;
import com.soryin.service.EntityService;

public class EntityServiceImpl implements EntityService {

	private EntityDao entityDao;
	
	public EntityDao getEntityDao() {
		return entityDao;
	}

	public void setEntityDao(EntityDao entityDao) {
		this.entityDao = entityDao;
	}

	public Entity findEntityById(Long id) {
		return entityDao.findById(id);
	}

	public boolean updateEntity(Entity entity) {
		try {
			entityDao.update(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean saveEntity(Entity entity) {
		try {
			entityDao.save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

}
