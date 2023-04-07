package com.workoutTracker;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Exercise {
	
	private static int ID = 378832;
	
	int heartRate;
	int calories;
	
	public double convertMilesToKilometers(double miles) {
		BigDecimal km = new BigDecimal(miles * 1.609344).setScale(2, RoundingMode.HALF_UP);
		return km.doubleValue();
	}
	
	public double convertPoundsToKilograms(double pounds) {
		BigDecimal kg = new BigDecimal(pounds * 0.453592).setScale(2, RoundingMode.HALF_UP);
		return kg.doubleValue();
	}
	
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

}
