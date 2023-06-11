package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class MainMenu extends Menu {

	public void displayMenu(UserManager userManager, MainMenu mainMenu, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable,
			RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable) {
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

	public int makeSelection() {
		System.out.println("Menu options:\n1 - Users\n2 - Workouts");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable,
			RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable) {
		switch (selection) {
		case 1:
			UserMenu userMenu = new UserMenu();
			userMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
			break;
		case 2:
			WorkoutMenu workoutMenu = new WorkoutMenu();
			workoutMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
			break;
		}
		displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
	}
}
