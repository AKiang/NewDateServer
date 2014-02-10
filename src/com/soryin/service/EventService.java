package com.soryin.service;

import java.util.List;

import com.soryin.entity.Event;

public interface EventService {
	public Event addEvent(Event event);
	
	public Event updateEvent(Event event);
	
	public boolean delelte(String id);
	
	public Event findEventById(String id);
	
	public List<Event> allEventList(int offset,int length);
}
