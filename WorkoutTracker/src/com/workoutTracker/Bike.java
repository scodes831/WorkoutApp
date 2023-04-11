package com.workoutTracker;

import java.time.LocalTime;

public class Bike extends Exercise implements Distance, Speed {
	
	double mph;
	LocalTime pace;
	double distanceMi;
	double distanceKm;
	int resistance;
	boolean isStationaryBike;
	
	public void addBikeDetails() {
		boolean isStationaryBike = UserPrompts.askIfStationaryBike();
		this.setStationaryBike(isStationaryBike);
		double distanceMi = UserPrompts.askDistanceMiles();
		this.setDistanceMi(distanceMi);
		this.setDistanceKm(this.convertMilesToKilometers(distanceMi));
		int resistance = UserPrompts.askResistance();
		this.setResistance(resistance);
		this.setMph(this.calculateMPH(distanceMi, this.getExerciseTime()));
		this.setPace(this.calculatePace(this.getMph()));
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
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public boolean isStationaryBike() {
		return isStationaryBike;
	}
	public void setStationaryBike(boolean isStationaryBike) {
		this.isStationaryBike = isStationaryBike;
	}

}
