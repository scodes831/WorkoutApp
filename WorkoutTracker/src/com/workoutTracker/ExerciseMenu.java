package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class ExerciseMenu {

	public void displayMenu(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(workout, userManager, mainMenu, workoutMenu, selection, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);
	}

	public void processSelection(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu, int selection, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable) {
		switch (selection) {
		case 1:
			Exercise selectedExercise = workout.selectExercise();
			displaySubExerciseMenu(workout, userManager, mainMenu, workoutMenu, this, connection, userTable, workoutTable, exerciseTable, stTable, setTable, selectedExercise);
		case 2:
			String exerciseType = UserPrompts.askExerciseType();
			Exercise newExercise = workout.addNewExercise(exerciseType);
			newExercise.addExerciseDetails(connection, workout, exerciseTable, stTable, setTable);
			System.out.println("new exercise has been added");
			break;
		case 3:
			workoutMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
			break;
		}
		displayMenu(workout, userManager, mainMenu, workoutMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
	}
	
	public int makeSelection() {
		System.out.println("Exercise Menu Options: \n1 - View Exercise Details\n2 - Add Exercise\n3 - Back to Workout Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}
	
	public void displaySubExerciseMenu(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu, ExerciseMenu exMenu, Connection connection, UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable, Exercise exercise) {
		if (exercise instanceof StrengthTraining) {
			StrengthTrainingMenu stMenu = new StrengthTrainingMenu();
			stMenu.displayMenu(workout, userManager, mainMenu, workoutMenu, exMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable, exercise);
		} else if (exercise instanceof Bike) {
			
		} else if (exercise instanceof Run) {
			
		} else if (exercise instanceof HIIT) {
			
		}
	}

}
