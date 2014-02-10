package com.soryin.service;

import com.soryin.entity.Entity;

public interface EntityService {
	public Entity findEntityById(Long id);
	
	public boolean updateEntity(Entity entity);
	
	public boolean saveEntity(Entity entity);
}
