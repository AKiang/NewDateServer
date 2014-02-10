package com.soryin.service;

import com.soryin.entity.Location;

public interface LocationService {
	public Location findLocationById(Long id);
	
	public boolean updateLocation(Location location);
	
	public boolean saveLocation(Location location);
}
