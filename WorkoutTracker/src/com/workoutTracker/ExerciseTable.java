package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class ExerciseTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists exercises (exerciseId SERIAL PRIMARY KEY, workout SERIAL, type VARCHAR(20), time INTEGER,"
					+ " FOREIGN KEY (workout) REFERENCES workouts(workoutId))";
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
					"insert into exercises (type, time) values ('%s', '%s');",
					values.get(0), values.get(1));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateRow(Connection connection, int id, ArrayList<Object> newValues) {
		
	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from exercises where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
