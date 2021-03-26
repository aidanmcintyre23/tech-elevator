package com.techelevator;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MeditationApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to my Meditation App!");
		
		System.out.println("Have you ever meditated before? (Y/N)");
		Scanner userInput = new Scanner(System.in);	// Use a Scanner to take user input from console
		String userResponse = userInput.nextLine(); // Store user input in userResponse
		String choiceLetter = userResponse.substring(0,1).toUpperCase(); // get the first letter of userResponse in uppercase and store it as choiceLetter
		
		if (choiceLetter.equals("Y")) {
			System.out.println("Great! Would you like to meditate now? (Y/N)");
			String userResponse2 = userInput.nextLine();
			String choiceLetter2 = userResponse2.substring(0,1).toUpperCase();
			
			if (choiceLetter2.equals("Y")) {
				Random rand = new Random();
				int int_random = rand.nextInt(101);
				if (int_random <= 50) {
					BreathMeditation aMeditation = new BreathMeditation();
					System.out.println(aMeditation.getType());
					System.out.println("\n");
					System.out.println(aMeditation.getDescription());
					System.out.println("\n");
					System.out.println(aMeditation.getTechnique());
					System.out.println("\n");
					System.out.println("How long would you like to meditate? (min)");
					int timeResponse = Integer.parseInt(userInput.nextLine());
					int timeInSecs = timeResponse * 60;
					BreathMeditationTimer timer = new BreathMeditationTimer(timeInSecs);
					timer.run();
				} else {
					MettaMeditation aMeditation = new MettaMeditation();
					System.out.println(aMeditation.getType());
					System.out.println("\n");
					System.out.println(aMeditation.getDescription());
					System.out.println("\n");
					System.out.println(aMeditation.getTechnique());
					String subject = "";
					System.out.println("\n");
					System.out.println("Would you like to focus this meditation on:" + "\n" + "(1) Yourself" + "\n" + "(2) Someone else" + "\n" + "(3) All beings");
					String userResponse4 = userInput.nextLine();
					Integer choiceNumber = Integer.parseInt(userResponse4.substring(0, 1));
					if (choiceNumber == 1) {
						subject = "I";
					} else if (choiceNumber == 2) {
						subject = "you";
					} else {
						subject = "all beings";
					}
					System.out.println("How long would you like to meditate? (min)");
					int timeResponse = Integer.parseInt(userInput.nextLine());
					int timeInSecs = timeResponse * 60;
					MettaMeditationTimer timer = new MettaMeditationTimer(timeInSecs, subject);
					timer.run();
				}
		}
		}
		else if (choiceLetter.equals("N")) {
			System.out.println("Would you like to give meditation a try? (Y/N)");
			String userResponse4 = userInput.nextLine();
			String choiceLetter4 = userResponse4.substring(0,1).toUpperCase();
			if (choiceLetter4.equals("Y")) {
				Random rand = new Random();
				int int_random = rand.nextInt(101);
				if (int_random <= 50) {
					BreathMeditation aMeditation = new BreathMeditation();
					System.out.println(aMeditation.getType());
					System.out.println(aMeditation.getDescription());
					System.out.println("Would you like to learn more? (Y/N)");
					String userResponse3 = userInput.nextLine();
					String choiceLetter3 = userResponse3.substring(0, 1).toUpperCase();
					if (choiceLetter3.equals("Y")) {
						System.out.println(aMeditation.getTechnique());
					}
					System.out.println("How long would you like to meditate? (min)");
					int timeResponse = Integer.parseInt(userInput.nextLine());
					int timeInSecs = timeResponse * 60;
					BreathMeditationTimer timer = new BreathMeditationTimer(timeInSecs);
					timer.run();
				} else {
					MettaMeditation aMeditation = new MettaMeditation();
					System.out.println(aMeditation.getType());
					System.out.println(aMeditation.getDescription());
					System.out.println("Would you like to learn more? (Y/N)");
					String userResponse3 = userInput.nextLine();
					String choiceLetter3 = userResponse3.substring(0, 1).toUpperCase();
					if (choiceLetter3.equals("Y")) {
						System.out.println(aMeditation.getTechnique());
					}
					String subject = "";
					System.out.println("\n");
					System.out.println("Would you like to focus this meditation on:" + "\n" + "(1) Yourself" + "\n" + "(2) Someone else" + "\n" + "(3) All beings");
					String userResponse5 = userInput.nextLine();
					String choiceNumber = userResponse5.substring(0, 1);
					if (choiceNumber == "1") {
						subject = "I";
					} else if (choiceNumber == "2") {
						subject = "you";
					} else {
						subject = "all beings";
					}
					System.out.println("How long would you like to meditate? (min)");
					int timeResponse = Integer.parseInt(userInput.nextLine());
					int timeInSecs = timeResponse * 60;
					MettaMeditationTimer timer = new MettaMeditationTimer(timeInSecs, subject);
					timer.run();
				}
				userInput.close();
				} else {
					System.out.println("Ok, have a nice day!");
				}
		
	}
}
}


