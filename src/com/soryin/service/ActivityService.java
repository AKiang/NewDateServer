package com.soryin.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.soryin.entity.Activity;

public interface ActivityService {
	
	public Activity show(Long activityID,String language);

	/**
	 * 删除activity信息，级联删除，返回json，一般用于ajax调用
	 * 
	 * @param activityID
	 *            你懂的
	 */
	public boolean delete(Long activityID);

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
			throws ParseException;

	/**
	 * 根据标题(activityName)获取Activity信息
	 * 
	 * @param name
	 *            小活动信息名
	 * @param type
	 *            搜索类型
	 */
	public List<Activity> getActivityInfoByLikeTitle(String name, String type);

	/**
	 * 根据内容（activityDescription）获取Activity信息
	 * 
	 * @param description
	 *            小活动描述
	 */
	public List<Activity> getActivityInfoByLikeContent(String description,
			String type);

	/**
	 * 根据时间（activityTime）获取Activity信息
	 * 
	 * @param time
	 *            小活动开始的时间
	 */
	public List<Activity> getActivityInfoByLikeTimeStart(Date time, String type);

	/**
	 * 小活动列表
	 */
	public List<Activity> list();
}
