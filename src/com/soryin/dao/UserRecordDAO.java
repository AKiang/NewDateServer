package com.soryin.dao;

import com.soryin.entity.UserAccessRecord;

public interface UserRecordDAO extends BaseDAO<UserAccessRecord>{
	public boolean delelteAllRecordByAccount(String account);
}
