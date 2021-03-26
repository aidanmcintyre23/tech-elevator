package com.techelevator;

public class Meditation {
	
// Instance variables
	private String type;
	private String description;
	private String technique;
	
//  Overloaded Constructor
	public Meditation() {
		this.type = "";
		this.description = "";
		this.technique = "";
	}
	
// Constructor
	public Meditation(String type) {
		if (type == "Breath-focused") {
			this.type = type;
			this.description = "This type of meditation involves simply focusing attention on the breath as an anchor";
			this.technique = "(1) Repeatedly count exhalations in cycles of 10" + "\n" + "(2) Repeatedly count inhalations in cycles of 10" + "\n" + "(3) Focus on the breath without counting" + "\n" + "(4) Focus only on the spot where the breath enters and leaves the nostrils (i.e., the nostril and upper lip area)";
		}
		if (type == "Metta (loving-kindness)") {
			this.type = type;
			this.description = "This type of meditation is concerned with the cultivation of benevolence and kindness towards the self and others";
			this.technique = "Silently repeat one or more of the following phrases: " + "\n" + "(1) May (I/you/all beings) be happy" + "\n" + "(2) May (I/you/all beings) be free from suffering" + "\n" + "(3) May (I/you/all beings) be safe and protected" + "\n" + "(4) May (I/you/all beings) be peaceful" + "\n" + "(5) May (I/you/all beings) live at ease and with kindness";
		}
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the technique
	 */
	public String getTechnique() {
		return technique;
	}

	/**
	 * @param technique the technique to set
	 */
	public void setTechnique(String technique) {
		this.technique = technique;
	}
	
}
