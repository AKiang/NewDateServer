package com.soryin.dao.implement;

import com.soryin.dao.UserRecordDAO;
import com.soryin.entity.UserAccessRecord;

public class UserRecordDAOImplement extends BaseDAOImpl<UserAccessRecord> implements UserRecordDAO{

	@Override
	public boolean delelteAllRecordByAccount(String account) {
		String hql="";
		hql="delete UserAccessRecord as uar where uar.userInfo.account=?";
		return (this.updateByHQL(hql, account));
	}
	
}
