package com.soryin.dao.implement;

import java.util.List;

import org.hibernate.SQLQuery;

import com.soryin.dao.UserRecordDAO;
import com.soryin.entity.UserAccessRecord;

public class UserRecordDAOImplement extends BaseDAOImpl<UserAccessRecord> implements UserRecordDAO{

	@Override
	public List<UserAccessRecord> getRecordListByAccount(String account) {
		String hql="";
		hql="from  UserAccessRecord as u  where u.userInfo.account=?";
		List<UserAccessRecord> accessRecords= this.findByHQL(hql, account);
		return accessRecords;
	}
	
	public void deleteRecord(Long id)
	{
		this.getSession().beginTransaction();
		SQLQuery query=this.getSession().createSQLQuery("delete from UserAccessRecord where id=?");
		query.setParameter(0, id);
		query.executeUpdate();
		this.getSession().getTransaction().commit();

	}
}
