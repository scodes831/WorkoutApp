package com.workoutTracker;

public class HIIT extends Exercise {
	
	double activeIntervalSec;
	double restInvertalSec;
	int numOfIntervals;
	
	public double getActiveIntervalSec() {
		return activeIntervalSec;
	}
	public void setActiveIntervalSec(double activeIntervalSec) {
		this.activeIntervalSec = activeIntervalSec;
	}
	public double getRestInvertalSec() {
		return restInvertalSec;
	}
	public void setRestInvertalSec(double restInvertalSec) {
		this.restInvertalSec = restInvertalSec;
	}
	public int getNumOfIntervals() {
		return numOfIntervals;
	}
	public void setNumOfIntervals(int numOfIntervals) {
		this.numOfIntervals = numOfIntervals;
	}

}
