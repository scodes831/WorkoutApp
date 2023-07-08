package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class WorkoutMenu extends Menu {

	public void displayMenu(UserManager userManager, MainMenu mainMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(userManager, mainMenu, selection, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);

	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable) {
		switch (selection) {
		case 1:
			User selectedUser = userManager.selectAUser(userManager);
			Workout workout = selectedUser.addWorkout(selectedUser);
			selectedUser.addWorkoutToDatabase(workout, connection, workoutTable);
			workout.addWorkoutDetails(workout, connection, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
			break;
		case 2:
			User selectedUser2 = userManager.selectAUser(userManager);
			if (selectedUser2.getWorkouts().size() == 0) {
				System.out.println("User " + selectedUser2.getFirstName() + " " + selectedUser2.getLastName() + " has 0 workouts to display.\n");
				break;
			} else {
				selectedUser2.displayAllWorkouts();
				Workout selectedWorkout = selectedUser2.selectWorkout();
				int selectedWorkoutOption = selectWorkoutOptions();
				if (selectedWorkoutOption == 1) {
					selectedWorkout.displayExercises();
					ExerciseMenu exerciseMenu = new ExerciseMenu();
					exerciseMenu.displayMenu(selectedWorkout, userManager, mainMenu, this, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
				} else if (selectedWorkoutOption == 2) {
					selectedWorkout.editWorkout(connection, selectedUser2, workoutTable, exerciseTable, bikeTable, hiitTable, runTable, stTable, setTable);
				} else {
					break;
				}
				break;
			}
		case 3:
			mainMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
		}
		displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
	}
	
	public int makeSelection() {
		System.out.println(
				"Workout Menu Options:\n1 - Add Workout\n2 - Display Workouts\n3 - Back to Main Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}
	
	public int selectWorkoutOptions() {
		System.out.println("\n1 - Display Exercises\n2 - Edit Workout\n3 - Back to Main Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
