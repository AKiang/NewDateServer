package com.soryin.service.Implement;

import com.soryin.dao.LocationDao;
import com.soryin.entity.Location;
import com.soryin.service.LocationService;

public class LocationServiceImpl implements LocationService {
	
	private LocationDao locationDao;
	
	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public Location findLocationById(Long id) {
		return locationDao.findById(id);
	}

	public boolean updateLocation(Location location) {
	try {
		locationDao.update(location);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	public boolean saveLocation(Location location) {
		try {
			locationDao.save(location);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
}
