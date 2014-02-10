package com.soryin.dao.implement;

import java.util.ArrayList;
import java.util.List;

import com.soryin.common.SoryinDashboardException;
import com.soryin.dao.ActvityDao;
import com.soryin.entity.Activity;

public class ActivityDaoImpl extends BaseDAOImpl<Activity> implements ActvityDao{

	public Activity lastActivity(Long uid) throws SoryinDashboardException {
		List<Activity> activitys = new ArrayList<Activity>();
		try {
			activitys =this.findByHQL(
					"event.userInfo.id=? order by event.releaseTime desc,id", uid);
		} catch (Exception e) {
		 throw	new SoryinDashboardException(e);
		}
		if (activitys.size() == 1) {
			return activitys.get(0);
		} else {
			return null;
		}
	}
	
}
