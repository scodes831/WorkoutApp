package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class WorkoutTable extends Table {
	
	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists workouts (workoutId SERIAL PRIMARY KEY, userId SERIAL, date DATE, time INTEGER, heartRate INTEGER, "
					+ "calories INTEGER, FOREIGN KEY (userId) REFERENCES users(userId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertRow(Connection connection, ArrayList<Object> values) {
		Statement statement;
		try {
			String query = String.format(
					"insert into workouts (date, time, heartRate, calories) values ('%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
