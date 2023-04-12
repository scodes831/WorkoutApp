package com.workoutTracker;

public class HIIT extends Exercise {
	
	int activeIntervalSec;
	int restIntervalSec;
	int numOfIntervals;
	
	public void addHIITDetails() {
		int activeIntervalSec = UserPrompts.askIntervalSeconds("active");
		this.setActiveIntervalSec(activeIntervalSec);
		int restIntervalSec = UserPrompts.askIntervalSeconds("rest");
		this.setRestIntervalSec(restIntervalSec);
		int numOfIntervals = UserPrompts.askNumIntervals();
		this.setNumOfIntervals(numOfIntervals);
	}
	
	public int getActiveIntervalSec() {
		return activeIntervalSec;
	}
	public void setActiveIntervalSec(int activeIntervalSec) {
		this.activeIntervalSec = activeIntervalSec;
	}
	public int getRestIntervalSec() {
		return restIntervalSec;
	}
	public void setRestIntervalSec(int restIntervalSec) {
		this.restIntervalSec = restIntervalSec;
	}
	public int getNumOfIntervals() {
		return numOfIntervals;
	}
	public void setNumOfIntervals(int numOfIntervals) {
		this.numOfIntervals = numOfIntervals;
	}

}
