package com.soryin.service.Implement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

import com.soryin.common.Arithmetic;
import com.soryin.common.SoryinDashboardException;
import com.soryin.dao.EventDao;
import com.soryin.entity.Activity;
import com.soryin.entity.Condition;
import com.soryin.entity.Constrain;
import com.soryin.entity.CountInfo;
import com.soryin.entity.Entity;
import com.soryin.entity.Event;
import com.soryin.service.DashboardService;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

/**
 * eventService接口的实现类<br>
 * 2013-03-05<br>
 * 
 * @author soryin
 * */
public class DashboardServiceImpl implements DashboardService{

	private EventDao eventDao;
	
	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public String getEventAutoID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public CountInfo statisticalInfo(Event event) throws SoryinDashboardException {

		
		CountInfo result = new CountInfo();
		// ~~~~~~~~~~~~~~~~~~~~统计activity数量开始~~2013-04-02~~~~~~~~~~~~~~~~~
		if(event==null){
			throw new SoryinDashboardException("统计event数据的时候出现了一个错误:错误的数据传入:event为空");
		}
		if(event.getActivityList()==null){
			throw new SoryinDashboardException("统计event数据的时候出现了一个错误:错误的数据传入:activityList为空");
		}
		result.setCreateTime(new Date());//创建时间
		result.setUpdateTime(new Date());//升级时间
		result.setPromulgator(event.getUserInfo().getName());//发布者
		result.setActivityCount(event.getActivityList().size());//activity的数量
		// ~~~~~~~~~~~~~~~~~~~~~activity统计结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// ~~~~~~~~~~~~~~~~~~~~~event开始时间和结束时间统计~~~~2013-04-11~~~~~~~~~~~~~~~~~
		List<Activity> activities = new ArrayList<Activity>();
		for (Activity activityTemp : event.getActivityList()) {
			activities.add(activityTemp);
		}
		Date[] times = loadEventTimeStartAndTimeEndCount(activities);
		if (times != null && times.length == 2) {
			result.setTimeStart(times[0]);
			result.setTimeEnd(times[1]);
		} else {
			throw new SoryinDashboardException(
					"统计Event信息的时候出现了一个异常-times传来的时间不完整，times传来的大小为:"
							+ times.length);
		}
		// ~~~~~~~~~~~~~~~~~~~~~event开始时间和结束时间统计结束~~~~~~~~~~~~~~~~~~~~~

		// ~~~~~~~~~~~~~~~~~~~~统计activity数量结束~~~~~~~~~~~~~~~~~~~~~~~~
		Set<Activity> activitySet = event.getActivityList();// 从event拿出所有Activity
		Vector<String> vet = new Vector<String>();// 向量数组，用来存储所有Activity的Condition（条件）描述
		Vector<String> vet_constrain = new Vector<String>();// 向量数组，用来存储所有Activity的Constrain（限制）描述
		for (Activity activity : activitySet) {
			for (Condition cdt : activity.getConditionSet()) {
				String str = cdt.getName();
				vet.add(str);
			}
			for (Constrain cst : activity.getConstrainList()) {
				String str = cst.getName();
				vet_constrain.add(str);
			}

		}

		// ###---------------- --------------------总条件数统计开始--------------2013-03-05-------------------###
		for (int i = 0; i < vet.size(); i++) {// 遍历数组
			String strtemp = vet.get(i);
			for (int j = i + 1; j < vet.size(); j++) {// 这里size初始值为一，用意是让vet的第一个元素从第二个元素开始对比
				if (strtemp.equals(vet.get(j))) {// 如果相同从数组中移除，可以在条件中添加新的匹配算法
					vet.removeElementAt(j);// 移除重复的元素
					j--;
				}
			}
		}

		// ###------------------------------------总条件数统计结束---------------------------------###

		// ###------------------------------------总限制数统计开始--------------2013-03-05-------------------###
		for (int i = 0; i < vet_constrain.size(); i++) {// 遍历数组
			String strtemp = vet_constrain.get(i);
			for (int j = i + 1; j < vet_constrain.size(); j++) {// 这里size初始值为1，用意是让vet的第一个元素从第二个元素开始对比
				if (strtemp.equals(vet_constrain.get(j))) {// 如果相同从数组中移除，可以在条件中添加新的匹配算法
					vet_constrain.removeElementAt(j);// 移除重复的元素
					j--;
				}
			}
		}
		// ###------------------------------------总限制数统计结束---------------------------------###

		// ########-------------------------------------总步骤统计开始--------------2013-03-05---------------------########
		boolean flag = false;
		if (activitySet.size() == 1) {// ~~~~~~~~~~~如果event只有一个activity的话，那么就显示步奏，否则就不显示为0~~~~~~~~~~~~~~~~
			flag = true;
		}
		if (flag) {
			result.setStepsCount(activitySet.size());
		} else {
			result.setStepsCount(0);
		}

		// ###-------------------------------------总步骤统计结束-----------------------------------###

		// ########################################
		// 统计组织/个人开始#########################################

		result.setConditionCount(vet.size());
		result.setConstrinCount(vet_constrain.size());
		// ###组织/个人统计开始###
		int personalCount = 0;// 个人计数
		String personalName = null;// 个人名称
		int organizationCount = 0;// 组织计数
		String organizationName = null;// 组织名称
		Vector<Entity> vet_entity = new Vector<Entity>();
		for (Activity activity : activitySet) {// 遍历不解释
			for (Entity entity : activity.getEntityList()) {
				vet_entity.add(entity);
			}
		}

		for (int i = 0; i < vet_entity.size(); i++) {// 遍历数组
			Entity temp = vet_entity.get(i);
			if (temp.getName() != null && !temp.getName().equals("")
					&& temp.getPersonal()!= 0) {
				for (int j = i + 1; j < vet_entity.size(); j++) {// 这里size初始值为一，用意是让vet的第一个元素从第二个元素开始对比
					if (temp.getName().equals(vet_entity.get(j).getName())
							&& temp.getPersonal() == (vet_entity.get(j).getPersonal())) {// 如果相同从数组中移除，可以在条件中添加新的匹配算法
						vet_entity.removeElementAt(j);// 移除重复的元素
						j--;
					}
				}
			} else {
				vet_entity.remove(i);
				i--;
			}

		}
		// **筛选**
		for (Entity entity : vet_entity) {
			if (entity.getPersonal() == 1) {// 个人

				personalCount++;
				personalName = entity.getName();
			} else if (entity.getPersonal() == 2) {// 组织
				organizationCount++;
				organizationName = entity.getName();
			}
		}
		//
		String flg_p = "null";
		if (personalCount == 1) {
			flg_p = personalName;
		} else if (personalCount > 1) {
			flg_p = "" + personalCount;
		}
		String flg_o = "null";
		if (organizationCount == 1) {
			flg_o = organizationName;
		} else if (organizationCount > 1) {
			flg_o = "" + organizationCount;
		}
		result.setPersonalCount(flg_p);
		result.setOrganization(flg_o);
		result.setEvent(event);
		// ########################################
		// 统计组织/个人结束#########################################
		
		//翻译event  2013-09-06
		return result;
	}

	/**
	 * 2013-03-06
	 * */
	public int getDays(String inputDate, String eventID)
			throws SoryinDashboardException {
		Event event = null;
		event = eventDao.findById(eventID);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-hh:mm");// 格式化时间
		long now = 0;// 请求传入的时间
		java.util.Date d = null;
		try {
			d = sdf.parse(inputDate);
			calendar.setTime(d);
			now = calendar.getTimeInMillis();
		} catch (ParseException e) {
			throw new SoryinDashboardException("获取天数解析传入时间的时候出现了一个异常： ", e);
		}
		Vector<Long> vet = new Vector<Long>();
		for (Activity activity : event.getActivityList()) {
			calendar.setTime(activity.getTimeStart());
			long eventTime = calendar.getTimeInMillis();
			long result;
			if ((eventTime - now) > 1) {// 计算传来的时间和活动开始时间差
				result = (eventTime - now) / (1000);
				vet.add(result);// 存入有效时间
			}

		}
		if (vet.size() > 0) {// 如果数组中存在有效时间的话，就进行排序
			Long arg[] = new Long[vet.size()];
			for (int i = 0; i < vet.size(); i++) {
				arg[i] = vet.get(i);
			}
			long ss = Arithmetic.bubbleSort(arg);// 冒泡排序
			long result = ss % (60 * 60 * 24);
			if (result != 0) {// 除非正好整除
				result = ss / (60 * 60 * 24) + 1;// 否则加一天
			}
			return (int) result;// 返回距离的天数
		}
		// /////所有有效时间存到了vet里面
		// ///利用冒泡排序的方法对有效时间进行排序
		// 求出最近的时间 然后return
		return -1;// 否则 返回-1（代表传入的时间已经错过了活动开始时间）
	}

	public AccessToken getSinaAccessToken(String code) throws WeiboException {
		Oauth oauth = new Oauth();
		AccessToken accessToken = oauth.getAccessTokenByCode(code);
		return accessToken;
	}

	public String getDefaultImg(String[] imgArray) {
		if (imgArray == null) {
			return null;
		}
		for (String img : imgArray) {
			if (img.contains("(_default)")) {
				img = img.substring(10);// 截掉标记(_default)
				return img;
			}
		}
		return null;
	}

	public Date[] loadEventTimeStartAndTimeEndCount(List<Activity> activities) throws SoryinDashboardException {
		Long[] startTimes = new Long[activities.size()];
		Long[] endTimes = new Long[activities.size()];
		for (int i = 0; i < activities.size(); i++) {
			Activity activity = activities.get(i);
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(activity.getTimeStart());
			} catch (NullPointerException e) {
				throw new SoryinDashboardException("在获取even的开始时间和结束时间的时候出现了一个错误：timeStart为null");
			}
			Long satrtTime = calendar.getTimeInMillis();
			try {
				calendar.setTime(activity.getTimeEnd());
			} catch (NullPointerException e) {
				throw new SoryinDashboardException("在获取even的开始时间和结束时间的时候出现了一个错误：timeEnd为:null");
			}
			Long endTime = calendar.getTimeInMillis();
			startTimes[i] = satrtTime;
			endTimes[i] = endTime;
		}
		Date timeStart = new Date(Arithmetic.bubbleSort(startTimes));//对提取出来的开始时间进行排序
		Date timeEnd = new Date(Arithmetic.max_BubbleSort(endTimes));//对提取出来的结束时间进行排序
		Date[] dates = new Date[2];
		dates[0] = timeStart;//输送返回值
		dates[1] = timeEnd;
		return dates;
	}
}
