package com.workoutTracker;

import java.sql.Connection;

public abstract class SubMenu {

	public abstract void displayMenu(Workout workout, UserManager userManager, MainMenu mainMenu,
			WorkoutMenu workoutMenu, ExerciseMenu exMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable,
			HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable, Exercise exercise);

	public abstract void processSelection(Workout workout, UserManager userManager, MainMenu mainMenu,
			WorkoutMenu workoutMenu, Connection connection, UserTable userTable, WorkoutTable workoutTable,
			ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable,
			StrengthTrainingTable stTable, SetTable setTable, ExerciseMenu exMenu, Exercise exercise, int selection);
	
	public abstract int makeSelection();
}
