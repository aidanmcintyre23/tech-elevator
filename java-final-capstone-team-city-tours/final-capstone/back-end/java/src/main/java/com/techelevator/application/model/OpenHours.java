package com.techelevator.application.model;

public class OpenHours {
	
	private Long hoursId;
	private Long destinationId;
	private Long dayId;
	private String open;
	private String close;
	
	private String dayOfWeek;
	
	public Long getHoursId() {
		return hoursId;
	}
	public void setHoursId(Long hoursId) {
		this.hoursId = hoursId;
	}
	public Long getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}
	public Long getDayId() {
		return dayId;
	}
	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	@Override
	public String toString() {
		return "OpenHours [hoursId=" + hoursId + ", destinationId=" + destinationId + ", dayId=" + dayId + ", open="
				+ open + ", close=" + close + "]";
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	
	

}
