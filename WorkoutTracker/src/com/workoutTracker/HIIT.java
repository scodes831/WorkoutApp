package com.workoutTracker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Formatter;

public class HIIT extends Exercise {

	int activeIntervalSec;
	int restIntervalSec;
	int numOfIntervals;

	public HIIT(int activeIntervalSec, int restIntervalSec, int numIntervals) {
		this.activeIntervalSec = activeIntervalSec;
		this.restIntervalSec = restIntervalSec;
		this.numOfIntervals = numIntervals;
	}

	public HIIT() {
	}

	public void addHIITDetails(Connection connection, HIITTable hiitTable) {
		int activeIntervalSec = UserPrompts.askIntervalSeconds("active");
		this.setActiveIntervalSec(activeIntervalSec);
		int restIntervalSec = UserPrompts.askIntervalSeconds("rest");
		this.setRestIntervalSec(restIntervalSec);
		int numOfIntervals = UserPrompts.askNumIntervals();
		this.setNumOfIntervals(numOfIntervals);
		addToHIITTable(connection, hiitTable);
	}

	public void addToHIITTable(Connection connection, HIITTable hiitTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(this.getExerciseId());
		values.add(this.getActiveIntervalSec());
		values.add(this.getRestIntervalSec());
		values.add(this.getNumOfIntervals());
		hiitTable.insertRow(connection, values);
	}

	public void editHIITDetails(Connection connection, Workout workout, ExerciseTable exerciseTable,
			HIITTable hiitTable) {
		boolean stillEditing = true;
		ArrayList<Object> exerciseValues = new ArrayList<Object>();
		ArrayList<Object> hiitValues = new ArrayList<Object>();
		do {
			int selection = UserPrompts.askHIITEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					break;
				case 2:
					int newActiveIntervalSec = UserPrompts.askIntervalSeconds("active");
					this.setActiveIntervalSec(newActiveIntervalSec);
					break;
				case 3:
					int newRestIntervalSec = UserPrompts.askIntervalSeconds("rest");
					this.setRestIntervalSec(newRestIntervalSec);
					break;
				case 4:
					int newNumOfIntervals = UserPrompts.askNumIntervals();
					this.setNumOfIntervals(newNumOfIntervals);
					break;
				}
				exerciseValues.add(this.getExerciseTime());
				hiitValues.add(this.getActiveIntervalSec());
				hiitValues.add(this.getRestIntervalSec());
				hiitValues.add(this.getNumOfIntervals());
				exerciseTable.updateRow(connection, this.getExerciseId(), exerciseValues);
				hiitTable.updateRow(connection, this.getExerciseId(), hiitValues);
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
	}

	public void displayHIITExercises() {
		Formatter table = new Formatter();
		table.format("%15s %15s %15s %15s %15s\n", "ExerciseId", "Time", "Active Interval (seconds)",
				"Rest Interval (seconds)", "# of Intervals");
		table.format("%15s %15s %15s %15s %15s\n", this.getExerciseId(), this.getExerciseTime(),
				this.getActiveIntervalSec(), this.getRestIntervalSec(), this.getNumOfIntervals());
		System.out.println(table);
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
