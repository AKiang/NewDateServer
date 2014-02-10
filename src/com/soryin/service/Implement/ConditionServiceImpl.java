package com.soryin.service.Implement;

import com.soryin.dao.ConditionDao;
import com.soryin.entity.Condition;
import com.soryin.service.ConditionService;

public class ConditionServiceImpl implements ConditionService {

	private ConditionDao conditionDao;

	public ConditionDao getConditionDao() {
		return conditionDao;
	}

	public void setConditionDao(ConditionDao conditionDao) {
		this.conditionDao = conditionDao;
	}

	public boolean addCondition(Condition condition) {
		if (condition == null || condition.getConditionID() != null) {
			return false;
		}
		try {
			conditionDao.save(condition);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Condition findConditionById(Long id) {
		
		return conditionDao.findById(id);
	}

	public boolean updateCondition(Condition condition) {
		try {
			conditionDao.update(condition);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
