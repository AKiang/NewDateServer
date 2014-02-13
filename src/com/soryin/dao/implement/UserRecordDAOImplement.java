package com.soryin.dao.implement;

import java.util.List;

import com.soryin.dao.UserRecordDAO;
import com.soryin.entity.UserAccessRecord;

public class UserRecordDAOImplement extends BaseDAOImpl<UserAccessRecord> implements UserRecordDAO{

	@Override
	public List<UserAccessRecord> getRecordListByAccount(String account) {
		String hql="";
		hql="from  UserAccessRecord as u  where u.userInfo.account=?";
		List<UserAccessRecord> accessRecords= this.findByHQL(hql, account);
		return accessRecords;
	}
	
}
