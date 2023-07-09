package com.workoutTracker;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		DatabaseManager dm = new DatabaseManager();
		Connection connection = dm.connectDatabase("workouttracker", null, null);
		UserTable userTable = new UserTable();
		WorkoutTable workoutTable = new WorkoutTable();
		ExerciseTable exerciseTable = new ExerciseTable();
		BikeTable bikeTable = new BikeTable();
		RunTable runTable = new RunTable();
		HIITTable hiitTable = new HIITTable();
		StrengthTrainingTable stTable = new StrengthTrainingTable();
		SetTable setTable = new SetTable();
		dm.createTables(connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
		UserManager um = new UserManager();
		MainMenu mainMenu = new MainMenu();
		userTable.readTable(connection, um, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
		mainMenu.displayMenu(um, mainMenu, connection, userTable, workoutTable, exerciseTable, bikeTable, runTable, hiitTable, stTable, setTable);
	}
}
