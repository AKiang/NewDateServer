package com.soryin.service;

import com.soryin.entity.Constrain;

public interface ConstrainService {
	public Constrain findConstrainById(Long id);
	
	public boolean saveConstrain(Constrain constrain);
	
	public boolean updateConstrain(Constrain constrain);
}
