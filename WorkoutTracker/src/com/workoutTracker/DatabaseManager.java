package com.workoutTracker;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

	public Connection connectDatabase(String database, String user, String pw) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user, pw);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public void createTables(Connection connection, UserTable userTable, WorkoutTable workoutTable, ExerciseTable exerciseTable,
			BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable,
			SetTable setTable) {
		userTable.createTable(connection);
		workoutTable.createTable(connection);
		exerciseTable.createTable(connection);
		bikeTable.createTable(connection);
		runTable.createTable(connection);
		hiitTable.createTable(connection);
		stTable.createTable(connection);
		setTable.createTable(connection);
	}
}
