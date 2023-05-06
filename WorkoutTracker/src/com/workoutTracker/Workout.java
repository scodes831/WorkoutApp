package com.workoutTracker;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

public class Workout {

	private static int ID = 49820;

	int workoutId;
	LocalDate date;
	int time;
	int heartRate;
	int calories;

	ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public Workout(LocalDate date, int time, ArrayList<Exercise> exercises) {
		this.workoutId = generateWorkoutId();
		this.date = date;
		this.time = time;
		this.exercises = exercises;
	}

	public Workout(LocalDate date, int time, int heartRate, int calories) {
		this.workoutId = generateWorkoutId();
		this.date = date;
		this.time = time;
		this.heartRate = heartRate;
		this.calories = calories;
	}

	public int generateWorkoutId() {
		int id = Workout.getID();
		id++;
		Workout.setID(id);
		return id;
	}

	public void addWorkoutDetails(Workout workout, Connection connection, ExerciseTable exerciseTable,
			StrengthTrainingTable stTable) {
		System.out.println("Let's add exercises to your workout!\n");
		boolean keepAddingExercises = true;
		do {
			String exerciseType = UserPrompts.askExerciseType();
			if (!exerciseType.equals("Exit")) {
				Exercise exercise = addNewExercise(exerciseType);
				workout.getExercises().add(exercise);
				exercise.addExerciseDetails(connection, exerciseTable, stTable);
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

	public void editWorkout(Connection connection, User user, WorkoutTable workoutTable, ExerciseTable exerciseTable,
			StrengthTrainingTable stTable, SetTable setTable) {
		boolean stillEditing = true;
		ArrayList<Object> newValues = new ArrayList<Object>();
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
					this.editExercises(connection, exerciseTable, stTable);
					break;
				case 4:
					stillEditing = false;
					int userIndex = -1;
					workoutTable.deleteWorkoutDependencies(connection, this, exerciseTable, stTable, setTable);
					workoutTable.deleteRow(connection, this.getWorkoutId());
					for (int i = 0; i < user.getWorkouts().size(); i++) {
						if (user.getWorkouts().get(i).getWorkoutId() == this.getWorkoutId()) {
							userIndex = i;
							break;
						}
					}
					user.getWorkouts().remove(userIndex);
				}
			}
			newValues.add(this.getDate());
			newValues.add(this.getTime());
			newValues.add(this.getHeartRate());
			newValues.add(this.getCalories());
			workoutTable.updateRow(connection, this.getWorkoutId(), newValues);
		} while (stillEditing);
	}

	public void editExercises(Connection connection, ExerciseTable exerciseTable, StrengthTrainingTable stTable) {
		displayExercises();
		Exercise selectedExercise = UserPrompts.askExerciseSelection(this);
		selectedExercise.editExerciseDetails(connection, exerciseTable, stTable);
	}

	public void displayExercises() {
		System.out.println("Displaying exercises...");
		Formatter table = new Formatter();
		table.format("%15s %15s %15s\n", "ExerciseId", "Exercise Time", "Exercise Name");
		for (Exercise exercise : getExercises()) {
			table.format("%15s %15s %15s", exercise.getExerciseId(), exercise.getExerciseTime(),
					exercise.getClass().getSimpleName());
		}
		System.out.println(table);
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

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

}
