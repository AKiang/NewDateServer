package com.soryin.dao;

import com.soryin.entity.UserInfo;

/**
 * @author kiang<br>
 * 2013-09-08
 */
public interface UserInfoDao extends BaseDAO<UserInfo>{
	public UserInfo findUserByNameAndPassword(String name,String password);
	public UserInfo findUserByAccount(String account);
}
