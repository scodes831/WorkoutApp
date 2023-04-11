package com.workoutTracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public abstract class Exercise {
	
	private static int ID = 378832;
	
	int exerciseId;
	int exerciseTime;
	int heartRate;
	int calories;
	
	Exercise() {
		this.exerciseId = generateExerciseId();
	}
	
	public int generateExerciseId() {
		int id = Exercise.getID();
		id++;
		Exercise.setID(id);
		return id;
	}
	
	public void addExerciseDetails() {
		int exerciseTime = UserPrompts.askTime("exercise");
		this.setExerciseTime(exerciseTime);
		if (this instanceof StrengthTraining) {
			((StrengthTraining)this).addStrengthTrainingDetails();
		} else if (this instanceof Bike) {
			
		} else if (this instanceof HIIT) {
			
		} else if (this instanceof Run) {
			
		}
	}
	
	public double calculateMPH(double miles, int time) {
		BigDecimal mph = new BigDecimal((miles*60)/time).setScale(1, RoundingMode.HALF_UP);
		return mph.doubleValue();
	}
	
	public LocalTime calculatePace(double mph) {
		int hour = 0;
		int minutes = (int) (60.0 / mph);
		if (minutes > 59) {
			hour++;
		}
		int seconds = (int) (((60.0/mph) - minutes) * 60);
		LocalTime pace = LocalTime.of(hour, minutes, seconds);
		return pace;
	}
	
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
	
	public int getExerciseId() {
		return exerciseId;
	}
	
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public int getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(int exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

}
