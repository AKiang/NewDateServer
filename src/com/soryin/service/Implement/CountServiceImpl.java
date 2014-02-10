package com.soryin.service.Implement;

import com.soryin.common.SoryinDashboardException;
import com.soryin.dao.CountDAO;
import com.soryin.entity.CountInfo;
import com.soryin.entity.Event;
import com.soryin.service.CountService;


/**
 * @author soryin
 *
 */
public class CountServiceImpl implements CountService {

	private CountDAO countDAO;
	
	public CountDAO getCountDAO() {
		return countDAO;
	}
	public void setCountDAO(CountDAO countDAO) {
		this.countDAO = countDAO;
	}
	public boolean saveOrUpdate(CountInfo count)  throws SoryinDashboardException {
		try {
			countDAO.save(count);
			return true;
		} catch (Exception e) {
			throw new SoryinDashboardException("保存或者更新统计数据的时候出现了一个错误：",e);
		}
	}
	public CountInfo loadCountByID(int countID)  throws SoryinDashboardException{
		try {
			return countDAO.findById(countID);
		} catch (Exception e) {
			throw new SoryinDashboardException("根据ID"+countID+"查找统计数据信息的时候出现了一个异常",e);
		}
	}

	public int CountEntity(Event event) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
