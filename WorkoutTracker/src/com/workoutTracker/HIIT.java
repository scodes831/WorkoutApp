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
	
	public void editHIITDetails() {
		boolean stillEditing = true;
		do {
			int selection = UserPrompts.askHIITEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					break;
				case 2:
					int newHeartRate = UserPrompts.askHeartRate();
					this.setHeartRate(newHeartRate);
					break;
				case 3:
					int calories = UserPrompts.askCalories();
					this.setCalories(calories);
					break;
				case 4:
					int newActiveIntervalSec = UserPrompts.askIntervalSeconds("active");
					this.setActiveIntervalSec(newActiveIntervalSec);
					break;
				case 5:
					int newRestIntervalSec = UserPrompts.askIntervalSeconds("rest");
					this.setRestIntervalSec(newRestIntervalSec);
					break;
				case 6:
					int newNumOfIntervals = UserPrompts.askNumIntervals();
					this.setNumOfIntervals(newNumOfIntervals);
					break;
				}
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
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
