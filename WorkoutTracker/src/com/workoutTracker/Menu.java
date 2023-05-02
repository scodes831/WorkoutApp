package com.workoutTracker;

import java.sql.Connection;

public abstract class Menu {

	public abstract void displayMenu(UserManager userManager, MainMenu mainMenu, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable);

	public abstract int makeSelection();

	public abstract void processSelection(UserManager userManager, MainMenu mainMenu, int selection, Connection connection,
			UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable);

}
