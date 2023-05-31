package com.workoutTracker;

import java.time.LocalTime;

public class Run extends Exercise {
	
	double mph;
	LocalTime pace;
	double distanceMi;
	double distanceKm;
	
	public Run(int exerciseId, double mph, double distanceMi, double distanceKm){
		this.exerciseId = exerciseId;
		this.mph = mph;
		this.distanceMi = distanceMi;
		this.distanceKm = distanceKm;
	}
	
	public void addRunDetails() {
		double distanceMi = UserPrompts.askDistanceMiles();
		this.setDistanceMi(distanceMi);
		this.setDistanceKm(this.convertMilesToKilometers(distanceMi));
		this.setMph(this.calculateMPH(distanceMi, this.getExerciseTime()));
		this.setPace(this.calculatePace(this.getMph()));
	}
	
	public void editRunDetails() {
		boolean stillEditing = true;
		do {
			int selection = UserPrompts.askRunEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					break;
				case 2:
					double newDistanceMi = UserPrompts.askDistanceMiles();
					this.setDistanceMi(newDistanceMi);
					this.setDistanceKm(this.convertMilesToKilometers(newDistanceMi));
					this.setMph(this.calculateMPH(newDistanceMi, this.getExerciseTime()));
					this.setPace(this.calculatePace(this.getMph()));
					break;
				}
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
	}
	
	public double getMph() {
		return mph;
	}
	public void setMph(double mph) {
		this.mph = mph;
	}
	public LocalTime getPace() {
		return pace;
	}
	public void setPace(LocalTime pace) {
		this.pace = pace;
	}
	public double getDistanceMi() {
		return distanceMi;
	}
	public void setDistanceMi(double distanceMi) {
		this.distanceMi = distanceMi;
	}
	public double getDistanceKm() {
		return distanceKm;
	}
	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	

}
