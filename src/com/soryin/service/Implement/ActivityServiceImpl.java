package com.soryin.service.Implement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.soryin.dao.ActvityDao;
import com.soryin.entity.Activity;
import com.soryin.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
	private ActvityDao activityDao;

	public ActvityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActvityDao activityDao) {
		this.activityDao = activityDao;
	}

	// 方法开始

	public Activity show(Long activityID, String language) {
		if (activityID == null || activityID < 1) {

		}
		Activity activity;
		try {
			activity = activityDao.findById(activityID);
			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 删除activity信息，级联删除，返回json，一般用于ajax调用
	 * 
	 * @param activityID
	 *            你懂的
	 */
	public boolean delete(Long activityID) {
		if (activityID == null || activityID < 1) {
			return false;
		}
		try {
			activityDao.delete(activityID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 搜索入口
	 * 
	 * @param type
	 *            搜索类型
	 * @param keyword
	 *            关键字
	 * @throws ParseException
	 *             时间格式解析异常
	 */
	public List<Activity> search(String type, String keyword)
			throws ParseException {
		if ("title".equals(type)) {
			getActivityInfoByLikeTitle(keyword, type);
		} else if ("content".equals(type)) {
			getActivityInfoByLikeContent(keyword, type);
		} else if ("time".equals(type)) {
			SimpleDateFormat df = null;
			if (keyword.length() == "yyyy-MM-dd HH:mm".length()) {
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			} else if (keyword.trim().length() == "yyyy-MM-dd ".trim().length()) {
				df = new SimpleDateFormat("yyyy-MM-dd");
			} else if (keyword.trim().length() == "yyyy-MM ".trim().length()) {
				df = new SimpleDateFormat("yyyy-MM");
			} else if (keyword.trim().length() == "yyyy".trim().length()) {
				df = new SimpleDateFormat("yyyy");
			} else {
				return null;
			}
			Date timeStart = null;
			try {
				timeStart = df.parse(keyword);
			} catch (ParseException e) {
				System.out.println("请输入正确的时间格式");
			}
			getActivityInfoByLikeTimeStart(timeStart, type);
		} else {
			getActivityInfoByLikeTitle(keyword, type);
		}
		return null;

	}

	/**
	 * 根据标题(activityName)获取Activity信息
	 * 
	 * @param name
	 *            小活动信息名
	 * @param type
	 *            搜索类型
	 */
	public List<Activity> getActivityInfoByLikeTitle(String name, String type) {
		if (name == null || "".equals(name)) {
			return null;
		}
		String keyword = name;
		return null;
	}

	/**
	 * 根据内容（activityDescription）获取Activity信息
	 * 
	 * @param description
	 *            小活动描述
	 */
	public List<Activity> getActivityInfoByLikeContent(String description, String type) {
		if (description == null || "".equals(description)) {
			return null;
		}
		try {
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String keyword = description;
		return null;
	}

	/**
	 * 根据时间（activityTime）获取Activity信息
	 * 
	 * @param time
	 *            小活动开始的时间
	 */
	public List<Activity> getActivityInfoByLikeTimeStart(Date time, String type) {
		try {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * 小活动列表
	 */
	public List<Activity> list() {
		return null;
	}
}
