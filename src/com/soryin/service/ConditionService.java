package com.soryin.service;

import com.soryin.entity.Condition;

public interface ConditionService {
	public boolean addCondition(Condition condition);
	
	public Condition findConditionById(Long id);
	
	public boolean updateCondition(Condition condition);
}
