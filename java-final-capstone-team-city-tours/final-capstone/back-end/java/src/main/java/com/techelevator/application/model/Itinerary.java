
package com.techelevator.application.model;

import java.util.Date;

public class Itinerary {
	
	private Long itineraryId;
	private Long userId;
	private String startingPoint;
	private String date;
	
	

	public Long getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(Long itineraryId) {
		this.itineraryId = itineraryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStartingPoint() {
		return startingPoint;
	}
	
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "itinerary [itineraryId=" + itineraryId + ", userId=" + userId + ", startingPoint=" + startingPoint
				+ ", date=" + date + "]";
	}
	
}