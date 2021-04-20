package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.OpenHours;

public interface OpenHoursDAO {
	
	// read
	
	public List <OpenHours> readOpenHoursById (long destinationId);
	
}
