package com.soryin.service.Implement;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soryin.dao.UserRecordDAO;
import com.soryin.dao.implement.UserRecordDAOImplement;
import com.soryin.entity.UserAccessRecord;
import com.soryin.service.ConditionService;
import com.soryin.service.ConstrainService;
import com.soryin.service.CountService;
import com.soryin.service.DashboardService;
import com.soryin.service.EntityService;
import com.soryin.service.EventService;
import com.soryin.service.LocationService;
import com.soryin.service.StepService;
import com.soryin.service.UserInfoService;
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
				userRecordDAO.deleteRecord(recordList.get(i).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	public UserRecordServerImplement(){
//		this.setUserRecordDAO(new UserRecordDAOImplement());
//	}
	
//	public static void main(String[] args) {
//		
//		UserRecordServerImplement service=new UserRecordServerImplement();
//		service.initSpring();
//		service.deleteAllRecordByAccount("****:*******");
//	}
//	
//	
//	public void initSpring(){
//		String paths[] = {"beans.xml"};
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
//		this.userRecordDAO=(UserRecordDAO)ctx.getBean("userRecordDAO");
//	}
	
	
}
