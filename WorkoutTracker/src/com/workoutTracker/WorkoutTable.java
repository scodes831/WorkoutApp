package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;

public class WorkoutTable extends Table {
	
	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists workouts (workoutId SERIAL PRIMARY KEY, userId SERIAL, date DATE, time INTEGER, "
					+ "FOREIGN KEY (userId) REFERENCES users(userId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
