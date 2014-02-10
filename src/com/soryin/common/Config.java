package com.soryin.common;

/**
 *	配置参数 
 * @author soryin
 */
public class Config {
	/**
	 * 分页-每页显示数据的数量 20
	 */
	public static final Integer pageSize = 20;
	/**
	 * 分页-翻页序号的数量 10
	 */
	public static final Integer PagesDisplayed = 10;

	/**
	 * View-小活动列表URL
	 */
	public final static String activityListPage = "ActivityController/list.html";
	
	/**
	 * View-活动列表URL
	 */
	public final static String eventListPage = "EventController/list.html";

	/**
	 * 新浪微博client_id
	 */
	public static final String client_id = "1514430043"; 										// 新浪微博AppKey
	/**
	 * 新浪微博授权成功回调地址
	 */
	public static final String redirect_uri = "http://127.0.0.1:8080/SoryinDashboardSSH/callback"; 				// 回调地址
	/**
	 * 新浪微博登陆URL
	 */
	public static final String url = "https://api.weibo.com/oauth2/authorize?client_id="
			+ client_id + "&redirect_uri=" + redirect_uri;

	/**
	 * 404页面输出信息
	 */
	public static final String MSG_404="找不到该页面！";												//404页面输出信息
	
	/**
	 * 	用户登录异常	
	 */
	public static final String MSG_LoginException="登录异常，请重新登录！";				
	
	/**
	 * 服务器异常
	 */
	public  static final String MSG_ServerException="服务器异常,操作失败！";
	
	/**
	 * 超级管理员组名称
	 */
	public static  final String Administrator="超级管理员";
	
}
