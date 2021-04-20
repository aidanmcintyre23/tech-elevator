package com.techelevator.application.controller;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.dao.ItineraryDAO;
import com.techelevator.application.model.Destination;
import com.techelevator.application.model.Itinerary;
import com.techelevator.security.dao.UserDAO;

@RestController
@CrossOrigin
public class ItineraryController {

public ItineraryController (ItineraryDAO itineraryDAO, UserDAO userDAO, DestinationDAO destinationDAO) {
	this.itineraryDAO = itineraryDAO;
	this.userDAO =userDAO;
	this.destinationDAO = destinationDAO;
}

private DestinationDAO destinationDAO;
private UserDAO userDAO;
private ItineraryDAO itineraryDAO;

@RequestMapping(path = "/viewItineraryById/{id}", method = RequestMethod.GET)
public Itinerary viewItinerary(@PathVariable Long id) {
	Itinerary itinerary = itineraryDAO.viewItineraryById(id);
	logAPICall("Called with the path: /viewItineraryById/" + id);
	return itinerary;
}

@RequestMapping(path = "/viewDestinationsByItineraryId/{id}", method = RequestMethod.GET)
public List<Destination> viewDestinationsByItineraryId(@PathVariable Long id) {
	List<Destination> destinations = new ArrayList<>();
	destinations = destinationDAO.viewDestinationsByItineraryId(id);
	logAPICall("Called with the path: /viewDestinationsByItineraryId/" + id);
	return destinations;
}

@RequestMapping(path = "/addItinerary/{destinationId}/{itineraryId}", method = RequestMethod.POST)
public void addToItinerary(@PathVariable Long destinationId,@PathVariable Long itineraryId) {
	itineraryDAO.addToItinerary(destinationId, itineraryId);
	logAPICall("Called with the path: /add/itinerary/");
	
}

@RequestMapping(path = "/createItinerary", method = RequestMethod.POST)
public void createItinerary(Principal userInfo, @RequestBody Itinerary itinerary) {
	long userId = userDAO.findIdByUsername(userInfo.getName());
	itineraryDAO.createItinerary(userId, itinerary.getDate(), itinerary.getStartingPoint());

}

@RequestMapping(path = "/itinerary/", method = RequestMethod.GET)
public List<Itinerary> viewAllItineraries () {
	List<Itinerary> itineraryUser = itineraryDAO.viewAllItineraries();
	logAPICall("Called with the path: /itinerary/");
	return itineraryUser;
}


@RequestMapping(path = "/itineraryUser/{userId}", method = RequestMethod.GET)
public List<Itinerary> viewItineraryByUser (@PathVariable Long userId) {
	List<Itinerary> itineraryUser = itineraryDAO.viewItineraryByUser(userId);
	logAPICall("Called with the path: /itineraryUser/" + userId);
	return itineraryUser;
}


@RequestMapping(path = "/itineraryDate/{date}", method = RequestMethod.GET)
public List<Itinerary> viewItineraryByDate (@PathVariable String date) {
	
	List<Itinerary> itineraryDate = itineraryDAO.viewItineraryByDate(date);
	logAPICall("Called with the path: /itineraryDate/" + date);
	return itineraryDate;
}

@RequestMapping(value = "/deleteItinerary/{itineraryId}", method = RequestMethod.DELETE)
public void deleteItinerary(@PathVariable Long itineraryId) {
	itineraryDAO.deleteItinerary(itineraryId);

}

@RequestMapping(value = "/deleteDestination/{id}", method = RequestMethod.DELETE)
public void deleteDestination(@PathVariable Long id) {
	itineraryDAO.deleteDestinationFromItinerary(id);

}

@RequestMapping(value = "/updateItinerary/{itineraryId}", method = RequestMethod.PUT)
public void updateItinerary(@PathVariable Long itineraryId, @RequestBody Itinerary itinerary) {
	itineraryDAO.updateItinerary(itinerary.getStartingPoint(), itinerary.getDate(), itineraryId);
}


public void logAPICall(String message) {    // write a message with a time stamp to the server log 
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
	String timeNow = now.format(formatter);
	System.out.println(timeNow + "-" + message);
}

}