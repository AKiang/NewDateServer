package com.soryin.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.soryin.entity.Event;
import com.soryin.service.EventService;
import com.soryin.vo.PageView;

public class EventAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6183370087025980474L;
	
	private PageView<Event> pageView;
	
	public PageView<Event> getPageView() {
		return pageView;
	}

	public void setPageView(PageView<Event> pageView) {
		this.pageView = pageView;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	private Event event;
	
	private EventService eventService;
	
	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}


	private String customError="";
	
	public String getCustomError() {
		return customError;
	}

	public void setCustomError(String customError) {
		this.customError = customError;
	}
	
	private List<Event> evnets;
	
	public List<Event> getEvnets() {
		return evnets;
	}

	public void setEvnets(List<Event> evnets) {
		this.evnets = evnets;
	}
	
	private String json;

	
//	//---------method begin---------\\
//	public String translation(){
//		if(content==null){
//			customError="错误的参数";
//			return "error";
//		}
//		try {
//			System.out.println(content);
//			dst=bdtUtil.translation(content);
//			System.out.println(dst);
//		} catch (JSONException e) {
//			e.printStackTrace();
//			System.out.println("解析JSON的时候出现一个错误");
//		}  
//
//		return "translation";
//	}
//	
	

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String addEvent(){
		eventService.addEvent(event);
		return "addEvent";
	}
	
	public String updateEvent(){
		if(eventService.updateEvent(event)==null){
			System.out.println("null");
			json="4";
		}else {
			System.out.println("success");
			json="1";
		}
		return "updateEvent";
	}
	
	public String delelte(){
		if(event.getEventID()==null||event.getEventID().trim().length()<1){
			customError="错误的参数";
			return "error";
		}
		eventService.delelte(event.getEventID());
		return "delelte";
	}
	
	public String show(){
		event=eventService.findEventById(event.getEventID());
		return "show";
	}
	
	public String list(){
		if(pageView.getCurrentpage()<1){
			pageView.setCurrentpage(1);
		}
		if(pageView.getMaxresult()<1){
			pageView.setMaxresult(10);
		}
		evnets=eventService.allEventList(pageView.getCurrentpage(), pageView.getMaxresult());
		return "list";
	}

}
