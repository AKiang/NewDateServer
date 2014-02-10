package com.soryin.dao.implement;

import java.util.List;

import com.soryin.dao.UserInfoDao;
import com.soryin.entity.UserInfo;

public class UserInfoDaoImpl extends BaseDAOImpl<UserInfo> implements UserInfoDao{

	public UserInfo findUserByNameAndPassword(String account, String password) {
		String hql="";
		hql="from UserInfo u where u.account=? and u.password=?";
		List<UserInfo> list=(List<UserInfo>) this.findByHQL(hql,account,password);
		if(list.size()!=1){
			return null;
		}
		return list.get(0);
	}

	public UserInfo findUserByAccount(String account) {
		String hql="";
		hql="from UserInfo u where u.account=?";
		List<UserInfo> list=(List<UserInfo>) this.findByHQL(hql,account);
		if(list.size()!=1){
			return null;
		}
		return list.get(0);
	}

}
