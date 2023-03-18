package com.workoutTracker;

public class Run extends Exercise implements Distance, Speed {
	
	double mph;
	double pace;
	double distanceMi;
	double distanceKm;
	
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
	public double getDistanceKm() {
		return distanceKm;
	}
	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

}
