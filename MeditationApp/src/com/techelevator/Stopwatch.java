package com.techelevator;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
	static int interval;
	/**
	 * @return the interval
	 */
	public static int getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public static void setInterval(int interval) {
		Stopwatch.interval = interval;
	}

	/**
	 * @return the timer
	 */
	public static Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public static void setTimer(Timer timer) {
		Stopwatch.timer = timer;
	}

	static Timer timer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How long would you like to meditate? (min)");
		String mins = sc.nextLine();
		int delay = 1000;
		int period = 1000;
		timer = new Timer();
		interval = (Integer.parseInt(mins)) * 60;
		System.out.println(mins);
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				System.out.println(setInterval());
			}
		}, delay, period);
	}
	
	private static final int setInterval() {
		if (interval == 1)
			timer.cancel();
		return --interval;
}
	
public Stopwatch() {
	this.interval = interval;
}
}
