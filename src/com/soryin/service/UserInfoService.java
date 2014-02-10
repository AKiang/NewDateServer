package com.soryin.service;

import com.soryin.entity.UserInfo;
import com.soryin.vo.UserRequestParameter;

public interface UserInfoService {

	public UserInfo userLogin(UserRequestParameter parames);
	
	public UserInfo register(UserInfo user);
	
	public boolean checkContainUser(String account);
	
	public UserInfo findUserInfoById(Long id);
	
	public Long addUserLevel(String account);
	
	/**
	 * 
	 * 根据用户账户获取用户资料
	 * @param account 缩影账号
	 * @return 用户信息
	 */
	public UserInfo findUserInfoByAccount(String account);
	
	
	/**
	 * 同步用户设置
	 * 
	 * @return object
	 */
	public Object syncUserSettingData(UserRequestParameter parameter);
	
	/**
	 * 同步用户记录
	 * 
	 * @return object
	 */
	public Object syncUserRecordData(UserRequestParameter parameter);
	
	/**
	 * 检测用户登录状态
	 * @param account
	 * @return
	 */
	public boolean checkUserLoginState(String account);
	
	/**
	 * 获取用户等级
	 * 
	 * @param uid 缩影ID
	 * @return
	 */
	public Long getUserLeve(String uid);
	
	/**
	 * 
	 * 同步用户数据
	 * @param parameter 
	 * @return
	 */
	public Object syncUserDate(UserRequestParameter parameter);
}
