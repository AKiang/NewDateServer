package com.soryin.service.Implement;

import com.soryin.dao.UserRecordDAO;
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
		try {
			return userRecordDAO.delelteAllRecordByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
