package com.workoutTracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workout {
	
	int workoutId;
	LocalDate date;
	int time;
	ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

}
