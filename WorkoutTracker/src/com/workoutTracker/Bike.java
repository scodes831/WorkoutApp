package com.workoutTracker;

public class Bike extends Exercise implements Distance, Speed {
	
	double mph;
	double pace;
	double distanceMi;
	double distanceKg;
	int resistance;
	boolean isStationaryBike;
	
	public double getMph() {
		return mph;
	}
	public void setMph(double mph) {
		this.mph = mph;
	}
	public double getPace() {
		return pace;
	}
	public void setPace(double pace) {
		this.pace = pace;
	}
	public double getDistanceMi() {
		return distanceMi;
	}
	public void setDistanceMi(double distanceMi) {
		this.distanceMi = distanceMi;
	}
	public double getDistanceKg() {
		return distanceKg;
	}
	public void setDistanceKg(double distanceKg) {
		this.distanceKg = distanceKg;
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
