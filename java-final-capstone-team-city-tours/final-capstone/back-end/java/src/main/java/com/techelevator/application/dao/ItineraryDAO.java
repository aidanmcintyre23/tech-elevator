package com.techelevator.application.dao;

import java.util.Date;
import java.util.List;

import com.techelevator.application.model.Destination;
import com.techelevator.application.model.Itinerary;

public interface ItineraryDAO {
	
	// create 
	
	public void addToItinerary (Long destinationId, Long itineraryId);
	
	public void createItinerary (Long userId, String date, String startingPoint);
	
	// read
	
	public List<Itinerary> viewAllItineraries ();
	
	public Itinerary viewItineraryById(Long itineraryId);
	
	public List<Itinerary> viewItineraryByUser (Long userId);
	
	public List<Itinerary> viewItineraryByDate (String date);
	
	// update 
	
	public void updateItinerary (String startingPoint, String date, Long itineraryId);
	
	
	// delete 
	public void deleteDestinationFromItinerary(Long destinationId);
	
	public void deleteItinerary (Long itineraryId);
	
	

}
