package com.workoutTracker;

public class HIIT extends Exercise {
	
	int activeIntervalSec;
	int restInvertalSec;
	int numOfIntervals;
	
	public int getActiveIntervalSec() {
		return activeIntervalSec;
	}
	public void setActiveIntervalSec(int activeIntervalSec) {
		this.activeIntervalSec = activeIntervalSec;
	}
	public int getRestInvertalSec() {
		return restInvertalSec;
	}
	public void setRestInvertalSec(int restInvertalSec) {
		this.restInvertalSec = restInvertalSec;
	}
	public int getNumOfIntervals() {
		return numOfIntervals;
	}
	public void setNumOfIntervals(int numOfIntervals) {
		this.numOfIntervals = numOfIntervals;
	}

}
