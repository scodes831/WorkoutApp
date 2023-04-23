package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;

public class SetTable extends Table {
	
	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists sets (setId SERIAL PRIMARY KEY, exercise SERIAL, weightLbs NUMERIC(6,1), weightKg NUMERIC(6,1), "
					+ "reps INTEGER, FOREIGN KEY (exercise) REFERENCES exercises(exerciseId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
