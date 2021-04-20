package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Destination;

public interface DestinationDAO {
	
	// read
	public List<Destination> findDestinationsByZip(String zipcode);

	public List<Destination>findDestinationByName(String name);
	
	public List<Destination> findDestinationById(long destinationId);

	public List<Destination> findDestinationsByType(String type);
	
	public List<Destination> getAllDestinations();
	
	public List<Destination> viewDestinationsByItineraryId(Long id);

	// delete
	public void deleteDestination(long destinationId);
}
