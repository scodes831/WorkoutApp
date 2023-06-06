package com.workoutTracker;

import java.sql.Connection;
import java.util.Scanner;

public class RunMenu extends SubMenu {

	public void displayMenu(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu,
			ExerciseMenu exMenu, Connection connection, UserTable userTable, WorkoutTable workoutTable,
			ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable,
			StrengthTrainingTable stTable, SetTable setTable, Exercise exercise) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(workout, userManager, mainMenu, workoutMenu, connection, userTable, workoutTable,
						exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable, exMenu, exercise, selection);
			} catch (Exception e) {
				System.out.println(e);
			}

		} while (inputError);
	}

	public void processSelection(Workout workout, UserManager userManager, MainMenu mainMenu, WorkoutMenu workoutMenu,
			Connection connection, UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable,
			BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable,
			SetTable setTable, ExerciseMenu exMenu, Exercise exercise, int selection) {
		Run run = (Run) exercise;
		switch (selection) {
		case 1:
			run.displayRunExercises();
			break;
		case 2:
			run.displayRunExercises();
			run.editRunDetails(connection, workout, exerciseTable, runTable);
			break;
		case 3:
			exMenu.displayMenu(workout, userManager, mainMenu, workoutMenu, connection, userTable, workoutTable,
					exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
			break;
		}
		displayMenu(workout, userManager, mainMenu, workoutMenu, exMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable, exercise);
	}

	public int makeSelection() {
		System.out.println(
				"Run Menu Options:\n1 - View Run Exercise Details\n2 - Edit Exercise\n3 - Back to Exercise Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
