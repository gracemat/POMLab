package com.qa.activecampaign.utilities;

public class Time_Utility_ActiveCampaign {
	public static void shortTimeWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public static void mediumTimeWait() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void longTimeWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
