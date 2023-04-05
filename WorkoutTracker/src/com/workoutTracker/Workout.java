package com.workoutTracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workout {
	
	private static int ID = 49820;
	
	int workoutId;
	LocalDate date;
	int time;
	ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public Workout (LocalDate date, int time, ArrayList<Exercise> exercises) {
		this.workoutId = generateWorkoutId();
		this.date = date;
		this.time = time;
		this.exercises = exercises;
	}
	
	public int generateWorkoutId() {
		int id = Workout.getID();
		id++;
		Workout.setID(id);
		return id;
	}
	
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

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

}
