package com.soryin.service.Implement;

import com.soryin.dao.ConstrainDao;
import com.soryin.entity.Constrain;
import com.soryin.service.ConstrainService;

public class ConstrainServiceImpl implements ConstrainService {

	private ConstrainDao constrainDao;

	public ConstrainDao getConstrainDao() {
		return constrainDao;
	}

	public void setConstrainDao(ConstrainDao constrainDao) {
		this.constrainDao = constrainDao;
	}

	public Constrain findConstrainById(Long id) {

		return constrainDao.findById(id);
	}

	public boolean saveConstrain(Constrain constrain) {
		try {
			constrainDao.save(constrain);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateConstrain(Constrain constrain) {
		try {
			constrainDao.update(constrain);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
