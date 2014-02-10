package com.soryin.service.Implement;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.opensymphony.xwork2.ActionContext;
import com.soryin.common.VerifyUtil;
import com.soryin.dao.UserInfoDao;
import com.soryin.entity.UserAccessRecord;
import com.soryin.entity.UserInfo;
import com.soryin.enumeration.SoryinEnum.UserLoginType;
import com.soryin.service.UserInfoService;
import com.soryin.vo.UserActionRquestType;
import com.soryin.vo.UserRecordVO;
import com.soryin.vo.UserRequestParameter;

public class UserInfoServiceImpl implements UserInfoService {


	private UserInfoDao userInfoDao;

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	public UserInfo userLogin(UserRequestParameter parames) {
		
		if(this.checkContainUser(parames.getUid())){
			Map<String, Object> session = ActionContext.getContext().getSession();
			UserInfo user=this.userInfoDao.findUserByAccount(parames.getUid());
			session.put("UserLoginInfo", user);
			return user;
		}else {
			UserInfo user=new UserInfo();
			user.setAccount(parames.getUid());
			user.setName(parames.getUserName());
			user.setLevel(1);
			user=this.register(user);
			return user;
		}
	}

	@Override
	public UserInfo register(UserInfo user) {
		if(this.getUserLoginType(user.getAccount())==UserLoginType.Unknown){
			return null;
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		try {
			userInfoDao.save(user);
			session.put("UserLoginInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userInfoDao.findUserByAccount(user.getAccount());
	}


	/**
	 * 检测表中是否包含某账户
	 * 
	 * @param account 缩影账号
	 * @return boolean
	 */
	public boolean checkContainUser(String account) {
		UserLoginType loginType=this.getUserLoginType(account);
		if(loginType==UserLoginType.Unknown){
			System.out.println("未知的登录类型");
			return false;
		}else {
		   Object o=userInfoDao.findUserByAccount(account);
		 	if(o==null){
				return false;
			}
			return true;
		}
	}
	



	@Override
	public Object syncUserSettingData(UserRequestParameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object syncUserRecordData(UserRequestParameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private UserLoginType getUserLoginType(String soryinid)
	{
		if(soryinid.contains("sinaWB:")){
			return UserLoginType.SinaWB;
		}else if(soryinid.contains("tencentWB:")){
			return UserLoginType.TencentWB;
		}
		return UserLoginType.Unknown;
	}

	@Override
	public UserInfo findUserInfoById(Long id) {
		return userInfoDao.findById(id);
	}

	@Override
	public Long addUserLevel(String account) {
	if(this.getUserLoginType(account)==UserLoginType.Unknown){
		return null;
	}
		UserInfo user=userInfoDao.findUserByAccount(account);
		if(user==null){
			return null;
		}
		user.setLevel(user.getLevel()+1);
		try {
			userInfoDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user.getLevel();
	}

	@Override
	public boolean checkUserLoginState(String account) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("UserLoginInfo")==null){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Long getUserLeve(String uid) {
		UserInfo user=userInfoDao.findUserByAccount(uid);
		if(user==null){
			return null;
		}else {
			return user.getLevel();
		}
	}

	@Override
	public UserInfo findUserInfoByAccount(String account) {
		try {
			return userInfoDao.findUserByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object syncUserDate(UserRequestParameter parameter) {
		UserInfo user=userInfoDao.findUserByAccount(parameter.getUid());
		if(user.getSyncTime()==null||user.getSyncTime().before(parameter.getSyncTime())&&parameter.getRecords()!=null&&parameter.getRecords().size()>0){
			Set<UserAccessRecord> recordList=new HashSet<UserAccessRecord>();
			for(int i=0;i<parameter.getRecords().size();i++){
				UserRecordVO vo=parameter.getRecords().get(i);
				UserAccessRecord uar=new UserAccessRecord();
				uar.setCreateDate(new Date());
				uar.setUserInfo(user);
				uar.setEventKey(vo.getEventKey());
				uar.setAccessDate(vo.getAccessDate());
				recordList.add(uar);
			}
			user.setUserAccessRecord(recordList);
			userInfoDao.save(user);
			return "complete";
		}else if(parameter.getSyncTime()==null||user.getSyncTime().after(user.getSyncTime())){
			Set<UserAccessRecord> recordList=user.getUserAccessRecord();
			return recordList;
		}
		return "failed";
	}

	

}
