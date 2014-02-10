package com.soryin.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.soryin.common.SoryinJsonUtil;
import com.soryin.entity.UserAccessRecord;
import com.soryin.entity.UserInfo;
import com.soryin.enumeration.SoryinEnum.State;
import com.soryin.service.UserInfoService;
import com.soryin.vo.UserRecordVO;
import com.soryin.vo.UserRequestParameter;

/**
 * @author kiang
 * 
 */
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -995819150135595663L;
	private UserInfoService userInfoService;
	private UserRequestParameter userRequestParameter;
	public UserRequestParameter getUserRequestParameter() {
		return userRequestParameter;
	}

	public void setUserRequestParameter(UserRequestParameter userRequestParameter) {
		this.userRequestParameter = userRequestParameter;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	private JSON jsonResult;

	public JSON getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSON jsonResult) {
		this.jsonResult = jsonResult;
	}

	
	
	
	/**
	 * 
	 * 检测用户登录状态
	 * @return
	 */
	public String checkUserLoginState(){
		if(userRequestParameter==null||userRequestParameter.getUid()==null||userRequestParameter.getUid().contains(" ")||userRequestParameter.getUid().length()<1){
			String jsonError=SoryinJsonUtil.convertToFormatStr("传来错误的参数");
			JSON resultData=SoryinJsonUtil.addState(jsonError, State.Error);
			this.setJsonResult(resultData);
			return "checkUserLoginState";
		}
		if(userInfoService.checkContainUser(userRequestParameter.getUid())&&userInfoService.checkUserLoginState(userRequestParameter.getUid()))
		{
			String newStr=SoryinJsonUtil.convertToFormatStr("ture");
			JSON resultData=SoryinJsonUtil.addState(newStr, State.Success);
			this.setJsonResult(resultData);
		}else {
			String newStr=SoryinJsonUtil.convertToFormatStr("false");
			JSON resultData=SoryinJsonUtil.addState(newStr, State.Success);
			this.setJsonResult(resultData);
		}
		return "checkUserLoginState";
	}
	
	public String userLogin()
	{
		String jsonError=null;
		JSON resultData=null;
		if(userRequestParameter==null||userRequestParameter.getUid()==null||userRequestParameter.getUid().contains(" ")||userRequestParameter.getUid().length()<1
				||userRequestParameter.getUserName()==null||userRequestParameter.getUserName().length()<1){
			jsonError=SoryinJsonUtil.convertToFormatStr("传来错误的参数");
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);
			this.setJsonResult(resultData);
			return "userLogin";
		}
		UserInfo userInfo=userInfoService.userLogin(userRequestParameter);
		if(userInfo==null){
			System.out.println("登录失败");
			jsonError=SoryinJsonUtil.convertToFormatStr("登录失败");
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);
		}else {
			System.out.println("user有数据");
			resultData=SoryinJsonUtil.addState(userInfo, State.Success);
		}
        this.setJsonResult(resultData);
		return "userLogin";
	}
	
	
	
	/**
	 * 
	 * 升级（在原本的等级上添加一级）
	 * @return
	 */
	public String addLevel()
	{
		String jsonError=null;
		JSON resultData=null;
		if(userRequestParameter==null||userRequestParameter.getUid()==null||userRequestParameter.getUid().contains(" ")||userRequestParameter.getUid().length()<1){
			jsonError=SoryinJsonUtil.convertToFormatStr("传来错误的参数");
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);
			this.setJsonResult(resultData);
			return "userLogin";
		}
		Long newLevel=userInfoService.addUserLevel(userRequestParameter.getUid());
		if(newLevel==null){
			jsonError="升级失败，数据异常";
			jsonError=SoryinJsonUtil.convertToFormatStr(jsonError);
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);
		}else {
			resultData=SoryinJsonUtil.addState(newLevel, State.Success);
		}
		this.setJsonResult(resultData);
		return "addLevel";
	}
	
	/**
	 * 
	 * 查看用户等级
	 * @return
	 */
	public String getUserLevel()
	{
		String jsonError=null;
		JSON resultData=null;
		if(userRequestParameter==null||userRequestParameter.getUid()==null||userRequestParameter.getUid().contains(" ")||userRequestParameter.getUid().length()<1){
			jsonError=SoryinJsonUtil.convertToFormatStr("传来错误的参数");
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);
			this.setJsonResult(resultData);
			return "getUserLevel";
		}
		
		Long userLevel=userInfoService.getUserLeve(userRequestParameter.getUid());
		if(userLevel==null){
			jsonError="等级查看失败";
			jsonError=SoryinJsonUtil.convertToFormatStr(jsonError);
			resultData=SoryinJsonUtil.addState(jsonError, State.Error);

		}else {
			resultData=SoryinJsonUtil.addState(userLevel, State.Success);
		}
		this.setJsonResult(resultData);
		return "getUserLevel";
		
	}
	
	public String syncUserDate() {
		String jsonError = null;
		JSON resultData = null;
		if (userRequestParameter == null
				|| userRequestParameter.getUid() == null
				|| userRequestParameter.getUid().contains(" ")
				|| userRequestParameter.getUid().length() < 1) {
			jsonError = SoryinJsonUtil.convertToFormatStr("传来错误的参数");
			resultData = SoryinJsonUtil.addState(jsonError, State.Error);
			this.setJsonResult(resultData);
			return "getUserLevel";
		}
		
		Object result=userInfoService.syncUserDate(userRequestParameter);
		if(result.getClass().equals(String.class)){
			String resultStr=SoryinJsonUtil.convertToFormatStr(result.toString());
			resultData=SoryinJsonUtil.addState(resultStr, State.Success);
		}else {
			resultData=SoryinJsonUtil.addState(result, State.Success);
		}
		this.setJsonResult(resultData);
		
		return "syncUserDate";
	}
	

}
