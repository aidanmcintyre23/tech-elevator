package com.techelevator.application.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DayOfWeekDAO;
import com.techelevator.application.dao.OpenHoursDAO;
import com.techelevator.application.model.OpenHours;

@CrossOrigin
@RestController
public class OpenHoursController {

	public OpenHoursController (OpenHoursDAO openHoursDAO) {
		this.openHoursDAO = openHoursDAO;
	}
	private OpenHoursDAO openHoursDAO;
	
	@RequestMapping(value = "/hours/{id}", method = RequestMethod.GET)
	public List<OpenHours> getDayById (@PathVariable Long id) {
		logAPICall("Called with the path: /hours/" + id);
		List<OpenHours> hours = openHoursDAO.readOpenHoursById(id);
		return hours;
	}
	
	public void logAPICall(String message) {    // write a message with a time stamp to the server log 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
		String timeNow = now.format(formatter);
		System.out.println(timeNow + "-" + message);
	}
}
