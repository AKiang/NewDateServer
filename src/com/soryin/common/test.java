package com.soryin.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soryin.entity.Activity;
import com.soryin.entity.ActivityType;
import com.soryin.entity.Condition;
import com.soryin.entity.Constrain;
import com.soryin.entity.CountInfo;
import com.soryin.entity.Entity;
import com.soryin.entity.Event;
import com.soryin.entity.Fare;
import com.soryin.entity.IDType;
import com.soryin.entity.Location;
import com.soryin.entity.Steps;
import com.soryin.entity.UserInfo;
import com.soryin.service.ConditionService;
import com.soryin.service.ConstrainService;
import com.soryin.service.CountService;
import com.soryin.service.DashboardService;
import com.soryin.service.EntityService;
import com.soryin.service.EventService;
import com.soryin.service.LocationService;
import com.soryin.service.StepService;
import com.soryin.service.UserInfoService;


public class test {
	public Event getEvent() {
		Event event1 = new Event();
		UserInfo userInfo=new UserInfo();
		userInfo=this.userInfoService.findUserInfoById(2L);
		event1.setUserInfo(userInfo);
		System.out.println(event1.getUserInfo().getName());
		event1.setDescription("本年度最后一场古典音乐会，李云迪带您再次领略肖邦王子的无限风采。。 李云迪依然以肖邦为始，以《夜曲》OP.9.1、OP.9.2、OP.48.1和《大波兰舞曲》开场，拉开新年音乐会浪漫的序幕。");
		event1.setName("李云迪跨年音乐会");
		event1.setPicture("(_default)image/event/test.jpg;image/event/test2.jpg");
		event1.setEventID(UUID.randomUUID().toString().replaceAll("-", ""));
		Set<Activity> as = new HashSet<Activity>();

		// //Activity for开始
		for (int temp = 0; temp < 4; temp++) {
			Activity activity = new Activity();
			activity.setDescription("热爱生活，乐于分享的各类达人聚在这里， 分享消费攻略，激发生活灵感，发现城市最IN的角落。 在这里，有爱，有乐，有生活。");
			activity.setName("李云迪小活动"+temp);

			ActivityType at = new ActivityType();
			at.setType("演唱会");
			activity.setActivityType(at);

			Set<Condition> cs = new HashSet<Condition>();
			int j = 0;
			while (j < 2) {
				Condition c = new Condition();
				Random r = new Random();
				c.setName("打领带" + r.nextInt(3));
			List<IDType> its = new ArrayList<IDType>();
				IDType it = new IDType();
				it.setType("临时身份证");
				its.add(it);
				it.setType("居民身份证");
				its.add(it);
				c.setIdTypeList(its);

				Set<Fare> fs = new HashSet<Fare>();
				int y = 0;
				while (y < 2) {
					Fare f = new Fare();
					f.setMethod("信用卡");
					f.setPrice(y + 20.8);
					fs.add(f);
					y++;
				}
				c.setFareList(fs);
				cs.add(c);
				j++;
			}
			activity.setConditionSet(cs);

			Set<Constrain> cts = new HashSet<Constrain>();
			for (int x = 0; x < 2; x++) {
				Constrain ct = new Constrain();
				ct.setDescripetion("仅限公司员工");
				ct.setName("名称");
				cts.add(ct);
			}
			activity.setConstrainList(cts);

			Set<Entity> ets = new HashSet<Entity>();
			for (int x = 0; x < 2; x++) {
				Entity et = new Entity();

				et.setAddress("天河城");
				et.setEmail("xxx@soryin.com");
				et.setTel("15878770646");
				et.setWebsite("http://www.soryin.com");
				et.setDescription("组织/个人描述");
				et.setPersonal(x + 1);
				et.setName("华纳音乐");
				et.setTqq("8888888");
				et.setWechat("9999999");
				et.setWeibo("xxxxxxxx.weib");
				ets.add(et);

			}

			Entity et = new Entity();

			et.setAddress("天河城");
			et.setEmail("xxx@soryin.com");
			et.setTel("15878770646");
			et.setWebsite("http://www.soryin.com");
			et.setDescription("组织/个人描述");
			et.setPersonal(2);
			et.setName("云迪音乐");
			et.setTqq("8888888");
			et.setWechat("9999999");
			et.setWeibo("xxxxxxxx.weib");
			ets.add(et);
			ets.add(et);

			activity.setEntityList(ets);

			Set<Location> lcts = new HashSet<Location>();
			Location lct = new Location();
			lct.setActivity(activity);
			lct.setAddress("华南理工大学广州学院");
			lct.setCity("广州花都区");
			lct.setGPS("113.36646-23.14649");		//经纬度
			lct.setLandmark("参照物。。");
			lcts.add(lct);
			activity.setLocations(lcts);

			Set<Steps> stepsList = new HashSet<Steps>();
			for (int x = 0; x < 2; x++) {
				Steps steps = new Steps();
				steps.setDescription("描述：到验票处登记");
				steps.setName("步骤"+x+1);
				stepsList.add(steps);
			}
			activity.setStepsList(stepsList);

			activity.setTimeStart(new Date());
			Date date=new Date();
			date.setDate(date.getDate()+temp);
			activity.setTimeEnd(date);

			activity.setEvent(event1);
			as.add(activity);
		}// //activity for结束
		event1.setActivityList(as);
		return event1;
	}
	
	@SuppressWarnings("unused")
	private static String getRandomNameAndType() {
		Random r = new Random();
		String name = "";
		for(int i=0;i<2;i++){
		switch (r.nextInt(10)) {
		
		case 0:
			name =name+ "测";
			break;
		case 1:
			name =name+ "实";
			break;
		case 2:
			name =name+ "软";
			break;
		case 3:
			name = name+"件";
			break;
		case 4:
			name =name+ "开";
			break;
		case 5:
			name =name+ "广";
			break;
		case 6:
			name =name+ "州";
			break;
		case 7:
			name =name+ "岑";
			break;
		case 8:
			name =name+ "村";
			break;
		case 9:
			name = name+"红";
			break;
		case 10:
			name = name+"花";
			break;
		default:
			name=name+"**";
			break;
		}
		}
		String type="";
		switch (r.nextInt(10)) {
		case 0:
			type="演唱会";
			name =name+type ;
			break;
		case 1:
			type="音乐会";
			name =name+type ;
			break;
		case 2:
			type="论坛";
			name =name+type ;
			break;
		case 3:
			type="同学会";
			name =name+type ;
			break;
		case 4:
			type="酷车一族";
			name =name+type ;
			break;
		case 5:
			type="比赛";
			name =name+type ;
			break;
		case 6:
			type="另类娱乐";
			name =name+type ;
			break;
		case 7:
			type="演讲";
			name =name+type ;
			break;
		case 8:
			type="晚会";
			name =name+type ;
			break;
		case 9:
			type="运动会";
			name =name+type ;
			break;
		case 10:
			type="读书会";
			name =name+type ;
			break;
		default:
			name=name+"**";
			break;
		}
		
		return name+"-"+type;
	}
	

	public static void main(String[] args) {
		
		//这个xml文件是Spring配置beans的文件，顺带一提，路径 在整个应用的根目录
		
		test t=new test();
		float size=100;
		t.initSpring();
		for(int i=0;i<size;i++){
			Event event=new Event();
			event=t.getEvent();
			event=t.eventSerivce.addEvent(event);
			System.out.println(event.getEventID());
			try {
				CountInfo countInfo=t.dashboardService.statisticalInfo(event);
				t.countService.saveOrUpdate(countInfo);
			} catch (SoryinDashboardException e) {
				e.printStackTrace();
			}
			System.out.println("已经完成了"+((float)(i/size))*100+"%");
		}


	}
	EventService eventSerivce;
	UserInfoService userInfoService;
	ConditionService conditionService;
	ConstrainService constrainService;
	StepService stepService;
	EntityService entityService;
	LocationService locationService;
	DashboardService dashboardService;
	CountService countService;
	public void initSpring(){
		String paths[] = {"beans.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
		this.eventSerivce = (EventService)ctx.getBean("eventService");
		this.userInfoService=(UserInfoService)ctx.getBean("userInfoService");
		this.conditionService=(ConditionService)ctx.getBean("conditionService");
		this.constrainService=(ConstrainService)ctx.getBean("constrainService");
		this.stepService=(StepService)ctx.getBean("stepService");
		this.locationService=(LocationService)ctx.getBean("locationService");
		this.entityService=(EntityService)ctx.getBean("entityService");
		this.dashboardService=(DashboardService)ctx.getBean("dashboardService");
		this.countService=(CountService)ctx.getBean("countService");
	}
}
