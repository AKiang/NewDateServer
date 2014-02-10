package com.soryin.dao;

import com.soryin.common.SoryinDashboardException;
import com.soryin.entity.Activity;

public interface ActvityDao extends BaseDAO<Activity>{
	/**
	 * 取出用户最后添加的一个Activity
	 * 
	 * @return
	 * @throws SoryinDashboardException
	 */
	 public Activity lastActivity(Long uid) throws SoryinDashboardException;
	 
}
