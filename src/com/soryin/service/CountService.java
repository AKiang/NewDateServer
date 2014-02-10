package com.soryin.service;

import java.sql.SQLException;

import com.soryin.common.SoryinDashboardException;
import com.soryin.entity.CountInfo;
import com.soryin.entity.Event;



/**
 * 统计数据业务接口
 * @author soryin
 *
 */
public interface CountService {
	/** 
	 * 保存数据Count对象
	 * */
	public boolean saveOrUpdate(CountInfo count)  throws SoryinDashboardException;
	
	/**
	 * 根据CountID编号加载Count信息
	 * @throws SQLException 
	 * @throws SoryinDashboardException 
	 * */
	public CountInfo loadCountByID(int countInfoID) throws SoryinDashboardException;
	/**
	 * 统计组织数量
	 * @param event
	 * @return
	 */
	public 	int CountEntity(Event event);
}