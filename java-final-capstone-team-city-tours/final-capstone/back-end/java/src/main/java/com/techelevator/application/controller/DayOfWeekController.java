package com.techelevator.application.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DayOfWeekDAO;
import com.techelevator.application.model.DayOfWeek;

@CrossOrigin
@RestController
public class DayOfWeekController {

	public DayOfWeekController (DayOfWeekDAO dayOfWeekDAO) {
		this.dayOfWeekDAO = dayOfWeekDAO;
	}
	private DayOfWeekDAO dayOfWeekDAO;
	
	@RequestMapping(path = "/dayOfWeek/{name}", method = RequestMethod.GET)
	public DayOfWeek getDayByName (@PathVariable String name) {
		DayOfWeek day = dayOfWeekDAO.getDayByName(name);
		logAPICall("Called with the path: /dayOfWeek/" + name);
		return day;
	}
	
	public void logAPICall(String message) {    // write a message with a time stamp to the server log 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
		String timeNow = now.format(formatter);
		System.out.println(timeNow + "-" + message);
	}
}
