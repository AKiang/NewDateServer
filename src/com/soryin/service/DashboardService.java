package com.soryin.service;

import java.util.Date;
import java.util.List;

import com.soryin.common.SoryinDashboardException;
import com.soryin.entity.Activity;
import com.soryin.entity.CountInfo;
import com.soryin.entity.Event;

import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
/**
 * 2013-03-04<br>
 * 业务层接口<br>
 * @author soryin
 * */
public interface DashboardService{
	/**
	 * 根据当前时间获取一个EventID值
	 * 
	 * */
	public String getEventAutoID();
	/**
	 * 统计信息（event所有条件、限制等）
	 * @throws SoryinDashboardException 
	 * */
	public CountInfo statisticalInfo(Event event) throws SoryinDashboardException;
	
	/**
	 * 
	 * 根据传入的时间和eventID获取event中距离即将到来的小活动的天数
	 * @param inputDate
	 * @param eventID
	 * @return 天数
	 * @throws SoryinDashboardException 
	 */
	public int getDays(String inputDate, String eventID) throws SoryinDashboardException;
	
	/**
	 * 获取新浪授权
	 * @param code	CODE
	 * @return	新浪微博TOKEN
	 * @throws WeiboException
	 */
	public AccessToken getSinaAccessToken(String code)  throws WeiboException;
	
	/**
	 *获取默认图片
	 * @param imgArray	图片数组
	 * @return	截取掉默认图片的标记，返回一个默认图片
	 */
	public String getDefaultImg(String[] imgArray);
	
	/**
	 * 统计整个event的开始时间和结束时间
	 * @param activities event中的所有activity
	 * @return	整个event的开始时间和结束时间,Data[] 0为开始时间，1为结束时间
	 * @throws SoryinDashboardException 
	 */
	public Date[] loadEventTimeStartAndTimeEndCount(List<Activity> activities) throws SoryinDashboardException; 

	

}