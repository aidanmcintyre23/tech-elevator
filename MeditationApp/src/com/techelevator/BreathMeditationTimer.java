package com.techelevator;

import java.util.Timer;
import java.util.TimerTask;

public class BreathMeditationTimer {
	
	public BreathMeditationTimer(int duration) {
		BreathMeditationTimer.duration = duration;
	}
	
	private static int duration;
	
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
		BreathMeditationTimer.duration = duration;
	}
		
	Timer timer = new Timer();
		public void run()
		{
			for (int i = 1; i <= duration - 1; i++) {
				if (i == 1) {
					System.out.println("Repeatedly count exhalations in cycles of 10");
				}
				else if (i == duration * 0.25) {
					System.out.println("Repeatedly count inhalations in cycles of 10");
				}
				else if (i == duration / 2) {
					System.out.println("Focus on the breath without counting");
				}
				else if (i == duration * 0.75) {
					System.out.println("Focus only on the spot where the breath enters and leaves the nostrils" + "\n" + "i.e., the nostril and upper lip area)");
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


	
