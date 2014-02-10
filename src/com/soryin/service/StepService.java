package com.soryin.service;

import com.soryin.entity.Steps;

public interface StepService {
	public Steps findStepById(Long id);
	
	public boolean updateStep(Steps step);
}
