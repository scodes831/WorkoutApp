package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class ExerciseMenu {

	public void displayMenu(Workout workout, MainMenu mainMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(workout, mainMenu, selection, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);
	}

	public void processSelection(Workout workout, MainMenu mainMenu, int selection, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable,
			SetTable setTable) {
		switch (selection) {
		case 1:
			String exerciseType = UserPrompts.askExerciseType();
			Exercise newExercise = workout.addNewExercise(exerciseType);
			newExercise.addExerciseDetails(connection, workout, exerciseTable, stTable);
			System.out.println("new exercise has been added");
			break;
		case 2:
			Exercise selectedExercise = workout.selectExercise();
			selectedExercise.editExerciseDetails(connection, exerciseTable, stTable);
			break;
		case 3:
			//back to main/workout menu
			break;
		}
		displayMenu(workout, mainMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
	}
	
	public int makeSelection() {
		System.out.println("Exercise Menu Options: \n1 - Add Exercise\n2 - Edit Exercise\n3 - Back to Main Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
