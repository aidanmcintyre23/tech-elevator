package com.techelevator;

import java.util.Timer;

public class MettaMeditationTimer {
	
	public MettaMeditationTimer(int duration, String subject) {
		MettaMeditationTimer.duration = duration;
		MettaMeditationTimer.subject = subject;
	}
	
	private static int duration;
	private static String subject;
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the duration
	 */
	public static int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		MettaMeditationTimer.duration = duration;
	}
		
	Timer timer = new Timer();
		public void run()
		{
			for (int i = 1; i <= duration - 1; i++) {
				if (i == 1) {
					System.out.println("May " + subject + " be happy");
				}
				else if (i == duration * 0.2) {
					System.out.println("May " + subject + " be free from suffering");
				}
				else if (i == duration * 0.4) {
					System.out.println("May " + subject + " be safe and protected");
				}
				else if (i == duration * 0.6) {
					System.out.println("May " + subject + " be peaceful");
				}
				else if (i == duration * 0.8) {
					System.out.println("May " + subject + " live at ease and with kindness");
				}
				else {
					System.out.println(duration - i);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Time's up!");
			timer.cancel();
		}

}
