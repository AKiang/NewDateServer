package com.soryin.common;


import com.alibaba.fastjson.JSON;
import com.soryin.entity.UserInfo;
import com.soryin.enumeration.SoryinEnum.State;


public class SoryinJsonUtil {
	public static JSON addState(Object obj,State state) {
		
		StringBuffer  result=new StringBuffer("{\"status\":\"");
		if(state==State.Success){
			result.append("true");
		}else {
			result.append("false");
		}
		result.append("\",\"data\":");
		String str=JSON.toJSONString(obj);
		result.append(str);
		result.append("}");
		JSON jsonResult=JSON.parseObject(result.toString());
		return jsonResult;
	}
	
	public static JSON addState(String json,State state) {
		
		StringBuffer  result=new StringBuffer("{\"status\":\"");
		if(state==State.Success){
			result.append("true");
		}else {
			result.append("false");
		}
		result.append("\",\"data\":");
		result.append(json);
		result.append("}");
		JSON jsonResult=JSON.parseObject(result.toString());
		return jsonResult;
	}
	
	public static String convertToFormatStr(String str)
	{
		StringBuffer strbuffer=new StringBuffer("\"");
		strbuffer.append(str);
		strbuffer.append("\"");
		return strbuffer.toString();
	}
}
