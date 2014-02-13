package com.soryin.dao;

import java.util.List;

import com.soryin.entity.UserAccessRecord;

public interface UserRecordDAO extends BaseDAO<UserAccessRecord>{
	public List<UserAccessRecord> getRecordListByAccount(String account);
	
	public void deleteRecord(Long id);
}
