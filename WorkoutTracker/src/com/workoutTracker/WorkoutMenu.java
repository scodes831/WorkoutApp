package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class WorkoutMenu extends Menu {

	public void displayMenu(UserManager userManager, MainMenu mainMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, SetTable setTable) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(userManager, mainMenu, selection, connection, userTable, workoutTable, exerciseTable, setTable);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);

	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, SetTable setTable) {
		User selectedUser = userManager.selectAUser(userManager);
		switch (selection) {
		case 1:
			Workout workout = selectedUser.addWorkout(selectedUser);
			workout.addWorkoutDetails(workout);
			selectedUser.addWorkoutToDatabase(workout, connection, workoutTable);
			break;
		case 2:
			selectedUser.displayAllWorkouts();
			break;
		case 3:
			selectedUser.displayAllWorkouts();
			Workout selectedWorkout = selectedUser.selectWorkout();
			selectedWorkout.editWorkout();
			break;
		case 4:
			mainMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, setTable);
		}
		displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, setTable);
	}

	public int makeSelection() {
		System.out.println(
				"Workout Menu Options:\n1 - Add Workout\n2 - Display Workouts\n3 - Edit Workouts\n4 - Back to Main Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
