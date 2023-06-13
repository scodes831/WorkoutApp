package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class SetMenu {
	
	public void displayMenu(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu, ExerciseMenu exMenu, StrengthTrainingMenu stMenu, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable,
			SetTable setTable, StrengthTraining st) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(workout, userManager, mainMenu, workoutMenu, stMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable, exMenu, st, selection);
			} catch (Exception e) {
				System.out.println(e);
			}

		} while (inputError);
	}
	
	public void processSelection(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu, StrengthTrainingMenu stMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable, ExerciseMenu exMenu, StrengthTraining st, int selection) {
		switch (selection) {
		case 1:
			st.displaySets();
			break;
		case 2:
			st.addSetDetails(connection, setTable);
			break;
		case 3:
			st.displaySets();
			Set selectedSet = UserPrompts.askSetSelection(st);
			st.editSetDetails(connection, selectedSet, setTable);
			break;
		case 4:
			stMenu.displayMenu(workout, userManager, mainMenu, workoutMenu, exMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable, st);
			break;
		}
		displayMenu(workout, userManager, mainMenu, workoutMenu, exMenu, stMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable, st);
	}
	
	public int makeSelection() {
		System.out.println(
				"Set Menu Options:\n1 - View Set Details\n2 - Add Set\n3 - Edit Set\n4 - Back to Strength Training Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
