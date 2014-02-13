package com.soryin.service.Implement;

import java.util.List;

import org.hibernate.SQLQuery;

import com.soryin.dao.UserRecordDAO;
import com.soryin.entity.UserAccessRecord;
import com.soryin.service.UserRecordService;

public class UserRecordServerImplement implements UserRecordService{
	private UserRecordDAO userRecordDAO;
	public UserRecordDAO getUserRecordDAO() {
		return userRecordDAO;
	}
	public void setUserRecordDAO(UserRecordDAO userRecordDAO) {
		this.userRecordDAO = userRecordDAO;
	}
	
	@Override
	public boolean deleteAllRecordByAccount(String account) {
		List<UserAccessRecord> recordList=null;
		try {
			recordList=userRecordDAO.getRecordListByAccount(account); 
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		try {
			for (int i = 0; i < recordList.size(); i++) {
				userRecordDAO.deleteRecord(recordList.get(0).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	
	
}
