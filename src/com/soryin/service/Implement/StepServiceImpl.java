package com.soryin.service.Implement;

import com.soryin.dao.StepDao;
import com.soryin.entity.Steps;
import com.soryin.service.StepService;

public class StepServiceImpl implements StepService {

	private StepDao stepDao;
	
	public StepDao getStepDao() {
		return stepDao;
	}

	public void setStepDao(StepDao stepDao) {
		this.stepDao = stepDao;
	}

	public Steps findStepById(Long id) {
		if(id==null||id<1){
			return null;
		}
		return stepDao.findById(id);
	}

	public boolean updateStep(Steps step) {
		if(step==null||step.getStepsID()==null||step.getStepsID()<1){
			return false;
		}
		try {
			stepDao.update(step);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
