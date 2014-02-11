package com.soryin.dao.implement;

import java.util.List;

import com.soryin.dao.UserRecordDAO;
import com.soryin.entity.UserAccessRecord;

public class UserRecordDAOImplement extends BaseDAOImpl<UserAccessRecord> implements UserRecordDAO{

	@Override
	public boolean delelteAllRecordByAccount(String account) {
		String hql="";
		hql="from  UserAccessRecord as u  where u.userInfo.account=?";
		List<UserAccessRecord> accessRecords= this.findByHQL(hql, account);
		try {
			for (UserAccessRecord userAccessRecord : accessRecords) {
				//this.delete(userAccessRecord.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
