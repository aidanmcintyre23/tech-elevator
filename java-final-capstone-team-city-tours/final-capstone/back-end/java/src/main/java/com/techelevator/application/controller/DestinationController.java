package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.model.DayOfWeek;
import com.techelevator.application.model.Destination;

@RestController
@CrossOrigin
public class DestinationController {

	public DestinationController (DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}
	private DestinationDAO destinationDAO;

	
	@RequestMapping(path = "/destinations", method = RequestMethod.GET)
	public List<Destination> findDestinations (@RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String zipcode, @RequestParam(defaultValue="") String type) {
		List<Destination> result = new ArrayList<>();
		if(zipcode.equals("") && name.equals("") && type.equals("")) {
			result = destinationDAO.getAllDestinations();
		}
		if(!zipcode.equals("")) {
			logAPICall("Called with the path: /destinations?zipcode=" + zipcode);
			result = destinationDAO.findDestinationsByZip(zipcode);
		}
		if(!name.equals("")) {
			logAPICall("Called with the path: /destinations?name=" + name);
			result = destinationDAO.findDestinationByName(name);
		}
		if(!type.equals("")) {
			logAPICall("Called with the path: /destinations?type=" + type);
			result = destinationDAO.findDestinationsByType(type);
		}
		
		logAPICall("Number of destinations found: " + result.size());
		return result;
	}
	
	@RequestMapping(path = "/destinations/{id}", method = RequestMethod.GET)
	public List<Destination> getDestinationById (@PathVariable Long id) {
		List<Destination> destination = destinationDAO.findDestinationById(id);
		logAPICall("Called with the path: /destinations/" + id);
		return destination;
	}
	
	@RequestMapping(value = "/delete/{destinationId}", method = RequestMethod.DELETE)
    public void deleteDestination(@PathVariable long destinationId) {
		destinationDAO.deleteDestination(destinationId);
 
    }

	public void logAPICall(String message) {    // write a message with a time stamp to the server log 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
		String timeNow = now.format(formatter);
		System.out.println(timeNow + "-" + message);
	}

}
