package com.soryin.service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;

import com.soryin.common.BaiduTranslactionUtil;
import com.soryin.dao.EventDao;
import com.soryin.entity.Activity;
import com.soryin.entity.Condition;
import com.soryin.entity.Constrain;
import com.soryin.entity.Entity;
import com.soryin.entity.Event;
import com.soryin.entity.Location;
import com.soryin.entity.Steps;
import com.soryin.service.ConditionService;
import com.soryin.service.ConstrainService;
import com.soryin.service.EntityService;
import com.soryin.service.EventService;
import com.soryin.service.LocationService;
import com.soryin.service.StepService;

public class EventServiceImpl implements EventService {

	private BaiduTranslactionUtil bdtUtil;

	public BaiduTranslactionUtil getBdtUtil() {
		return bdtUtil;
	}

	public void setBdtUtil(BaiduTranslactionUtil bdtUtil) {
		this.bdtUtil = bdtUtil;
	}
	private ConditionService conditionService;
	
	public ConditionService getConditionService() {
		return conditionService;
	}

	public void setConditionService(ConditionService conditionService) {
		this.conditionService = conditionService;
	}
	
	private ConstrainService constrainService;
	
	private StepService stepService;
	
	private EntityService entityService;
	
	private LocationService locationService;
	
	public ConstrainService getConstrainService() {
		return constrainService;
	}

	public void setConstrainService(ConstrainService constrainService) {
		this.constrainService = constrainService;
	}

	public StepService getStepService() {
		return stepService;
	}

	public void setStepService(StepService stepService) {
		this.stepService = stepService;
	}

	public EntityService getEntityService() {
		return entityService;
	}

	public void setEntityService(EntityService entityService) {
		this.entityService = entityService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	private EventDao eventDao;

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public Event addEvent(Event event) {
		
		try {
			eventDao.save(event);
			event = eventDao.findById(event.getEventID());
			//translactionEvent(event);//逐句翻译
			//String result = translcationPackage(event);
			//result=bdtUtil.translation(result);
			//mapping(result);
			// event=eventDao.findById(event.getEventID());
			return event;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Event updateEvent(Event event) {
		if (event == null || event.getEventID() == null)
			return null;
		try {
			event = eventDao.findById(event.getEventID());
			translactionEvent(event);
			event = eventDao.findById(event.getEventID());
			return event;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void mapping(String str) {
		
		System.out.println(str);
		
		List<String> result_condition = new ArrayList<String>();
		List<String> result_step = new ArrayList<String>();
		List<String> result_constrain = new ArrayList<String>();
		List<String> result_entity = new ArrayList<String>();
		List<String> result_location = new ArrayList<String>();
		Pattern p = Pattern.compile("*condition#(.*?)*/condition#");
		Matcher m = p.matcher(str);
		while (m.find()) {
//			System.out.println(m.group(1));
			result_condition.add(m.group(1));
		}
		p=Pattern.compile("*step#(.*?)*/step#");
		m=p.matcher(str);
		while (m.find()) {
			System.out.println("....."+m.group(1));
			result_step.add(m.group(1));
		}
		
		
		p=Pattern.compile("*constrain#(.*?)*/constrain#");
		m=p.matcher(str);
		while (m.find()) {
//			System.out.println(m.group(1));
			result_constrain.add(m.group(1));
		}
		
		p=Pattern.compile("*entity#(.*?)*/entity#");
		m=p.matcher(str);
		while (m.find()) {
//			System.out.println(m.group(1));
			result_entity.add(m.group(1));
		}
		
		p=Pattern.compile("*location#(.*?)*/location#");
		m=p.matcher(str);
		while (m.find()) {
//			System.out.println(m.group(1));
			result_location.add(m.group(1));
		}
		
		
		for (String result_str : result_condition) {
			String[] arg = result_str.split("*soryin_tr#");

			for (String tr : arg) {
				String[] td = tr.split("*soryin_td#");
				if (td.length == 3) {
					Long conditionID = Long.parseLong(td[1]);
					String conditionName = td[2];
					Condition condition=conditionService.findConditionById(conditionID);
					condition.setName_EN(conditionName);
					conditionService.updateCondition(condition);
				}
			}
		}
		
		for (String result_str : result_step) {
			String[] arg = result_str.split("*soryin_tr#");

			for (String tr : arg) {
				String[] td = tr.split("*soryin_td#");
				if (td.length == 4) {
					Long stepID = Long.parseLong(td[1]);
					String stepName = td[2];
					String stepDescription=td[3];
					
					Steps step=stepService.findStepById(stepID);
					step.setName_EN(stepName);
					step.setDescription_EN(stepDescription);
					stepService.updateStep(step);
				}
			}
		}
		
		for (String result_str : result_constrain) {
			String[] arg = result_str.split("*soryin_tr#");

			for (String tr : arg) {
				String[] td = tr.split("*soryin_td#");
				if (td.length == 4) {
					Long constrainID = Long.parseLong(td[1]);
					String constrainName = td[2];
					String constrainDescription=td[3];
					Constrain constrain=constrainService.findConstrainById(constrainID);
					constrain.setName_EN(constrainName);
					constrain.setDescription_EN(constrainDescription);
					constrainService.updateConstrain(constrain);
				}
			}
		}
		
		for (String result_str : result_entity) {
			String[] arg = result_str.split("*soryin_tr#");

			for (String tr : arg) {
				String[] td = tr.split("*soryin_td#");
				if (td.length == 5) {
					Long entityID = Long.parseLong(td[1]);
					String entityName = td[2];
					String entityDescription=td[3];
					String entityAddress=td[4];
					
					Entity entity=entityService.findEntityById(entityID);
					entity.setName_EN(entityName);
					entity.setDescription_EN(entityDescription);
					entity.setAddress_EN(entityAddress);
					
					entityService.updateEntity(entity);
				}
			}
		}
		
		for (String result_str : result_location) {
			String[] arg = result_str.split("*soryin_tr#");

			for (String tr : arg) {
				String[] td = tr.split("*soryin_td#");
				if (td.length == 8) {
					Long locationID = Long.parseLong(td[1]);
					String locationAddress = td[2];
					String locationBuilding=td[3];
					String locationCity=td[4];
					String locationLandmark=td[5];
					String locationStree=td[6];
					String locationRoom=td[7];
					
					Location location=locationService.findLocationById(locationID);
					location.setAddress_EN(locationAddress);
					location.setBuilding_EN(locationBuilding);
					location.setCity_EN(locationCity);
					location.setLandmark_EN(locationLandmark);
					location.setStreet(locationStree);
					location.setRoom_EN(locationRoom);
					
					locationService.updateLocation(location);
					
				}
			}
		}
		
	}

	protected String translcationPackage(Event event) throws JSONException {
		String result = "";
		for (Activity activity : event.getActivityList()) {
			// activity.setName_EN(bdtUtil.translation(activity.getName()));
			// activity.setDescription_EN(bdtUtil.translation(activity
			// .getDescription()));

			// 条件翻译
			result = result + "*condition#";
			for (Condition condition : activity.getConditionSet()) {
				result = result + "*soryin_tr#*soryin_td#"
						+ condition.getConditionID() + "*soryin_td#"
						+ condition.getName();
				// System.out.println(condition.getConditionID());
			}
			result = result + "*/condition#";

			// 步骤翻译
			result = result + "*step#";
			System.out.println("listsize:::"+activity.getStepsList().size());
			for (Steps step : activity.getStepsList()) {
				String temp="*soryin_tr#*soryin_td#" + step.getStepsID()
						+ "*soryin_td#" + step.getName() + "*soryin_td#"
						+ step.getDescription();
				result = result + temp;
			}
			result = result + "*/step#";

			// 限制翻译*	
			result = result + "*constrain#";
			for (Constrain constrain : activity.getConstrainList()) {
				result = result + "*soryin_tr#*soryin_td#"
						+ constrain.getConstrainID() + "*soryin_td#"
						+ constrain.getName() + "*soryin_td#"
						+ constrain.getDescripetion();
			}
			result = result + "*/constrain#";

			result = result + "*entity#";
			for (Entity entity : activity.getEntityList()) {
				result = result + "*soryin_tr#*soryin_td#"
						+ entity.getEntityID() + "*soryin_td#"
						+ entity.getName() + "*soryin_td#"
						+ entity.getDescription() + "*soryin_td#"
						+ entity.getAddress();
			}
			result = result + "*/entity#";

			result = result + "*location#";
			for (Location location : activity.getLocations()) {
				result = result + "*soryin_tr#*soryin_td#"
						+ location.getLocationID() + "*soryin_td#"
						+ location.getAddress() + "*soryin_td#"
						+ location.getBuilding() + "*soryin_td#"
						+ location.getCity() + "*soryin_td#"
						+ location.getLandmark() + "*soryin_td#"
						+ location.getStreet() + "*soryin_td#"
						+ location.getRoom();
			}
			result = result + "*/location#";
		}

		return result;
	}


	protected boolean translactionEvent(Event event) {
		if (event == null) {
			return false;
		}
		try {
			event.setName_EN(bdtUtil.translation(event.getName()));
			// 翻译
			event.setDescription_EN(bdtUtil.translation(event.getDescription()));

			for (Activity activity : event.getActivityList()) {
				activity.setName_EN(bdtUtil.translation(activity.getName()));
				activity.setDescription_EN(bdtUtil.translation(activity
						.getDescription()));

				// 条件翻译
				for (Condition condition : activity.getConditionSet()) {
					condition.setName_EN(bdtUtil.translation(condition
							.getName()));
				}

				// 步骤翻译
				for (Steps step : activity.getStepsList()) {
					step.setDescription_EN(bdtUtil.translation(step
							.getDescription()));
					step.setName_EN(bdtUtil.translation(step.getName()));
				}

				// 限制翻译
				for (Constrain constrain : activity.getConstrainList()) {
					constrain.setDescription_EN(bdtUtil.translation(constrain
							.getDescripetion()));
					constrain.setName_EN(bdtUtil.translation(constrain
							.getName()));
				}

				for (Entity entity : activity.getEntityList()) {
					entity.setName_EN(bdtUtil.translation(entity.getName()));
					entity.setDescription_EN(bdtUtil.translation(entity
							.getDescription()));
					entity.setAddress_EN(bdtUtil.translation(entity
							.getAddress()));
				}

				for (Location location : activity.getLocations()) {
					location.setAddress_EN(bdtUtil.translation(location
							.getAddress()));
					location.setBuilding_EN(bdtUtil.translation(location
							.getBuilding()));
					location.setCity_EN(bdtUtil.translation(location.getCity()));
					location.setLandmark_EN(bdtUtil.translation(location
							.getLandmark()));
					location.setRoom_EN(bdtUtil.translation(location.getRoom()));
					location.setStreet_EN(bdtUtil.translation(location
							.getStreet()));
				}

			}
		} catch (JSONException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			eventDao.update(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delelte(String id) {
		try {
			eventDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Event findEventById(String id) {
		try {
			return eventDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Event> allEventList(int offset, int length) {
		
		return (List<Event>) eventDao.findListForPage(null, offset, length);
	}

}
