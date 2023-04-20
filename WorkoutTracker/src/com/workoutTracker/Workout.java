package com.workoutTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Workout {

	private static int ID = 49820;

	int workoutId;
	LocalDate date;
	int time;
	ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public Workout(LocalDate date, int time, ArrayList<Exercise> exercises) {
		this.workoutId = generateWorkoutId();
		this.date = date;
		this.time = time;
		this.exercises = exercises;
	}

	public Workout(LocalDate date, int time) {
		this.workoutId = generateWorkoutId();
		this.date = date;
		this.time = time;
	}

	public int generateWorkoutId() {
		int id = Workout.getID();
		id++;
		Workout.setID(id);
		return id;
	}
	
	public void addWorkoutDetails(Workout workout) {
		System.out.println("Let's add exercises to your workout!\n");
		boolean keepAddingExercises = true;
		do {
			String exerciseType = UserPrompts.askExerciseType();
			if (!exerciseType.equals("Exit")) {
				Exercise exercise = addNewExercise(exerciseType);
				workout.getExercises().add(exercise);
				exercise.addExerciseDetails();
			} else {
				keepAddingExercises = false;
			}
		} while (keepAddingExercises);		
	}
	
	public Exercise addNewExercise(String exerciseType) {
		switch (exerciseType) {
		case "Run":
			Run run = new Run();
			return run;
		case "HIIT":
			HIIT hiit = new HIIT();
			return hiit;
		case "Bike":
			Bike bike = new Bike();
			return bike;
		case "Strength Training":
			StrengthTraining strengthTraining = new StrengthTraining();
			return strengthTraining;
		case "Exit":
			break;
		}
		return null;
	}
	
	public void editWorkout() {
		boolean stillEditing = true;
		do {
			int selection = UserPrompts.askWorkoutFieldToEdit();
			if (selection == 0) {
				stillEditing = false;
			} else {
				switch (selection) {
				case 1:
					LocalDate newDate = UserPrompts.askWorkoutDate();
					this.setDate(newDate);
					break;
				case 2:
					int newTime = UserPrompts.askTime("workout");
					this.setTime(newTime);
					break;
				case 3:
					this.editExercises();
					break;
				}
			}
		} while (stillEditing);
	}
	
	public void editExercises() {
		System.out.println("Editing the exercises...");
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
